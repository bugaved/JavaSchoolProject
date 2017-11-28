package com.tsystems.jms;

import lombok.Getter;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.jms.*;

/**
 * Created by bugav on 22.11.2017.
 */
@Singleton
@Startup
@Getter
public class NotifyConsumer {

    private ConnectionFactory connectionFactory;
    private Connection connection;

    @PostConstruct
    public void init() {
        connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
    }

    /**
     * creates connection to active mq
     */
    public void createConnection() throws JMSException {
        connection = connectionFactory.createConnection();
        connection.start();
    }

    /**
     * recieves jms message
     */
    public void receive() {

        Session session = null;

        try {

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            String subject = "Bugaved";
            Destination destination = session.createQueue(subject);

            MessageConsumer consumer = session.createConsumer(destination);

            Message message = consumer.receive();

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
    /**
     * close connection to active mq
     */
    public void closeConnection() throws JMSException {
        connection.close();
    }

}
