/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Models.Student;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
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
            DatagramSocket ds = new DatagramSocket();
            InetAddress ip = InetAddress.getByName("localhost");
            byte[] send = null;
            byte[] recieve = null;
            
            send = new byte[65535];
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            Student student = new Student("B17DCCN002");
            oos.writeObject(student);
            send = bos.toByteArray();
            DatagramPacket dpSend = new DatagramPacket(send, send.length, ip, 1234);
            ds.send(dpSend);
            
            recieve = new byte[65535];
            DatagramPacket dpRecieve = new DatagramPacket(recieve, recieve.length);
            ds.receive(dpRecieve);
            ByteArrayInputStream bis = new ByteArrayInputStream(recieve);
            ObjectInputStream ois = new ObjectInputStream(bis);
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
            
            send = new byte[65535];
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(inp);
            send = bos.toByteArray();
            dpSend = new DatagramPacket(send, send.length, ip, 1234);
            ds.send(dpSend);
            
        } catch (SocketException ex) {
            Logger.getLogger(b2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(b2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(b2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
