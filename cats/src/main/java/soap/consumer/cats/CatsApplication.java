package soap.consumer.cats;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import soap.consumer.cats.model.GetInvoiceFromBooksResultResponse;
import soap.consumer.cats.model.GetInvoicesFromBooksRequest;
import soap.consumer.cats.service.SoapService;

@SpringBootApplication
public class CatsApplication implements CommandLineRunner{


	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(CatsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SoapService soapService = new SoapService();
		GetInvoicesFromBooksRequest getInvoicesFromBooksRequest = soapService.formatParameters();
		GetInvoiceFromBooksResultResponse response = soapService.getInvoicesFromBooksResponse(getInvoicesFromBooksRequest);

		log.info("Invoice date  : {}", response.getInvoiceDate());
		log.info("Invoice Number  : {}", response.getInvoiceNumber());
		log.info("Nipt : {}", response.getNIPT());
		log.info("Book Version : {}", response.getBookVersion());
		log.info("Is Sales Invoice : {}", response.getIsSalesInvoice());
		log.info("Target taxpayer name : {}", response.getTargetTaxpayerName());
		log.info("Line id : {}", response.getLineID());
		log.info("Target taxpayer id id : {}", response.getTargetTaxpayerID());
		log.info("Target taxpayer nipt id : {}", response.getTargetTaxpayerNIPT());
		log.info("Book id : {}", response.getBookID());
	}
}
