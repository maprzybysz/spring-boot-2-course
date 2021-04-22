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


    @Around("@annotation(HelloAspectAnnotation)")
    private void aroundHello(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around hello");
        joinPoint.proceed();
    }


}
