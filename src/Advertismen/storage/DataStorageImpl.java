package Advertismen.storage;

import Advertismen.commands.DataStorage;
import Advertismen.exception.ModelNotFoundException;
import Advertismen.model.AD;
import Advertismen.model.User;

import java.util.*;

public class DataStorageImpl implements DataStorage {

    List<AD> ads;
    List<User> users;
    Map<String, User> userMap;

    public DataStorageImpl() {
        ads = new ArrayList<>();
        users = new ArrayList<>();
        userMap = new HashMap<>();
    }

    public void addAds(AD ad) {
        ads.add(ad);
    }

    public void addUsers(User user) {
        users.add(user);
    }

    public void addMap(String phoneNumber, User user) {
        userMap.put(phoneNumber, user);
    }

    @Override
    public void printMyAllADS() {

    }

    @Override
    public void printAllADS() {
        for (int i = 0; i < ads.size(); i++) {
            System.out.println(ads.get(i));
        }
    }

    @Override
    public void printADByCategory(String category) throws ModelNotFoundException {
        for (int i = 0; i < ads.size(); i++) {
            if (ads.get(i).getCategory().equals(category)) {
                System.out.println(ads.get(i));
            }
        }
    }

    @Override
    public void printAllADSByTitleSort(String title) {
        for (int i = 0; i < ads.size(); i++) {
            if (ads.get(i).getTitle().equals(title)) {
                System.out.println(ads.get(i).getTitle().compareTo(title));
            }
        }
    }

    @Override
    public void printAllADSByDataSort(Date date) {
        for (int i = 0; i < ads.size(); i++) {
            System.out.println(ads.get(i).getCreatedData().compareTo(date));
        }
    }

    @Override
    public AD deleteMyAllADS() {
        return null;
    }

    @Override
    public AD deleteADByTitle(String title) {
        return null;
    }

    @Override
    public User getUserByPhoneNumber(String phoneNumber) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getPhoneNumber().equals(phoneNumber)) {
                return users.get(i);
            }
        }
        return null;
    }

    @Override
    public User getUserByPhoneNumberAndPassword(String phoneNumber, String password) throws ModelNotFoundException {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getPhoneNumber().equals(phoneNumber) && users.get(i).getPassword().equals(password)) {
                return users.get(i);
            }
        }
        throw new ModelNotFoundException("Wrong PhoneNumber or password !!!");
    }
}
