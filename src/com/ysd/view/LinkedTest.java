package com.ysd.view;

/**
 * Created by FanLiYang on 2017/3/31.
 */
public class LinkedTest {
    public static void main(String[] args) {

        MyArrayStack myStack = new MyArrayStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        myStack.push(7);
        myStack.push(8);
        myStack.push(9);
        myStack.push(10);
        myStack.push(11);
        myStack.push(12);
        myStack.push(13);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
