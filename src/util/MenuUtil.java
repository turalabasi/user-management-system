package util;
import static util.InputUtil.inputRequiredByte;
public class MenuUtil {
    public static byte entryApp() {
        System.out.println("[1].-> Exit \n" +
                "[2].-> Register \n" +
                "[3].-> Update user parameters \n" +
                "[4].-> Delete user id \n" +
                "[5].->  Search user name/surname \n" +
                "[6].-> Show user list \n" );


        return InputUtil.inputRequiredByte(" choose option: ");

}}
