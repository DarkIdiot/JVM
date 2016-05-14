package com.dark.HotSwap;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class TestHotSwap {

    public static void main(String args[]) throws MalformedURLException {
        A a = new A();  // 加载类A
        B b = new B();  // 加载类B
        a.setB(b);  // A引用了B，把b对象拷贝到A.b
        System.out.printf("A classLoader is %s\n", a.getClass().getClassLoader());
        System.out.printf("B classLoader is %s\n", b.getClass().getClassLoader());
        System.out.printf("A.b classLoader is %s\n", a.getB().getClass().getClassLoader());
        
        try {
            URL[] urls = new URL[]{ new URL("file:///D:/eclipse-jee-luna-R-win32-x86_64/workplace/JVM/target/classes/") };
            HotSwapClassLoader c1 = new HotSwapClassLoader(urls, a.getClass().getClassLoader());
            Class clazz = c1.load("com.dark.HotSwap.A");  // 用hot swap重新加载类A
            System.err.println(clazz.getClassLoader());
            Object aInstance = clazz.newInstance();  // 创建A类对象
            Method method1 = clazz.getMethod("setB", B.class);  // 获取setB(B b)方法
            method1.invoke(aInstance, b);    // 调用setB(b)方法，重新把b对象拷贝到A.b
            Method method2 = clazz.getMethod("getB");  // 获取getB()方法
            Object bInstance = method2.invoke(aInstance);  // 调用getB()方法
            System.out.printf("Reloaded A.b classLoader is %s\n", bInstance.getClass().getClassLoader());
        } catch (MalformedURLException | ClassNotFoundException | 
                InstantiationException | IllegalAccessException | 
                NoSuchMethodException | SecurityException | 
                IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}