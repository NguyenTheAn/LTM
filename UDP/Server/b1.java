/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ann52
 */
public class b1 {
    public static void main(String[] args) {
        try {
            System.out.println("UDP Server Started =============>>>>>>>>>>");
            DatagramSocket ds = new DatagramSocket(1231);
            byte[] recieve = null;
            byte[] send = null;
            while (true){
                recieve = new byte[65535];
                DatagramPacket dpRecieve = new DatagramPacket(recieve, recieve.length);
                ds.receive(dpRecieve);
                InetAddress clientAddress = dpRecieve.getAddress();
                int clientPort = dpRecieve.getPort();
                
                send = new byte[65535];
                send = "123,456".getBytes();
                DatagramPacket sendP = new DatagramPacket(send, send.length, clientAddress, clientPort);
                ds.send(sendP);
                
                recieve = new byte[65535];
                dpRecieve = new DatagramPacket(recieve, recieve.length);
                ds.receive(dpRecieve);
                
                String res = new String(recieve).trim();
                if (res.equals("579")){
                    System.out.println("True");
                }
                else{
                    System.out.println("False");
                }
            }
        } catch (SocketException | UnknownHostException ex) {
            Logger.getLogger(b1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(b1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
