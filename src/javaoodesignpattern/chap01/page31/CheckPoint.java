package javaoodesignpattern.chap01.page31;

import java.util.List;

public class CheckPoint {
    class Student{
        List<Transcript> transcripts;
    }

    class Transcript{
        Student student;
        Course course;
    }

    class Course{
        List<Transcript> transcripts;
    }
}
