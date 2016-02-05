package com.gft.jms.receiver;

import com.gft.jms.producer.MessageMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MapMessage;
import java.io.File;


@Component
public class Receiver {
    private Logger logger = LoggerFactory.getLogger(Receiver.class);
    @Autowired
    private MessageMap messageMap;

    @JmsListener(destination = "ReplyQueue")
    public void receiveMessage(Message message) {
        try {
            String correlationId = message.getJMSCorrelationID();
            if (messageMap.get(correlationId) != null) {
                logger.info("Message matched. Correlatio ID [{}]", correlationId);
                messageMap.remove(correlationId);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
        FileSystemUtils.deleteRecursively(new File("activemq-data"));
    }
}