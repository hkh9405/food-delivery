package fooddelivery.domain;

import fooddelivery.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class DeliveryCmplt extends AbstractEvent {

    private String orderId;
    private String status;
}
