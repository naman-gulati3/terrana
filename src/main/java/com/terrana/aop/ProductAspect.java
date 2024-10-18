package com.terrana.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ProductAspect {

  @Before(value = "execution(* com.terrana.controller.ProductController.*(..))")
  public void beforeAdvice(JoinPoint joinPoint) {
    log.info("Request to " + joinPoint.getSignature() + " started");
  }
}
