package tools;

import javax.net.ssl.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;

public class SslContextFactory {
    static SSLContext server_sslContext = null;
    static SSLContext client_sslContext = null;

    public static SSLContext get_server_sslContext() throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException, IOException, CertificateException, KeyManagementException {
        if (server_sslContext == null) {
            server_sslContext = SSLContext.getInstance("SSL");
        }

        server_sslContext.init(get_KeyManagers("E:\\Projects\\Security\\JavaSSLSocket\\server.jks", "cccccc"),
                get_TrustManagers("E:\\Projects\\Security\\JavaSSLSocket\\root.jks", "cccccc"), null);

        return server_sslContext;
    }

    public static SSLContext get_client_sslContext() throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException, IOException, CertificateException, KeyManagementException {
        if (client_sslContext == null) {
            client_sslContext = SSLContext.getInstance("SSL");
        }

        client_sslContext.init(get_KeyManagers("E:/Projects/Security/JavaSSLSocket/client.jks", "cccccc"),
                get_TrustManagers("E:/Projects/Security/JavaSSLSocket/root.jks", "cccccc"), null);

        return client_sslContext;
    }



    private static TrustManager[] get_TrustManagers(String ca_Path, String ca_pass) throws IOException, NoSuchAlgorithmException, KeyStoreException, CertificateException {
        TrustManager[] trustManagers = null;
        TrustManagerFactory factory = null;
        KeyStore keyStore=null;

        keyStore = get_keystore(ca_Path, ca_pass);
        if(keyStore==null) {
            return null;
        }
        factory = TrustManagerFactory.getInstance("SunX509");
        factory.init(keyStore);
        trustManagers=factory.getTrustManagers();
        return trustManagers;
    }

    private static KeyManager[] get_KeyManagers(String store_path, String store_pass) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException, IOException, CertificateException {
        KeyManager[] keyManagers = null;
        KeyManagerFactory factory = null;
        KeyStore keyStore = null;

        keyStore = get_keystore(store_path, store_pass);

        if (keyStore == null) { return null; }

        factory = KeyManagerFactory.getInstance("SunX509");

        factory.init(keyStore, store_pass.toCharArray());
        keyManagers = factory.getKeyManagers();
        return keyManagers;
    }

    private static KeyStore get_keystore(String store_path, String store_pass) throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException {
        InputStream inputStream = null;
        //inputStream = SslContextFactory.class.getResourceAsStream(store_path);
        inputStream = new FileInputStream(store_path);
        if (inputStream == null) {
            throw new IOException("Certificate not found.");
        }

        KeyStore keyStore = null;
        keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(inputStream, store_pass.toCharArray());
        if (inputStream != null) {
            inputStream.close();
        }

        return keyStore;
    }

    public static void main(String[] args) throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException {
        InputStream inputStream = null;
        inputStream = SslContextFactory.class.getResourceAsStream("server.jks");
        //inputStream = new FileInputStream("E:\\Projects\\Security\\JavaSSLSocket\\server.jks");
        if (inputStream == null) {
            throw new IOException("Certificate not found.");
        }

        KeyStore keyStore = null;
        keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(inputStream, "cccccc".toCharArray());
        if (inputStream != null) {
            inputStream.close();
        }

    }
}
