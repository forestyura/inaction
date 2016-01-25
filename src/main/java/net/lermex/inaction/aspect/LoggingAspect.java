package net.lermex.inaction.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* net.lermex..*.*(..))")
    public void log(final JoinPoint point) {
        System.out.println(point.getSignature().getName() + " called...");
    }

}
