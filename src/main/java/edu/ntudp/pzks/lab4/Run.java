package edu.ntudp.pzks.lab4;

import edu.ntudp.pzks.lab4.controller.UniversityCreator;
import edu.ntudp.pzks.lab4.model.University;

public class Run {
    public static void main(String[] args){
         UniversityCreator universitycreator = new UniversityCreator();

         University  university = universitycreator.createTypicalUniversity();
         System.out.println(university);
    }

}
