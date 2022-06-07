package com.atcoder.in.java11.Restore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//       Scanner scan = new Scanner(System.in);
       Scanner scan = new Scanner(new File("src/com/atcoder/in/java11/Restore/input1.txt"));
        Main main = new Main();

       int userCount = toInt(scan.next());
       int actionCount = toInt(scan.next());
       Users users = main.getUsers(userCount);

       for (int i = 0; i < actionCount; i++) {
           users.execAction(scan);
       }

        users.printResult();
    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

    public Users getUsers(int userCount) {
        return new Users(userCount + 1);
    }

    public class Users {
        public List<User> userList;

        public Users(int userCount) {
            userList = new ArrayList<>();
            userList.add(null);

            for (int i = 1; i < userCount; i++) {
                userList.add(new User(i, userCount));
            }
        }

        public void execAction(Scanner scan) {
            char action = scan.next().charAt(0);

            if (action == '1') {
                int follower = toInt(scan.next());
                int target = toInt(scan.next());
                userList.get(follower).follow(userList.get(target));
                userList.get(target).followerList.add(userList.get(follower));
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

        public void allFollowReturn(User targetUser) {
            for (User follower : userList) {
                if (follower != null && follower.isFollow(targetUser)) {
                    targetUser.follow(follower);
                    follower.followerList.add(targetUser);
                }
            }
        }

        public void followFollow(User targetUser) {
            List<Integer> addingUserNoList = new ArrayList<>();
            for (User followUser : targetUser.followList) {
                if (followUser == null) {
                    continue;
                }
                if (addingUserNoList.contains(followUser.userNo)) {
                    continue;
                }

                List<User> followerFollowList = followUser.followList;
                for (User followerFollow : followerFollowList) {
                    if (followerFollow != null) {
                        targetUser.follow(followerFollow);
                        followerFollow.followerList.add(targetUser);
                        addingUserNoList.add(followerFollow.userNo);
                        // TODO 自分自身は？
                    }
                }
            }
        }

        public void printResult() {
            boolean isFirst = true;
            for (User user : userList) {
                if (isFirst) {
                    isFirst = false;
                    continue;
                }
                System.out.println(user.printResult());
            }
        }
    }

    public class User {
        public int userNo;
        public List<User> followList;
        public List<User> followerList;

        public User(int userNo, int userCount) {
            this.userNo = userNo;
            followList = new ArrayList<>(userCount);
            followerList = new ArrayList<>(userCount);
            for (int i = 0; i < userCount; i++) {
                followList.add(null);
            }
        }

        public void follow(User user) {
            followList.set(user.userNo, user);
        }

        public boolean isFollow(User user) {
            return followList.get(user.userNo) != null;
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