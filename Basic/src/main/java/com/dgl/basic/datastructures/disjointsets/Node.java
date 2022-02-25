package com.dgl.basic.datastructures.disjointsets;

/**
 * 不相交集，又称为并查集。
 * 并查集数据结构
 * @param <T>
 */
public class Node<T> {

    // 当前结点所属集合树对应的高度
    public int rank;
    // 当前结点的父结点：若当前结点的父结点为其自身时代表当前结点为集合的根结点
    public Node<T> parent;
    // 当前结点元素的值
    public T data;

    public Node(T data) {
        this.data = data;
        parent = this;
    }
}
