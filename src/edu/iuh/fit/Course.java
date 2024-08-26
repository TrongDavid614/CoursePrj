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
public class Course {
 private String id;
 private String title;
 private int credit;
 private String department;

 public Course() {
 }
 public Course(String id, String title, int credit, String department) {
  this.id = id;
  this.title = title;
  this.credit = credit;
  this.department = department;
 }

 public String getId() {
  return id;
 }
 public void setId(String id) {
  if (id == null || id.length() < 3 || !id.matches("[a-zA-Z0-9]+")) {
   throw new IllegalArgumentException("ID khoa hoc khong hop le");
  }
  this.id = id;
 }
 public String getTitle() {
  return title;
 }
 public void setTitle(String title) {
  if (title == null || title.isEmpty()) {
   throw new IllegalArgumentException("Ten khoa hoc khong duoc de trong");
  }
  this.title = title;
 }
 public int getCredit() {
  return credit;
 }
 public void setCredit(int credit) {
  if (credit <= 0) {
   throw new IllegalArgumentException("So tin chi phai lon hon 0");
  }
  this.credit = credit;
 }
 public String getDepartment() {
  return department;
 }
 public void setDepartment(String department) {
  this.department = department;
 }
 @Override
 public String toString() {
  return String.format("%-10s %-30s %-10d %-20s", id, title, credit, department);
 }
}

