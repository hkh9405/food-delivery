package fooddelivery.external;

import lombok.Data;
import java.util.Date;
@Data
public class Pay {

    private String custId;
    private String orderId;
    private String custAddr;
    private String custTel;
    private Long totPrice;
    private String status;
    private String orderInfo;
}


