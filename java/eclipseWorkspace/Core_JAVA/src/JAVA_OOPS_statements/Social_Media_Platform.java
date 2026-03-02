package JAVA_OOPS_statements;

import java.util.*;
import java.io.*;

// CUSTOM EXCEPTIONS
// Runtime Exception: Used for logic errors (Unchecked)
class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) { super(message); }
}

// Compile-time Exception: Used for restricted actions (Checked)
class IllegalInteractionException extends Exception {
    public IllegalInteractionException(String message) { super(message); }
}

// ---------------------------------------------------------


// ABSTRACTION: We define a contract for what a User should do
interface SocialActions {
    void post(String content);
    void follow(User target) throws IllegalInteractionException;
}

// ENCAPSULATION: Data is hidden, access is controlled
class User implements Comparable<User>, SocialActions {
    private final Integer id; 
    private final String name;
    private final Set<User> followers; 
    private final Set<User> following;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.followers = new TreeSet<>();
        this.following = new TreeSet<>();
    }

    // Getters (Accessing private data safely)
    public String getName() { return name; }
    public Integer getId() { return id; }

    @Override
    public void post(String content) {
        System.out.println(this.name + " posted: \"" + content + "\"");
        notifyFollowers(content);
    }

    @Override
    public void follow(User target) throws IllegalInteractionException {
        if (this.id.equals(target.getId())) {
            // Throwing a Checked Exception (Compile-time requirement)
            throw new IllegalInteractionException("User cannot follow themselves.");
        }
        target.addFollower(this);
        this.following.add(target);
    }

    public void unfollow(User target) {
        target.removeFollower(this);
        this.following.remove(target);
    }

    // Internal notification logic
    public void update(String message, User followee) {
        System.out.println(this.name + " received notification: " + followee.getName() + " posted: \"" + message + "\"");
    }

    protected void addFollower(User user) { this.followers.add(user); }
    protected void removeFollower(User user) { this.followers.remove(user); }

    private void notifyFollowers(String message) {
        for (User follower : followers) {
            follower.update(message, this);
        }
    }

    @Override
    public int compareTo(User other) {
        return this.id.compareTo(other.id);
    }
}

// INHERITANCE: If we had a 'PremiumUser', it would extend User
class Platform {
    private final Map<Integer, User> userMap = new HashMap<>();

    public void addUser(Integer id, String name) {
        userMap.putIfAbsent(id, new User(id, name));
        System.out.println(name + " added successfully.");
    }

    public void follow(Integer followerId, Integer followeeId) {
        User follower = userMap.get(followerId);
        User followee = userMap.get(followeeId);

        if (follower == null || followee == null) {
            // Throwing Runtime Exception (Unchecked)
            throw new UserNotFoundException("ID not found in system.");
        }

        try {
            follower.follow(followee);
            System.out.println(follower.getName() + " is now following " + followee.getName() + ".");
        } catch (IllegalInteractionException e) {
            System.out.println("Follow failed: " + e.getMessage());
        }
    }

    public void post(Integer userId, String content) {
        User user = userMap.get(userId);
        if (user != null) user.post(content);
    }
}