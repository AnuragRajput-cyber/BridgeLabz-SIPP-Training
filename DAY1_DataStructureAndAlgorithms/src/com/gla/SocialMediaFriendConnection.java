package com.gla;
import java.util.*;

class UserNode {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friendIds;

    UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
    }
}

public class SocialMediaFriendConnection {
    private List<UserNode> users = new ArrayList<>();

    public void addUser(int userId, String name, int age) {
        users.add(new UserNode(userId, name, age));
    }

    private UserNode getUserById(int userId) {
        for (UserNode user : users) {
            if (user.userId == userId) return user;
        }
        return null;
    }

    public void addConnection(int userId1, int userId2) {
        UserNode user1 = getUserById(userId1);
        UserNode user2 = getUserById(userId2);
        if (user1 != null && user2 != null) {
            if (!user1.friendIds.contains(userId2)) user1.friendIds.add(userId2);
            if (!user2.friendIds.contains(userId1)) user2.friendIds.add(userId1);
            System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    public void removeConnection(int userId1, int userId2) {
        UserNode user1 = getUserById(userId1);
        UserNode user2 = getUserById(userId2);
        if (user1 != null && user2 != null) {
            user1.friendIds.remove((Integer) userId2);
            user2.friendIds.remove((Integer) userId1);
            System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    public void findMutualFriends(int userId1, int userId2) {
        UserNode user1 = getUserById(userId1);
        UserNode user2 = getUserById(userId2);
        if (user1 != null && user2 != null) {
            Set<Integer> mutual = new HashSet<>(user1.friendIds);
            mutual.retainAll(user2.friendIds);
            if (mutual.isEmpty()) {
                System.out.println("No mutual friends.");
            } else {
                System.out.println("Mutual friends:");
                for (Integer id : mutual) {
                    UserNode u = getUserById(id);
                    if (u != null) {
                        System.out.println("ID: " + u.userId + ", Name: " + u.name);
                    }
                }
            }
        } else {
            System.out.println("One or both users not found.");
        }
    }

    public void displayAllFriends(int userId) {
        UserNode user = getUserById(userId);
        if (user != null) {
            if (user.friendIds.isEmpty()) {
                System.out.println(user.name + " has no friends.");
            } else {
                System.out.println(user.name + "'s friends:");
                for (Integer id : user.friendIds) {
                    UserNode f = getUserById(id);
                    if (f != null) {
                        System.out.println("ID: " + f.userId + ", Name: " + f.name);
                    }
                }
            }
        } else {
            System.out.println("User not found.");
        }
    }

    public void searchUserByName(String name) {
        boolean found = false;
        for (UserNode user : users) {
            if (user.name.equalsIgnoreCase(name)) {
                System.out.println("User found: ID " + user.userId + ", Age " + user.age);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No user with name " + name);
        }
    }

    public void searchUserById(int userId) {
        UserNode user = getUserById(userId);
        if (user != null) {
            System.out.println("User found: Name " + user.name + ", Age " + user.age);
        } else {
            System.out.println("User with ID " + userId + " not found.");
        }
    }

    public void countFriends(int userId) {
        UserNode user = getUserById(userId);
        if (user != null) {
            System.out.println(user.name + " has " + user.friendIds.size() + " friends.");
        } else {
            System.out.println("User not found.");
        }
    }

    public static void main(String[] args) {
        SocialMediaFriendConnection smfc = new SocialMediaFriendConnection();

        smfc.addUser(1, "Anurag", 25);
        smfc.addUser(2, "raghav", 30);
        smfc.addUser(3, "prashant", 28);
        smfc.addUser(4, "aditya", 22);

        smfc.addConnection(1, 2);
        smfc.addConnection(1, 3);
        smfc.addConnection(2, 3);
        smfc.addConnection(2, 4);

        smfc.displayAllFriends(2);
        smfc.findMutualFriends(1, 2);
        smfc.countFriends(1);

        smfc.removeConnection(1, 2);

        smfc.displayAllFriends(1);
        smfc.countFriends(1);

        smfc.searchUserByName("mukund");
        smfc.searchUserById(3);
    }
}
