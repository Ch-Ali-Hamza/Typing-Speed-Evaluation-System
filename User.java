import java.io.Serializable;

public abstract class User implements TypingBehavior, Serializable {
    protected String username;
    protected String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String input) {
        return password.equals(input);
    }

    public abstract boolean isPremium();
}