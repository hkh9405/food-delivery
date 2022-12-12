package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
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
}


