package my.examples.chat;

public class Main {

    public static void main(String[] args) {
        System.out.println(args[0] + ":" + args[1] + "로 접속 시도");
        ChatClient chatClient = new ChatClient(args[0], Integer.parseInt(args[1]));
        chatClient.start();
    }
}