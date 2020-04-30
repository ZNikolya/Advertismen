package Advertismen.commands;

import Advertismen.exception.ModelNotFoundException;
import Advertismen.model.AD;
import Advertismen.model.User;
import advertismentApp.exception.ModelNotFoundException;
import advertismentApp.model.AD;
import advertismentApp.model.User;

import java.util.Date;

public interface DataStorage {

    void printMyAllADS ();
    void printAllADS ();
    void printADByCategory (String category) throws ModelNotFoundException, ModelNotFoundException;
    void printAllADSByTitleSort (String title);
    void printAllADSByDataSort (Date date);
    AD deleteMyAllADS ();
    AD deleteADByTitle (String title);
    User getUserByPhoneNumber(String phoneNumber);
    User getUserByPhoneNumberAndPassword(String phoneNumber,String password) throws ModelNotFoundException;



}
