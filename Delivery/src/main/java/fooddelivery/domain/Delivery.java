package fooddelivery.domain;

import fooddelivery.domain.DeliveryStart;
import fooddelivery.DeliveryApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Delivery_table")
@Data

public class Delivery  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private String custId;
    
    
    
    
    
    private String custAddr;
    
    
    
    
    
    private String custTel;
    
    
    
    
    
    private String orderInfo;
    
    
    
    
    
    private Long totPrice;

    @PostPersist
    public void onPostPersist(){


        DeliveryStart deliveryStart = new DeliveryStart(this);
        deliveryStart.publishAfterCommit();

    }

    public static DeliveryRepository repository(){
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(DeliveryRepository.class);
        return deliveryRepository;
    }




    public static void getDeliveryInfo(FindRider findRider){

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(findRider.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

        
    }


}
