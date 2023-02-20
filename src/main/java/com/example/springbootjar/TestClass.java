package com.example.springbootjar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZonedDateTime;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2023-02-20 23:21
 * @blog <a href="https://blog.csdn.net/next_second">...</a>
 * @github <a href="https://github.com/YoungBear">...</a>
 * @description 测试类
 */
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
