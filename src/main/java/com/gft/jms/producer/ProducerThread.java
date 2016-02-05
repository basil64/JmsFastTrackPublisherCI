package com.gft.jms.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import static java.lang.Thread.sleep;

@Service
public class ProducerThread {
    public static final int DELAY = 2000;
    public static final int BASIC_DELAY = 5000;
    Logger logger = LoggerFactory.getLogger(ProducerThread.class);

    @Autowired
    private MessageSender messageSender;

    @Async
    public void run() {
        while (true) {
            try {
                sleep((int)(DELAY * Math.random()) + BASIC_DELAY);
                messageSender.sendMessage();
                logger.info("Message sent to RequestQueue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
