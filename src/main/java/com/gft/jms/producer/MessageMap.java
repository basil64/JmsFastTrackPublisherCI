package com.gft.jms.producer;

import org.springframework.stereotype.Component;

import javax.jms.Message;
import java.util.HashMap;
import java.util.Map;

public class MessageMap {
    private Map<String, Message> msgMap;

    public MessageMap() {
        msgMap = new HashMap<>();
    }

    public void put(String ci, Message message) {
        msgMap.put(ci, message);
    }

    public Message get(String ci) {
        return msgMap.get(ci);
    }

    public void remove(String ci) {
        msgMap.remove(ci);
    }
}
