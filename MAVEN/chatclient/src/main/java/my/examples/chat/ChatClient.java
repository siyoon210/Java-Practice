package my.examples.chat;

import java.io.*;
import java.net.Socket;
import java.util.logging.Handler;

public class ChatClient extends Thread{
    private String ip;
    private int port;
    private String name;

    public ChatClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        BufferedReader keyboard = null;
        Socket socket = null;

        try {
            socket = new Socket(ip, port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line = null;

            InputHandler inputHandler = new InputHandler(in);
            inputHandler.start();

            while ((line = keyboard.readLine())!=null){
                out.println(line);
                out.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}