package io.robothouse.codingassignments.assignmentone;

public class GCDIntegers {
    private final int[] numbers;

    public GCDIntegers(int[] numbers) {
        this.numbers = numbers;
    }

    public int calculateGCDArray() {
        int res = numbers[0];

        for (int num : numbers) {
            res = calculateGCD(res, num);
        }

        return res;
    }

    private int calculateGCD(int a, int b) {
        if (a < b) {
            int temp = b;
            b = a;
            a = temp;
        }
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}


