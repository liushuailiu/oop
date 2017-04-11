package com.ysd.view;

/**
 * Created by FanLiYang on 2017/4/10.
 * 利用数组实现栈
 */
public class MyArrayStack<T>{

    private static final int DEFAULT_CAPACITY = 10 ;
    private int size ;
    private int top ;
    private T[] items ;

    public void push(T t){
        if(items.length==size())
            ensureCapacity(size()*2+1);
        items[top+1] = t ;
        this.top ++ ;
        this.size ++ ;
    }

    public T pop(){
        if(top<0)
            throw new IndexOutOfBoundsException();
        T t = items[top];
        top -- ;
        this.size -- ;
        return t;
    }

    public MyArrayStack(){
        doClear();
    }

    private void doClear() {
        this.size = 0 ;
        this.top = -1 ;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size(){
        return this.size ;
    }

    private void ensureCapacity(int newCapacity){
        if(newCapacity<size())
            return;
        T[] old = items ;
        items = (T[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            items[i] = old[i] ;
        }
    }

}
