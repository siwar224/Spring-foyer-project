package tn.esprit.tpfoyer.config;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
@Component
@Aspect
@Slf4j
public class ConfigAOP {
    @Before("execution( * tn.esprit.tpfoyer.service.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {String name = joinPoint.getSignature().getName();
        log.info("Bienvenue dans le service 4TWIN8 : " + name);    }

    @After("execution(* tn.esprit.tpfoyer.service.*.*(..))")
    public void logMethodOut(JoinPoint joinPoint) {        String name = joinPoint.getSignature().getName();
        log.info("Execution Finie 4TWIN8 du service " + name);    }

    @AfterReturning("execution(* tn.esprit.tpfoyer.service.*.*(..))")
    public void logMethodOutOK(JoinPoint joinPoint) {        String name = joinPoint.getSignature().getName();
        log.info("Execution Réussie ! ");    }

    @AfterThrowing("execution(* tn.esprit.tpfoyer.service.*.*(..))")
    public void logMethodOutKO(JoinPoint joinPoint) {        String name = joinPoint.getSignature().getName();
        log.error("Error ! ");    }

    @Around("execution(* tn.esprit.tpfoyer.service.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable    {
        long start= System.currentTimeMillis();        Object obj= pjp.proceed();
        long elapsedTime= System.currentTimeMillis() -start;
        log.info("Methodexecutiontime: " + elapsedTime+ " milliseconds.");
        return obj;    }

}