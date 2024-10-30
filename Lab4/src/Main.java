
interface Notification {
    void send(String title, String message);
}

class EmailNotification implements Notification {
    private String adminEmail;

    public EmailNotification(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    @Override
    public void send(String title, String message) {
        System.out.println("Sent email title '" + title + "' to '" + adminEmail + "' message '" + message + "'.");
}
}

class SlackAPI {
    private String login;
    private String apiKey;

    public SlackAPI(String login, String apiKey) {
        this.login = login;
        this.apiKey = apiKey;
    }

    public void logIn() {
        System.out.println("Logged as " + login);
    }

    public void sendMessage(String chatId, String message) {
        System.out.println("Posted to Slack chat " + chatId + ": " + message);
    }
}

class SlackNotificationAdapter implements Notification {
    private SlackAPI slack;
    private String chatId;

    public SlackNotificationAdapter(String login, String apiKey, String chatId) {
        this.slack = new SlackAPI(login, apiKey);
        this.chatId = chatId;
        this.slack.logIn();
    }

    @Override
    public void send(String title, String message) {
        String formattedMessage = formatMessage(title, message);
        slack.sendMessage(chatId, formattedMessage);
    }

    private String formatMessage(String title, String message) {
        return title + "\n" + message;
    }
}

class SMSService {
    private String phoneNumber;
    private String sender;

    public SMSService(String phoneNumber, String sender) {
        this.phoneNumber = phoneNumber;
        this.sender = sender;
    }

    public void sendSMS(String text) {
        System.out.println("Sent SMS from " + sender + " to " + phoneNumber + ": " + text);
    }
}

class SMSNotificationAdapter implements Notification {
    private SMSService smsService;

    public SMSNotificationAdapter(String phoneNumber, String sender) {
        this.smsService = new SMSService(phoneNumber, sender);
    }

    @Override
    public void send(String title, String message) {
        String formattedMessage = formatMessage(title, message);
        smsService.sendSMS(formattedMessage);
    }

    private String formatMessage(String title, String message) {
        return title + ": " + message;
    }
}

class Main {
    public static void main(String[] args) {
        Notification emailNotification = new EmailNotification("Hakagron11037@gmail.com");
        emailNotification.send("Website is down!", "HELLOO");

        Notification slackNotification = new SlackNotificationAdapter(
                "admin",
                "Hakagron-123456789",
                "general-channel"
        );
        slackNotification.send("Website Status", "Hi!");

        Notification smsNotification = new SMSNotificationAdapter(
                "+1234567890",
                "AdminAlert"
        );
        smsNotification.send("Alert", "Hi 2!");
    }
}