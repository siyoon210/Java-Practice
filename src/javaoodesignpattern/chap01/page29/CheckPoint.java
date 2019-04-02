package javaoodesignpattern.chap01.page29;

import java.util.List;

public class CheckPoint {
    class Student {
        List<Course> courses;

        public void registerCourse(Course course) {
        }

        public void dropCourse(Course course) {

        }
    }

    class Course{
        List<Student> students;
    }
}
