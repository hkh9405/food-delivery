package fooddelivery.domain;

import fooddelivery.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class PayCmplt extends AbstractEvent {

    private String custId;
    private String orderId;
    private String custAddr;
    private String custTel;
    private Long totPrice;
    private String status;
    private String orderInfo;
}
