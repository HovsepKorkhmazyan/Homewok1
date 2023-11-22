package OnlineStore.storages;

import OnlineStore.model.Order;
import OnlineStore.model.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserStorage implements Serializable {
    private Map<String, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getEmail(), user);
    }

    public User getUser(String email) {
        return users.get(email);
    }

    public void printUsers() {
        for (User user : users.values()) {
            System.out.println(user);
        }
    }

    public void saveOrdersToFile(String filename) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(users);
        }
    }

    public void loadOrdersFromFile(String filename) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            users = (Map<String, User>) in.readObject();
        }
    }
}