package edu.ntudp.pzks.lab4;

import edu.ntudp.pzks.lab4.model.University;

import static edu.ntudp.pzks.lab4.controller.UniversityCreator.createTypicalUniversity;

public class Run {
    public static void main(String[] args){
         University  university = createTypicalUniversity();
         System.out.println(university);
    }

}
