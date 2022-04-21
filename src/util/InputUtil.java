/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class InputUtil {

    public static String requireText(String title) {
        Scanner sc = new Scanner(System.in);
        System.out.println(title);
        String answer = sc.nextLine();
        return answer;
    }

    public static int requireNumber(String title) {
        System.out.println(title);
        Scanner sc = new Scanner(System.in);
        int answer = sc.nextInt();
        return answer;
    }
}
