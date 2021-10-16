package tr.com.getir.book.api.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.ResponseEntity;

/**
 * @author Ozan Emrah Yakupoğlu
 */
@Aspect
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Slf4j
public class IncomingLogConfig {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
	public void springBeanPointcut() {
	
	}
	
	@Before("execution(* tr.com.getir.book.api.controller..*(..))")
	public void logBefore(JoinPoint joinPoint) throws JsonProcessingException {
		MDC.put("type", "incomingInput");
		log.info("{}", objectMapper.writeValueAsString(joinPoint.getArgs()));
		MDC.remove("type");
	}
	
	@AfterReturning(pointcut = "execution(* tr.com.getir.book.api.controller..*(..))", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) throws JsonProcessingException {
		MDC.put("type", "incomingOutput");
		if (result instanceof ResponseEntity) {
			log.info("{} finished", objectMapper.writeValueAsString(((ResponseEntity) result).getBody()));
		} else {
			log.info("{} finished", objectMapper.writeValueAsString(result));
		}
		MDC.remove("type");
	}
	
	@AfterThrowing(pointcut = "execution(* tr.com.getir.book.api.controller..*(..))", throwing = "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		MDC.put("type","incomingOutput");
		log.error("Exception in {} with cause = {}", joinPoint.getSignature().toShortString(), error.getCause() != null ? error.getCause() : "NULL");
		MDC.remove("type");
	}
}