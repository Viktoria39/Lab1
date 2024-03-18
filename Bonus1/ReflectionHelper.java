package Bonus1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

class ReflectionHelper {
    public static ConstructorInfo[] getConstructorsInfo(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getConstructors();
        ConstructorInfo[] constructorInfos = new ConstructorInfo[constructors.length];
        for (int i = 0; i < constructors.length; i++) {
            constructorInfos[i] = new ConstructorInfo(constructors[i]);
        }
        return constructorInfos;
    }

    public static MethodInfo[] getMethodsInfo(Class<?> clazz) {
        Method[] methods = clazz.getMethods();
        MethodInfo[] methodInfos = new MethodInfo[methods.length];
        for (int i = 0; i < methods.length; i++) {
            methodInfos[i] = new MethodInfo(methods[i]);
        }
        return methodInfos;
    }
}