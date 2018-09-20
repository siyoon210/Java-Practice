package my.examples.was;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Connector connector = new Connector(8080);
        connector.run();
    }

}
