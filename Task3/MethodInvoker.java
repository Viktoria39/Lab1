package Task3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class MethodInvoker {
    public static void invokeMethod(Object object, String methodName, List<Object> parameters) throws FunctionNotFoundException {
        try {
            Class<?>[] parameterTypes = new Class<?>[parameters.size()];
            for (int i = 0; i < parameters.size(); i++) {
                parameterTypes[i] = parameters.get(i).getClass();
            }

            Method method = object.getClass().getMethod(methodName, parameterTypes);

            System.out.println("Типи: " + parameterTypesToString(parameterTypes) + ", значення: " + parameters);

            Object result = method.invoke(object, parameters.toArray());

            System.out.println("Результат виклику: " + result);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new FunctionNotFoundException("Метод не знайдено або неможливо викликати на цьому об'єкті.", e);
        }
    }

    private static String parameterTypesToString(Class<?>[] parameterTypes) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < parameterTypes.length; i++) {
            builder.append(parameterTypes[i].getSimpleName());
            if (i < parameterTypes.length - 1) {
                builder.append(", ");
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        try {
            TestClass testObject = new TestClass();

            invokeMethod(testObject, "evaluate", List.of(1.0));
            invokeMethod(testObject, "evaluate", List.of(1.0, 1));
        } catch (FunctionNotFoundException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}