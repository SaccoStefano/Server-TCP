package server;

import java.io.*;
import java.net.*;
import java.util.*;

public class EchoThread extends Thread{
    
    private Socket s;
    private int porta;
    Socket connection;
    String echo;
    InputStream inSocket;
    OutputStream outSocket;
    PrintWriter streamOut;
    Scanner streamIn;
    
    public EchoThread(Socket s, int port){
        this.s=s;
        porta=port;
        
    }
    
    public void run(){
        try{
            
        System.out.println("Server in ascolto sulla porta "+ porta +"\n");
                
                connection = s;
                //inSocket = connection.getInputStream();
                //streamIn= new Scanner(inSocket);  
                streamIn= new Scanner(connection.getInputStream());   
                String aux = streamIn.nextLine();
                String richiesta="";
                
                if(aux.equals("maiuscole: on")){
                    richiesta = streamIn.nextLine();
                    richiesta = richiesta.toUpperCase();
                }
                else{
                    richiesta = streamIn.nextLine(); 
                }
               
                //outSocket = connection.getOutputStream();
                //streamOut= new PrintWriter(outSocket);
                streamOut= new PrintWriter(connection.getOutputStream());
                System.out.println("Connessione stabilita e richiesta");                
                streamOut.println(richiesta);
                streamOut.close();                 
                System.out.println("Risposta inviata");
            
        }catch(Exception e){}
    }
}
