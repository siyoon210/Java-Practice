package my.examples.chat;

import java.io.*;
import java.net.Socket;

public class SocketHandler extends Thread {

    private final ChatServer chatServer;
    private final Socket socket;

    public SocketHandler(ChatServer chatServer, Socket socket) {
        this.chatServer = chatServer;
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in;
        PrintWriter out;

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            System.out.println(socket.getInetAddress().getHostAddress());
            chatServer.addPrintWriter(out);
            while (true) {
                chatServer.broadCast(in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
