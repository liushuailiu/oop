package com.ysd.tree;

/**
 * Created by fanliyang on 17-5-15.
 * 二叉查找树
 */
public class BinarySearchTree<T extends Comparable<? super T>>{

    private BinaryNode<T> root ; //根节点

    public BinarySearchTree() {
        this.root = null;
    }

    public void makeEmpty(){
        this.root = null;
    }

    public boolean isEmpty(){
        return this.root == null ;
    }

    //判断二叉树 t 中是否含有节点 x

    private boolean contains(T x , BinaryNode<T> t){
        if (t==null)
            return false;
        int compareResult = x.compareTo(t.element);
        if(compareResult<0)
            return contains(x,t.left);
        else if (compareResult>0)
            return contains(x,t.right);
        else
            return true ;
    }

    // 二叉树查询最小值的递归实现
    private BinaryNode<T> findMin(BinaryNode<T> t){
        if(t==null)
            return null;
        else if (t.left == null)
            return t ;
        return findMin(t.left);
    }

    //  二叉树查询最大值的循环实现
    private BinaryNode<T> findMax(BinaryNode<T> t){
        if( t!=null )
            while ( t.right != null )
                t = t.right ;
        return t ;
    }


    private static class BinaryNode<T>{

        T element ;
        BinaryNode<T> left ;
        BinaryNode<T> right ;

        public BinaryNode(T theElement) {
            this(theElement,null,null);
        }

        public BinaryNode(T theElement,BinaryNode<T> it ,BinaryNode<T> rt) {
            element = theElement ;
            left = it ;
            right = rt ;
        }
    }


}
