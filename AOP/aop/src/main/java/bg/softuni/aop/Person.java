package bg.softuni.aop;

import org.springframework.stereotype.Component;

@Component
public class Person {

    public void sayHello() {
        System.out.println("Hello !");
    }

    public void greeting(String name) {
        System.out.println("Good afternoon " + name);
    }

    public String concat(String a, String b) {
        return a + b;
    }

    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public void throwBomb() {
        throw new IllegalArgumentException("I am throwing big bomb exception !");
    }
}
