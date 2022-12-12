package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderCmplt extends AbstractEvent {

    private String oderId;
    private String custId;
    private String custAddr;
    private String custTel;
    private String orderInfo;
    private Long totPrice;
    private String status;

    public OrderCmplt(Order aggregate){
        super(aggregate);
    }
    public OrderCmplt(){
        super();
    }
}
