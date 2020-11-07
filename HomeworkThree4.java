package vanilla.demo;


public class HomeworkThree4 {
    public static void main(String[] args) throws CloneNotSupportedException {
        newCourse course1 = new newCourse("C!");
        course1.addStudent("Student1");
        course1.addStudent("Student2");
        newCourse course2 = (newCourse) course1.clone() ;
        //检测是否为深复制
        System.out.println(course1==course2);
        System.out.println(course1.getStudents()== course2.getStudents());
        System.out.println("Students in course1:");
        for (int i=0; i< course1.getNumberOfStudents(); i++){
            System.out.println(course1.getStudents()[i]);
        }
        System.out.println("Students in course2:");
        for (int i=0; i< course2.getNumberOfStudents(); i++){
            System.out.println(course2.getStudents()[i]);
        }
    }
}
class newCourse implements Cloneable{
    private String courseName;
    private String[] students = new String[100];
    private int numberOfStudents;

    public newCourse(String courseName){
        this.courseName =courseName;
    }

    public void addStudent(String student){
        students[numberOfStudents] =student;
        numberOfStudents++;
    }

    public String[] getStudents(){
        return students;
    }

    public int getNumberOfStudents(){
        return numberOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }
    @Override /** Override the protected clone method defined in the Object class, and strengthen its accessibility */
    public Object clone() throws CloneNotSupportedException {
        // Perform a shallow copy
        newCourse courseClone = (newCourse) super.clone();
        // Deep copy on students
        courseClone.students = (String[]) (students.clone());
        return courseClone;
    }


}