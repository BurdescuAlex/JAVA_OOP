package unibuc.fulger.Repository.PaymentRepository;

import unibuc.fulger.Model.Payment.Payment;

import java.util.Vector;

public class PaymentRepository {
    private Vector<Payment> paymentRepository = new Vector<Payment>();

    public PaymentRepository() {
    }

    public PaymentRepository(Vector<Payment> paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void addPayment(Payment P)
    {
        paymentRepository.add(P);
    }
    public void addPayment(Vector<Payment> P) { paymentRepository.addAll(P);}

    public Payment findPaymentById(int id)
    {
        for( Payment pay: paymentRepository)
        {
            if(pay.getId() == id)
            {
               return pay;
            }
        }
        return null;
    }

    public void removePaymentById(int id)
    {
        for(Payment p : paymentRepository)
        {
            if(p.getId() == id){
                System.out.println("Removed: " + p.toString());
            }
        }
        paymentRepository.removeIf(p -> p.getId() == id);
    }

    public Vector<Payment> getPaymentRepository()
    {
        return paymentRepository;
    }
}
