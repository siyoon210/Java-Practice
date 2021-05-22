package me.siyoon.sample.p366;

import io.reactivex.Flowable;
import org.junit.jupiter.api.Assertions;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class P366 {
    public static void main(String[] args) throws InterruptedException {
        Iterable<Long> result = Flowable.interval(1000L, TimeUnit.MILLISECONDS)
                .take(5)
                .blockingIterable();

        Iterator<Long> iterator = result.iterator();

        Assertions.assertTrue(iterator.hasNext());

        Assertions.assertEquals(iterator.next(), 0L);
        Assertions.assertEquals(iterator.next(), 1L);
        Assertions.assertEquals(iterator.next(), 2L);
        Assertions.assertEquals(iterator.next(), 3L);
        Assertions.assertEquals(iterator.next(), 4L);

        Assertions.assertFalse(iterator.hasNext());

        Assertions.assertThrows(NoSuchElementException.class, iterator::next);
    }
}
