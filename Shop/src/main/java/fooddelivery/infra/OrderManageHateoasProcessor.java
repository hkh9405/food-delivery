package fooddelivery.infra;
import fooddelivery.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class OrderManageHateoasProcessor implements RepresentationModelProcessor<EntityModel<OrderManage>>  {

    @Override
    public EntityModel<OrderManage> process(EntityModel<OrderManage> model) {

        
        return model;
    }
    
}
