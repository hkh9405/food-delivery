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
    @Autowired OrderRepository orderRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryStart'")
    public void wheneverDeliveryStart_OrderChg(@Payload DeliveryStart deliveryStart){

        DeliveryStart event = deliveryStart;
        System.out.println("\n\n##### listener OrderChg : " + deliveryStart + "\n\n");


        

        // Sample Logic //
        Order.orderChg(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='PayCmplt'")
    public void wheneverPayCmplt_OrderChg(@Payload PayCmplt payCmplt){

        PayCmplt event = payCmplt;
        System.out.println("\n\n##### listener OrderChg : " + payCmplt + "\n\n");


        

        // Sample Logic //
        Order.orderChg(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='PayCxl'")
    public void wheneverPayCxl_OrderChg(@Payload PayCxl payCxl){

        PayCxl event = payCxl;
        System.out.println("\n\n##### listener OrderChg : " + payCxl + "\n\n");


        

        // Sample Logic //
        Order.orderChg(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryCmplt'")
    public void wheneverDeliveryCmplt_OrderChg(@Payload DeliveryCmplt deliveryCmplt){

        DeliveryCmplt event = deliveryCmplt;
        System.out.println("\n\n##### listener OrderChg : " + deliveryCmplt + "\n\n");


        

        // Sample Logic //
        Order.orderChg(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCxl'")
    public void wheneverOrderCxl_OrderChg(@Payload OrderCxl orderCxl){

        OrderCxl event = orderCxl;
        System.out.println("\n\n##### listener OrderChg : " + orderCxl + "\n\n");


        

        // Sample Logic //
        Order.orderChg(event);
        

        

    }

}


