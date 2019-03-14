package practice.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

class Job extends Thread {
    private int id;
    private SharingObject sharingObject1;
    private SharingObject sharingObject2;

    public Job(int id, SharingObject sharingObject1, SharingObject sharingObject2) {
        this.id = id;
        this.sharingObject1 = sharingObject1;
        this.sharingObject2 = sharingObject2;
    }

    @Override
    public void run() {
        System.out.println(id + "번의 run 메소드 시작!");

        for (int i = 0; i < 1000; i++) {
            sharingObject1.lock.lock();
            if (sharingObject2.lock.tryLock()) {
                sharingObject2.lock.lock();
                while (true) {

                }
            }
        }
    }
}

class SharingObject {
    Lock lock = new Lock() {
        @Override
        public void lock() {

        }

        @Override
        public void lockInterruptibly() throws InterruptedException {

        }

        @Override
        public boolean tryLock() {
            return false;
        }

        @Override
        public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
            return false;
        }

        @Override
        public void unlock() {

        }

        @Override
        public Condition newCondition() {
            return null;
        }
    };
}

public class MyThreadTest {
    public static void main(String[] args) {
        SharingObject sharingObject1 = new SharingObject();
        SharingObject sharingObject2 = new SharingObject();

        Job job1 = new Job(1, sharingObject1, sharingObject2);
        Job job2 = new Job(2, sharingObject2, sharingObject1);

        job1.start();
        job2.start();
    }
}
