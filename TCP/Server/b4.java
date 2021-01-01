/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Models.Student;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ann52
 */

public class b4 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Socket Server Started =============>>>>>>>>>");
            while(true){
                Student res = null;
                try {
                    Socket socket = serverSocket.accept();
                    
                    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                    Student inp = (Student) ois.readObject();  
                    inp.id = "ABC";
                    inp.name = "nguyen the an";
                    
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(inp);
                    oos.flush();
                    
                    ois = new ObjectInputStream(socket.getInputStream());
                    res = (Student) ois.readObject();  
                    
                } catch (Exception ex) {
                    Logger.getLogger(b4.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (res != null && res.name.equals("Nguyen The An") && res.email.equals("annt@ptit.edu.vn")){
                    System.out.println("True");
                }
                else{
                    System.out.println("False");
                }
                
            }
        } catch (IOException ex) {            
            Logger.getLogger(b4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
