package fooddelivery.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;


@Entity
@Table(name="DeliveryInfo_table")
@Data
public class DeliveryInfo {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private String orderId;
        private String custId;
        private String custAddr;
        private String custTel;
        private String orderInfo;
        private Long totPrice;
        private Date cmpltTime;


}
