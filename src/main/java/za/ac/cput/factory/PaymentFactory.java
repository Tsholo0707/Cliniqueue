

package za.ac.cput.factory;

import za.ac.cput.domain.Payment;
import za.ac.cput.domain.Patient;
import za.ac.cput.util.Helper;


public class PaymentFactory {
    public static Payment createPayment(int paymentId, Patient patient, double amount, String paymentMethod, String status) {
        if (paymentId <= 0) {
            return null;
        }
        if (patient == null) {
            return null;
        }
        if (!Helper.isValidAmount(amount)) {
            return null;
        }
        if (!Helper.isValidPaymentMethod(paymentMethod)) {
            return null;
        }
        if (!Helper.isValidStatus(status)) {
            return null;
        }

        return new Payment.Builder()
                .setPaymentId(paymentId)
                .setPatient(patient)
                .setAmount(amount)
                .setPaymentMethod(paymentMethod)
                .setStatus(status)
                .build();
    }
}


