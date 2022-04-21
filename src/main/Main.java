/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import util.InputUtil;
import util.MenuUtil;

/**
 *
 * @author admin
 */
public class Main {

    public static void main(String[] args) {
        int menu = 0;
        while (true) {
            menu = InputUtil.requireNumber("What do you want to do?"
                    + "\n1. Register Student"
                    + "\n2. Show all students"
                    + "\n3. Find student"
                    + "\n4. Update Student"
                    + "\n5. Exit");
            MenuUtil.processMenu(menu);
        }
    }
}
