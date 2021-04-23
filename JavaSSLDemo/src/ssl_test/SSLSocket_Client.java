package ssl_test;

import tools.SslContextFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

public class SSLSocket_Client extends Thread{
    SSLSocket socket = null;

    public SSLSocket_Client() {
        try {
            SSLContext sslContext = SslContextFactory.get_client_sslContext();
            socket = (SSLSocket) sslContext.getSocketFactory().createSocket(InetAddress.getLocalHost(), 6666);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        byte[] by = null;
        by = "Hello world!".getBytes(StandardCharsets.UTF_8);
        try {
            socket.getOutputStream().write(by, 0, by.length);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SSLSocket_Client().start();
    }
}
