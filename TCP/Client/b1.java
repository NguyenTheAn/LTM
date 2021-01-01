/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ann52
 */
public class b1 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
            String str = "B1DCCN002;1";
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(str);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String inp = dis.readUTF();
            String res = "";
            for (int i=inp.length()-1; i>=0; i--){
                res += inp.charAt(i);
            }
//            dos.writeUTF(res);
            
            dos.close();
            dis.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(b1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
