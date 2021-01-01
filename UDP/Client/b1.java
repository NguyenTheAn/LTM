/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
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
            DatagramSocket ds = new DatagramSocket();
            byte[] send = new byte[65535];
            send = "Hello Server".getBytes();
            InetAddress ip = InetAddress.getByName("localhost");
            DatagramPacket dpSend = new DatagramPacket(send, send.length, ip, 1231);
            ds.send(dpSend);
            byte[] recieve = new byte[65535];
            DatagramPacket dpRecieve = new DatagramPacket(recieve, recieve.length);
            ds.receive(dpRecieve);
            
            String[] inp = new String(recieve).trim().split(",");
            Integer a = Integer.parseInt(inp[0]);
            Integer b = Integer.parseInt(inp[1]);
            Integer c = a + b;
            send = new byte[65535];
            send = c.toString().getBytes();
            dpSend = new DatagramPacket(send, send.length, ip, 1231);
            ds.send(dpSend);
            ds.close();
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(b1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(b1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
