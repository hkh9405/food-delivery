package fooddelivery.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;


@Entity
@Table(name="OrderInfo_table")
@Data
public class OrderInfo {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private String orderId;
        private Long orderInfo;
        private Long totPrice;
        private String status;


}
