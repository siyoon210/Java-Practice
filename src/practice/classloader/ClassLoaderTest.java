package practice.classloader;

import practice.clone.CloneTest;

// 참고 https://stackoverflow.com/questions/1921238/getclass-getclassloader-is-null-why
public class ClassLoaderTest {
    public static void main(String[] args) {
        // Some implementations may use null to represent the bootstrap class loader.
        // This method will return null in such implementations if this class was loaded by the bootstrap class loader.
        System.out.println(Integer.class.getClassLoader());

        // AppClassLoader represented
        final ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader.getClass().getName());

        // ExtensionClassLoader represented
        System.out.println(classLoader.getParent().getClass().getName());

        // BootstrapClassLoader represented null!
        System.out.println(classLoader.getParent().getParent());

    }
}
