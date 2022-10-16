package com.atcoder.in.java11.Continuous1.CheckCaseTest.utils;

import com.atcoder.in.java11.Continuous1.Main;
import com.atcoder.in.java11.utils.StandardInputSnatcher;

import java.util.Scanner;

public class CheckCaseFactory {
    private StandardInputSnatcher in = new StandardInputSnatcher();

    public Main.CheckCase クエスチョンが無い場合() {
        in = new StandardInputSnatcher();

//         in.inputln("1");
        in.inputln("3 3");
        in.inputln("111");

        return createCheckCase();
    }

    public Main.CheckCase クエスチョンが1つの場合() {
        in = new StandardInputSnatcher();

//        in.inputln("1");
        in.inputln("3 2");
        in.inputln("1?1");

        return createCheckCase();
    }

    public Main.CheckCase クエスチョンが2つある場合() {
        in = new StandardInputSnatcher();

//        in.inputln("1");
        in.inputln("3 3");
        in.inputln("1?1?1");

        return createCheckCase();
    }

    public Main.CheckCase クエスチョンが3つある場合() {
        in = new StandardInputSnatcher();

//        in.inputln("1");
        in.inputln("3 4");
        in.inputln("1?1?1?1");

        return createCheckCase();
    }

    public Main.CheckCase クエスチョンが最初にある場合() {
        in = new StandardInputSnatcher();

//        in.inputln("1");
        in.inputln("3 3");
        in.inputln("?111");

        return createCheckCase();
    }

    public Main.CheckCase クエスチョンが最後にある場合() {
        in = new StandardInputSnatcher();

//        in.inputln("1");
        in.inputln("3 3");
        in.inputln("111?");

        return createCheckCase();
    }

    public Main.CheckCase クエスチョンが続く場合() {
        in = new StandardInputSnatcher();

//        in.inputln("1");
        in.inputln("3 3");
        in.inputln("1???11");

        return createCheckCase();
    }

    public Main.CheckCase 全てクエスチョンの場合() {
        in = new StandardInputSnatcher();

//        in.inputln("1");
        in.inputln("3 3");
        in.inputln("???");

        return createCheckCase();
    }

    private Main.CheckCase createCheckCase() {
        Scanner scan = new Scanner(in);
        return new Main().createCheckCase(scan);
    }

}