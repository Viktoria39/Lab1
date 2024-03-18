package Bonus1;

import java.lang.reflect.Constructor;

class ConstructorInfo {
    private Constructor<?> constructor;

    public ConstructorInfo(Constructor<?> constructor) {
        this.constructor = constructor;
    }

    public Constructor<?> getConstructor() {
        return constructor;
    }

    @Override
    public String toString() {
        return constructor.toString();
    }
}