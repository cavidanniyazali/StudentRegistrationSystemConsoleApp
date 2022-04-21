/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import beans.Student;
import main.Config;

/**
 *
 * @author admin
 */
public class StudentUtil {

    public static Student fillStudent() {
        String name = MenuUtil.requireName();
        String surname = MenuUtil.requireSurname();
        int age = MenuUtil.requireAge();
        String className = MenuUtil.requireClassName();

        Student st = new Student(name, surname, age, className);
        return st;
    }

    public static void printAllRegisteredStudents() {
        if (Config.students == null) {
            return;
        }
        for (int i = 0; i < Config.students.length; i++) {//NullPointerException
            Student st = Config.students[i];
            System.out.println((i + 1) + "." + st.getFullInfo());
        }
    }

    public static void registerStudents() {
        int count = InputUtil.requireNumber("Neche telebe qeydiyyatdan kechire bileceksiniz?");
        Config.students = new Student[count];

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ".Register");
            Config.students[i] = StudentUtil.fillStudent();
        }
        MenuUtil.showSuccessOpMessage();
        StudentUtil.printAllRegisteredStudents();
    }

    public static void findStudentsAndPrint() {
        String text = InputUtil.requireText("type name,surname or class name");
        Student[] result = findStudents(text);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i].getFullInfo());
        }
    }

    public static Student[] findStudents(String text) {
        int count = 0;
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)) {
                count++;
            }
        }
        Student[] result = new Student[count];
        int found = 0;
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)) {
                result[found++] = st;
            }
        }
        return result;
    }

    public static void updateStudentWithNewObject() {
        StudentUtil.printAllRegisteredStudents();

        int i = InputUtil.requireNumber("Nechenci adamda deyishiklik etmek isteyirsiniz?");

        System.out.println("Yeni melumatlari daxil edin:");
        Student s = StudentUtil.fillStudent();

        Config.students[i - 1] = s;
    }

    public static void updateStudentWithSameObject() {
        StudentUtil.printAllRegisteredStudents();

        int i = InputUtil.requireNumber("Nechenci adamda deyishiklik etmek isteyirsiniz?");

        System.out.println("Yeni melumatlari daxil edin:");

        Student selectedStudent = Config.students[i - 1];
        String changeParams = InputUtil.requireText("Neleri deyishmek isteyirsiniz? mes:name,surname");
        if (changeParams.contains("'name'")) {
            selectedStudent.setName(MenuUtil.requireName());
        }
        if (changeParams.contains("'surname'")) {
            selectedStudent.setSurname(MenuUtil.requireSurname());
        }
        if (changeParams.contains("'class name'")) {
            selectedStudent.setClassName(MenuUtil.requireClassName());
        }
        if (changeParams.contains("'age'")) {
            selectedStudent.setAge(MenuUtil.requireAge());
        }
    }

    public static void updateStudentWithSplit() {
        StudentUtil.printAllRegisteredStudents();

        int index = InputUtil.requireNumber("Nechenci adamda deyishiklik etmek isteyirsiniz?");

        System.out.println("Yeni melumatlari daxil edin:");

        Student selectedStudent = Config.students[index - 1];
        String changeParams = InputUtil.requireText("Neleri deyishmek isteyirsiniz? mes:name,surname");
        String[] parameters = changeParams.split(",");
        for (int i = 0; i < parameters.length; i++) {
            String params = parameters[i];
            if (params.equalsIgnoreCase("name")) {
                selectedStudent.setName(MenuUtil.requireName());
            } else if (params.equalsIgnoreCase("surname")) {
                selectedStudent.setSurname(MenuUtil.requireSurname());
            } else if (params.equalsIgnoreCase("class name")) {
                selectedStudent.setClassName(MenuUtil.requireClassName());
            } else if (params.equalsIgnoreCase("age")) {
                selectedStudent.setAge(MenuUtil.requireAge());
            }
        }
    }
}
