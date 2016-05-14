package com.dark.defaultClassloader;
/**
 * 类加载策略接口
 */
public interface IClassLoadStrategy {

    ClassLoader getClassLoader(ClassLoadContext ctx);
}