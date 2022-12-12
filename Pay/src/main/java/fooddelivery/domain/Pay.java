package fooddelivery.domain;

import fooddelivery.domain.PayCmplt;
import fooddelivery.domain.PayCxl;
import fooddelivery.PayApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Pay_table")
@Data

public class Pay  {


    
    
    
    
    
    private String custId;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private String custAddr;
    
    
    
    
    
    private String custTel;
    
    
    
    
    
    private Long totPrice;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String orderInfo;

    @PostPersist
    public void onPostPersist(){


        PayCmplt payCmplt = new PayCmplt(this);
        payCmplt.publishAfterCommit();



        PayCxl payCxl = new PayCxl(this);
        payCxl.publishAfterCommit();

    }

    public static PayRepository repository(){
        PayRepository payRepository = PayApplication.applicationContext.getBean(PayRepository.class);
        return payRepository;
    }






}
