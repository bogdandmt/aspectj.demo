package aop.aspectj.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ConsoleLogAspect {

    @Pointcut("execution (* *(..)) && @annotation(aop.aspectj.annotation.Loggable)")
    public void loggable() {
    }

    @Pointcut("call(* *Service*.*(..))")
    public void serviceCall() {
    }

    @Around("loggable() || serviceCall()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
	String methodName = joinPoint.getSignature().getName();
	Object[] args = joinPoint.getArgs();

	System.out.println("call " + methodName + Arrays.asList(args));

	Object result = joinPoint.proceed();
	System.out.println(methodName + " return " + result);

	return result;
    }
}
