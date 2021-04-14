package cn.shaoxiongdu;

/**
 * ClassName : ArrayStackTestMain
 * (c)CopyRight 2021/4/14 All rights reserved to ShaoxiongDu<shaoxiongdu.dev@gmail.com>
 */
public class ArrayStackTestMain {

    public static void main(String[] args) {

        ArrayStack arrayStack = new ArrayStack(2);
        System.out.println("添加之前");
        System.out.println("元素个数为" + arrayStack.size());
        System.out.println("是否为空" + arrayStack.empty());
        System.out.println("添加之后");

        try {
            arrayStack.push(new Student("张三",10));
            arrayStack.push(new Student("李四",20));
            arrayStack.push(new Student("王五",30));

            System.out.println("元素个数为" + arrayStack.size());
            System.out.println("是否为空" + arrayStack.empty());

            while (!arrayStack.empty()){
                System.out.println(arrayStack.pop());
            }




        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
