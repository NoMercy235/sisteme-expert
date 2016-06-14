package exempluinterfataprolog;

import static exempluinterfataprolog.Fereastra.fereastra;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class CititorMesaje extends Thread {
    ServerSocket servs;
    volatile Socket s=null;//volatile ca sa fie protejat la accesul concurent al mai multor threaduri
    volatile PipedInputStream pis=null;
    ConexiuneProlog conexiune;

    //setteri sincronizati
    public synchronized void setSocket(Socket _s){
        s=_s;
        notify();
    }    
    
    public final synchronized void setPipedInputStream(PipedInputStream _pis){
        pis=_pis;
        notify();
    }
    //getteri sincronizati
    
    public synchronized Socket getSocket() throws InterruptedException
    {
        if (s==null){
            wait();//asteapta pana este setat un socket
        }
        return s;
    }
    
    public synchronized PipedInputStream getPipedInputStream() throws InterruptedException{
        if(pis==null){
            wait();
        }
        return pis;
    }
    
    
    //constructor
    public CititorMesaje(ConexiuneProlog _conexiune, ServerSocket _servs) throws IOException{
        servs=_servs;
        conexiune=_conexiune;
    }
    
    public void askToSave(){
        if(Fereastra.dialogResult != -1) return;
            else
            Fereastra.dialogResult = -2;
        
        Fereastra.dialogResult = JOptionPane.showConfirmDialog (null, 
                                     "Doriti sa salvati acest query?",
                                     "Warning",
                                     Fereastra.dialogButton);
                                
        if(Fereastra.dialogResult == 0){
            //YES
            String queryName = "";
            do{
                queryName = JOptionPane.showInputDialog(Fereastra.results, 
                                        "Cu ce nume doriti sa salvati?");
                if(queryName != null && queryName.equals("")){
                    JOptionPane.showMessageDialog(Fereastra.results, 
                            "Numele introdus nu este corect!");
                }
            }while(queryName != null && queryName.equals(""));
            
            if(queryName == null){
                JOptionPane.showMessageDialog(Fereastra.results, 
                            "Salvarea a fost anulata!");
                return;
            }
            try{
                File file = new File(Fereastra.pathToMyProject + "log_witcher3/query_" + queryName + ".txt");

                if (!file.exists()) {
                    file.createNewFile();
                }
                
                FileWriter fw = new FileWriter(file.getAbsoluteFile(), false);
                BufferedWriter bw = new BufferedWriter(fw);
                for(int i = 0; i < Fereastra.fereastra.givenAnswers.size(); i++){
                    bw.write(Fereastra.fereastra.givenAnswers.get(i));
                    bw.newLine();
                }
                bw.close();

            }catch(IOException ex){
                System.out.println(ex);
            }
        }
        else{
            //NO
        }
    }
    
    @Override
    public void run(){
        try {
            //apel blocant, asteapta conexiunea
            //conexiunea clinetului se face din prolog
            Socket s_aux=servs.accept();
            setSocket(s_aux);
            //pregatesc InputStream-ul pentru a citi de pe Socket
            InputStream is=s_aux.getInputStream();
            
            //construim pipe-ul pentru a trimite informatii
            //exista un pipe pentru comunicarea intre program si sicstus si 
            //inca unul pentru interfata grafica si thread
            PipedOutputStream pos=new PipedOutputStream();
            setPipedInputStream(new PipedInputStream(pos));//leg un pipedInputStream de capatul in care se scrie
            
            int chr;
            String str="";
            while((chr=is.read())!=-1) {//pana nu citeste EOF
                pos.write(chr);//pun date in Pipe, primite de la Prolog
                str+=(char)chr;
                if(chr=='\n'){
                    final String sirDeScris = str.replace("\r\n", "");
                    str="";
                    // functia asta updateaza elementele din interfata grafica
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run(){ 
                            // iau fereastra, iau elementul si pun pe el ce am primit
                                conexiune.getFereastra().getDebugTextArea().append(sirDeScris); 
                            System.out.println(sirDeScris);
                            if(sirDeScris.contains("?")){
                                Fereastra.fereastra.clearAnswers();
                                
                                int firstQuote = sirDeScris.indexOf("'");
                                int secondQuote = sirDeScris.indexOf("'", firstQuote + 1);
                                String question = sirDeScris.substring(firstQuote + 1, secondQuote);
                                Fereastra.fereastra.setQuestion(question);
                               // Fereastra.fereastra.labels.push(question);
                                int firstParanthesis = sirDeScris.indexOf("(");
                                int lastParanthesis = sirDeScris.indexOf(")");
                                String answers;
                                if(firstParanthesis != -1)
                                    answers = sirDeScris.substring(firstParanthesis + 1, lastParanthesis);
                                else
                                    answers = "da nu";
                                String aux[] = answers.split(" ");
                                for(int i = 0; i < aux.length; i++){
                                    aux[i] = aux[i].replaceAll("_", " ");
                                    Fereastra.fereastra.answers.push(aux[i]);
                                } 
                                Fereastra.fereastra.generateAnswers();
                            }
                            else
                            if(sirDeScris.contains("reinit_done")){
                                Fereastra.fereastra.clearAll();
                                Fereastra.fereastra.deactivateReset();
                                Fereastra.fereastra.resetConnection();
                            }
                            else
                            if(sirDeScris.matches("[a-z]+[\\s][a-z]+[\\s][0-9]+")){
                                Fereastra.fereastra.disableAutoQuery();
                                if(!(sirDeScris.equals(""))){
                                    if(Fereastra.results == null || !Fereastra.results.isVisible()){
                                        Fereastra.results = new Results();
                                        Fereastra.results.setVisible(true);
                                    }
                                    Fereastra.results.addResult(sirDeScris);
                                }
                                if(!Fereastra.bHasAutoQuery)
                                    askToSave();
                                Fereastra.fereastra.activateReset();
                            }
                            else
                            if(sirDeScris.contains("Nu exista")){
                                Fereastra.fereastra.disableAutoQuery();
                                JOptionPane.showMessageDialog(Fereastra.fereastra, "Nu a fost gasit niciun rezultat!");
                                if(!Fereastra.bHasAutoQuery)
                                    askToSave();
                                Fereastra.fereastra.activateReset();
                            }
                            else
                            if(!sirDeScris.contains("am citit")){
                                if(!(sirDeScris.equals(""))){
                                    if(Fereastra.dece == null || !Fereastra.dece.isVisible()){
                                        Fereastra.dece = new DeCe();
                                        Fereastra.dece.setVisible(true);
                                    }
                                    Fereastra.dece.addWhy(sirDeScris);
                                }
                            }
                        }
                    });
                }
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(CititorMesaje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    
}
