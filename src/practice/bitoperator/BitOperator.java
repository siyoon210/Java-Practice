package practice.bitoperator;


import static org.assertj.core.api.Assertions.assertThat;

/**
 * XOR : 두개의 비트가 다르면 1, 같으면 0을 반환한다.
 * 이러한 특징때문에 숫자 N과 0을 XOR 연산하면 항상 숫자 N이 반환된다.
 */
public class BitOperator {
    public static void main(String[] args) {
        int a = 1; // 01
        int b = 2; // 10
        int c = 1; // 01
        final int ZERO = 0; // 00

        assertThat(a & b).isEqualTo(0);
        assertThat(a | b).isEqualTo(3);
        assertThat(a ^ b).isEqualTo(3);
        assertThat(a ^ c).isEqualTo(0);

        assertThat(a ^ ZERO).isEqualTo(a);
        assertThat(b ^ ZERO).isEqualTo(b);
    }
}
