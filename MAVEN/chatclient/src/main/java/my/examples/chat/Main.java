package my.examples.chat;

public class Main {
    public static void main(String[] args){
        ChatClient chatClient = new ChatClient("192.168.0.158", 11000);
        chatClient.start();
    }
}