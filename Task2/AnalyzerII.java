package Task2;

import java.lang.reflect.*;
import java.util.Scanner;

public class AnalyzerII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Object obj = new Check();

        System.out.println("Реальний тип об'єкту: " + obj.getClass().getName());
        System.out.println("Стан об'єкту:");
        printFields(obj);

        System.out.println("Список відкритих методів:");
        printPublicMethods(obj);

        System.out.println("Введіть порядковий номер методу [1 ," + publicMethods.length + "]:");
        int methodIndex = scanner.nextInt();
        invokeMethod(obj, methodIndex);
    }

    private static void printFields(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                System.out.println(field.getType().getName() + " " + field.getName() + " = " + field.get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private static Method[] publicMethods;
    static {
        publicMethods = Check.class.getMethods();
    }

    private static void printPublicMethods(Object obj) {
        for (int i = 0; i < publicMethods.length; i++) {
            System.out.println((i + 1) + "). " + publicMethods[i]);
        }
    }

    private static void invokeMethod(Object obj, int methodIndex) {
        try {
            Method method = publicMethods[methodIndex - 1];
            Object result = method.invoke(obj);
            System.out.println("Результат виклику методу: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}