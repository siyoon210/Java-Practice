package elrisgame;

import java.util.Random;

class RandomUtil {
    private static final Random random = new Random();

    public static int getRandomInt(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}
