package my.examples.was;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        //System.out.println(Object.class.getClass().getResource("/").getPath());
        Connector connector = new Connector(8080);
        connector.run();
    }

}

