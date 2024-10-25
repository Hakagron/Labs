
abstract class SocialNetworkPoster {
    public abstract SocialNetwork createNetwork();

    public void postMessage(String message) {
        SocialNetwork network = createNetwork();
        network.logIn();
        network.createPost(message);
        network.logOut();
    }
}

interface SocialNetwork {
    void logIn();
    void createPost(String message);
    void logOut();
}

class Facebook implements SocialNetwork {
    private String login;
    private String password;

    public Facebook(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public void logIn() {
        System.out.println("Logging into Facebook with login: " + login);
    }

    @Override
    public void createPost(String message) {
        System.out.println("Posting message on Facebook: " + message);
    }

    @Override
    public void logOut() {
        System.out.println("Logging out from Facebook.");
    }
}

class LinkedIn implements SocialNetwork {
    private String email;
    private String password;

    public LinkedIn(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void logIn() {
        System.out.println("Logging into LinkedIn with email: " + email);
    }

    @Override
    public void createPost(String message) {
        System.out.println("Posting message on LinkedIn: " + message);
    }

    @Override
    public void logOut() {
        System.out.println("Logging out from LinkedIn.");
    }
}

class FacebookPoster extends SocialNetworkPoster {
    private String login;
    private String password;

    public FacebookPoster(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public SocialNetwork createNetwork() {
        return new Facebook(login, password);
    }
}
class LinkedInPoster extends SocialNetworkPoster {
    private String email;
    private String password;

    public LinkedInPoster(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public SocialNetwork createNetwork() {
        return new LinkedIn(email, password);
    }
}

public class Main {
    public static void main(String[] args) {
        SocialNetworkPoster facebookPoster = new FacebookPoster("user_login", "user_password");
        facebookPoster.postMessage("Hiiiiiii, Facebook!");

        SocialNetworkPoster linkedInPoster = new LinkedInPoster("user_email@example.com", "user_password");
        linkedInPoster.postMessage("Hiiiiiii, LinkedIn!");
    }
}
