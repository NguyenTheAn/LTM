/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ann52
 */



public class b1 {
    
    public static boolean b1(Socket socket, DataOutputStream dos, DataInputStream dis) throws IOException{
        
        dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF("abcdefghi");
        String res = null;
        try {
            dis = new DataInputStream(socket.getInputStream());
            res = dis.readUTF();
        } catch(Exception e){
            
        }
        if (res != null && res.equals("ihgfedcba")){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1231);
            System.out.println("TCP server started ===================>");
            while (true){
                Socket socket = serverSocket.accept();
                
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                String str = dis.readUTF();
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                String code = str.split(";")[1];
                if (code.equals("1")){
                    System.out.println(b1(socket, dos, dis));
                }
                dos.close();
                dis.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(b1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
