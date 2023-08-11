package se.mkk.springprofessionaldevelopexam.aop;

import org.springframework.stereotype.Component;

@Component
public class Person {

    public String doSomething() {
        System.out.println("doing something");
        return "Did it";
    }

    public void throwException() {
        throw new IllegalStateException("Did it");
    }
}
