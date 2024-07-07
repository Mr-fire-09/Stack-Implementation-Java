package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class StackService {
    private static final int MAX = 5;
    private int[] arr = new int[MAX];
    private int top = -1;

    public void push(int item) {
        if (top == MAX - 1) {
            throw new RuntimeException("Stack overflow: Cannot push " + item + ". The stack is full.");
        }
        arr[++top] = item;
    }

    public int pop() {
        if (top == -1) {
            return -999; // Return -999 as an error code
        }
        return arr[top--];
    }

    public int peek() {
        if (top == -1) {
            return -999; // Return -999 as an error code
        }
        return arr[top];
    }

    public void reset() {
        top = -1;
    }
}
