package soap.consumer.cats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
//import soap.consumer.cats.service.SoapService;

@Endpoint
public class Controller {

//    @Autowired
//    SoapService service;
//
//    @PayloadRoot(namespace = "http://tempuri.org/model", localPart = "GetInvoicesFromBooksRequest")
//    @ResponsePayload
//    public GetInvoiceFromBooks getInvoiceFromBooks (GetInvoiceFromBooks getInvoiceFromBooks){
//
//        //format parameters to Jaxb-element
//        GetInvoicesFromBooks getInvoicesFromBooks = service.formatParameters(getInvoicesFromBooksRequest);
//        //call api
//        GetInvoicesFromBooksResponse response = service.getInvoicesFromBooksResponse(getInvoicesFromBooks);
//
//        return  invoiceMapper.invoiceMapper(response.getGetInvoicesFromBooksResult().getValue().getGetInvoiceFromBooksResult());
//    }
}
