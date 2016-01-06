package org.zyq.swing_utils.console;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class StreamHandler implements MethodInterceptor {

//输出流链表  

    private List<PrintStream> streamList = new ArrayList<PrintStream>();

//代理处理类生效，不允许再添加输出流标志    

    private boolean validate = false;

    /**
     * 生成代理的方法
     */
    public static PrintStream proxyFor(StreamHandler handler) {
        if (!handler.getValidate()) throw new RuntimeException("Handler not validate");
        Enhancer enhancer = new Enhancer();

        //被代理的ClassLoader
        enhancer.setClassLoader(PseudoPrintStream.class.getClassLoader());

        //被代理的Class
        enhancer.setSuperclass(PseudoPrintStream.class);

        //代理的方法被调用时，处理该调用的MethodInterceptor接口实现
        enhancer.setCallback(handler);

        //生成代理
        PrintStream proxy = (PseudoPrintStream) enhancer.create();

        //返回生成的代理
        return proxy;
    }

    /**
     * 添加输出流
     */

    public synchronized void addStream(PrintStream ps) {
        if (validate) {
            throw new IllegalStateException();
        }
        streamList.add(ps);
    }

    /**
     * 代理生效
     */
    public synchronized void validate() {
        validate = true;
    }

    /**
     * 查询代理是否生效
     */
    public synchronized boolean getValidate() {
        return validate;
    }

    /**
     * 拦截被代理的方法并处理
     */
    public Object intercept(Object object,
                            Method method,
                            Object[] args,
                            MethodProxy proxy)
            throws Throwable {
        //如果是PseudoPrintStream 的close方法被调用，则调用PseudoPrintStream 的close
        //方法关闭其匿名输出流
        if ("close".equals(method.getName())) {
            proxy.invokeSuper(object, args);
        }
        object.getClass();
        for (int i = 0; i < streamList.size(); i++) {
            PrintStream ps = streamList.get(i);
            object = method.invoke(ps, args);
        }
        return object;//返回链表最后一个输出流调用的结果
    }
}  