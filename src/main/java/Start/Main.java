package Start;

import BLL.MenuItem;
import BLL.Order;
import BLL.User;
import DAL.FileSplit;
import DAL.Serializator;
import Presentation.Controller;
import Presentation.MainGUI;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args){
        MainGUI mainGUI = new MainGUI();
        ArrayList<User> users = new ArrayList<User>();
        Serializator serializator = new Serializator();
        serializator.deser(users);
        Controller controller = new Controller(mainGUI, users);

    }
}
