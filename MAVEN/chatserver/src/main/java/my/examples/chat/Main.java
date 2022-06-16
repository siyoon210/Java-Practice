package my.examples.chat;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println(InetAddress.getLocalHost().getHostAddress() + ":" + args[0]);
        ChatServer chatServer = new ChatServer(Integer.parseInt(args[0]));
        chatServer.start();
    }
}
