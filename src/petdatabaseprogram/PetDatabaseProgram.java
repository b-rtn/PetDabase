/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petdatabaseprogram;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author ratnabarot
 */
public class PetDatabaseProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        int choice, id = ' ';
        String input = " ";
        petsData data = new petsData();
        //String data[] = new String[size];
 
        //Main menu
        Scanner s = new Scanner(System.in);
        do
        {
           
            System.out.println("\nWhat would you like to do?");
            System.out.println("1) View all pets");
            System.out.println("2) Add more pets");
            System.out.println("3) Update an existing pet");
            System.out.println("4) Remove an existing pet");
            System.out.println("5) Search pets by name");
            System.out.println("6) Search pets by age");
            System.out.println("7) Exit program");
            System.out.print("\nYour choice: ");
            choice = s.nextInt();
            
            
            if(choice == 1){
                 data.show();
            }
            if(choice == 2){
                data.show();
                int count = 0;
                while(true){
                    System.out.print("\nadd pet (name, age): ");
                    input = s.next();
                    
                    String[] name=input.split(" ");
                    
                    if(input.equalsIgnoreCase("done")){
                        break;
                    }
                    int age = Integer.parseInt(name[1]);
                    data.add(name[0], age);
                    count++;
                }
                
                System.out.println(count + " pets added.");
                break;
            
            }
            if(choice == 3){
                data.show();
                System.out.print("\nEnter the pet ID you want to update: ");
                id = s.nextInt();
                System.out.print("\nEnter new name and new age: ");
                input = s.next(); 
                String[] name = input.split(" ");
                data.update(id,name[0], Integer.parseInt(name[1]));
                System.out.print("\n       changed to       .\n");
              
            }
            if(choice == 4){
                data.show();
                System.out.print("\nEnter the pet ID to remove: ");
                id = s.nextInt();
                data.remove(id);
                System.out.print("\n      is removed.\n");
            } 
            if(choice == 5){
                
                System.out.print("\nEnter a name to search: "); 
                input = s.next();
            }
            if(choice == 6){
            
                System.out.print("\nEnter age to search: ");
                input = s.next();
            }

        }while(choice !=7);
        
        if(choice == 7){
            System.out.println("Successfully exited the program");
            System.exit(0);
        }
    }
    
}
