package com.gla;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class Service {
    @ImportantMethod
    public void criticalProcess() {}

    @ImportantMethod(level = "LOW")
    public void helperProcess() {}
}

public class ImportantMethodExample {
    public static void main(String[] args) {
        for (Method m : Service.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod im = m.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + m.getName() + ", Level: " + im.level());
            }
        }
    }
}

