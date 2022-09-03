package com.training.fooddelivery.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.epam.training.fooddelivery.view..*(..))")
    private void parametersCalled() {
    }

    @Before("@annotation(argumentLogging) && parametersCalled()")
    public void beforeParametricMethod(JoinPoint joinPoint, EnableArgumentLogging argumentLogging) {
        LOGGER.info(
                "Method name: ["
                        + joinPoint.getSignature().getName()
                        + "], parameter(s): "
                        + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(
            value = "@annotation(returnValueLogging) && parametersCalled()",
            returning = "returnValue")
    public void afterReturnedMethod(
            JoinPoint joinPoint, Object returnValue, EnableReturnValueLogging returnValueLogging) {

        LOGGER.info(
                "Method name: ["
                        + joinPoint.getSignature().getName()
                        + "], return value: "
                        + returnValue.toString());
    }

    @Around(value = "@annotation(executionTimeLogging) && parametersCalled()")
    public Object executionTimeMethod(
            ProceedingJoinPoint joinPoint, EnableExecutionTimeLogging executionTimeLogging)
            throws Throwable {
        double startTime = System.nanoTime();
        Object proceed = joinPoint.proceed();
        double executionTime = (System.nanoTime() - startTime) * 1000;
        LOGGER.info("Execution time = " + executionTime + "μs");
        return proceed;
    }
}
