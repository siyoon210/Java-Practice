package sqs.test;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;

public class LambdaTest implements RequestHandler<String, String> {
    @Override
    public String handleRequest(String input, Context context) {
        try {
            SqsClient sqsClient = SqsClient.builder()
                    .region(Region.US_EAST_1)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "hello " + input;
    }
}
