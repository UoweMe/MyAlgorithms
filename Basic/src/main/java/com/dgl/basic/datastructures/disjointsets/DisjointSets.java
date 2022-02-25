package com.dgl.basic.datastructures.disjointsets;

/**
 * 不相交集，又称为并查集。
 * @param <T>
 */
public class DisjointSets<T> {

    /**
     * 首先我们需要创建n个单元素集合，每个元素的父元素为自身。
     *
     * @param x
     * @return
     */
    public Node<T> MakeSet(T x) {
        return new Node<>(x);
    }

    /**
     * 该函数可以检查一个元素是否属于一个集合，也可以确定一条边（两个点）是否属于同一集合，
     * 返回之后为集合的代表（根），也就是一个集合，即等价类，路径压缩在这里实现。
     *
     * @param node
     * @return
     */
    public Node<T> FindSet(Node<T> node) {
        if (node != node.parent) {
            node.parent = FindSet(node.parent);
        }

        return node.parent;
    }

    /**
     * 该联合操作先调用find查找检查x、y是否在同一个等价类中；
     * 若不在同一个等价类则执行合并操作，联合或合并两个集合成一个集合；
     * 该操作可以检查一个图是否存在环，合并优化采用按秩合并(按高度合并)。
     * @param x
     * @param y
     */
    public void UnionSet(Node<T> x, Node<T> y) {
        Node<T> nx = FindSet(x);
        Node<T> ny = FindSet(y);

        if (nx == ny) {
            return;
        }
        if (nx.rank > ny.rank) {
            ny.parent = nx;
        } else if (ny.rank > nx.rank) {
            nx.parent = ny;
        } else {
            nx.parent = ny;
            ny.rank++;
        }
    }
}
