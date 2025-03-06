package edu.ntudp.pzks.lab5;

import edu.ntudp.pzks.lab5.controller.UniversityCreator;
import edu.ntudp.pzks.lab5.model.University;

public class Run {
    public static void main(String[] args){
        University university = UniversityCreator.createTypicalUniversity();
        System.out.println(university);
    }

}
