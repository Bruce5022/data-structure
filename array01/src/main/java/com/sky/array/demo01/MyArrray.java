package com.sky.array.demo01;

public class MyArrray {
    private int[] data;//数据,容量字段不需要维护,data.length()就是容量的长度
    private int size;// 记录有多少个有效元素

    /**
     * capacity数组容量
     *
     * @param capacity
     */
    public MyArrray(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public MyArrray() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return data.length == 0;
    }

    public void addLast(int e) {
        add(size, e);
    }

    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 在第index个位置插入一个新元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, int e) {
        if (size == data.length)
            throw new IllegalArgumentException("AddLast failed.Array is full.");
        // 保证往size之前的元素中放,如果放到size后面,就会有空的格子
        if (index < 0 || index > size)
            throw new IllegalArgumentException("AddLast failed.Array index >= 0 and index <= size.");

        // 思路:从有元素的格子遍历,拿着当前格子后移,遍历,直到找到下标==index的位置,加入后,退出程序
        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];
        data[index] = e;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(",");
        }
        res.append("]");
        return res.toString();
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed.Index is illegal.");
        return data[index];
    }


    public void set(int index,int e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed.Index is illegal.");
        data[index] = e;
    }

}
