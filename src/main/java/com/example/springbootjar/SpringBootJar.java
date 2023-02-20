package com.example.springbootjar;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2023-02-20 23:21
 * @blog <a href="https://blog.csdn.net/next_second">...</a>
 * @github <a href="https://github.com/YoungBear">...</a>
 * @description 启动入口类
 */
public class SpringBootJar {

    /**
     * 入口函数
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        System.out.println("hello start");
        TestClass testClass = new TestClass();
        testClass.log();
    }

}
