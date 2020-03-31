package practice.clone;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@NoArgsConstructor
class MyClass {
    Integer value;
    String strVale;

    public MyClass(Integer value, String strVale) {
        this.value = value;
        this.strVale = strVale;
    }
}

public class CloneTest {
    public static void main(String[] args) {
        final MyClass[] myClasses = new MyClass[3];
        myClasses[0] = new MyClass(1000, "1000");
        final MyClass[] clone = myClasses.clone();
        System.out.println("(myClasses == clone) = " + (myClasses == clone));
        System.out.println("(myClasses[0] == clone[0]) = " + (myClasses[0] == clone[0]));
        clone[0].strVale = "clone 2000";
        System.out.println("myClasses[0].strVale = " + myClasses[0].strVale);
    }
}
