package practice.polymorphism.update;

public class TestAnti {
    void testExecuteDoA() {
        FLAG = true;
        Update u = new Update();
        u.execute();
        assertThat(/*Do A*/);
    }

    void testExecuteDoB() {
        FLAG = false;
        Update u = new Update();
        u.execute();
        assertThat(/*Do B*/);
    }
}
