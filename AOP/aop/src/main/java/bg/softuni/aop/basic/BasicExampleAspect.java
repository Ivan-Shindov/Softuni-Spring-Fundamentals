package bg.softuni.aop.basic;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Aspect
@Component
@ConditionalOnProperty(name = "examples.basic.enabled", havingValue = "true")
public class BasicExampleAspect {

    private static final Logger logger = LoggerFactory.getLogger(BasicExampleAspect.class);

    @Pointcut("execution(* bg.softuni.aop.Person.*(..))")
    public void track() {}

    @Pointcut("execution(* bg.softuni.aop.Person.greeting(..))")
    public void trackGreeting() {}

    @Before("track()")
    public void beforeAnyMethod(JoinPoint joinPoint) {
        logger.info("Before calling: {}",joinPoint.getSignature());
    }

    @Before("trackGreeting()")
    public void beforeGreeting(JoinPoint joinPoint) {
        logger.info("Before greeting method: {}",joinPoint.getSignature());
    }

    @AfterThrowing(pointcut = "track()", throwing = "error")
    public void trackExceptions(Throwable error) {
        logger.info("Here is detected exception: ", error);
    }

}
