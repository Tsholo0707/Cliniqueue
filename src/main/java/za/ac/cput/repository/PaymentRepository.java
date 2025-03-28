
package za.ac.cput.repository;

import za.ac.cput.domain.Payment;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepository implements IPaymentRepository {

    private static PaymentRepository repository = null;
    private List<Payment> paymentList;

    private PaymentRepository() {
        this.paymentList = new ArrayList<>();
    }

    public static PaymentRepository getRepository() {
        if (repository == null) {
            repository = new PaymentRepository();
        }
        return repository;
    }

    @Override
    public Payment create(Payment payment) {
        boolean success = paymentList.add(payment);
        return success ? payment : null;
    }

    @Override
    public Payment read(String paymentId) {
        for (Payment payment : paymentList) {
            if (payment.getPaymentId().equals(paymentId)) {
                return payment;
            }
        }
        return null;
    }

    @Override
    public Payment update(Payment payment) {
        Payment existingPayment = read(payment.getPaymentId());

        if (existingPayment != null) {
            delete(payment.getPaymentId());
            paymentList.add(payment);
            return payment;
        }
        return null;
    }

    @Override
    public boolean delete(String paymentId) {
        Payment paymentToDelete = read(paymentId);
        if (paymentToDelete != null) {
            return paymentList.remove(paymentToDelete);
        }
        return false;
    }

    @Override
    public List<Payment> getAll() {
        return new ArrayList<>(paymentList);
    }
}

