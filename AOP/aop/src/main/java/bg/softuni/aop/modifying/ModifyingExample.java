package bg.softuni.aop.modifying;

import bg.softuni.aop.Person;
import bg.softuni.aop.basic.BasicExampleAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "examples.modifying.enabled", havingValue = "true")
public class ModifyingExample implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(BasicExampleAspect.class);

    private final Person person;

    public ModifyingExample(Person person) {
        this.person = person;
    }

    @Override
    public void run(String... args) throws Exception {

        String concat = person.concat("a", "b");

        // without AOP result would be ab
        // with AOP (@Around) result is modified and it is [a]-[b]

        logger.info("Result from around advice: {}", concat);
    }
}
