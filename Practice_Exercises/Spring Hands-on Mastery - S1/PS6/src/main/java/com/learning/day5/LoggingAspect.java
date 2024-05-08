package com.learning.day5;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.learning.day5.ShoppingCart.addItem(..))")
    public void logBeforeAddItem(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Entering method: " + methodName);
        System.out.println("Arguments: " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "execution(* com.learning.day5.ShoppingCart.addItem(..))", returning = "result")
    public void logAfterReturningAddItem(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Exiting method: " + methodName);
        System.out.println("Returned: " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.learning.day5.ShoppingCart.addItem(..))", throwing = "error")
    public void logAfterThrowingAddItem(JoinPoint joinPoint, Throwable error) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Exception in method: " + methodName);
        System.out.println("Exception: " + error);
    }

    @Before("execution(* com.learning.day5.ShoppingCart.getItems())")
    public void logBeforeGetItems(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Entering method: " + methodName);
    }

    @AfterReturning(pointcut = "execution(* com.learning.day5.ShoppingCart.getItems())", returning = "result")
    public void logAfterReturningGetItems(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Exiting method: " + methodName);
        System.out.println("Returned: " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.learning.day5.ShoppingCart.getItems())", throwing = "error")
    public void logAfterThrowingGetItems(JoinPoint joinPoint, Throwable error) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Exception in method: " + methodName);
        System.out.println("Exception: " + error);
    }
}