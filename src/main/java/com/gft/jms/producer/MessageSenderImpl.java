package com.gft.jms.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class MessageSenderImpl implements MessageSender {

    public static final String REQUEST_QUEUE = "RequestQueue";
    private final JmsTemplate jmsTemplate;

    @Autowired
    private MessageMap messageMap;

    @Autowired
    public MessageSenderImpl(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void sendMessage() {
        MessageCreator messageCretaor = new MessageCreatorImpl(messageMap);
        jmsTemplate.send(REQUEST_QUEUE, messageCretaor);
    }
}
