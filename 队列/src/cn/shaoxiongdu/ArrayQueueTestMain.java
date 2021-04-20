package cn.shaoxiongdu;

/**
 * ClassName : ArrayQueueTestMain
 * (c)CopyRight 2021/4/20 All rights reserved to ShaoxiongDu<shaoxiongdu.dev@gmail.com>
 */
public class ArrayQueueTestMain {

    public static void main(String[] args) {

        try {

            Queue queue = new ArrayQueue(10);
            System.out.println("入队之前大小 " + queue.size());
            System.out.println("入队之前是否为空 " + queue.empty());

            System.out.println("入队中!!!");
            queue.enterObject(new Student("张3",10));
            queue.enterObject(new Student("李4",20));
            queue.enterObject(new Student("王5",30));
            System.out.println("入队之后大小 " + queue.size());
            System.out.println("入队之后是否为空 " + queue.empty());

            System.out.println("头元素:");
            System.out.println(queue.getHead());

            System.out.println("出队");
            System.out.println("出队--->" + queue.deleteObject());
            System.out.println("出队--->" + queue.deleteObject());
            System.out.println("出队--->" + queue.deleteObject());

            System.out.println("出队之后大小 " + queue.size());
            System.out.println("出队之后是否为空 " + queue.empty());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
