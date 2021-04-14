package cn.shaoxiongdu;

/**
 * ClassName : ArrayStack
 * (c)CopyRight 2021/4/14 All rights reserved to ShaoxiongDu<shaoxiongdu.dev@gmail.com>
 */
public class ArrayStack implements Stack{

    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 默认扩容倍数
     */
    private static  int DEFAULT_EXPAND_MULTIPLE = 2;

    private Object [] elementData = null;

    private int size;

    /**
     * 构造指定大小的栈
     * @param size
     */
    public ArrayStack(int size) {
        this.size = 0;
        this.elementData = new Object[size];
    }

    /**
     * 构造默认大小的栈
     */
    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 销毁栈
     */
    @Override
    public void destroy() {
        this.elementData = null;
    }

    /**
     * 清空栈
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
    }

    /**
     * 判断是否为空
     * @return
     */
    @Override
    public boolean empty() {
        return this.size == 0;
    }

    /**
     * 获取栈顶元素
     * @return
     * @throws Exception 若栈空 则抛出此异常
     */
    @Override
    public Object getTop() throws Exception {
        if(size==0){
            throw new Exception("栈空");
        }
        return elementData[size-1];
    }

    /**
     * 获取默认扩容倍数
     * @return
     */
    public static int getDefaultExpandMultiple() {
        return DEFAULT_EXPAND_MULTIPLE;
    }

    /**
     * 设置默认扩容倍数
     * @param defaultExpandMultiple
     */
    public static void setDefaultExpandMultiple(int defaultExpandMultiple) throws Exception {
        if(defaultExpandMultiple < 0) throw new Exception("默认扩容倍数参数错误");
        DEFAULT_EXPAND_MULTIPLE = defaultExpandMultiple;
    }

    /**
     * 压栈指定元素
     * @param object
     */
    @Override
    public void push(Object object){

        /**
         * 若当前栈满 则扩容
         */
        if(size == elementData.length){
            //扩大默认倍数
            expansion(DEFAULT_EXPAND_MULTIPLE);
        }
        size++;
        elementData[size-1] = object;
    }

    /**
     * 扩容指定倍数
     */
    public void expansion(int expandMultiple){
        Object[] newElementData = new Object[elementData.length * expandMultiple];
        for (int i = 0; i < elementData.length; i++) {
            newElementData [i] = elementData[i];
        }
        elementData = newElementData;
    }

    @Override
    public Object pop() throws Exception {
        Object elementDatum = elementData[size - 1];
        elementData[size-1] = null;
        size--;
        return elementDatum;
    }

    @Override
    public int size() {
        return this.size;
    }
}
