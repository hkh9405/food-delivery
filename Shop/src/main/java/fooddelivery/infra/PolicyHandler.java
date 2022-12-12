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
    @Autowired OrderManageRepository orderManageRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='PayCmplt'")
    public void wheneverPayCmplt_GetOrderInfo(@Payload PayCmplt payCmplt){

        PayCmplt event = payCmplt;
        System.out.println("\n\n##### listener GetOrderInfo : " + payCmplt + "\n\n");


        

        // Sample Logic //
        OrderManage.getOrderInfo(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='PayCxl'")
    public void wheneverPayCxl_OrderCxl(@Payload PayCxl payCxl){

        PayCxl event = payCxl;
        System.out.println("\n\n##### listener OrderCxl : " + payCxl + "\n\n");


        

        // Sample Logic //
        OrderManage.orderCxl(event);
        

        

    }

}


