package pl.maprzybysz.springboot2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloAspect {

    @Before("execution(String pl.maprzybysz.springboot2.Hello.sayHello())")
    private void beforeHello(){
        System.out.println("Before hello");
    }

    @Around("execution(String pl.maprzybysz.springboot2.Hello.sayHello())")
    private void aroundHello(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around hello");
        joinPoint.proceed();
    }

    @After("execution(String pl.maprzybysz.springboot2.Hello.sayHello())")
    private void afterHello() throws Throwable {
        System.out.println("After hello");

    }
}
