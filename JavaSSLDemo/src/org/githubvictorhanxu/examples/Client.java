package org.githubvictorhanxu.examples;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.Socket;

public class Client {
    private static String CLIENT_KEYSTORE = "E:/Projects/Security/SSL_keystore/victor_client_ks.jks";

    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("javax.net.ssl.trustStore", CLIENT_KEYSTORE);
        System.setProperty("javax.net.debug", "ssl,handshake");
        SocketFactory sf = SSLSocketFactory.getDefault();

            //Socket client = new Socket("localhost", 8888);
            Socket client = sf.createSocket("localhost", 8443);
            String echo = "";
            String msg = "Hello from Client-" + Math.random();
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            echo = br.readLine();

            //DataInputStream dis = new DataInputStream(client.getInputStream());
            //echo = dis.readUTF();

            System.out.println("Received--->"+echo);

            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            //dos.writeUTF(msg);
            //dos.flush();

            client.close();

            Thread.sleep(1000);

    }
}
