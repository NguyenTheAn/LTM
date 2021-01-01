/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Models.Student;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
            Socket socket = new Socket("localhost", 1234);
            
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            Student student = new Student("B17DCCN002");
            oos.writeObject(student);
            oos.flush();
            
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Student inp = (Student) ois.readObject();
            
            String[] tmp = inp.name.split(" ");
            String email = tmp[tmp.length - 1].toLowerCase();
            for (int i=0; i<tmp.length-1; i++){
                email = email + tmp[i].substring(0, 1).toLowerCase();
            }
            email = email + "@ptit.edu.vn";
            String name = tmp[0].substring(0, 1).toUpperCase() + tmp[0].substring(1);
            for (int i=1; i<tmp.length; i++){
                name = name + " " + tmp[i].substring(0, 1).toUpperCase() + tmp[i].substring(1);
            }
            inp.email = email;
            inp.name = name;
            
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(inp);
            oos.flush();
            socket.close();
        } catch (IOException ex) {
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(b4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
