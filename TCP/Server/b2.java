/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ann52
 */
public class b2 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1232);
            System.out.println("TCP server started ===================>");
            while (true){
                Socket socket = serverSocket.accept();
                String inp = null;
                try{
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String code = reader.readLine();
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    writer.write("123,456\n");
                    writer.flush();

                    reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    inp = reader.readLine();
                    
                    writer.close();
                    reader.close();
                    } catch (Exception e){}
                    if (inp != null && inp.equals("579")){
                        System.out.println("True");
                    }
                    else{
                        System.out.println("False");
                    }

            }
        } catch (IOException ex) {
            Logger.getLogger(b2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
