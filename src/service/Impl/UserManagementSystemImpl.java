package service.Impl;

import enums.ExceptionsEnum;
import exception.EmptyListException;
import exception.InvalidOptionException;
import exception.UsernameNotFoundException;
import exception.WrongFormatException;
import service.UserManagementSystem;
import service.UserService;

import java.util.InputMismatchException;

import static util.MenuUtil.entryApp;
public class UserManagementSystemImpl implements UserManagementSystem {
    @Override
    public void management() {
        while (true){

            try {
                byte option=entryApp();
                UserService userService =new UserServiceImpl();
                switch (option) {
                    case 1:
                        System.exit(-1);
                        break;
                    case 2:
                        userService.register();
                        break;
                    case 3:
                        userService.update();
                        break;
                    case 4:
                        userService.delete();
                        break;
                    case 5:
                        userService.search();
                        break;
                    case 6:
                        userService.show();
                        break;
                    default:
                        throw new InvalidOptionException(ExceptionsEnum.INVALID_OPTION_EXCEPTION);
                }
            } catch (InvalidOptionException | UsernameNotFoundException | WrongFormatException | EmptyListException |
                     InputMismatchException | NumberFormatException e){
                System.err.println(e.getMessage());

            }

          }
    }

}

