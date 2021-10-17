package tr.com.getir.book.orderdomain.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Ozan Emrah Yakupoğlu
 */
@Aspect
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Slf4j
public class OrderDomainLogConfig {

    @Pointcut("within(@org.springframework.stereotype.Repository *)")
    public void springBeanPointcut() {

    }

    @Before("execution(* tr.com.getir.book.orderdomain..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.debug("{} started", joinPoint.getSignature().toShortString());
    }

    @AfterReturning(pointcut = "execution(* tr.com.getir.book.orderdomain..*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.debug("{} finished", joinPoint.getSignature().toShortString());
    }

    @AfterThrowing(pointcut = "execution(* tr.com.getir.book.orderdomain..*(..))", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        log.error("Exception in {} with cause = {}", joinPoint.getSignature().toShortString(),
                error.getCause() != null ? error.getCause() : "NULL");
    }
}