package my.examples.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServer extends Thread {

    private final int port;
    private final Set<PrintWriter> socketSet;

    public ChatServer(int port) {
        this.port = port;
        this.socketSet = new HashSet<>();
    }

    public void addPrintWriter(PrintWriter out) {
        System.out.println("새로운 커낵션!");
        socketSet.add(out);
    }

    public void removePrintWriter(PrintWriter out) {
        socketSet.remove(out);
    }

    public void broadCast(String msg) {
        System.out.println("ChatServer.broadCast : " + msg);
        for (PrintWriter out : socketSet) {
            try {
                out.println("> " + msg);
                out.flush();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket socket = serverSocket.accept(); //블록킹 메소드
                SocketHandler socketHandler = new SocketHandler(this, socket);
                socketHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}