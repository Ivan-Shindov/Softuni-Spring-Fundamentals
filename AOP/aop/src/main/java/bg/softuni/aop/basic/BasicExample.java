package bg.softuni.aop.basic;

import bg.softuni.aop.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
public class BasicExample implements CommandLineRunner {

private final Person person;

    public BasicExample(Person person) {
        this.person = person;
    }

    @Override
    public void run(String... args) throws Exception {

        person.sayHello();
        person.greeting("Ivan");
        person.concat("a","b");
        person.subtract(100,30);
        try {
            person.throwBomb();
        } catch (Exception ex) {

        }
    }
}
