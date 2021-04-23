package org.githubvictorhanxu.examples;

import javax.net.ServerSocketFactory;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.*;
import java.security.cert.CertificateException;

/***
 * keytool -genkey -alias victor-ssl-demo-server -keyalg RSA -keystore ./victor_server_ks -dname "CN=localhost,OU=cn,O=cn,L=cn,ST=cn,C=cn" -storepass server -keypass 123123
 *
 * keytool -genkey -alias victor-ssl-demo-client -keyalg RSA -keystore ./victor_client_ks -dname "CN=localhost,OU=cn,O=cn,L=cn,ST=cn,C=cn" -storepass client -keypass 456456
 */
public class Server extends Thread{

    private static String SERVER_KEYSTORE = "E:/Projects/Security/SSL_keystore/victor_server_ks.jks";
    private static String SERVER_KEYSTORE_PASSWORD = "server";

    public static void main(String[] args) throws IOException, InterruptedException, NoSuchAlgorithmException, KeyStoreException, CertificateException, UnrecoverableKeyException, KeyManagementException {
        //ServerSocket server = new ServerSocket(8888);
        String echo = "";

        System.setProperty("javax.net.ssl.trustStore", SERVER_KEYSTORE);
        SSLContext context = SSLContext.getInstance("TLS");

        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(new FileInputStream(SERVER_KEYSTORE), null);

        KeyManagerFactory kf = KeyManagerFactory.getInstance("SunX509");
        kf.init(ks, SERVER_KEYSTORE_PASSWORD.toCharArray());

        context.init(kf.getKeyManagers(), null, null);

        ServerSocketFactory factory = context.getServerSocketFactory();
        ServerSocket _socket = factory.createServerSocket(8443);

            ((SSLServerSocket)_socket).setNeedClientAuth(false);
            Socket socket = _socket.accept();
            System.out.println("Client connection established.");
            String msg = "Welcome, you are connected with server-"+Math.random();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write(msg);
            bw.newLine();
            bw.flush();
            /*DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(msg);
            dos.flush();*/

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            echo = dis.readUTF();

            System.out.println("Received from client--->"+echo);
            Thread.sleep(1000);

    }
}
