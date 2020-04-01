package Repository.PaymentRepository;

import Model.Payment.Payment;

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
        for( Payment pay: paymentRepository)
        {
            if(pay.getId() == id)
            {
                paymentRepository.remove(pay);
            }
        }
    }

    public Vector<Payment> getPaymentRepository()
    {
        return paymentRepository;
    }
}
