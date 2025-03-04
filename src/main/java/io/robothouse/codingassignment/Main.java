package io.robothouse.codingassignment;

import io.robothouse.codingassignment.assignmentone.GCDIntegers;

public class Main {
    public static void main(String[] args) {
        int val = new GCDIntegers(new int[]{4, 64, 32, 120}).calculateGCDArray();
        System.out.println(val);
    }
}