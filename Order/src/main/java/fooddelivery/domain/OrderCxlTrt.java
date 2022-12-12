package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderCxlTrt extends AbstractEvent {

    private String orderId;
    private String custId;
    private String custAddr;
    private String custTel;
    private String orderInfo;
    private Long totPrice;
    private String status;

    public OrderCxlTrt(Order aggregate){
        super(aggregate);
    }
    public OrderCxlTrt(){
        super();
    }
}
