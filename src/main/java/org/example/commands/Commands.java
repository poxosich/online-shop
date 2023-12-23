package org.example.commands;

public interface Commands {
     String Exit = "0";
     String ADD_CATEGORY = "1";
     String EDIT_CATEGORY_BY_ID = "2";
     String DELETE_CATEGORY_BY_ID = "3";


     static void printCommands(){
         System.out.println("կայքից դուռս գալու համար սեխմեք " + Exit);
         System.out.println("Category ավելացնելու համար սեխմեք " + ADD_CATEGORY);
         System.out.println("Category-ի տվյալները ID-ով փոխելու համար սեխմեք " + EDIT_CATEGORY_BY_ID);
         System.out.println("Category-ները ID-ով ջնջելու համար ցեխմեք " + DELETE_CATEGORY_BY_ID);
     }


}
