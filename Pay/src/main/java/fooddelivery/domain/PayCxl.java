package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class PayCxl extends AbstractEvent {

    private String custId;
    private String orderId;
    private String custAddr;
    private String custTel;
    private Long totPrice;
    private String status;
    private String orderInfo;

    public PayCxl(Pay aggregate){
        super(aggregate);
    }
    public PayCxl(){
        super();
    }
}
