package com.sjprogramming.quizapp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Quiz q = new Quiz();
        q.logic();

    }
}

class Quiz{
    Scanner sc = new Scanner(System.in);
    int correctAnsCount =0;
    int wrongAnsCount=0;

    public void logic(){
        Questions q1 = new Questions("Which statement is true about Java?","a)Java is a sequence-dependent programming language","b)Java is a code dependent programming language","c)Java is a platform-dependent programming language","d)Java is a plateform independent programming language");
        Questions q2 = new Questions("What is the extentision of Java code files?","a).js","b).java","c).txt","d).class");
        Questions q3 = new Questions("Which of the following is a marker interface in Java?","a) Serializable","b) Cloneable","c) Remote","d) All of the above");
        Questions q4 = new Questions("What is the default value of an instance variable of type int in Java?","a) 0","b) null","c) 1","d) -1");
        Questions q5 = new Questions("Which of the following is not a feature of Java?","a) Platform Independent","b) Object-Oriented","c)Procedural programming","d)Compiler-based");

        Map<Questions,Character> hmap=new HashMap<>();
        hmap.put(q1,'d');
        hmap.put(q2,'b');
        hmap.put(q3,'d');
        hmap.put(q4,'a');
        hmap.put(q5,'c');

        for(Map.Entry<Questions,Character>map:hmap.entrySet()){
            System.out.println(map.getKey().getQuestion());
            System.out.println(map.getKey().getOption1());
            System.out.println(map.getKey().getOption2());
            System.out.println(map.getKey().getOption3());
            System.out.println(map.getKey().getOption4());


            System.out.println("Please Enter Your Answer:  ");
            Character ans = sc.next().charAt(0);

            int cans=Character.compare(ans,map.getValue());
            if(cans==0){
                System.out.println("Correct");
                correctAnsCount++;
            }else {
                System.out.println("Wrong");
                wrongAnsCount++;
            }

        }

        System.out.println();
        System.out.println("-------Result-------");
        System.out.println("Total Questions: " +hmap.size());
        System.out.println("Correct Answered Questions: "+ correctAnsCount);
        System.out.println("Wrong Answered Questions: " + wrongAnsCount);
        int precentage =(100*correctAnsCount)/hmap.size();
        System.out.println("Presentage: "+(100*correctAnsCount)/hmap.size());
        if(precentage>95){
            System.out.println("Performance: Exellent");
        } else if (precentage<80&&precentage>50) {
            System.out.println("Performance: Good");
        }else {
            System.out.println("Performance: Bad");
        }


    }
}
