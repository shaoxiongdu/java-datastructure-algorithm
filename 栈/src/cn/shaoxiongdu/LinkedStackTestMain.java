package cn.shaoxiongdu;

/**
 * ClassName : LinkedStackTestMain
 * (c)CopyRight 2021/4/19 All rights reserved to ShaoxiongDu<shaoxiongdu.dev@gmail.com>
 */
public class LinkedStackTestMain {

    public static void main(String[] args) {

        LinkedStack linkedStack = new LinkedStack();

        System.out.println("入栈前:元素个数为" + linkedStack.size() + "  是否为空 " + linkedStack.empty());

        System.out.println("添加之后");

        try {
            linkedStack.push(new Student("张三",10));
            linkedStack.push(new Student("李四",20));
            linkedStack.push(new Student("王五",30));

            System.out.println("元素个数为" + linkedStack.size());
            System.out.println("是否为空" + linkedStack.empty());

            while (!linkedStack.empty()){
                System.out.println(linkedStack.pop());
            }

            linkedStack.pop();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
