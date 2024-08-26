/*
 * @ (#) $NAME.java       1.0    26/08/2024
 *
 * CopyRight (c) 2024 iuh.edu.vn
 */
package edu.iuh.fit;

/*
 * @description : DHKTPM19ATT
 * @author : Van Trong
 * @date 26/08/2024
 * @version 1.0
 */

import java.util.Scanner;

public class TestCourseList{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Course course1 = new Course("FIT101", "Java Programming", 3, "FIT");
        Course course2 = new Course("FIT102", "Web Programming", 3, "FIT");
        Course course3 = new Course("FIT103", "Database Programming", 3, "FIT");
        Course course4 = new Course("FIT104", "Mobile Programming", 3, "FIT");
        Course course5 = new Course("FIT105", "Software Engineering", 4, "FIT");
        CourseList courseList = new CourseList(10);
        courseList.addCourse(course1);
        courseList.addCourse(course2);
        courseList.addCourse(course3);
        courseList.addCourse(course4);
        courseList.addCourse(course5);
        int choice;
        do {
            System.out.println("1.Them khoa hoc");
            System.out.println("2.Xoa khoa hoc");
            System.out.println("3.Tim kiem khoa hoc bang ID");
            System.out.println("4.Tim kiem khoa hoc bang ten");
            System.out.println("5.Tim kim khoa hoc theo khoa");
            System.out.println("6.Sap xep khoa hoc theo ten");
            System.out.println("7.Tim khoa hoc co so tin chi max");
            System.out.println("8.Khoa phu trach co nhieu khoa hoc nhat");
            System.out.println("9.Xuat ra khoa hoc");
            System.out.println("0.Exit\n");
            choice = sc.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Thoat chuong trinh.");
                    break;
                case 1 :
                    System.out.println("Nhap so luong khoa hoc: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.println("Nhap thong tin khoa hoc thu " + (i + 1));
                        System.out.println("Nhap ID: ");
                        String id = sc.nextLine();
                        System.out.println("Nhap Title: ");
                        String title = sc.nextLine();
                        System.out.println("Nhap Credit: ");
                        int credit = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Nhap Department: ");
                        String department = sc.nextLine();
                        Course course = new Course(id, title, credit, department);
                        if (courseList.addCourse(course)) {
                            System.out.println("Them thanh cong");
                        } else {
                            System.out.println("Them that bai");
                        }
                    }

                    break;

                case 2:
                    sc.nextLine();
                    System.out.println("Nhap ID khoa hoc can xoa: ");
                    String id = sc.nextLine();
                    Course course = new Course();
                    course.setId(id);
                    if (courseList.removeCourse(course)) {
                        System.out.println("Xoa thanh cong");
                    } else {
                        System.out.println("Xoa that bai");
                    }
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Nhap ID khoa hoc can tim: ");
                    String id1 = sc.nextLine();
                    if (courseList.FindCourse(id1)) {
                        System.out.println("Tim thay");
                    } else {
                        System.out.println("Khong tim thay");
                    }
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("Nhap ten khoa hoc can tim: ");
                    String title = sc.nextLine();
                    if (courseList.NameCourse(title)) {
                        System.out.println("Tim thay");
                    } else {
                        System.out.println("Khong tim thay");
                    }
                    break;
                case 5:
                    sc.nextLine();
                    System.out.println("Nhap khoa can tim: ");
                    String department = sc.nextLine();
                    if (courseList.DepartmentCourse(department)) {
                        for (Course c : courseList.getCourses()) {
                            if (c != null) {
                                System.out.println(c);
                            }
                        }
                        System.out.println("Tim thay");
                    } else {
                        System.out.println("Khong tim thay");
                    }
                    break;
                case 6:
                    System.out.println("Danh sac khoa hoc sau khi sap xep theo ten");
                    courseList.sortCoursesByTitle();
                    System.out.println("Course List");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println(String.format("%-10s%-30s%2s %-10s", "ID", "Title", "Credit", "Department"));
                    System.out.println("-------------------------------------------------------------");
                    for (Course c : courseList.getCourses()) {
                        if (c != null) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 7:
                    System.out.println("Danh sach khoa hoc cos so tin chi max");
                    courseList.FindCreditMax();
                    break;
                case 8:

                    break;
                case 9:
                    System.out.println("Course List");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println(String.format("%-10s%-30s%2s %-10s", "ID", "Title", "Credit", "Department"));
                    System.out.println("-------------------------------------------------------------");
                    for (Course c : courseList.getCourses()) {
                        if (c != null) {
                            System.out.println(c);
                        }
                    }
                    break;
                default:
                    throw new AssertionError("Nhap sai");
            }
        } while (choice != 0);

    }
}
