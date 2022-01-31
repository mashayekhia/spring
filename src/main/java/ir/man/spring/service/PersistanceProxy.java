package ir.man.spring.service;

import ir.man.spring.model.interfaces.IDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PersistanceProxy implements InvocationHandler {
    private IDao dao;

    public PersistanceProxy(IDao dao) {
        this.dao = dao;
    }

    public static IDao getPersistanceProxy(IDao dao) {
        return (IDao) Proxy.newProxyInstance(dao.getClass().getClassLoader(), dao.getClass().getInterfaces(), new PersistanceProxy(dao));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
