package org.githubvictorhanxu.examples;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

class TCPClient{
    public static void main(String[] args)throws IOException {
        Socket client = new Socket("127.0.0.1" , 5050);
        InputStream in = client.getInputStream();
        OutputStream out = client.getOutputStream();

        out.write('b');
        char c = (char)in.read();
        System.out.println("收到:" + c);
        out.close();
        in.close();
        client.close();
    }
}