package Services.PaymentService;
import Model.Payment.Payment;
import Repository.PaymentRepository.PaymentRepository;

import java.util.Vector;


public class PaymentService {
    private static PaymentService instance = new PaymentService();
    private PaymentRepository paymentRepository = new PaymentRepository() ;

    private PaymentService(){

    }

    public static PaymentService getInstance() {
        return instance;
    }

    public void addPayment(Payment P) { paymentRepository.addPayment(P) ;}

    public Payment findPayment( int id) { return paymentRepository.findPaymentById(id); }

    public void removePayment(int id) {  paymentRepository.removePaymentById(id);}

    public String seePayments()
    {
        String Output="";
        Vector<Payment> paymentList = paymentRepository.getPaymentRepository();
        for(Payment pay : paymentList){
            Output = Output + pay.toString() + "\n";
        }
        return Output;
    }
}
