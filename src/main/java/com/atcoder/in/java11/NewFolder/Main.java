package com.atcoder.in.java11.NewFolder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//       Scanner scan = new Scanner(System.in);
       Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/NewFolder/input1.txt"));

       Main main = new Main();
       int N = toInt(scan.nextLine());
       folders keys = main.getFolders();
       folders folders = main.getFolders();

       for (int i = 0; i < N; i++) {
           String tmpkey = scan.nextLine();
           if (!keys.has(tmpkey)) {
               keys.folderList.add(main.getFolder(tmpkey, 0));
               folders.folderList.add(main.getFolder(tmpkey, 0));
               continue;
           }

           folder key = keys.getFolder(tmpkey);
           key.n = key.n + 1;
           folder folder = main.getFolder(tmpkey, key.n);
           folders.folderList.add(folder);
       }

       for (folder folder : folders.folderList) {
           System.out.println(folder.print());
       }
    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

    public folders getFolders() {
        return new folders();
    }
    public folder getFolder(final String name, int i) {
        return new folder(name, i);
    }

    public class folders {
        public List<folder> folderList;
        public folders() {
            this.folderList = new ArrayList<>();
        }

        public folder getFolder(String name) {
            for (folder folder: folderList) {
                if (folder.name.equals(name)) {
                    return folder;
                }
            }
            return null;
        }

        public boolean has(String name) {
            for (folder folder: folderList) {
                if (folder.name.equals(name)) {
                    return true;
                }
            }
            return false;
        }


    }

    public class folder {
        public String name;
        public int n;
        public folder(String name, int n) {
            this.name = name;
            this.n = n;
        }

        public String print() {
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            if (n != 0) {
                sb.append("("+ n +")");
            }
            return sb.toString();
        }
    }
}