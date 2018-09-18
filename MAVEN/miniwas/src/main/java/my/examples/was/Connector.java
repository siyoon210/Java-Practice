package my.examples.was;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class Connector extends Thread{
    private int port;
    private Set<InetAddress> InetAddresses = new HashSet<>();

    public Connector(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(port);
            while (true){
                socket = serverSocket.accept();

                if(InetAddresses.add(socket.getInetAddress())){
                    Handler handler = new Handler(this, socket);
                    handler.start();
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}

