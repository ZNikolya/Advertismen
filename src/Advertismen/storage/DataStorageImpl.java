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
    public void printMyAllADS(User user) {
        for (int i = 0; i < ads.size(); i++) {
            if (ads.get(i).getUser().equals(user)) {
                System.out.println(ads.get(i));
            }
        }
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
    public void printAllADSByTitleSort() {
        ads.sort(this::compareTo);
        for (int i = 0; i < ads.size(); i++) {
            System.out.println(ads.get(i));
        }
    }

    @Override
    public void printAllADSByDataSort() {
        ads.sort(this::compare);
        for (int i = 0; i < ads.size(); i++) {
            System.out.println(ads.get(i));
        }
    }

    @Override
    public void deleteMyAllADS(User user) {
        ads.removeIf(ad -> ad.getUser().equals(user));
        System.out.println("Advertismen is delete!");
    }

    @Override
    public void deleteADByTitle(String title,User user) {
        if (ads.removeIf(ad -> ad.getTitle().equals(title) && ad.getUser().equals(user))){
        System.out.println("Advertismen delete by title!");
        }
        else System.out.println("You don have rights Advertismen!!");
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

    public int compare(AD o1, AD o2) {
        return o1.getCreatedData().compareTo(o2.getCreatedData());
    }

    public int compareTo(AD o1, AD o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }


}
