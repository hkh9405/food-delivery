package fooddelivery.domain;

import fooddelivery.domain.FindRider;
import fooddelivery.domain.OrderCxl;
import fooddelivery.ShopApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="OrderManage_table")
@Data

public class OrderManage  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private String oderId;
    
    
    
    
    
    private String custId;
    
    
    
    
    
    private String custAddr;
    
    
    
    
    
    private String custTel;
    
    
    
    
    
    private String orderInfo;
    
    
    
    
    
    private Long totPrice;
    
    
    
    
    
    private Date cmpltTime;

    @PostPersist
    public void onPostPersist(){


        FindRider findRider = new FindRider(this);
        findRider.publishAfterCommit();



        OrderCxl orderCxl = new OrderCxl(this);
        orderCxl.publishAfterCommit();

    }

    public static OrderManageRepository repository(){
        OrderManageRepository orderManageRepository = ShopApplication.applicationContext.getBean(OrderManageRepository.class);
        return orderManageRepository;
    }




    public static void getOrderInfo(PayCmplt payCmplt){

        /** Example 1:  new item 
        OrderManage orderManage = new OrderManage();
        repository().save(orderManage);

        */

        /** Example 2:  finding and process
        
        repository().findById(payCmplt.get???()).ifPresent(orderManage->{
            
            orderManage // do something
            repository().save(orderManage);


         });
        */

        
    }
    public static void orderCxl(PayCxl payCxl){

        /** Example 1:  new item 
        OrderManage orderManage = new OrderManage();
        repository().save(orderManage);

        */

        /** Example 2:  finding and process
        
        repository().findById(payCxl.get???()).ifPresent(orderManage->{
            
            orderManage // do something
            repository().save(orderManage);


         });
        */

        
    }


}
