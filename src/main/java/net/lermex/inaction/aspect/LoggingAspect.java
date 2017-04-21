package net.lermex.inaction.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    long time;

    @Before("execution(* net.lermex.inaction.model.entity.*.*(..))")
    public void methodStart(JoinPoint joinPoint) {
        time = System.currentTimeMillis();
        System.out.println("--- Call method " + joinPoint.getSignature().getName() +  " in class " + joinPoint.getTarget().getClass().getSimpleName());
    }

    @After("execution(* net.lermex.inaction.model.entity.*.*(..))")
    public void methodEnd(JoinPoint joinPoint) {
        System.out.println("Method " +  joinPoint.getSignature().getName() + " work " + (System.currentTimeMillis() - time) + "ms");
    }
}
