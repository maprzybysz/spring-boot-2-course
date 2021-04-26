package pl.maprzybysz.springboot2.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CounterAspect {

    private long start;
    private long end;

    @Before("@annotation(pl.maprzybysz.springboot2.annotation.CounterAnnotation)")
    public void startTimer() {
        start = System.nanoTime();
    }

    @After("@annotation(pl.maprzybysz.springboot2.annotation.CounterAnnotation)")
    public void stopTimer() {
        end = System.nanoTime();
        long timeElapsed = (end - start);
        System.out.println(timeElapsed / 1000000 + "ms");
    }
}
