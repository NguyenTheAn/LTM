/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.Buffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ann52
 */
public class b2 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1232);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write("code\n");
            writer.flush();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String inp = reader.readLine();
            String[] arr = inp.split(",");
            Integer a = Integer.parseInt(arr[0]);
            Integer b = Integer.parseInt(arr[1]);
            Integer c = a + b;
            String res = c.toString();
            
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write(res + "\n");
            writer.flush();
            
            reader.close();
            writer.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(b2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
