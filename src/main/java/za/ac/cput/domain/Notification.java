package za.ac.cput.domain;

public class Notification {
    private int notificationId;
    private User sender;
    private User recipient;
    private String message;
    private String status;

    private Notification(){}

    private Notification(Builder builder){
        this.notificationId = builder.notificationId;
        this.sender = builder.sender;
        this.recipient = builder.recipient;
        this.message = builder.message;
        this.status = builder.message;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public User getSender() {
        return sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId=" + notificationId +
                ", sender=" + sender +
                ", recipient=" + recipient +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public static class Builder{
        private int notificationId;
        private User sender;
        private User recipient;
        private String message;
        private String status;

        public Builder setNotificationId(int notificationId){
            this.notificationId = notificationId;
            return this;
        }
        public Builder setSender(User sender){
            this.sender = sender;
            return this;
        }
        public Builder setRecipient(User recipient){
            this.recipient = recipient;
            return this;
        }
        public Builder setMessage(String message){
            this.message = message;
            return this;

        }
        public Builder setStatus(String status){
            this.status = status;
            return this;
        }

        public Notification build(){
            return new Notification(this);
        }
    }
}
