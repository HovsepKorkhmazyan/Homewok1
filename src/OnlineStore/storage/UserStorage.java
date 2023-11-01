package OnlineStore.storage;

import OnlineStore.model.User;

public class UserStorage {
    public static User[] users = new User[10];
    private static int size = 0;

    public void add(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        if (size == users.length) {
            extend();
        }
        users[size++] = user;
    }

    private void extend() {
        User[] newUsers = new User[users.length * 10];
        System.arraycopy(users, 0, newUsers, 0, users.length);
        users = newUsers;
    }

    public User getUserByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index Out Of Bounds");
        }
        return users[index];
    }
}
