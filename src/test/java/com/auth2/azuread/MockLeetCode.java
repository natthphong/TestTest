package com.auth2.azuread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.json.GsonTester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class MockLeetCode {

    public int[] kWeakestRows(int[][] mat, int k) {
        var temp = new int[mat.length][2];
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int j = 0; j < mat[i].length; j++) {
                sum += mat[i][j];
            }
            temp[i][0] = sum;
            temp[i][1] = i;
        }
        Arrays.sort(temp, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        var indexK = new int[k];
        for (int i = 0; i < k; ++i) {
            indexK[i] = temp[i][1];
        }
        return indexK;
    }

    @Test
    public void leetCode_1337() {
        var mat = new int[][]{{1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}};
        log.info("{}", kWeakestRows(mat, 3));
    }

    public boolean isSubsequence(String s, String t) {
        int h = s.length();
        if (h == 0) return true;
        int hh = 0;
        int i = 0;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        while (i < tt.length) {
            if (ss[hh] == tt[i]) {
                hh++;
            }
            if (hh==h) return true;
            i++;
        }
        return false;
    }

    @Test
    public void leetCode_392() {
        String s = "ahc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    public List<List<Integer>> permute(int[] nums) {
        int [] status = new int[nums.length];
        for (int i = 0;i<nums.length;i++){
            int [] temp  = new int[nums.length];
            int indexTemp =  1;
            for (int j = 0 ; j<temp.length;i++){
                if (nums[i]!=nums[j]){
                    temp[indexTemp++] = nums[j];
                }

            }
        }



        return new ArrayList<>();
    }

    @Test
    public void  leetCode_46(){
        log.info(" {}" , permute(new int[]{1,2,3}));
    }


    @Test
    public void test() {
        var x = 10;
        var y = x;
        x = 5;

        System.out.println(x);
        System.out.println(y);
    }

    @Test
    public void printO() {

        String[][] matrix = new String[][]{
                {"O", "O", "O", "O", "O", " ", " ", " ", " ", "O", " ", " ", " ", " ", " ", " ", "O", " ", " ", " ", " ", " ", "O", " ", " ", " ", " ", " ", " ", "O", "O", "O", " ", " ", " "},
                {"O", " ", " ", " ", "O", " ", " ", " ", " ", "O", "O", "O", "O", " ", " ", " ", "O", " ", " ", " ", " ", "O", " ", "O", " ", " ", " ", " ", " ", "O", " ", " ", "O", " ", " "},
                {"O", " ", " ", " ", "O", " ", " ", " ", " ", "O", " ", " ", "O", " ", " ", " ", "O", " ", " ", " ", "O", " ", " ", " ", "O", " ", " ", " ", " ", "O", " ", " ", "O", "", " "},
                {"O", "O", "O", "O", "O", " ", " ", " ", " ", "O", " ", " ", " ", " ", " ", " ", "O", " ", " ", "O", " ", " ", " ", " ", " ", "O", " ", " ", " ", "O", "O", "O", " ", " ", " "},
                {"O", " ", " ", " ", " ", " ", " ", " ", " ", "O", " ", " ", " ", " ", " ", " ", "O", " ", " ", " ", "O", " ", " ", " ", "O", " ", " ", " ", " ", "O", " ", "O", " ", " ", " "},
                {"O", " ", " ", " ", " ", " ", " ", " ", " ", "O", " ", " ", " ", " ", " ", " ", "O", " ", " ", " ", " ", "O", " ", "O", " ", " ", " ", " ", " ", "O", " ", " ", "O", " ", " "},
                {"O", " ", " ", " ", " ", " ", " ", " ", " ", "O", " ", " ", " ", " ", " ", " ", "O", " ", " ", " ", " ", " ", "O", " ", " ", " ", " ", " ", " ", "O", " ", " ", " ", "O", " "}
        };


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }


    }


    @Test
    public void testfdsfs() {
        String input = "C0053012340003300000";
        input = input.replaceAll("0+$", "");

        System.out.println(input);
        String str = "manGirlMan";
        String str2  =  str.replaceAll("(.)(\\p{Upper})", "$1_$2").toLowerCase();
        System.out.println(str2);

    }

    @Test
    public void capacity() {
        String[] models = {"iPhone15plus", "iPhone15pro", "iPhone15promax"};
        int[] b = {6820, 7240, 7030};
        double[] per = {0.008, 0.4, 18};
        for (int i = 0; i < models.length; i++) {
            double battery = b[i];
            double perRate = per[i];
            double round = 0;
//            System.out.println(perRate);
//            System.out.println(b[i] *( perRate/100));
//            while (battery > b[i] *( perRate/100)) {
//                battery -= (double)b[i] *( perRate/100);
//                round++;
//            }
//            System.out.println( b[i] *( perRate/100));
//            round+= ( battery / (b[i] *( perRate/100)));

            round = (battery / (b[i] * (perRate / 100)));
            if (models[i].equalsIgnoreCase("iPhone15plus")) {
                System.out.println(models[i] + " ใช้งานได้ " + round + " วินาที");
            } else if (models[i].equalsIgnoreCase("iPhone15pro")) {
                System.out.println(models[i] + " ใช้งานได้ " + round + " นาที");

            } else {
                System.out.println(models[i] + " ใช้งานได้ " + round + " ชั่วโมง");

            }
        }


    }
}
