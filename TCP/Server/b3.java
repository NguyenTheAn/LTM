/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ann52
 */
public class b3 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1233);
            System.out.println("Server started ===============>>>>");
            while (true){
                Socket socket = serverSocket.accept();
                String result = null;
                try{
                    byte[] arr = new byte[65535];
                    socket.getInputStream().read(arr);
                    ByteArrayInputStream bis = new ByteArrayInputStream(arr);
                    arr = new byte[65535];
                    bis.read(arr);
                    String code = new String(arr).trim();
                    
                    arr = new byte[65535];
                    arr = "123,456".getBytes();
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    bos.write(arr);
                    dos.write(bos.toByteArray());
                    
                    arr = new byte[65535];
                    socket.getInputStream().read(arr);
                    bis = new ByteArrayInputStream(arr);
                    arr = new byte[65535];
                    bis.read(arr);
                    result = new String(arr).trim();
                    
                    dos.close();
                    bis.close();
                    bos.close();
                } catch (Exception e){
                    System.out.println(e);
                }
                if (result != null && result.equals("579")){
                    System.out.println("True");
                }
                else{
                    System.out.println("False");
                }
                socket.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(b3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
