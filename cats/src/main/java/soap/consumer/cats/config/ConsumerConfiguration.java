package soap.consumer.cats.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import soap.consumer.cats.service.SoapService;

@Configuration
public class ConsumerConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("soap.consumer.cats.model");
        return marshaller;
    }

    @Bean
    public SoapService soapService(Jaxb2Marshaller marshaller) {
        SoapService client = new SoapService();
        client.setDefaultUri("http://localhost:8097/ws/invoice.wsdl");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
