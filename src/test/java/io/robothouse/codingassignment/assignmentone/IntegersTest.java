package io.robothouse.codingassignment.assignmentone;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegersTest {

    @Test
    public void testCalculateGCDArray() {
        GCDIntegers integers = new GCDIntegers(new int[]{4, 64, 32, 120});
        int result = integers.calculateGCDArray();
        assertEquals(4, result);
    }

    @Test
    public void testCalculateGCDArrayWithPrimes() {
        GCDIntegers integers = new GCDIntegers(new int[]{3, 5, 7, 11});
        int result = integers.calculateGCDArray();
        assertEquals(1, result);
    }

    @Test
    public void testCalculateGCDArrayWithSameNumbers() {
        GCDIntegers integers = new GCDIntegers(new int[]{8, 8, 8, 8});
        int result = integers.calculateGCDArray();
        assertEquals(8, result);
    }

    @Test
    public void testCalculateGCDArrayWithOneNumber() {
        GCDIntegers integers = new GCDIntegers(new int[]{10});
        int result = integers.calculateGCDArray();
        assertEquals(10, result);
    }

    @Test
    public void testCalculateGCDArrayWithZero() {
        GCDIntegers integers = new GCDIntegers(new int[]{0, 10, 20});
        int result = integers.calculateGCDArray();
        assertEquals(10, result);
    }
}
