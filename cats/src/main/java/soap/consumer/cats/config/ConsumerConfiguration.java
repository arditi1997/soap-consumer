package soap.consumer.cats.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ConsumerConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("soap.consumer.cats.model");
        return marshaller;
    }

//    @Bean
//    public SoapService quoteClient(Jaxb2Marshaller marshaller) {
//        SoapService client = new SoapService();
//        client.setDefaultUri("http://localhost:8097/ws/invoice.wsdl");
//        client.setMarshaller(marshaller);
//        client.setUnmarshaller(marshaller);
//        return client;
//    }

}
