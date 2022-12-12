package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderCxl extends AbstractEvent {

    private String orderId;
    private String status;

    public OrderCxl(OrderManage aggregate){
        super(aggregate);
    }
    public OrderCxl(){
        super();
    }
}
