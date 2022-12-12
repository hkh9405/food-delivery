package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class DeliveryCmplt extends AbstractEvent {

    private String orderId;
    private String status;

    public DeliveryCmplt(CmpltTrt aggregate){
        super(aggregate);
    }
    public DeliveryCmplt(){
        super();
    }
}
