package za.ac.cput.factory.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.PaymentFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PaymentFactoryTest {

    private static Payment validPayment;
    private static Payment paymentWithNegativeAmount;
    private static Payment paymentWithInvalidDate;
    private static Payment paymentWithNullStatus;
    private static Payment paymentWithEmptyId;

    @BeforeAll
    static void setUp() {
        validPayment = PaymentFactory.createPayment("P001", 1000.50, "2025-03-27", "Completed");
        paymentWithNegativeAmount = PaymentFactory.createPayment("P002", -500.00, "2025-03-27", "Pending");
        paymentWithInvalidDate = PaymentFactory.createPayment("P003", 750.75, "Invalid-Date", "Completed");
        paymentWithNullStatus = PaymentFactory.createPayment("P004", 1200.00, "2025-03-27", null);
        paymentWithEmptyId = PaymentFactory.createPayment("", 500.00, "2025-03-27", "Failed");
    }

    @Test
    @Order(1)
    public void testCreatePaymentWithValidData() {
        System.out.println("Test: testCreatePaymentWithValidData");
        assertNotNull(validPayment, "Payment should be created successfully with valid data");
        System.out.println("Created Payment: " + validPayment);
    }

    @Test
    @Order(2)
    public void testCreatePaymentWithNegativeAmount() {
        System.out.println("Test: testCreatePaymentWithNegativeAmount");
        assertNull(paymentWithNegativeAmount, "Payment with negative amount should not be created");
        System.out.println("Failed payment creation with negative amount: " + paymentWithNegativeAmount);
    }

    @Test
    @Order(3)
    public void testCreatePaymentWithInvalidDate() {
        System.out.println("Test: testCreatePaymentWithInvalidDate");
        assertNull(paymentWithInvalidDate, "Payment with invalid date should not be created");
        System.out.println("Failed payment creation with invalid date: " + paymentWithInvalidDate);
    }

    @Test
    @Order(4)
    public void testCreatePaymentWithNullStatus() {
        System.out.println("Test: testCreatePaymentWithNullStatus");
        assertNull(paymentWithNullStatus, "Payment with null status should not be created");
        System.out.println("Failed payment creation with null status: " + paymentWithNullStatus);
    }

    @Test
    @Order(5)
    public void testCreatePaymentWithEmptyId() {
        System.out.println("Test: testCreatePaymentWithEmptyId");
        assertNull(paymentWithEmptyId, "Payment with an empty ID should not be created");
        System.out.println("Failed payment creation with empty ID: " + paymentWithEmptyId);
    }

    @Test
    @Order(6)
    public void testCreatePaymentWithNullPatient() {
        System.out.println("Test: testCreatePaymentWithNullPatient");
        Payment paymentWithNullPatient = PaymentFactory.createPayment("P005", 500.00, "2025-03-27", "Completed");
        assertNull(paymentWithNullPatient, "Payment with null patient should not be created");
        System.out.println("Failed payment creation with null patient: " + paymentWithNullPatient);
    }
}
