package fooddelivery.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import fooddelivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import fooddelivery.domain.*;

@Service
@Transactional
public class PolicyHandler{
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryStart'")
    public void wheneverDeliveryStart_SendMsg(@Payload DeliveryStart deliveryStart){

        DeliveryStart event = deliveryStart;
        System.out.println("\n\n##### listener SendMsg : " + deliveryStart + "\n\n");


        

        // Sample Logic //

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryCmplt'")
    public void wheneverDeliveryCmplt_SendMsg(@Payload DeliveryCmplt deliveryCmplt){

        DeliveryCmplt event = deliveryCmplt;
        System.out.println("\n\n##### listener SendMsg : " + deliveryCmplt + "\n\n");


        

        // Sample Logic //

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='PayCmplt'")
    public void wheneverPayCmplt_SendMsg(@Payload PayCmplt payCmplt){

        PayCmplt event = payCmplt;
        System.out.println("\n\n##### listener SendMsg : " + payCmplt + "\n\n");


        

        // Sample Logic //

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='PayCxl'")
    public void wheneverPayCxl_SendMsg(@Payload PayCxl payCxl){

        PayCxl event = payCxl;
        System.out.println("\n\n##### listener SendMsg : " + payCxl + "\n\n");


        

        // Sample Logic //

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCxl'")
    public void wheneverOrderCxl_SendMsg(@Payload OrderCxl orderCxl){

        OrderCxl event = orderCxl;
        System.out.println("\n\n##### listener SendMsg : " + orderCxl + "\n\n");


        

        // Sample Logic //

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='FindRider'")
    public void wheneverFindRider_SendMsg(@Payload FindRider findRider){

        FindRider event = findRider;
        System.out.println("\n\n##### listener SendMsg : " + findRider + "\n\n");


        

        // Sample Logic //

        

    }

}


