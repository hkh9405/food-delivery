package fooddelivery.infra;

import fooddelivery.domain.*;
import fooddelivery.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDtlViewHandler {

    @Autowired
    private OrderDtlRepository orderDtlRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPayCmplt_then_CREATE_1 (@Payload PayCmplt payCmplt) {
        try {

            if (!payCmplt.validate()) return;

            // view 객체 생성
            OrderDtl orderDtl = new OrderDtl();
            // view 객체에 이벤트의 Value 를 set 함
            orderDtl.setOrderId(payCmplt.getOrderId());
            orderDtl.setCustId(payCmplt.getCustId());
            orderDtl.setCustAddr(payCmplt.getCustAddr());
            orderDtl.setCustTel(payCmplt.getCustTel());
            orderDtl.setOrderInfo(payCmplt.getOrderInfo());
            orderDtl.setTotPrice(String.valueOf(payCmplt.getTotPrice()));
            orderDtl.setStatus(payCmplt.getStatus());
            // view 레파지 토리에 save
            orderDtlRepository.save(orderDtl);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStart_then_UPDATE_1(@Payload DeliveryStart deliveryStart) {
        try {
            if (!deliveryStart.validate()) return;
                // view 객체 조회
            Optional<OrderDtl> orderDtlOptional = orderDtlRepository.findById(deliveryStart.getId());

            if( orderDtlOptional.isPresent()) {
                 OrderDtl orderDtl = orderDtlOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderDtl.setStatus("deliveryStart");    
                // view 레파지 토리에 save
                 orderDtlRepository.save(orderDtl);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCmplt_then_UPDATE_2(@Payload DeliveryCmplt deliveryCmplt) {
        try {
            if (!deliveryCmplt.validate()) return;
                // view 객체 조회
            Optional<OrderDtl> orderDtlOptional = orderDtlRepository.findById(deliveryCmplt.getId());

            if( orderDtlOptional.isPresent()) {
                 OrderDtl orderDtl = orderDtlOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderDtl.setStatus("deliveryCmplt");    
                // view 레파지 토리에 save
                 orderDtlRepository.save(orderDtl);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

