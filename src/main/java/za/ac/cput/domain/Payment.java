package za.ac.cput.domain;


public class Payment {
    private  int paymentId;
    private  Patient patient ;
    private  double amount;
    private  String paymentMethod;
    private  String status;

    private Payment(){}

    private Payment(Builder builder){
        this.paymentId = builder.paymentId;
        this.patient = builder.patient;
        this.amount = builder.amount;
        this.paymentMethod = builder.paymentMethod;
        this.status = builder.status;
        }

    public int getPaymentId() {
        return paymentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", patient=" + patient +
                ", amount=" + amount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public static class Builder{
        private int paymentId;
        private Patient patient;
        private double amount;
        private String paymentMethod;
        private String status;


        public Builder setPaymentId(int paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder setPatient(Patient patient) {
            this.patient = patient;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder copy(Payment payment){
            this.paymentId = payment.getPaymentId();
            this.patient = payment.getPatient();
            this.amount = payment.getAmount();
            this.paymentMethod = payment.getPaymentMethod();
            this.status = payment.getStatus();
            return this;

        }
        public Payment build(){
            return new Payment(this);
        }
    }
}
