package com.imooc.test2;

import com.imooc.class2.Bean;
import com.imooc.class2.Bean2;
import com.imooc.class2.Bean3;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 搭建Spring环境
 * 创建一个xml配置文件
 * 在xml文件中将一个Bean交由Spring创建并管理
 * 获取Spring上下文  通过ApplicationContext.ClassPathXmlApplicationContext;
 * 获取bean，使用getBean;
 */

public class Test2 {
    @Test
    public void test()
    {
        ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");

        //通过构造方法实例化bean;
        Bean bean=context.getBean("Bean",Bean.class);
        System.out.println("bean= "+bean);


        //通过静态方法实例化bean;
        Bean2 bean2=context.getBean("Bean2",Bean2.class);

        //通过实例化对象实例化bean
        Bean3 bean3=context.getBean("Bean3",Bean3.class);


        //使用别名实例化bean;
        Bean bean1_1=context.getBean("Bean1_1",Bean.class);
        Bean bean1_2=context.getBean("Bean1_2",Bean.class);
    }
}
