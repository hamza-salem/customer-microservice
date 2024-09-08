package com.digitinary.customer.customer_microservice.aspect;


import com.digitinary.customer.customer_microservice.config.RabbitMQConfig;
import com.digitinary.customer.customer_microservice.entity.Customer;
import com.digitinary.customer.customer_microservice.enums.NotificationType;
import com.digitinary.customer.customer_microservice.model.CustomerModel;
import com.digitinary.customer.customer_microservice.model.NotificationModel;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Slf4j
@Aspect
@Component
public class CustomerServiceAspect {
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @AfterReturning(value = "execution(* com.digitinary.customer.customer_microservice.service.CustomerService.createCustomer(..))",returning = "customer")
    public void afterAdvice(JoinPoint joinPoint, Customer customer) {
        log.info("customerId " + customer.getId().toString());
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, new NotificationModel(customer.getId(),NotificationType.CUSTOMER_CREATED));
    }

    @AfterReturning(value = "execution(* com.digitinary.customer.customer_microservice.service.CustomerService.deleteCustomer(..))",returning = "customer")
    public void afterDelete(JoinPoint joinPoint,Customer customer) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, new NotificationModel(customer.getId(),NotificationType.CUSTOMER_DELETED));
    }
}
