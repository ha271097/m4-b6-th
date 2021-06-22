package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    @AfterReturning(pointcut = "within(controller.*)", returning = "result")
    public void log(JoinPoint joinPoint, Object result){
        System.out.println("Start log");
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println(className + "." + methodName);
        if(result == null){
            System.out.println("null");
        }
        else {
            System.out.println(result.hashCode());
        }
    }
}
