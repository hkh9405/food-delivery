package fooddelivery.infra;
import fooddelivery.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class CmpltTrtHateoasProcessor implements RepresentationModelProcessor<EntityModel<CmpltTrt>>  {

    @Override
    public EntityModel<CmpltTrt> process(EntityModel<CmpltTrt> model) {

        
        return model;
    }
    
}
