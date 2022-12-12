package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class DeliveryStart extends AbstractEvent {

    private String orderId;
    private String status;

    public DeliveryStart(Delivery aggregate){
        super(aggregate);
    }
    public DeliveryStart(){
        super();
    }
}
