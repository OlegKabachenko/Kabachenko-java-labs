package edu.ntudp.pzks.lab4;

import edu.ntudp.pzks.lab4.controller.UniversityCreator;
import edu.ntudp.pzks.lab4.model.University;

public class Run {
    public static void main(String[] args){
        University university = UniversityCreator.createTypicalUniversity();
        System.out.println(university);
    }

}
