package cn.shaoxiongdu;

/**
 * InterfaceName : Stack
 * (c)CopyRight 2021/4/14 All rights reserved to ShaoxiongDu<shaoxiongdu.dev@gmail.com>
 *     栈的接口
 */
public interface Stack {

    /**
     * 如果栈存在,则销毁栈
     */
    public void destroy();

    /**
     * 清空栈元素
     */
    public void clear();

    /**
     * 判断栈是否为空
     */
    public boolean empty();

    /**
     * 如果栈存在且非空,返回栈顶元素
     * @return 如果栈空,则返回NULL
     */
    public Object getTop() throws Exception;

    /**
     * 插入新元素到栈顶
     * @param object
     * @throws Exception 若栈被销毁或者已满 抛出此异常
     */
    public void push(Object object);

    /**
     * 弹出栈顶元素
     * @return
     * @throws Exception 若栈被销毁或者栈为空,则抛出此异常
     */
    public Object pop() throws Exception;

    /**
     * 返回栈中元素个数
     * @return
     */
    public int size();



}
