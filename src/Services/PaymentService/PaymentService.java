package Services.PaymentService;
import Model.Payment.Payment;
import Repository.PaymentRepository.PaymentRepository;
import Services.AuditService;

import java.util.Vector;


public class PaymentService {
    private static PaymentService instance = new PaymentService();
    private PaymentRepository paymentRepository = new PaymentRepository() ;
    private AuditService auditService = AuditService.getInstance();

    private PaymentService(){

    }

    public static PaymentService getInstance() {
        return instance;
    }

    public void addPayment(Payment P) {
        auditService.writeLog("addPayment");
        paymentRepository.addPayment(P) ;
    }
    public void addPayments(Vector<Payment> P){
        auditService.writeLog("addPayments");
        paymentRepository.addPayment(P);
    }

    public Payment findPayment( int id) {
        auditService.writeLog("findPayment");
        return paymentRepository.findPaymentById(id);
    }

    public void removePayment(int id) {
        auditService.writeLog("removePayment");
        paymentRepository.removePaymentById(id);
    }

    public Vector<Payment> getPayments()
    {
        auditService.writeLog("getPayments");
        return paymentRepository.getPaymentRepository();
    }

    public String seePayments()
    {
        auditService.writeLog("seePayments");
        String Output="";
        Vector<Payment> paymentList = paymentRepository.getPaymentRepository();
        for(Payment pay : paymentList){
            Output = Output + pay.toString() + "\n";
        }
        return Output;
    }
}
