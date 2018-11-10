package sample;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dummy {
   private float quiz_1,quiz_2,quiz_3,test_1,test_2,test_3,assignment,lab,selfstudy,f1=0,f2=0,f3=0;
    private String usn,ccode;
   private String reg1="1rv16cs[0-9][0-9][0-9]",reg2="16cs[0-9][0-9]";
    void function() throws Exception {
        Insert insert = new Insert();


        Scanner sc = new Scanner(System.in);
       while(f1==0){
            System.out.println("Enter the USN");
            usn=sc.next();
            usn=usn.toLowerCase();
            Pattern pat=Pattern.compile(reg1);
            Matcher matcher = pat.matcher(usn);
               boolean b=matcher.matches();
               if(b)
                   f1=1;
               else
                    f1=0;
       }
       while(f2==0){
            System.out.println("Enter Course-code");
            ccode=sc.next();
            ccode=ccode.toLowerCase();
            Pattern pat=Pattern.compile(reg2);
            Matcher matcher = pat.matcher(ccode);
            boolean b=matcher.matches();
            if(b)
                   f2=1;
            else
                   f2=0;

       }
        while(f3==0){
        System.out.println("Enter Q1,Q2 and Q3 marks");
        quiz_1=sc.nextFloat();
        quiz_2=sc.nextFloat();
        quiz_3=sc.nextFloat();
        if(quiz_1 >10 || quiz_2>10 || quiz_3>10)
            System.out.println("Incorrect Quiz marks");
        else
            f3=1;
       }
        System.out.println("Enter T1,T2 and T3 marks");
        test_1=sc.nextFloat();
        test_2=sc.nextFloat();
        test_3=sc.nextFloat();
        System.out.println("Enter assignment and lab marks");
        assignment=sc.nextFloat();
        lab=sc.nextFloat();
        System.out.println("Enter self-study marks");
        selfstudy=sc.nextFloat();


        insert.insertintoquiz(usn, ccode, quiz_1, quiz_2, quiz_3);
        insert.insertintotest(usn, ccode, test_1, test_2, test_3);
        insert.insertintoassgn(ccode, usn, assignment, lab,selfstudy);
    }
}
