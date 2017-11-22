package com.tsystems.jms;

import com.tsystems.ejbbeans.RestClient;
import com.tsystems.pojo.StationScheduleDTO;
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
public class NotifyReceiver {

    private StationScheduleDTO[] dtos;

    private ConnectionFactory connectionFactory;
    private Connection connection;

    @PostConstruct
    public void init() {
        connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
    }

    public void createConnection() throws JMSException {
        connection = connectionFactory.createConnection();
        connection.start();
    }

    public void receive(RestClient restClient, String stationName, String stringDate) throws JMSException {

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        String subject = "Bugaved";
        Destination destination = session.createQueue(subject);

        MessageConsumer consumer = session.createConsumer(destination);

        while (true) {

            Message message = consumer.receive();

            if (message != null) {
                try {
                    dtos = restClient.getAllDtos(stationName, stringDate);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void closeConnection() throws JMSException {
        connection.close();
    }

}
