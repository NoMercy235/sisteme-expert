package exempluinterfataprolog;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                    final String sirDeScris=str;
                    str="";
                    // functia asta updateaza e;lementele din interfata grafica
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run(){ 
                            // iau fereastra, iau elementul si pun pe el ce am primit
                            conexiune.getFereastra().getDebugTextArea().append(sirDeScris); 
                            
                            if(sirDeScris.contains("?")){
                                int firstQuote = sirDeScris.indexOf("'");
                                int secondQuote = sirDeScris.indexOf("'", firstQuote + 1);
                                String question = sirDeScris.substring(firstQuote + 1, secondQuote);
                                Fereastra.fereastra.setQuestion(question);
                                
                                int firstParanthesis = sirDeScris.indexOf("(");
                                int lastParanthesis = sirDeScris.indexOf(")");
                                String answers;
                                if(firstParanthesis != -1)
                                    answers = sirDeScris.substring(firstParanthesis + 1, lastParanthesis);
                                else
                                    answers = "da nu";
                                String aux[] = answers.split(" ");
                                for(int i = 0; i < aux.length; i++){
                                    Fereastra.fereastra.answers.push(aux[i]);
                                } 
                                Fereastra.fereastra.generateAnswers();
                            }
                            else{
                                String result = sirDeScris.replace("\r\n", "");
                                if(!(result.equals(""))){
                                    if(Fereastra.results == null){
                                        Fereastra.results = new Results();
                                        Fereastra.results.setVisible(true);
                                    }
                                    Fereastra.results.addResult(result);
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
