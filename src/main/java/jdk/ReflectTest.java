package jdk;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ReflectTest {
    public static void main(String[] args) throws Exception {
        cglibProxy1();
    }

    private static void jdkDynamicProxy1() throws Exception {
        InvocationHandler invocationHandler = new MyInvocationHandler<JdkProxyInterface>(new JdkProxyInterfaceClass());

        Class<?> proxyClass = Proxy.getProxyClass(JdkProxyInterface.class.getClassLoader(),
                JdkProxyInterface.class);

        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);

        JdkProxyInterface jdkProxyInterface = (JdkProxyInterface) constructor.newInstance(invocationHandler);
        jdkProxyInterface.hello();
        jdkProxyInterface.add(1);
    }

    private static void jdkDynamicProxy2() throws Exception {
        InvocationHandler invocationHandler = new MyInvocationHandler<JdkProxyInterface>(new JdkProxyInterfaceClass());

        Object proxyInstance = Proxy.newProxyInstance(JdkProxyInterface.class.getClassLoader(),
                new Class<?>[]{JdkProxyInterface.class}, invocationHandler);

        JdkProxyInterface jdkProxyInterface = (JdkProxyInterface) proxyInstance;
        jdkProxyInterface.hello();
        jdkProxyInterface.add(1);
    }

    private static void cglibProxy1() throws Exception {
        CglibInterceptor cglibProxy = new CglibInterceptor();
        CglibClass cglibClass = (CglibClass) cglibProxy.newProxyInstance(CglibClass.class);
        cglibClass.hello();
        cglibClass.hello("rgq");
    }

    private static class CglibClass {
        public CglibClass() {
        }

        public void hello(String name) {
            System.out.println("hello:" + name);
        }

        public final void hello() {
            this.hello("default");
        }

        public int add(int input) {
            return input + 1;
        }
    }

    private static class CglibInterceptor implements MethodInterceptor {

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            System.out.println("方法调用之前");
            Object result = proxy.invokeSuper(obj, args);
            System.out.println("方法调用之后");
            return result;
        }

        public Object newProxyInstance(Class<?> klass) {
            /**
             * CGLIB 增强类对象，代理类对象是由 Enhancer 类创建的，
             * Enhancer 是 CGLIB 的字节码增强器，可以很方便的对类进行拓展
            */
            Enhancer enhancer = new Enhancer();
            /**
             * 设置产生的代理对象的父类,增强类型
             */
            enhancer.setSuperclass(klass);
            /**
             * 定义代理逻辑对象为当前对象，要求当前对象实现 MethodInterceptor 接口
             */
            enhancer.setCallback(this);
            /**
             * 使用默认无参数的构造函数创建目标对象,这是一个前提,被代理的类要提供无参构造方法
             */
            return enhancer.create();
        }
    }

    private interface JdkProxyInterface {
        void hello(String name);

        void hello();

        int add(int input);
    }

    private static class JdkProxyInterfaceClass implements JdkProxyInterface {

        @Override
        public void hello(String name) {
            System.out.println("hello:" + name);
        }

        @Override
        public void hello() {
            this.hello("default");
        }

        @Override
        public int add(int input) {
            return input + 1;
        }
    }

    private static class MyInvocationHandler<T> implements InvocationHandler {

        private T target;

        public MyInvocationHandler(T target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("代理执行方法:" + method.getName());
            long start = System.currentTimeMillis();
            Object result = method.invoke(target, args);
            System.out.println("代理执行耗时:" + (System.currentTimeMillis() - start));
            return result;
        }
    }
}

