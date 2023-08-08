package helper;
import exception.WrongFormatException;
import globaldata.GlobalData;
import model.User;
import util.InputUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserServiceHelper {
    static long id=0;
    static int userCount=0;
    public static User fillUser() {
        try {
            String name = InputUtil.inputRequiredString("Enter the name");
            String username = InputUtil.inputRequiredString("Enter the surname");
            LocalDate birthdate = birthdayHelperService();
            LocalDateTime registerDate = nowDate();
            return new User(++id,name, username, birthdate,registerDate,null);
        } catch (WrongFormatException ex) {
            System.out.println(ex.getMessage());

        }
        return null;

    }



    public static LocalDate birthdayHelperService(){

         try {
             String str1 = InputUtil.inputRequiredString("Enter the Local Date (day-month-years) : ");
             String[] str2 = str1.split("-");
             int years = Integer.parseInt(str2[0]);
             int month = Integer.parseInt(str2[1]);
             int day = Integer.parseInt(str2[2]);
             return LocalDate.of(day, month, years);
         }catch (RuntimeException e){
             System.out.println(e.getMessage());
         }
         return null;
    }
    public static void helpRegister(){
        User user = fillUser();
        if (user!=null){
            GlobalData.users[userCount]= user;
            userCount++;
        }

    }
    public static LocalDateTime nowDate(){
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.withNano(0);
    }
}
