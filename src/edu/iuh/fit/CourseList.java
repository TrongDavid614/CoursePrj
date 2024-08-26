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
public class CourseList{
    private Course[] courses;
    private static int count=0;
    public CourseList(int n){
        if(n<=0){
            throw new IllegalArgumentException("So luong khoa hoc phai lon hon 0");
        }
        courses = new Course[n];
    }
    public Course[] getCourses() {
        return courses;
    }
    // check course exists
    private boolean isExists(Course course)
    {
        for(int i=0;i<count;i++)
        {
            if(courses[i].getId().equalsIgnoreCase(course.getId()) && courses[i] != null)
            {
                return true;
            }
        }
        return false;
    }
    // add course to list
    public boolean addCourse(Course course){
        if(course == null){
            return false;
        }
        if(isExists(course)){
            return false;
        }
        if(count == courses.length){
            return false;
        }
        courses[count++] = course;
        return true;
    }
    // clear course to list
    public boolean removeCourse(Course course){
        if(course == null){
            return false;
        }
        for(int i=0;i<count;i++){
            if(courses[i].getId().equalsIgnoreCase(course.getId())){
                for(int j=i;j<count-1;j++){
                    courses[j] = courses[j+1];
                }
                count--;
                return true;
            }
        }
        return false;
    }
    public boolean FindCourse(String id){
        for(int i=0;i<count;i++){
            if(courses[i].getId().equalsIgnoreCase(id)){
                System.out.println("Course List");
                System.out.println("-------------------------------------------------------------");
                System.out.println(String.format("%-10s%-30s%2s %-10s", "ID", "Title", "Credit", "Department"));
                System.out.println("-------------------------------------------------------------");
                System.out.println(courses[i]);
                return true;
            }
        }
        return false;
    }
    public boolean NameCourse(String title){
        for(int i=0;i<count;i++){
            if(courses[i].getTitle().toLowerCase().contains(title.toLowerCase())){
                System.out.println("Course List");
                System.out.println("-------------------------------------------------------------");
                System.out.println(String.format("%-10s%-30s%2s %-10s", "ID", "Title", "Credit", "Department"));
                System.out.println("-------------------------------------------------------------");
                System.out.println(courses[i]);
                return true;
            }
        }
        return false;
    }
    public boolean DepartmentCourse(String department){
        for(int i=0;i<count;i++){
            if(courses[i].getDepartment().equalsIgnoreCase(department)){
                System.out.println("Course List");
                System.out.println("-------------------------------------------------------------");
                System.out.println(String.format("%-10s%-30s%2s %-10s", "ID", "Title", "Credit", "Department"));
                System.out.println("-------------------------------------------------------------");
                System.out.println(courses[i]);
                return true;
            }
        }
        return false;
    }
    public void sortCoursesByTitle(){
        for(int i=0;i<count-1;i++){
            for(int j=i+1;j<count;j++){
                if(courses[i].getTitle().compareTo(courses[j].getTitle())>0){
                    Course temp = courses[i];
                    courses[i] = courses[j];
                    courses[j] = temp;
                }
            }
        }
    }
    public void FindCreditMax(){
        int max = courses[0].getCredit();
        for(int i=1;i<count;i++){
            if(courses[i].getCredit()>max){
                max = courses[i].getCredit();
            }
        }
        System.out.println("Course List");
        System.out.println("-------------------------------------------------------------");
        System.out.println(String.format("%-10s%-30s%2s %-10s", "ID", "Title", "Credit", "Department"));
        System.out.println("-------------------------------------------------------------");
        for(int i=0;i<count;i++){
            if(courses[i].getCredit() == max){
                System.out.println(courses[i]);
            }
        }
    }

}
