package my.examples.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ChatServer extends Thread{
    private int port;
    private Set<PrintWriter> socketSet;

    public ChatServer(int port) {
        this.port = port;
    }

    public void addPrintWriter(PrintWriter out){
        socketSet.add(out);
    }

    public void removePrintWriter(PrintWriter out){
        socketSet.remove(out);
    }

    public void broadCast(String msg){
        for(PrintWriter out : socketSet){
            try {
                out.println(msg);
                out.flush();
            }catch(Exception ex){}
        }
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(port);

            while (true) {
                socket = serverSocket.accept(); //블록킹 메소드
                SocketHandler socketHandler = new SocketHandler(this, socket);
                socketHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}