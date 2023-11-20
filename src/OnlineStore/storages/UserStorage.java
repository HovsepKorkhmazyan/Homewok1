package OnlineStore.storages;

import OnlineStore.model.Order;
import OnlineStore.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserStorage {
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
}
