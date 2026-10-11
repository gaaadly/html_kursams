package lt.techin.oop;

public class MessagingService {

    private java.util.List<Message> messages = new java.util.ArrayList<>();


    public MessagingService() {
        // TODO: implement the contract in README.md / README.lt.md.
    }

    public void add(Message message) {
        // TODO: implement the contract in README.md / README.lt.md.
        if (message.getContent().length() <= 280) {
            messages.add(message);
        }
    }

    public java.util.ArrayList<Message> getMessages() {
        // TODO: implement the contract in README.md / README.lt.md.
        return new java.util.ArrayList<>(messages);
    }
}