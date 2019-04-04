package com.imooc.class4Test;

import com.imooc.class4.Bean;
import com.imooc.class4.SubBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Class4Test {
    @Test
    public void test()
    {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        SubBean subBean01=applicationContext.getBean("subBean",SubBean.class);
        SubBean subBean02=applicationContext.getBean("subBean",SubBean.class);
        System.out.println(subBean01);
        System.out.println(subBean02);
        Bean bean=applicationContext.getBean("bean",Bean.class);
        System.out.println(bean);
        Bean bean1=applicationContext.getBean("bean",Bean.class);
        System.out.println(bean1);
    }
}
