package org.halogen.jobportalrestapi.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {
    Logger log = Logger.getLogger(this.getClass().getName());

    // join point represents a method execution
    @Before("execution(* org.halogen.jobportalrestapi.Service.JobService.*(..))")
    public void logBeforeMethodExecution(JoinPoint joinPoint) {
        log.info("Before: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }

    @AfterThrowing("execution(* org.halogen.jobportalrestapi.Service.JobService.*(..))")
    public void logAfterMethodExecutionError(JoinPoint joinPoint) {
        log.info("After exception: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* org.halogen.jobportalrestapi.Service.JobService.*(..))")
    public void logAfterMethodExecutionSuccess(JoinPoint joinPoint) {
        log.info("After returning: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }
}
