package ssl_test;

import tools.SslContextFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SSLSocket_Server extends Thread{
    Socket socket = null;
    SSLServerSocket serverSocket = null;

    public SSLSocket_Server() {
        try {
            SSLContext sslContext = SslContextFactory.get_server_sslContext();
            serverSocket = (SSLServerSocket) sslContext.getServerSocketFactory().createServerSocket(6666);
            serverSocket.setNeedClientAuth(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        byte[] by = new byte[1024];
        try {
            socket = serverSocket.accept();
            socket.getInputStream().read(by);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String s = new String(by, "UTF-8");
            System.out.println("Received from client:" + s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new SSLSocket_Server().start();
        System.out.println("Server started");
    }
}
