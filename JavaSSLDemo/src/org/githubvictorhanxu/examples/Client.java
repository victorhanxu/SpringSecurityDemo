package org.githubvictorhanxu.examples;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        while(true) {
            Socket client = new Socket("localhost", 8888);
            String echo = "";
            String msg = "Hello from Client-" + Math.random();
            //BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            //echo = br.readLine();

            DataInputStream dis = new DataInputStream(client.getInputStream());
            echo = dis.readUTF();

            System.out.println("Received--->"+echo);

            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            dos.writeUTF(msg);
            dos.flush();

            client.close();

            Thread.sleep(1000);
        }

    }
}
