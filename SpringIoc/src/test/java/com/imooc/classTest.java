package com.imooc;

import com.imooc.car.Audi;
import com.imooc.car.Black;
import com.imooc.human.Human;
import com.imooc.human.LiSi;
import com.imooc.human.ZhangSan;
import org.junit.Before;
import org.junit.Test;


public class classTest {

    private IOCContainer iocContainer=new IOCContainer();

    //创建bean
    @Before
    public void before()
    {
        iocContainer.setBeans(Audi.class,"audi");
        iocContainer.setBeans(Black.class,"black");
        iocContainer.setBeans(ZhangSan.class,"zhangsan","audi");
        iocContainer.setBeans(LiSi.class,"lisi","black");
    }

    //使用bean
    @Test
    public void test()
    {
        Human zhangsan=(Human)iocContainer.getBean("zhangsan");
        zhangsan.goHome();
        Human lisi=(Human)iocContainer.getBean("lisi");
        lisi.goHome();
    }
}
