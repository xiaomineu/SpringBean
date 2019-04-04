package com.imooc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 1.实例化bean;
 * 2.保存beam;
 * 3.提供bean;
 * 4.每一个bean要产生唯一一个id与之相对应;
 */

public class IOCContainer {
    private Map<String,Object> beans=new ConcurrentHashMap<String, Object>();

    /**
     * 根据beanId获取一个bean
     * @param beanId beanId
     * @return 返回bean;
     */
    public Object getBean(String beanId)
    {
        return beans.get(beanId);//根据beanId查找对应的bean;
    }

    /**
     * 委托IoC容器创建一个bean;
     * @param clazz 要创建的bean的Class
     * @param BeanId beanId
     * @param paramBeanIds 要创建的bean的class的构造方法所需要的beanId们
     */
    public void setBeans(Class<?> clazz,String BeanId,String...paramBeanIds)//实例化bean;
    {
        //1.组装构造方法所需要的参数值
        Object[] paramValues=new Object[paramBeanIds.length];
        for (int i = 0; i < paramBeanIds.length; i++) {
            paramValues[i]=beans.get(paramBeanIds[i]);
        }
        
        //2.调用构造方法实例化bean
        Object bean=null;
        for(Constructor<?> constructor:clazz.getConstructors())
        {
            try {
                bean=constructor.newInstance(paramValues);//所有异常均不处理
            } catch (InstantiationException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
            if(bean==null)
            {
                throw new RuntimeException("找不到合适构造方法实例化bean");
            }
        }
        //3.将实例化bean放入beans中
        beans.put(BeanId,bean);
    }
}
