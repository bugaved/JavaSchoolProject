package com.javaschool.jms;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * Created by bugav on 22.11.2017.
 */
@Component
public class NotifyProducer {

    public void sendNotifyUpdate() throws JMSException {

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        String subject = "Bugaved";
        Destination destination = session.createQueue(subject);
        MessageProducer producer = session.createProducer(destination);

        TextMessage message = session.createTextMessage("Hello !!! Welcome to the world of ActiveMQ.");

        producer.send(message);

        connection.close();
    }

}
