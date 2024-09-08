package com.digitinary.customer.customer_microservice.model;

import com.digitinary.customer.customer_microservice.enums.NotificationType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NotificationModel {

    private NotificationType notificationType;

    private String title;

    private Long customerId;



    public NotificationModel(Long id, NotificationType notificationType) {
        setCustomerId(id);
        setNotificationType(notificationType);
    }
}
