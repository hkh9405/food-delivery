package fooddelivery.domain;

import fooddelivery.domain.OrderCmplt;
import fooddelivery.domain.OrderCxlTrt;
import fooddelivery.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Order_table")
@Data

public class Order  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private String custId;
    
    
    
    
    
    private String custAddr;
    
    
    
    
    
    private String custTel;
    
    
    
    
    
    private String orderInfo;
    
    
    
    
    
    private Long totPrice;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        fooddelivery.external.Pay pay = new fooddelivery.external.Pay();
        // mappings goes here
        OrderApplication.applicationContext.getBean(fooddelivery.external.PayService.class)
            .pay(pay);


        OrderCmplt orderCmplt = new OrderCmplt(this);
        orderCmplt.publishAfterCommit();


        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        fooddelivery.external.Pay pay = new fooddelivery.external.Pay();
        // mappings goes here
        OrderApplication.applicationContext.getBean(fooddelivery.external.PayService.class)
            .payCxl(pay);


        OrderCxlTrt orderCxlTrt = new OrderCxlTrt(this);
        orderCxlTrt.publishAfterCommit();

    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }

    public void Order(){
        //
    }



    public static void orderChg(DeliveryStart deliveryStart){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStart.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void orderChg(PayCmplt payCmplt){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(payCmplt.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void orderChg(PayCxl payCxl){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(payCxl.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void orderChg(DeliveryCmplt deliveryCmplt){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCmplt.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void orderChg(OrderCxl orderCxl){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCxl.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }


}
