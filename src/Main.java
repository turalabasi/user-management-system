import service.Impl.UserManagementSystemImpl;
import service.UserManagementSystem;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        UserManagementSystem userManagementSystem=new UserManagementSystemImpl();
        userManagementSystem.management();
    }
}