package fastcampus3.javaexam.src.main.java.my.examples.javaexam.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int lang;
    private int eng;
    private int math;

    public Student(String name, int lang, int eng, int math) {
        this.name = name;
        this.lang = lang;
        this.eng = eng;
        this.math = math;
    }

    public String getName() {
        return name;
    }

    public int getLang() {
        return lang;
    }

    public int getEng() {
        return eng;
    }

    public int getMath() {
        return math;
    }
}
public class StudentScore {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        loop:
        while (true) {
            System.out.print("이름 : ");
            String name = sc.next();
            System.out.print("국어 : ");
            int lang = sc.nextInt();
            System.out.print("영어 : ");
            int eng = sc.nextInt();
            System.out.print("수학 : ");
            int math = sc.nextInt();
//            sc.nextLine();
            studentList.add(new Student(name, lang, eng, math));

            String flag = null;

            while (true) {
                System.out.print("계속 입력 하시겠습니까? (Y/N) : ");
                flag = sc.next();

                if (flag.toUpperCase().equals("Y")) {
                    break;
                } else if (flag.toUpperCase().equals("N")) {
                    studentList.forEach(i-> System.out.println("이름 : "+ i.getName()+" "+ " 국어 : "+i.getLang()+ " 영어 : "+i.getEng()+ " 수학 : " +i.getMath()));
                    break loop;
                }
            }

        }
    }
}
