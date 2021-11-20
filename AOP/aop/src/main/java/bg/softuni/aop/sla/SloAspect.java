package bg.softuni.aop.sla;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class SloAspect {
    private static final Logger logger = LoggerFactory.getLogger(SloAspect.class);
    private final SlosConfig slosConfig;

    public SloAspect(SlosConfig slosConfig) {
        this.slosConfig = slosConfig;
    }

    @Around(value = "@annotation(TrackLatency)")
    public Object trackLatency(ProceedingJoinPoint pjp, TrackLatency TrackLatency) throws Throwable {
        String latencyId = TrackLatency.latency();
        SlosConfig.SloConfig sloConfig = slosConfig.getSlos()
                .stream()
                .filter(s -> s.getId().equals(latencyId))
                .findAny()
                .orElseThrow(() -> new IllegalStateException("Slo with ID: " + latencyId + " is not configured"));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object proceed = pjp.proceed();
        stopWatch.stop();

        long actualExecutionTime = stopWatch.getTotalTimeMillis();
        if (actualExecutionTime > sloConfig.getThreshold()) {
            logger.warn("Method {} was too slow. Execution time: {}",
                    latencyId, actualExecutionTime);
        }

        return proceed;
    }

}
