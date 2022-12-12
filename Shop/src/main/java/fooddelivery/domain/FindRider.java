package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class FindRider extends AbstractEvent {

    private String oderId;
    private String custId;
    private String custAddr;
    private String custTel;
    private String orderInfo;
    private Long totPrice;
    private Date cmpltTime;

    public FindRider(OrderManage aggregate){
        super(aggregate);
    }
    public FindRider(){
        super();
    }
}
