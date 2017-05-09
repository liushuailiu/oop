package com.ysd.view;

/**
 * Created by fanliyang on 17-5-9.
 */

public class MyArrayQueue<T> {

    private static final int DEFAULT_CAPACITY = 10 ;
    private int front ;
    private int rear ;
    private int theSize ;
    private T[] theItems ;

    public MyArrayQueue() {
        clear();
    }

    public boolean isEmpty(){
        return theSize == 0;
    }

    public boolean enqueue(T t){
        if(theSize == DEFAULT_CAPACITY)
            return false;
        theItems[rear++] = t ;
        theSize ++ ;
        if(rear == DEFAULT_CAPACITY)
            rear = 0 ;
        return true ;
    }

    public T dequeue(){
        if( theSize == 0 )
            return null ;
        theSize -- ;
        T temp = theItems[front];
        if(++front == DEFAULT_CAPACITY)
            front = 0 ;
        return temp ;
    }

    private void clear() {
        theItems = (T[]) new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = 0 ;
        theSize = 0 ;
    }

}
