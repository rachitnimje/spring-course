package org.halogen.jobportalrestapi.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitoringAspect {
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Around("execution(* org.halogen.jobportalrestapi.Service.JobService.*(..))")
    public Object timeMonitor(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object obj = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("Time taken: " + (endTime - startTime) + " ms");

        return obj;
    }
}
