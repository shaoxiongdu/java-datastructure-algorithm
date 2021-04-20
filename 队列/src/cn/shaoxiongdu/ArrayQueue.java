package cn.shaoxiongdu;

import com.sun.rowset.internal.WebRowSetXmlReader;

/**
 * ClassName : ArrayQueue
 * (c)CopyRight 2021/4/20 All rights reserved to ShaoxiongDu<shaoxiongdu.dev@gmail.com>
 */
public class ArrayQueue implements Queue{


    /**
     * 队头元素
     */
    private int front;

    /**
     * 队尾元素
     */
    private int rear;

    /**
     * 队列数组
     */
    private Object [] theArray;

    /**
     * 元素个数
     */
    private int size;

    /**
     * 构造大小为10的默认环形队列
     * @throws Exception 容量错误返回此异常
     */
    public ArrayQueue() throws Exception {
        this(10);
    }

    /**
     * 构造指定大小的环形队列
     * @param capacity 容量
     * @throws Exception 容量错误返回此异常
     */
    public ArrayQueue(int capacity) throws Exception {

        if(capacity < 1 || capacity > 10000) throw new Exception("容量错误");
        this.theArray = new Object[capacity];
        // 头指针置0
        front = 0;
        // 头指针置0
        rear = 0;
        // 元素个数置0
        size = 0;
    }

    /**
     * 清空队列中全部元素
     */
    @Override
    public void clear() {
        for (Object o : theArray) {
            o = null;
        }
    }

    /**
     * 判断是否为空
     * @return
     */
    @Override
    public boolean empty() {
        return rear == front;
    }

    /**
     * 获取头元素
     * @return
     */
    @Override
    public Object getHead() {
        return theArray[front];
    }

    /**
     * 入队
     * @param object
     * @throws Exception 队列已满时抛出此异常
     */
    @Override
    public void enterObject(Object object) throws Exception {
        if(( rear + 1) % this.theArray.length == front) throw new Exception("队列已满!");
        /**
         * 入队
         */
        theArray [rear] = object;

        /**
         * 尾指针后移
         */
        rear = (rear + 1) % this.theArray.length;
        size++;
    }

    /**
     *  出队
     * @return
     * @throws Exception 队列为空时抛出此异常
     */
    @Override
    public Object deleteObject() throws Exception{
        if(empty()) throw new Exception("队列为空");
        Object object = theArray[front];
        front = (front + 1) % this.theArray.length;
        return object;
    }

    @Override
    public int size() {
        return size;
    }
}
