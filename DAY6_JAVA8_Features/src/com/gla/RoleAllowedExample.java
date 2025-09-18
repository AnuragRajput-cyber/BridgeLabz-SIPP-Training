package com.gla;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class SecureService {
    @RoleAllowed("ADMIN")
    public void deleteData() {
        System.out.println("Data deleted!");
    }
}

public class RoleAllowedExample {
    public static void main(String[] args) throws Exception {
        String currentUserRole = "USER"; // try changing to ADMIN
        SecureService service = new SecureService();

        for (Method m : SecureService.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(RoleAllowed.class)) {
                String allowed = m.getAnnotation(RoleAllowed.class).value();
                if (allowed.equals(currentUserRole)) {
                    m.invoke(service);
                } else {
                    System.out.println("Access Denied!");
                }
            }
        }
    }
}

