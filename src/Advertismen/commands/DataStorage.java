package Advertismen.commands;

import Advertismen.exception.ModelNotFoundException;
import Advertismen.model.AD;
import Advertismen.model.User;

import java.util.Date;

public interface DataStorage {

    void printMyAllADS (User user);
    void printAllADS ();
    void printADByCategory (String category) throws ModelNotFoundException, ModelNotFoundException;
    void printAllADSByTitleSort () throws ModelNotFoundException;
    void printAllADSByDataSort ();
    void deleteMyAllADS (User user);
    void deleteADByTitle (String title,User user);
    User getUserByPhoneNumber(String phoneNumber);
    User getUserByPhoneNumberAndPassword(String phoneNumber,String password) throws ModelNotFoundException;



}
