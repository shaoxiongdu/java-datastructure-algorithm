package cn.shaoxiongdu;

/**
 * ClassName : ArrayList
 * (c)CopyRight 2021/4/12 All rights reserved to ShaoxiongDu<shaoxiongdu.dev@gmail.com>
 */
public class ArrayList implements List{

    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    private Object [] elementData;

    /**
     * 默认扩容倍数
     */
    private static final int DEFAULT_EXPAND_MULTIPLE = 2;

    /**
     * 元素数量
     */
    private int size;

    /**
     * 创建默认容量(10)的数组线性表
     */
    public ArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * 创建指定大小的数组线性表
     * @param size 指定大小
     * @throws Exception 若传入的容量大于9999或者小于0则抛出此异常
     */
    public ArrayList(int size) throws Exception {
        if(size <= 0 || size > 9999) throw new Exception("容量数据错误!");
        elementData = new Object[size];
    }


    public void print() {
        System.out.println("==================================");
        for (int i = 1; i <= this.size(); i++) {
            try {
                System.out.println(this.get(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("==================================");
    }

    /**
     * 判断是否为空
     * @return
     */

    public boolean isEmpty() {
        return size==0;
    }


    public void clear() {
        for (int i = 0; i < elementData.length; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    /**
     *  返回指定位置处的下标
     * @param index
     * @return
     * @throws Exception 若下标<0或者大于线性表的长度 抛出此异常
     */

    public Object get(int index) throws Exception {
        if(index < 0 || index > elementData.length) throw new Exception("下标错误");
        return elementData[index-1];
    }

    /**
     * 返回指定元素的下标
     * @param object
     * @return 如果线性表中没有,则返回-1
     */

    public int findIndexByObject(Object object) {
        if(object == null) return -1;
        for (int i = 0; i < elementData.length; i++) {
            if(object.equals(elementData[i])) return i+1;
        }
        return -1;
    }

    /**
     * 向指定位置添加元素
     * @param index 指定位置
     * @param object 指定元素
     * @return
     * @throws Exception 如果下标小于0或者大于容量则抛出此异常
     */

    public Object insert(int index, Object object) throws Exception {

        if( index < 0 || index > elementData.length) throw new Exception("下标错误!");

        //如果容量已满 则自动扩容
        if(size == elementData.length){
            expansion();
        }
        elementData[index-1] = object;
        return elementData[index-1];
    }

    /**
     * 添加元素
     * @param object
     * @return 返回添加好的元素
     */

    public Object insert(Object object) throws Exception {
        //如果容量已满 则自动扩容
        if(size == elementData.length){
            expansion();
        }
        elementData[size] = object;
        size++;
        return elementData[size];
    }

    /**
     * 删除指定位置的元素
     * @param index 指定位置
     * @return
     * @throws Exception 如果下标小于0或者大于元素个数则抛出此异常
     */

    public Object delete(int index) throws Exception {
        if( index < 0 || index > size) throw new Exception("下标错误!");
        Object object = elementData[index-1];
        for (int i = index-1; i < elementData.length-1-1; i++) {
            elementData[i] = elementData[i+1];
        }
        size--;
        return object;
    }




    public int size() {
        return size;
    }

    /**
     * 扩容
     */
    private void expansion(){
        Object[] newElementData = new Object[elementData.length * DEFAULT_EXPAND_MULTIPLE];
        for (int i = 0; i < elementData.length; i++) {
            newElementData[i] = elementData[i];
        }
        elementData = newElementData;
    }
}
