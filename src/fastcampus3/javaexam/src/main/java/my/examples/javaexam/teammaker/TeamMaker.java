package my.examples.javaexam.teammaker;

import java.util.*;

class Student {
    private String name;
    private int preTeamIndex;

    Student(String name, int teamIndex) {
        this.name = name;
        this.preTeamIndex = teamIndex;
    }

    String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return preTeamIndex == student.preTeamIndex;
    }

    @Override
    public int hashCode() {
        return preTeamIndex;
    }
}

class Team {
    private Set<Student> students;
    private int maxSize;

    Team(int maxSize) {
        this.students = new HashSet<>();
        this.maxSize = maxSize;
    }

    Set<Student> getStudents() {
        return students;
    }

    void setStudents(Set<Student> students) {
        this.students = students;
    }

    int getMaxSize() {
        return maxSize;
    }
}

public class TeamMaker {
    public static void main(String[] args) throws Exception {
        List<Student> students = new ArrayList<>();
        students.add(new Student("박재희", 1));
        students.add(new Student("최원오", 1));
        students.add(new Student("김대용", 1));
        students.add(new Student("여현석", 2));
//        students.add(new Student("백병화", 2));
        students.add(new Student("박찬종", 2));
        students.add(new Student("최주리", 3));
        students.add(new Student("서청원", 3));
        students.add(new Student("민경수", 3));
//        students.add(new Student("윤여훈", 4));
        students.add(new Student("최다빈", 4));
        students.add(new Student("정미수", 4));
        students.add(new Student("조은현", 5));
        students.add(new Student("윤 정", 5));

        List<Team> teams = new ArrayList<>();
        teams.add(new Team(3));
        teams.add(new Team(3));
        teams.add(new Team(3));
        teams.add(new Team(3));


        while (true){
            Collections.shuffle(students);
            for (Student student : students) {
                for (Team team : teams) {
                    if (team.getStudents().size() < team.getMaxSize() && team.getStudents().add(student)) {
                        break;
                    }
                }
            }
            int checkSize = 0;
            for (Team t : teams) {
                checkSize += t.getStudents().size();
            }
            if (checkSize < students.size()) {
                for (Team t : teams) {
                    t.setStudents(new HashSet<>());
                }
            } else {
                break;
            }
        }


        for (Team t : teams) {
            for (Student s : t.getStudents()) {
                System.out.print(s.getName()+"\t");
                Thread.sleep(1000);
            }
            System.out.println();
        }

    }

}
