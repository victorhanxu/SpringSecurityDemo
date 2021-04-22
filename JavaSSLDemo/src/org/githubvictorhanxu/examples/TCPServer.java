package org.githubvictorhanxu.examples;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class TCPServer{
    public static void main(String[] args)throws IOException {
        ServerSocket listen = new ServerSocket(5050);

        Socket server  = listen.accept();
        InputStream in = server.getInputStream();
        OutputStream out = server.getOutputStream();
        char c = (char)in.read();
        System.out.println("收到:" + c);
        out.write('a');

        out.close();
        in.close();
        server.close();
        listen.close();
    }
}