package Advertismen;

import Advertismen.commands.Command;
import Advertismen.exception.ModelNotFoundException;
import Advertismen.model.AD;
import Advertismen.model.Gender;
import Advertismen.model.User;
import Advertismen.storage.DataStorageImpl;
import java.util.Date;
import java.util.Scanner;

public class RunAd implements Command {

    private static final DataStorageImpl dataStorageImpl = new DataStorageImpl();
    private static final Scanner scanner = new Scanner(System.in);
    private static User users;

    public static void main(String[] args) {
        main();
    }

    private static void main() {
        boolean isRun = true;
        while (isRun) {
            Command.printMainCommands();
            int mainCommand;
            try {
                mainCommand = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                mainCommand = -1;
            }
            switch (mainCommand) {
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    register();
                    break;
                case EXIT:
                    isRun = false;
                    break;
            }
        }
    }

    private static void register() {
        try {
            System.out.println("Please input User data: name,surname,gender,age,phoneNumber,password");
            String userData = scanner.nextLine();
            String[] userDataStr = userData.split(",");
            User userByPhoneNumber = dataStorageImpl.getUserByPhoneNumber(userDataStr[4]);
            if (userByPhoneNumber != null) {
                System.out.println("Dublicate Data!!!");
            } else {
                User user = new User();
                user.setName(userDataStr[0]);
                user.setSurName(userDataStr[1]);
                user.setGender(Gender.valueOf(userDataStr[2].toUpperCase()));
                user.setAge(Integer.parseInt(userDataStr[3]));
                user.setPhoneNumber(userDataStr[4]);
                user.setPassword(userDataStr[5]);
                dataStorageImpl.addUsers(user);
                dataStorageImpl.addMap(userDataStr[4], user);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid Data! please try again");
            register();
        }
    }

    private static void login() {
        System.out.println("Please input PhoneNumber and password(phoneNumber.password)");
        String userData = scanner.nextLine();
        String [] userDataStr = userData.split(",");
        try {
            users = dataStorageImpl.getUserByPhoneNumberAndPassword(userDataStr[0],userDataStr[1]);
            loginUser();
        }catch (ModelNotFoundException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            login();
        }
    }

    private static void loginUser() {
        boolean isRun = true;
        while (isRun) {
            Command.printUserCommands();
            int userCommand;
            try {
                userCommand = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                userCommand = -1;
            }
            switch (userCommand) {
                case ADD_NEW_AD:
                    addNewAd();
                    break;
                case PRINT_MY_ALL_ADS:
                    break;
                case PRINT_ALL_ADS:
                    dataStorageImpl.printAllADS();
                    break;
                case PRINT_AD_BY_CATEGORY:
                    adByCategory();
                    break;
                case PRINT_ALL_AD_BY_TITLE_SORT:

                    break;
                case PRINT_ALL_AD_BY_DATE_SORT:
                    break;
                case DELETE_MY_ALL_ADS:
                    break;
                case DELETE_AD_BY_TITLE:
                    break;
                case LOGOUT:
                    isRun =false;
                    main();
                    break;

            }
        }
    }

    private static void adByCategory() {
        System.out.println("Please input Advertisment category");
        try {
            String category = scanner.nextLine();
            dataStorageImpl.printADByCategory(category);
        }catch (ModelNotFoundException e) {
            System.out.println("Advertisment not found");
        }
    }

    private static void addNewAd() {
        try {
        System.out.println("Please input Advertisment data: title,text,price,category");
        String adData = scanner.nextLine();
        String [] adDataStr = adData.split(",");
        AD ad = new AD();
        Date date = new Date();
        ad.setTitle(adDataStr[0]);
        ad.setText(adDataStr[1]);
        ad.setPrice(Integer.parseInt(adDataStr[2]));
        ad.setCreatedData(date);
        ad.setCategory(adDataStr[3]);
        ad.setUser(users);
        dataStorageImpl.addAds(ad);
        System.out.println("Thank you, Advertisment was added");
    }catch (ArrayIndexOutOfBoundsException  e) {
            System.out.println("Invalid Data! please try again");
            addNewAd();
        }
    }
}
