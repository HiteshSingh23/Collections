package collectioal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Alstudent {


    public static void main(String[] args) {

        String filepath = "C:\\Users\\hitesh\\Ideaprojects\\DataSets\\arrayliststudent.csv";
        String filepath2 = "C:\\Users\\hitesh\\Ideaprojects\\DataSets\\outputfileal.txt";
        ArrayList<String> linesread = new ArrayList<>();
        ArrayList<Student> records = new ArrayList<>();

        try {

            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String currentline = br.readLine();

            while (currentline != null) {
                linesread.add(currentline);
                currentline = br.readLine();
            }
            br.close();
            fr.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        int size = linesread.size();
        System.out.println("size of arraylist in which the lined from files are read: " + size);

        Student sobj;
        for (String s : linesread) {
            String[] words = s.split(",");
            sobj = new Student(Integer.parseInt(words[0]), words[1], Integer.parseInt(words[2]));
            records.add(sobj);
        }
        for (String i : linesread) {
            System.out.println(i);
        }
        size = records.size();
        System.out.println("size of arraylist in which student objtects are stored " + size);

        System.out.println();
        Scanner scan = new Scanner(System.in);

        System.out.println("to filter by name");
        String name = scan.next();
        for (Student st1 : records) {
            if (name.equals(st1.getStudentname())) {
                System.out.println(st1.getRollno() + " " + st1.getStudentname() + " " + st1.getAge());
            }
        }
        System.out.println();
        System.out.println("to filter by name character");
        char c = scan.next().charAt(0);
        for (Student st2 : records) {
            if (c == st2.getStudentname().charAt(0)) {
                System.out.println(st2.getRollno() + " " + st2.getStudentname() + " " + st2.getAge());
            }
        }
        System.out.println();
        System.out.println("to filter by age");
        int age = scan.nextInt();

        for (Student st3 : records) {
            if (age == st3.getAge()) {
                System.out.println(st3.getRollno() + " " + st3.getStudentname() + " " + st3.getAge());
            }
        }

        String filewrcontents = "";
        for (Student s : records) {
            filewrcontents += s.getRollno() + " " + s.getStudentname() + " " + s.getAge() + "\n";
        }


        Student f3 = new Student();
        System.out.println("assembled file content " + "\n" + filewrcontents);
        f3.writeToFile(filewrcontents, filepath2);
    }

}

