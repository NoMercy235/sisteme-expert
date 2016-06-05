package exempluinterfataprolog;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConexiuneProlog {
    //String caleExecutabilSicstus = "C:\\Users\\Izabela\\Desktop\\ia\\SICStus Prolog 4.0.2\\bin\\spwin.exe";
    String caleExecutabilSicstus = "C:\\Program Files\\SICStus Prolog VC12 4.3.2\\bin\\spwin.exe";
    final String nume_fisier="my_project/sist.pl";
    //final String nume_fisier="ceva_simplu.pl";    
    final String scop="inceput.";    
    //final String scop="main.";

    Process procesSicstus;
    ExpeditorMesaje expeditor;
    CititorMesaje cititor;
    Fereastra fereastra;
    int port;
    
    
    public Fereastra getFereastra(){
        return fereastra;
    }
    
    public ConexiuneProlog(int _port, Fereastra _fereastra) throws IOException, InterruptedException{
        InputStream processIs, processStreamErr;
        port=_port;
        fereastra=_fereastra;
        //acces la mediul curent de rulare
        ServerSocket servs=new ServerSocket(port);
        //Socket sock_s=servs.accept();
        cititor=new CititorMesaje(this,servs);
        cititor.start();
        expeditor=new ExpeditorMesaje(cititor);
        expeditor.start();
        
        
        Runtime rtime= Runtime.getRuntime();
        
        String comanda=caleExecutabilSicstus+" -f -l "+nume_fisier+" --goal "+scop+" -a "+port;
        
        procesSicstus=rtime.exec(comanda);
        
        //InputStream-ul din care citim ce scrie procesul
        processIs=procesSicstus.getInputStream();
        //stream-ul de eroare
        processStreamErr=procesSicstus.getErrorStream();
    }
    
    void opresteProlog() throws InterruptedException{
        PipedOutputStream pos= this.expeditor.getPipedOutputStream();
        PrintStream ps=new PrintStream(pos);
        ps.println("exit.");
        ps.flush();
    }
}
