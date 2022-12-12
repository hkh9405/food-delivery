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
public class OrderInfoViewHandler {

    @Autowired
    private OrderInfoRepository orderInfoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPayCmplt_then_CREATE_1 (@Payload PayCmplt payCmplt) {
        try {

            if (!payCmplt.validate()) return;

            // view 객체 생성
            OrderInfo orderInfo = new OrderInfo();
            // view 객체에 이벤트의 Value 를 set 함
            orderInfo.setStatus("orderCmplt");
            orderInfo.setOrderId(payCmplt.getOrderId());
            orderInfo.setOrderInfo(Long.valueOf(payCmplt.getOrderInfo()));
            orderInfo.setTotPrice(payCmplt.getTotPrice());
            // view 레파지 토리에 save
            orderInfoRepository.save(orderInfo);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenFindRider_then_UPDATE_1(@Payload FindRider findRider) {
        try {
            if (!findRider.validate()) return;
                // view 객체 조회
            Optional<OrderInfo> orderInfoOptional = orderInfoRepository.findById(findRider.getId());

            if( orderInfoOptional.isPresent()) {
                 OrderInfo orderInfo = orderInfoOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderInfo.setStatus("orderAccept");    
                // view 레파지 토리에 save
                 orderInfoRepository.save(orderInfo);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPayCxl_then_UPDATE_2(@Payload PayCxl payCxl) {
        try {
            if (!payCxl.validate()) return;
                // view 객체 조회
            Optional<OrderInfo> orderInfoOptional = orderInfoRepository.findById(payCxl.getOrderId());

            if( orderInfoOptional.isPresent()) {
                 OrderInfo orderInfo = orderInfoOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderInfo.setStatus("payCxl");    
                // view 레파지 토리에 save
                 orderInfoRepository.save(orderInfo);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCxl_then_UPDATE_3(@Payload OrderCxl orderCxl) {
        try {
            if (!orderCxl.validate()) return;
                // view 객체 조회
            Optional<OrderInfo> orderInfoOptional = orderInfoRepository.findById(orderCxl.getId());

            if( orderInfoOptional.isPresent()) {
                 OrderInfo orderInfo = orderInfoOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderInfo.setStatus("orderCxl");    
                // view 레파지 토리에 save
                 orderInfoRepository.save(orderInfo);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStart_then_UPDATE_4(@Payload DeliveryStart deliveryStart) {
        try {
            if (!deliveryStart.validate()) return;
                // view 객체 조회
            Optional<OrderInfo> orderInfoOptional = orderInfoRepository.findById(deliveryStart.getId());

            if( orderInfoOptional.isPresent()) {
                 OrderInfo orderInfo = orderInfoOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderInfo.setStatus("deliveryStart"");    
                // view 레파지 토리에 save
                 orderInfoRepository.save(orderInfo);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCmplt_then_UPDATE_5(@Payload DeliveryCmplt deliveryCmplt) {
        try {
            if (!deliveryCmplt.validate()) return;
                // view 객체 조회
            Optional<OrderInfo> orderInfoOptional = orderInfoRepository.findById(deliveryCmplt.getId());

            if( orderInfoOptional.isPresent()) {
                 OrderInfo orderInfo = orderInfoOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderInfo.setStatus("deliveryCmplt");    
                // view 레파지 토리에 save
                 orderInfoRepository.save(orderInfo);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

