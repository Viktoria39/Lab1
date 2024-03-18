package Task5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProfilingHandler implements InvocationHandler {
    private final Object target;

    public ProfilingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.nanoTime();
        Object result = method.invoke(target, args);
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println(method.getName() + " took " + elapsedTime + " ns");
        return result;
    }
}