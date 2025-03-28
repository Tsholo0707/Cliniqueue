


package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.PaymentFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentRepositoryTest {

    private static IPaymentRepository repository = PaymentRepository.getRepository();
    private static Payment payment = PaymentFactory.createPayment("P123", 1500.00, "2025-03-27", "2025-03-27");

    @Test
    void a_create() {
        Payment created = repository.create(payment);
        assertNotNull(created);
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Payment read = repository.read(payment.getPaymentId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Payment updatedPayment = new Payment.Builder()
                .copy(payment)
                .setAmount(2000.00)
                .build();

        Payment updated = repository.update(updatedPayment);
        assertNotNull(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_delete() {
        assertTrue(repository.delete(payment.getPaymentId()));
        System.out.println("Success: Payment deleted");
    }

    @Test
    void e_getAll() {
        System.out.println("All Payments: " + repository.getAll());
    }
}
