package com.ysd.view;

/**
 * Created by FanLiYang on 2017/4/18.
 */
public class Test {
    public static void main(String[] args) {
        MyCircularLinkedList<Integer> my = new MyCircularLinkedList<>();
        for (int i = 1; i <=400 ; i++) {
            my.add(i);
        }

        my.remove();
        System.out.println(my.get(0));
        System.out.println(my.get(1));
        System.out.println(my.get(2));
    }
}
