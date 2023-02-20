# java -jar 执行普通main方法（使用spring-boot打包插件）



## 1. 背景

在日常开发中，会存在环境使用jre而没有jdk的场景，特别是在linux环境上。但是很多的验证性的代码，需要在linux环境执行，所以就需要一个方便的方式，在环境上执行main方法。

参考spring-boot的打包及启动方法，我们可以使用java -jar xxx.jar执行指定的main方法，并且可以引用三方件，将所有代码及三方件打包到一个jar文件。

## 2. 方法

使用标准的maven工程接口，引用插件配置：

```xml
<plugins>
    <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        <version>2.7.8</version>
        <configuration>
            <!-- 指定启动类 -->
            <mainClass>com.example.springbootjar.SpringBootJar</mainClass>
        </configuration>
        <executions>
            <execution>
                <goals>
                    <goal>repackage</goal>
                </goals>
            </execution>
        </executions>
    </plugin>
</plugins>
```

然后就可以在指定的启动类的main方法中写自己的代码了。

eg.

com.example.springbootjar.SpringBootJar

```java
package com.example.springbootjar;
// 启动类
public class SpringBootJar {

    /**
     * 入口函数
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        System.out.println("hello SpringBootJar!");
        TestClass testClass = new TestClass();
        testClass.log();
    }

}

```



```java
package com.example.springbootjar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZonedDateTime;
// 测试类
public class TestClass {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestClass.class);

    /**
     * 打印日志
     * 使用logback 模拟调用第三方jar包的方法
     */
    public void log() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        LOGGER.info("now: {}", zonedDateTime);

    }
}

```



执行结果：

```shell
# 打包
$ mvn clean package
# 执行
$ java -jar target/SpringBootJar.jar
hello SpringBootJar!
2023-02-21T00:01:24.397 CST+08:00 [main] INFO  com.example.springbootjar.TestClass:26 - now: 2023-02-21T00:01:24.394+08:00[Asia/Shanghai]

```





常用的场景：

- 验证linux下执行效果
- 获取linux环境的信息
- 调用linux下命令行执行
- http请求
- ...



## 源码

https://github.com/YoungBear/spring-boot-jar



## 参考

https://www.baeldung.com/executable-jar-with-maven



