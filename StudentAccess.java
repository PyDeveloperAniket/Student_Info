import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class student{
    String name;
    String branch;
    int rollno;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);
    void inputdata() throws IOException
    {
        System.out.println("\tEnter the Name of Student");
        name = br.readLine();
        System.out.println("\tEnter the rollno of the Student");
        rollno = Integer.parseInt(br.readLine());
        System.out.println("\tEnter the Branch of Student");
        branch = br.readLine();
    }
    void display()
    {
        System.out.println("====================================================================");
        System.out.println("\t\tStudent Data");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("\tThe name of the Student : " + name);
        System.out.println("\tThe Roll no of the Student : " + rollno);
        System.out.println("\tThe Branch of the Student : " + branch);
    }
}
class mark_distribution extends student{
    Scanner sc = new Scanner(System.in);
    int marks[]=new int[2];
    double attendance;
    int assignment[]=new int[2];
    int internal_marks=0;
    int sum_of_sessional_marks=0,sum_of_assignment_marks=0;
    int total_marks;
    void sessional() 
    {
        System.out.println("\tEnter the marks of the Sessional Examination out of 20");
        for(int i=0;i<2;i++){
            System.out.println("\tEnter marks of "+(i+1)+" Subject");
            sum_of_sessional_marks+=marks[i] = sc.nextInt();
        }
        total_marks += sum_of_sessional_marks;
    }
    void attendance()
    {
        System.out.println("\tEnter the attendance percentage of Student"); 
        attendance=sc.nextDouble();
    }
    void assignments()
    {
        System.out.println("\tEnter the Assignment marks of 2 subject out of 20");
        for (int i = 0; i < 2; i++) {
            System.out.println("\tEnter marks of "+(i+1)+" Subject");
            sum_of_assignment_marks+=assignment[i]=sc.nextInt();
        }
        total_marks += sum_of_assignment_marks;
    }
}
class internal_marks_calculation extends mark_distribution{
    void marks_calculation()
    {
        if (sum_of_assignment_marks > 40 && sum_of_sessional_marks > 40 && attendance > 95) {
            internal_marks = 20;
            total_marks += internal_marks;
        } else if (sum_of_assignment_marks > 35 && sum_of_sessional_marks > 35 && attendance > 90) {
            internal_marks = 18;
            total_marks += internal_marks;
        } else if (sum_of_assignment_marks > 30 && sum_of_sessional_marks > 30 && attendance > 80) {
            internal_marks = 15;
            total_marks += internal_marks;
        } else if (sum_of_assignment_marks > 20 && sum_of_sessional_marks > 20 && attendance > 70) {
            internal_marks = 13;
            total_marks += internal_marks;
        } else if (sum_of_assignment_marks < 15 && sum_of_sessional_marks < 15 && attendance < 60) {
            internal_marks = 10;
            total_marks += internal_marks;
        } else if (sum_of_assignment_marks < 10 && sum_of_sessional_marks < 10 && attendance < 45) {
            internal_marks = 0;
            total_marks += internal_marks;
        } 
    }
    void display_Class_data()
    {
        System.out.println("\tStudent Attendance Percentage are : "+attendance);
        System.out.println("\tStudent marks are : "+total_marks+"/100");
        System.out.println("====================================================================");
    }
}
class StudentAccess{
    public static void main(String[] args) throws IOException{
        student s1 = new student();
        s1.inputdata();
        mark_distribution m1= new mark_distribution();
        internal_marks_calculation e1 = new internal_marks_calculation();
        m1.sessional();
        m1.attendance();
        m1.assignments();
        s1.display();
        e1.display_Class_data();
    }
}