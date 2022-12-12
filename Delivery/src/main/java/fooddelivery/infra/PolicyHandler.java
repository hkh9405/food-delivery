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
    @Autowired DeliveryRepository deliveryRepository;
    @Autowired CmpltTrtRepository cmpltTrtRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='FindRider'")
    public void wheneverFindRider_GetDeliveryInfo(@Payload FindRider findRider){

        FindRider event = findRider;
        System.out.println("\n\n##### listener GetDeliveryInfo : " + findRider + "\n\n");


        

        // Sample Logic //
        Delivery.getDeliveryInfo(event);
        

        

    }

}


