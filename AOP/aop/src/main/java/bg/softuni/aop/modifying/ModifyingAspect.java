package bg.softuni.aop.modifying;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@Aspect
@ConditionalOnProperty(name = "examples.modifying.enabled", havingValue = "true")
public class ModifyingAspect {

    @Pointcut("execution(* bg.softuni.aop.Person.concat(..))")
    public void trackConcat() {}

    @Around(value = "trackConcat() && args(a,b)", argNames = "pjp,a,b")
    public Object modify(ProceedingJoinPoint pjp, String a, String b) throws Throwable {
        Object proceed = pjp.proceed(new Object[]{
                "[" + a + "]-",
                "[" + b + "]"
        });

        return proceed;
    }
}
