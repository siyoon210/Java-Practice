package sqs.test;

public class Main {
    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();
        String siyoon = lambdaTest.handleRequest("siyoon", null);
//        System.setProperties(new Properties().setProperty(""));
        System.out.println(siyoon);
    }
}
