public class SecurityUtils {
    public static User login(User u){
        IO.println("Username: " + u.getName());
        IO.println("Password: " + u.getPassword());
        u.setPassword("");
        return u;
    }
}
