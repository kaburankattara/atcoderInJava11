package com.atcoder.in.java11.Restore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/Restore/input1.txt"));
        Main main = new Main();

        int userCount = toInt(scan.next());
        int actionCount = toInt(scan.next());
        Users users = main.getUsers(userCount);

        for (int i = 0; i < actionCount; i++) {
            users.execAction(scan);
        }

        System.out.println(users.printResult());
    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

    public Users getUsers(int userCount) {
        return new Users(userCount);
    }

    public class Users {
        public List<User> userList;

        public Users(int userCount) {
            userList = new ArrayList<>();
            userList.add(null);
            userCount++;
            for (int i = 1; i < userCount; i++) {
                userList.add(new User(i, userCount));
            }
        }

        public void execAction(Scanner scan) {
            char action = scan.next().charAt(0);

            if (action == '1') {
                User follower = userList.get(toInt(scan.next()));
                User target = userList.get(toInt(scan.next()));
                follow(follower, target);
                return;
            }

            if (action == '2') {
                User targetUser = userList.get(toInt(scan.next()));
                allFollowReturn(targetUser);
                return;
            }

            if (action == '3') {
                User targetUser = userList.get(toInt(scan.next()));
                followFollow(targetUser);
                return;
            }
        }

        public void follow(User follower, User target) {
            if (follower.isEquals(target)) {
                return;
            }
            if (follower.isFollow(target)) {
                return;
            }
            follower.follow(target);
            target.addFollower(follower);
        }

        public void allFollowReturn(User target) {
            List<User> addingUserList = new ArrayList<>();
            for (User follower : target.followerList) {
                if (follower == null) {
                    continue;
                }
                if (addingUserList.contains(follower)) {
                    continue;
                }

                follow(target, follower);
                addingUserList.add(follower);
            }
        }

        public void followFollow(User target) {
            List<User> addingUserList = new ArrayList<>();
            for (User followUser : target.followList) {
                if (followUser == null) {
                    continue;
                }

                for (User followFollow : followUser.followList) {
                    if (followFollow == null || followFollow.isEquals(target)) {
                        continue;
                    }
                    addingUserList.add(followFollow);
                }
            }

            for (User addingUser : addingUserList) {
                follow(target, addingUser);
            }
        }

        public String printResult() {
            boolean isFirst = true;
            StringBuilder sb = new StringBuilder();
            for (User user : userList) {
                if (isFirst) {
                    isFirst = false;
                    continue;
                }
                sb.append(System.lineSeparator() + user.printResult());
            }
            return sb.toString().substring(1);
        }
    }

    public class User {
        public int userNo;
        public List<User> followList;
        public List<User> followerList;

        public User(int userNo, int userCount) {
            this.userNo = userNo;
            followList = new ArrayList<>(userCount);
            followerList = new ArrayList<>();
            for (int i = 0; i < userCount; i++) {
                followList.add(null);
            }
        }

        public void follow(User user) {
            if (isFollow(user)) {
                return;
            }
            followList.set(user.userNo, user);
        }

        public boolean isFollow(User user) {
            return followList.contains(user);
        }

        public boolean isFollower(User user) {
            return followerList.contains(user);
        }

        public boolean isEquals(User user) {
            return userNo == user.userNo;
        }

        public void addFollower(User user) {
            if (isFollower(user))  {
                return;
            }
            followerList.add(user);
        }

        public String printResult() {
            boolean isFirst = true;
            StringBuilder sb = new StringBuilder();
            for (User follow : followList) {
                if (isFirst) {
                    isFirst = false;
                    continue;
                }

                sb.append(follow != null ? 'Y': 'N');
            }
            return sb.toString();
        }

    }
}