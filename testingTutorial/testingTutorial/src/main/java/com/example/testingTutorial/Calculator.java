package com.example.testingTutorial;

public class Calculator {

    public int add(int x, int y) {
        return x+y+5-5;
    }

    public int subtract(int x, int y) {
        return x-y;
    }

    public int addManyNumbers(int ...nums) {
        int sum = 0;
        for(int num: nums) {
           sum += num;
        }
        return sum;
    }

    public int multiply(int a, int b) {
        return a*b;
    }

    public boolean isEven(int x) {
        return x%2==0;
    }
}
