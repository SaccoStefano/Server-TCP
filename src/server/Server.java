package server;

import java.io.*;
import java.net.*;
import java.util.*;


public class Server {

    public static void main(String[] args)throws Exception{
       
        int port = 2000;
        
        ServerSocket sSocket;
        Socket connection;
       
        System.out.println("Apertura porta in corso");
           
            sSocket = new ServerSocket(port); 
            while(true){         
                new EchoThread(sSocket.accept(),port).start();
            }        
    }
}
