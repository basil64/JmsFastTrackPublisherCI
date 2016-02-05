package com.gft.jms.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;


public class MessageCreatorImpl implements MessageCreator {

    private static int count = 0;
    private MessageMap messageMap;

    public MessageCreatorImpl(MessageMap messageMap) {
        this.messageMap = messageMap;
    }

    @Override
    public Message createMessage(Session session) throws JMSException {
        MapMessage mapMessage = session.createMapMessage();
        mapMessage.setInt("Count", count);
        mapMessage.setString("Name", "Name_" + (int)(Math.random() * 100));
        String corellationId = "CI_" + count;
        mapMessage.setJMSCorrelationID(corellationId);
        messageMap.put(corellationId, mapMessage);
        count++;
        return mapMessage;
    }
}
