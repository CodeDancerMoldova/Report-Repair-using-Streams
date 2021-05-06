package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> data= new ArrayList<>();
        int prod=1;
        try {
            File myObj = new File("dataInput.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                  data.add(Integer.parseInt(myReader.nextLine()));
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        List<Integer[]> dataFinal = data.stream().flatMap(i->data.stream().filter(j -> (i + j)  == 2020).map(j->new Integer[]{i,j})).limit(1).collect(toList());

        for(int i=0;i<dataFinal.size();i++){
            for(Integer j : dataFinal.get(i)){
                prod*=j;
            }
            System.out.println(prod);
        }
    }
}
