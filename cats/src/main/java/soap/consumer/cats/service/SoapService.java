package soap.consumer.cats.service;

import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.client.SoapFaultClientException;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.GregorianCalendar;

//@Service
//public class SoapService extends WebServiceGatewaySupport {
//
//
//    public GetInvoicesFromBooksResponse getInvoicesFromBooksResponse(GetInvoicesFromBooks getInvoicesFromBooks) {
//
//        GetInvoicesFromBooksResponse response = null;
//        try {
//            response = (GetInvoicesFromBooksResponse) getWebServiceTemplate()
//                    .marshalSendAndReceive("http:localhost:8097/ws/invoice.wsdl",
//                            getInvoicesFromBooks,
//                            new SoapActionCallback("http://tempuri.org/model/GetInvoiceFromBooksRequest"));
//        } catch (SoapFaultClientException e) {
//            log.warn("", e);
//            SoapFault fault = e.getSoapFault();
//            if (fault == null) {
//                return response;
//            }
//            SoapFaultDetail details = fault.getFaultDetail();
//            if (details == null) {
//                return response;
//            }
//        }
//        return response;
//    }
//
//    public GetInvoicesFromBooks formatParameters(GetInvoicesFromBooksRequest getInvoicesFromBooksRequest) throws DatatypeConfigurationException {
//
//        GetInvoicesFromBooks getInvoicesFromBooks = new GetInvoicesFromBooks();
//        //format nipt
//        JAXBElement<String> nipt = new JAXBElement(new QName("http://tempuri.org/", "nipt"), String.class, getInvoicesFromBooksRequest.getNipt());
//        //format invoiceNumber
//        JAXBElement<String> invoiceNumber = new JAXBElement(new QName("http://tempuri.org/", "invoiceNumber"), String.class, getInvoicesFromBooksRequest.getInvoiceNumber());
//        //format invoiceDate
//        LocalDate localDate = LocalDate.parse(getInvoicesFromBooksRequest.getInvoiceDate());
//        GregorianCalendar gcal = GregorianCalendar.from(localDate.atStartOfDay(ZoneId.systemDefault()));
//        XMLGregorianCalendar invoiceDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
//
//        //set elements
//        getInvoicesFromBooks.setNipt(nipt);
//        getInvoicesFromBooks.setInvoiceDate(invoiceDate);
//        getInvoicesFromBooks.setInvoiceNumber(invoiceNumber);
//
//        return getInvoicesFromBooks;
//    }
//}
