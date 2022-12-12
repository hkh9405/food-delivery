package fooddelivery.domain;

import fooddelivery.domain.DeliveryCmplt;
import fooddelivery.DeliveryApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="CmpltTrt_table")
@Data

public class CmpltTrt  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private String orderId;

    @PostPersist
    public void onPostPersist(){


        DeliveryCmplt deliveryCmplt = new DeliveryCmplt(this);
        deliveryCmplt.publishAfterCommit();

    }

    public static CmpltTrtRepository repository(){
        CmpltTrtRepository cmpltTrtRepository = DeliveryApplication.applicationContext.getBean(CmpltTrtRepository.class);
        return cmpltTrtRepository;
    }






}
