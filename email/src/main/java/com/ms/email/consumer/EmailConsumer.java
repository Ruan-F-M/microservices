package com.ms.email.consumer;

import com.ms.email.dto.EmailRecordDt0;
import com.ms.email.model.EmailModel;
import com.ms.email.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class EmailConsumer {

    @Autowired
    EmailService emailService;

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void linstenEmailQueue(@Payload EmailRecordDt0 emailRecordDt0) {
        var emailModel = new EmailModel();
        BeanUtils.copyProperties(emailRecordDt0, emailModel);
        emailService.sendEmail(emailModel);
    }

}
