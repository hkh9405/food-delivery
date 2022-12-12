package fooddelivery.common;


import fooddelivery.CustHelpApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { CustHelpApplication.class })
public class CucumberSpingConfiguration {
    
}
