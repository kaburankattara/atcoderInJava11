package com.atcoder.in.java11.Continuous1.CheckCaseTest.testcase;

import com.atcoder.in.java11.Continuous1.Main;
import com.atcoder.in.java11.utils.StandardInputSnatcher;
import com.atcoder.in.java11.utils.StandardOutputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    private StandardInputSnatcher in = new StandardInputSnatcher();
    private StandardOutputStream out = new StandardOutputStream();

    @BeforeEach
    public void before() {
        System.setIn(in);
        System.setOut(out);
    }

    @AfterEach
    public void after() {
        System.setIn(null);
        System.setOut(null);
    }

    @Test
    void クエスチョンが複数ある場合() throws FileNotFoundException {
        in.inputln("1");
        in.inputln("3 2");
        in.inputln("1??");

        Main.main(null);
        assertEquals("Yes", out.readLine());
    }

    @Test
    void 一通りだけあるパターン() throws FileNotFoundException {
        in.inputln("1");
        in.inputln("3 2");
        in.inputln("1??");

        Main.main(null);
        assertEquals("Yes", out.readLine());
    }

    @Test
    void 全て0をセットするパターン() throws FileNotFoundException {
        in.inputln("1");
        in.inputln("3 1");
        in.inputln("1??");

        Main.main(null);
        assertEquals("Yes", out.readLine());
    }

    @Test
    void 全て1をセットするパターン() throws FileNotFoundException {
        in.inputln("1");
        in.inputln("3 3");
        in.inputln("1??");

        Main.main(null);
        assertEquals("Yes", out.readLine());
    }

    @Test
    void 複数通りあるパターン() throws FileNotFoundException {
        in.inputln("1");
        in.inputln("3 1");
        in.inputln("0??");

        Main.main(null);
        assertEquals("No", out.readLine());
    }

    @Test
    void ゼロ通りのパターン() throws FileNotFoundException {
        in.inputln("1");
        in.inputln("6 6");
        in.inputln("011?1?");

        Main.main(null);
        assertEquals("No", out.readLine());
    }

    @Test
    void Nが1の場合() throws FileNotFoundException {
        in.inputln("1");
        in.inputln("1 1");
        in.inputln("?");

        Main.main(null);
        assertEquals("Yes", out.readLine());
    }

    @Test
    void Nが2の場合() throws FileNotFoundException {
        in.inputln("1");
        in.inputln("2 1");
        in.inputln("??");

        Main.main(null);
        assertEquals("No", out.readLine());
    }

    @Test
    void Nが2で1通りの場合() throws FileNotFoundException {
        in.inputln("1");
        in.inputln("2 1");
        in.inputln("0?");

        Main.main(null);
        assertEquals("Yes", out.readLine());
    }

    @Test
    void Nが2で1通りの場合2() throws FileNotFoundException {
        in.inputln("1");
        in.inputln("2 1");
        in.inputln("1?");

        Main.main(null);
        assertEquals("Yes", out.readLine());
    }

    @Test
    void クエスチョンがない場合() throws FileNotFoundException {
        in.inputln("1");
        in.inputln("2 1");
        in.inputln("10");

        Main.main(null);
        assertEquals("Yes", out.readLine());
    }

    @Test
    void 一が連続しない場合() throws FileNotFoundException {
        in.inputln("1");
        in.inputln("3 2");
        in.inputln("101");

        Main.main(null);
        assertEquals("No", out.readLine());
    }

    @Test
    void Nが5でクエスチョンが複数続く場合() throws FileNotFoundException {
        in.inputln("1");
        in.inputln("5 2");
        in.inputln("??0??");

        Main.main(null);
        assertEquals("No", out.readLine());
    }

    @Test
    void 一がK以上である場合() throws FileNotFoundException {
        in.inputln("1");
        in.inputln("7 2");
        in.inputln("??111??");

        Main.main(null);
        assertEquals("No", out.readLine());
    }

    @Test
    void 既にある1を使ってKを実現する場合() throws FileNotFoundException {
        in.inputln("1");
        in.inputln("7 5");
        in.inputln("0??1??0");

        Main.main(null);
        assertEquals("Yes", out.readLine());
    }

    @Test
    void 既にある1を使ってKを実現するが複数ある場合() throws FileNotFoundException {
        in.inputln("1");
        in.inputln("7 4");
        in.inputln("0??1??0");

        Main.main(null);
        assertEquals("No", out.readLine());
    }

    @Test
    void 既にある1を使ってKを実現するが複数ある場合でクエスチョンが最初() throws FileNotFoundException {
        in.inputln("1");
        in.inputln("5 4");
        in.inputln("?1??0");

        Main.main(null);
        assertEquals("Yes", out.readLine());
    }

    @Test
    void 既にある1を使ってKを実現するが複数ある場合でクエスチョンが最後() throws FileNotFoundException {
        in.inputln("1");
        in.inputln("5 4");
        in.inputln("0??1?");

        Main.main(null);
        assertEquals("Yes", out.readLine());
    }

    @Test
    void 全てがクエスチョン() throws FileNotFoundException {
        in.inputln("1");
        in.inputln("4 4");
        in.inputln("????");

        Main.main(null);
        assertEquals("Yes", out.readLine());
    }

    @Test
    void 全てがクエスチョンで複数パターンある() throws FileNotFoundException {
        in.inputln("1");
        in.inputln("4 3");
        in.inputln("????");

        Main.main(null);
        assertEquals("No", out.readLine());
    }

}