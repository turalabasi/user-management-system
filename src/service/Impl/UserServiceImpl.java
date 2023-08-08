package service.Impl;
import enums.ExceptionsEnum;
import enums.StatusEnum;
import exception.EmptyListException;
import exception.UsernameNotFoundException;
import exception.WrongFormatException;
import globaldata.GlobalData;
import model.User;
import service.UserService;
import util.InputUtil;
import util.MenuUtil;

import static globaldata.GlobalData.users;
import static helper.UserServiceHelper.*;

public class UserServiceImpl implements UserService {
    static int userCount=0;
    @Override
    public boolean register() {
        byte count = InputUtil.inputRequiredByte("Enter the user count");

            if (GlobalData.users == null) {
                GlobalData.users = new User[count];
                for (int i = 0; i < count; i++) {
                    helpRegister();
                }
                System.out.println(StatusEnum.REGISTER_SUCCESSFULLY);
            } else {
                User[] tempUser = GlobalData.users;
                GlobalData.users = new User[tempUser.length + count];
                for (int i = 0; i < tempUser.length; i++) {
                    GlobalData.users[i] = tempUser[i];
                }
                for (int i = tempUser.length; i < GlobalData.users.length; i++) {
                    helpRegister();
                }
                System.out.println(StatusEnum.REGISTER_SUCCESSFULLY);
            }
            return true;
        }

    @Override
    public void show() {
        for (User user:GlobalData.users) {
              {
                  System.out.println(user);
              }
        }
    }

    @Override
    public void search() {
        if (GlobalData.users==null || GlobalData.users.length==0)
            throw new EmptyListException(ExceptionsEnum.EMPTY_LIST_EXCEPTION);
        else {
            String key = InputUtil.inputRequiredString("Search");
            boolean isFind = false;

            for (int i = 0; i < users.length; i++) {
                if (users[i].getSurname().contains(key) ||
                        users[i].getName().contains(key)) {
                    isFind = true;
                    System.out.println(users[i].toString());
                }

            }
            if (!isFind) {
                throw new UsernameNotFoundException(ExceptionsEnum.USERNAME_NOT_FOUND);

            }
         }
    }

    @Override
    public boolean update() {
        if (GlobalData.users == null || GlobalData.users.length == 0)
            throw new EmptyListException(ExceptionsEnum.EMPTY_LIST_EXCEPTION);
          long id=InputUtil.inputRequiredLong("enter the updated user id");
          boolean isTrue = false;

        for (int i = 0; i < GlobalData.users.length; i++) {
            if (GlobalData.users[i].getId() == id) {
                String parameter = InputUtil.inputRequiredString("enter the update use parameters");
                String[] parameters = parameter.toLowerCase().split(",");
                for (String str : parameters) {
                    switch (str) {
                        case "name":
                            GlobalData.users[i].setName(InputUtil.inputRequiredString("enter the update user name"));
                            isTrue = true;
                            break;
                        case "surname":
                            GlobalData.users[i].setSurname(InputUtil.inputRequiredString("enter the update user surname"));
                            isTrue = true;
                            break;
                        default:
                            throw new WrongFormatException(ExceptionsEnum.WRONG_FORMAT);
                    }

                }
                if (isTrue) {
                    GlobalData.users[i].setUpdateDate(nowDate());
                    System.out.println(StatusEnum.UPDATED_SUCCESFULLY);
                }

            else {
                throw new UsernameNotFoundException(ExceptionsEnum.USERNAME_NOT_FOUND);
            }}
        }
        return true;

    }

    @Override
    public boolean delete() {
        if (GlobalData.users == null || GlobalData.users.length == 0)
            throw new EmptyListException(ExceptionsEnum.EMPTY_LIST_EXCEPTION);

        long id = InputUtil.inputRequiredLong("Enter the deleted user id");

        for (int i = 0; i < GlobalData.users.length; i++) {
            if (GlobalData.users[i].getId() == id) {
                User[] users = GlobalData.users;
                GlobalData.users = new User[GlobalData.users.length - 1];
                int k = 0;
                for (User user : users) {
                    if (user.getId() == id) {
                        continue;
                    }
                    GlobalData.users[k] = user;
                    k++;
                }
                System.out.println(StatusEnum.DELETED_SUCCESSFULLY);
                return true;
            }
        }

        throw new UsernameNotFoundException(ExceptionsEnum.USERNAME_NOT_FOUND);
    }}












   


