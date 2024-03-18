package Bonus1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = CheckNext.class;

        ConstructorInfo[] constructors = ReflectionHelper.getConstructorsInfo(clazz);

        System.out.println("Constructors:");
        for (int i = 0; i < constructors.length; i++) {
            System.out.println((i + 1) + "). " + constructors[i]);
        }

        int constructorIndex = selectConstructor();
        Constructor<?> selectedConstructor = constructors[constructorIndex - 1].getConstructor();
        Object[] constructorArgs = getConstructorArgs(selectedConstructor);
        Object instance = selectedConstructor.newInstance(constructorArgs);
        System.out.println("Object: " + instance);
        MethodInfo[] methods = ReflectionHelper.getMethodsInfo(clazz);

        System.out.println("\nMethods:");
        for (int i = 0; i < methods.length; i++) {
            System.out.println((i + 1) + "). " + methods[i]);
        }

        int methodIndex = selectMethod();
        Method selectedMethod = methods[methodIndex - 1].getMethod();

        Object result = selectedMethod.invoke(instance);
        System.out.println("Method result: " + result);
    }

    private static int selectConstructor() {
        System.out.println("\nInput the Number of Constructor [1 ,4]:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static Object[] getConstructorArgs(Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] args = new Object[parameterTypes.length];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < parameterTypes.length; i++) {
            System.out.println("Input the value for parameter " + (i + 1) + ":");
            if (parameterTypes[i] == int.class) {
                args[i] = scanner.nextInt();
            } else if (parameterTypes[i] == double.class) {
                args[i] = scanner.nextDouble();
            } else if (parameterTypes[i] == String.class) {
                args[i] = scanner.next();
            }
        }
        return args;
    }

    private static int selectMethod() {
        System.out.println("\nInput the Number of Method [1 ,2]:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}