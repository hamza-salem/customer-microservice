package com.digitinary.customer.customer_microservice.aspect;


import com.digitinary.customer.customer_microservice.model.CustomerModel;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Slf4j
@Aspect
@Component
public class CustomerServiceAspect {

    @AfterReturning(value = "execution(* com.digitinary.customer.customer_microservice.service.CustomerService.createCustomer(..)) and args(customerModel)")
    public void afterAdvice(JoinPoint joinPoint,CustomerModel customerModel) {
        log.info(customerModel.toString());
    }
}
