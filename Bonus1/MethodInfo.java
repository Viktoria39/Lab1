package Bonus1;

import java.lang.reflect.Method;

class MethodInfo {
    private Method method;

    public MethodInfo(Method method) {
        this.method = method;
    }

    public Method getMethod() {
        return method;
    }

    @Override
    public String toString() {
        return method.toString();
    }
}