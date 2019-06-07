package practice.serialization;

import java.io.*;

class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private transient int id; //transient 키워드를 달면 직렬화 할때 저장하지 않는다.
    private String name;
    private String phone;

    public User(final int id, final String name, final String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

public class SerializationTest {
    public static void main(String[] args) throws Exception {
        User user = new User(1, "푸루", "010-1234-5678");

        FileOutputStream fileOutputStream = new FileOutputStream("./src/practice/serialization/user1Info.bin");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(user);
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("./src/practice/serialization/user1Info.bin");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        User userFromBinFile = (User) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("userFromBinFile.toString() = " + userFromBinFile.toString());
    }
}
