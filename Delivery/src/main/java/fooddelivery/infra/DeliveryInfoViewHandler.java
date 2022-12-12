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
public class DeliveryInfoViewHandler {

    @Autowired
    private DeliveryInfoRepository deliveryInfoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFindRider_then_CREATE_1 (@Payload FindRider findRider) {
        try {

            if (!findRider.validate()) return;

            // view 객체 생성
            DeliveryInfo deliveryInfo = new DeliveryInfo();
            // view 객체에 이벤트의 Value 를 set 함
            deliveryInfo.setOrderId(findRider.getOderId());
            deliveryInfo.setCustId(findRider.getCustId());
            deliveryInfo.setCustAddr(findRider.getCustAddr());
            deliveryInfo.setCustTel(findRider.getCustTel());
            deliveryInfo.setOrderInfo(findRider.getOrderInfo());
            deliveryInfo.setTotPrice(findRider.getTotPrice());
            // view 레파지 토리에 save
            deliveryInfoRepository.save(deliveryInfo);

        }catch (Exception e){
            e.printStackTrace();
        }
    }




}

