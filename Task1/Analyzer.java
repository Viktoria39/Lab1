package Task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Analyzer {
    public static String getClassDescription(String className) throws ClassNotFoundException {
        Class<?> clas = Class.forName(className);
        return getClassDescription(clas);
    }

    public static String getClassDescription(Class<?> clas) {
        StringBuilder descrip = new StringBuilder();

        Package pkg = clas.getPackage();
        if (pkg != null) {
            descrip.append("Type Java class full name (for example ").append(pkg.getName()).append(".Date)\n-> ").append(clas.getName()).append("\n");
            descrip.append("package ").append(pkg.getName()).append(", ").append("Java Platform API Specification, version 1.7").append("\n");
        }
        descrip.append(Modifier.toString(clas.getModifiers())).append(" class ").append(clas.getSimpleName());

        Class<?> superClass = clas.getSuperclass();
        if (superClass != null && superClass != Object.class) {
            descrip.append(" extends ").append(superClass.getSimpleName());
        }

        Class<?>[] interfaces = clas.getInterfaces();
        if (interfaces.length > 0) {
            descrip.append("\nimplements ");
            for (int i = 0; i < interfaces.length; i++) {
                descrip.append(interfaces[i].getSimpleName());
                if (i < interfaces.length - 1) {
                    descrip.append(", ");
                }
            }
        }
        descrip.append(" {\n\n");

        descrip.append("// Поля\n");
        Field[] fields = clas.getDeclaredFields();
        for (Field field : fields) {
            descrip.append(Modifier.toString(field.getModifiers())).append(" ").append(field.getType().getSimpleName()).append(" ").append(field.getName()).append(";\n");
        }

        descrip.append("\n// Конструктори\n");
        Constructor<?>[] constructors = clas.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            descrip.append(Modifier.toString(constructor.getModifiers())).append(" ").append(constructor.getName()).append("(");
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                descrip.append(parameterTypes[i].getSimpleName());
                if (i < parameterTypes.length - 1) {
                    descrip.append(", ");
                }
            }
            descrip.append(");\n");
        }

        descrip.append("\n// Методи\n");
        Method[] methods = clas.getDeclaredMethods();
        for (Method method : methods) {
            descrip.append(Modifier.toString(method.getModifiers())).append(" ").append(method.getReturnType().getSimpleName()).append(" ").append(method.getName()).append("(");
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                descrip.append(parameterTypes[i].getSimpleName());
                if (i < parameterTypes.length - 1) {
                    descrip.append(", ");
                }
            }
            descrip.append(");\n");
        }
        descrip.append("}");

        return descrip.toString();
    }

    public static void main(String[] args) {
        try {
            String classDescription = getClassDescription("java.lang.String");
            System.out.println(classDescription);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}