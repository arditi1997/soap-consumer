package soap.consumer.cats.service;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.client.SoapFaultClientException;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.datatype.DatatypeConfigurationException;
import soap.consumer.cats.model.GetInvoiceFromBooksResultResponse;
import soap.consumer.cats.model.GetInvoicesFromBooksRequest;

public class SoapService extends WebServiceGatewaySupport {

    public GetInvoiceFromBooksResultResponse getInvoicesFromBooksResponse(GetInvoicesFromBooksRequest getInvoicesFromBooksRequest) {

        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        webServiceTemplate.setMarshaller(jaxb2Marshaller);
        webServiceTemplate.setUnmarshaller(jaxb2Marshaller);
        jaxb2Marshaller.setContextPath("soap.consumer.cats.model");

        GetInvoiceFromBooksResultResponse response = null;
        try {
            response = (GetInvoiceFromBooksResultResponse) webServiceTemplate
                    .marshalSendAndReceive("http://localhost:8097/ws/invoice.wsdl",
                            getInvoicesFromBooksRequest, new SoapActionCallback("http://tempuri.org/model/GetInvoiceFromBooksRequest")
                    );
        } catch (SoapFaultClientException e) {

            SoapFault fault = e.getSoapFault();
            if (fault == null) {
                return response;
            }
            SoapFaultDetail details = fault.getFaultDetail();
            if (details == null) {
                return response;
            }
        }
        return response;
    }

    public GetInvoicesFromBooksRequest formatParameters() throws DatatypeConfigurationException {

        String invoiceDate = "2018-12-05";
        String invoiceNumber = "09";
        String nipt = "L26523202A";

        GetInvoicesFromBooksRequest getInvoicesFromBooksRequest = new GetInvoicesFromBooksRequest();
        //set elements
        getInvoicesFromBooksRequest.setNipt(nipt);
        getInvoicesFromBooksRequest.setInvoiceDate(invoiceDate);
        getInvoicesFromBooksRequest.setInvoiceNumber(invoiceNumber);

        return getInvoicesFromBooksRequest;
    }
}
