package se.mkk.springprofessionaldevelopexam.aop;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//  *  - matches once
//  .. - matches zero or more 
// 
// execution(* se.mkk.*Service.find*(..))
//           | return type
//             | package
//                     | class
//                              | method
//                                   | arguments
//
// execution(@jakarta.annotation.security.RolesAllowed void exec*(..))
@Aspect
@Component
public class MyAspect {

    @Before("execution(* se.mkk..doSomething(..))")
    public void before(JoinPoint joinPoint) {
        joinPoint("***** before", joinPoint);
    }

    @Around("execution(* doSomething(..))") // every method named doSomething
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        joinPoint("***** around", proceedingJoinPoint);
        return proceedingJoinPoint.proceed(); // make sure to proceed if wanted, otherwise will method not be executed
    }

    @After("execution(* se.mkk..Person.*(..))") // every method in class 'se.mkk..Person'
    public void after(JoinPoint joinPoint) {
        joinPoint("***** after", joinPoint);
    }

    // every method named starting with 'do*' and returning String
    @AfterReturning(value = "execution(String do*(..))", returning = "paramname")
    public void afterReturning(JoinPoint joinPoint, String paramname) {
        joinPoint("***** afterReturning", joinPoint, paramname);
    }

    @AfterThrowing(value = "execution(* throwException(..))", throwing = "paramname")
    public void afterThrowing(JoinPoint joinPoint, IllegalStateException paramname) {
        joinPoint("***** afterThrowing", joinPoint, paramname.getClass().getSimpleName(), paramname.getMessage());
    }

    protected void joinPoint(String message, JoinPoint joinPoint, Object... rtn) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = List.of(joinPoint.getArgs());
        Object bean = joinPoint.getTarget();
        System.out.println(message + " methodName " + methodName + " args " + args + " bean " + bean + " rtn " + rtn);
    }
}
