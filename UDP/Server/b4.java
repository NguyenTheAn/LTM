/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Models.Student;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ann52
 */
public class b4 {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(1234);
            System.out.println("UDP Server Started ==========>>>>>>>>>>>");
            byte[] send = null; 
            byte[] recieve = null;
            while (true){
                recieve = new byte[65535];
                DatagramPacket dpRecieve = new DatagramPacket(recieve, recieve.length);
                ds.receive(dpRecieve);
                ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(recieve));
                Student rescieveStudent = (Student) ois.readObject();
                rescieveStudent.id = "ABC";
                rescieveStudent.name = "nguyen the an";
                InetAddress clientAddress = dpRecieve.getAddress();
                int clientPort = dpRecieve.getPort();
                
                send = new byte[65535];
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(bos);
                oos.writeObject(rescieveStudent);
                send = bos.toByteArray();
                DatagramPacket dpSend = new DatagramPacket(send, send.length, clientAddress, clientPort);
                ds.send(dpSend);
                
                recieve = new byte[65535];
                dpRecieve = new DatagramPacket(recieve, recieve.length);
                ds.receive(dpRecieve);
                ois = new ObjectInputStream(new ByteArrayInputStream(recieve));
                Student res = (Student) ois.readObject();
                
                if (res.name.equals("Nguyen The An") && res.email.equals("annt@ptit.edu.vn")){
                    System.out.println("True");
                }
                else{
                    System.out.println("False");
                }
            }
        } catch (SocketException ex) {
            Logger.getLogger(b2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(b2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(b2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
