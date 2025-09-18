package com.gla;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class MathOps {
    @LogExecutionTime
    public void compute() throws InterruptedException {
        Thread.sleep(500);
    }
}

public class LogExcecutionExamplr {
    public static void main(String[] args) throws Exception {
        MathOps obj = new MathOps();
        for (Method m : MathOps.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                m.invoke(obj);
                long end = System.nanoTime();
                System.out.println(m.getName() + " executed in " + (end - start) + " ns");
            }
        }
    }
}
