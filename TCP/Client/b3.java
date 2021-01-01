/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
            Socket socket = new Socket("localhost", 1233);
            byte[] buf = new byte[65535];
            buf = "code".getBytes();
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bos.write(buf);
            dos.write(bos.toByteArray());
            
            buf = new byte[65535];
            socket.getInputStream().read(buf);
            ByteArrayInputStream bis = new ByteArrayInputStream(buf);
            bis.read(buf);
            String[] inp = new String(buf).trim().split(",");
            Integer a = new Integer(inp[0]);
            Integer b = new Integer(inp[1]);
            Integer c = a + b;
            
            buf = new byte[65535];
            buf = c.toString().getBytes();
            dos = new DataOutputStream(socket.getOutputStream());
            bos = new ByteArrayOutputStream();
            bos.write(buf);
            dos.write(bos.toByteArray());
            
            dos.close();
            bos.close();
            bis.close();

        } catch (IOException ex) {
            Logger.getLogger(b3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
