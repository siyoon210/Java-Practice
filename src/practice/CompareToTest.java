package practice;

import java.util.HashSet;
import java.util.TreeSet;

public class CompareToTest {
    private static class Person implements Comparable<Person> {
        String name;
        int score;

        public Person(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Person o) {
            if (o.score == score) {
                return name.compareTo(o.name);
            }
            return Integer.compare(o.score, score);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person)) return false;

            Person person = (Person) o;

            return name.equals(person.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }

    public static void main(String[] args) {
        Person puru = new Person("puru", 100);
        Person puru2 = new Person("puru", 80);

        TreeSet<Person> treeSet = new TreeSet<>();
        treeSet.add(puru);
        treeSet.add(puru2);
        System.out.println("treeSet = " + treeSet);

        HashSet<Person> hashSet = new HashSet<>();
        hashSet.add(puru);
        hashSet.add(puru2);
        System.out.println("hashSet = " + hashSet);

        System.out.println("puru.compareTo(puru2) = " + puru.compareTo(puru2));
        System.out.println("puru.equals(puru2) = " + puru.equals(puru2));
    }
}
