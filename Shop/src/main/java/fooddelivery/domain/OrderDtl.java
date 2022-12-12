package fooddelivery.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;


@Entity
@Table(name="OrderDtl_table")
@Data
public class OrderDtl {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private String orderId;
        private String custId;
        private String custAddr;
        private String custTel;
        private String orderInfo;
        private String totPrice;
        private String status;


}
