package practice.builderPattern;

import java.util.Objects;

/**
 * 이펙티브 자바 - 아이템51 메서드 시그니처는 신중하게. 참고
 * 너무 많은 매개변수를 넘겨야 할때 하나의 헬퍼 클래스 사용하여 넘김
 * (헬퍼클래스는 보통 정적 멤버 클래스로 선언한다고 한다.)
 * 생각해보니 헬퍼 클래스에 빌더패턴 정도만 적용하는 것이니 실전에서도 충분히 생각하고 적용 가능 할듯
 */
public class TooManyParameter {
    public static void main(String[] args) {
        Member puru = Member.builder()
                .name("puru")
                .age(7)
                .job("entertainer")
                .phone("01012345678")
                .execute();
//        Member beko = new Member();

        printMemberInfo(puru);
    }

    private static void printMemberInfo(Member member) {
        System.out.println("member.toString() = " + member.toString());
    }
}

class Member {
    private String name;
    private int age;
    private String job;
    private String phone;

    private Member() {} //생성을 빌더패턴으로 강제하기 위한 접근제어자 처리

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    static Builder builder() {
        return new Member.Builder();
    }

    static class Builder {
        private String name;
        private int age;
        private String job;
        private String phone;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder job(String job) {
            this.job = job;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Member execute() { // = build()
            Member member = new Member();
            member.name = Objects.requireNonNull(name, "이름 널 안됨"); //널 검사 한줄에!
            member.age = age;
            member.job = job;
            member.phone = phone;

            return member;
        }
    }
}