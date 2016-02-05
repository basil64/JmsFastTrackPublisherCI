package com.gft.jms;

import com.gft.jms.producer.MessageMap;
import com.gft.jms.producer.ProducerThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class JmsFastTrackPublisherApplicationCI implements CommandLineRunner {

    @Autowired
    ProducerThread producer;

    @Override
    public void run(String... args) throws Exception {
        producer.run();
    }

	public static void main(String[] args) {
		SpringApplication.run(JmsFastTrackPublisherApplicationCI.class, args);
	}

    @Bean
    public MessageMap getMessageMap() {
        return new MessageMap();
    }
}
