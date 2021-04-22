package org.githubvictorhanxu.examples;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket server = new ServerSocket(8888);
        String echo = "";
        while(true){
            Socket socket = server.accept();
            System.out.println("Client connection established.");
            String msg = "Welcome, you are connected with server-"+Math.random();
            /*BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write(msg);
            bw.newLine();
            bw.flush();*/
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(msg);
            dos.flush();

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            echo = dis.readUTF();

            System.out.println("Received from client--->"+echo);
            Thread.sleep(1000);

        }
    }
}
