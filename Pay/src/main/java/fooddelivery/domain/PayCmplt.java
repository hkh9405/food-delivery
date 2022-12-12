package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class PayCmplt extends AbstractEvent {

    private String custId;
    private String orderId;
    private String custAddr;
    private String custTel;
    private Long totPrice;
    private String status;
    private String orderInfo;

    public PayCmplt(Pay aggregate){
        super(aggregate);
    }
    public PayCmplt(){
        super();
    }
}
