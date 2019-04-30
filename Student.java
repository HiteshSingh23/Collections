package collectioal;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Student {

    private int rollno;
    private String Studentname;
    private int age;

    public Student() {
    }

    public Student(int rollno, String studentname, int age) {
        this.rollno = rollno;
        Studentname = studentname;
        this.age = age;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getStudentname() {
        return Studentname;
    }

    public void setStudentname(String studentname) {
        Studentname = studentname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public void writeToFile(String filewrcontents, String filepath1) {
        try {
            FileWriter fw = new FileWriter(filepath1);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(filewrcontents);
            bw.close();
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}