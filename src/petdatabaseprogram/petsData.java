/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petdatabaseprogram;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ratnabarot
 */
class petsData {
    
    static Pet pets[] = new Pet[5];
    

    //Method for loading Pet data from file.
    public petsData() throws FileNotFoundException {
        { 
            String[] name = null;
            int i=0;
                try {
		    FileInputStream fstream = new FileInputStream("pets.txt");
		    DataInputStream in = new DataInputStream(fstream);
		    BufferedReader br = new BufferedReader(new InputStreamReader(in));
		    String strLine;
		            
		        while ((strLine = br.readLine()) != null) {
		            name = strLine.split(" ");
		            pets[i++]= new Pet(name[0], Integer.parseInt(name[1])); 
		                
		        }
		            in.close();
		    } 
                    catch(FileNotFoundException e){
				//e.printStackTrace();
                    }
                    catch(ArrayIndexOutOfBoundsException exception) {
                        add(name[0], Integer.parseInt(name[1]));
                    }
			  
                    catch(Exception e){
		        System.err.println("Error: " + e.getMessage());
		            
		    }
	}
    }
	//Method used to output pet data to file.
    public static void writeToFile(){
	try{
	    FileWriter fr = new FileWriter("pets.txt");
	    BufferedWriter br = new BufferedWriter(fr);
	    PrintWriter out = new PrintWriter(br);
	    for(int i=0; i<pets.length; i++){
	            
                if(pets[i] != null){  
                    out.write(pets[i].getName()+" "+pets[i].getAge());
	            out.write("\n");
                }
            }
	          out.close();
	}
        catch(IOException e){
	    System.out.println(e);   
	}
    }

    public static void add(String name, int age) {

        // Convert array to list
	List<Pet> listFromArray = Arrays.asList(pets);
        
        // Convert array to list
        List<Pet> tempList = new ArrayList<Pet>(listFromArray);
        
        //Check to see if the database is full
        if(Arrays.stream(pets).filter(e -> e != null).count() < 5){
            tempList.add(new Pet(name,age));
        }else{
            System.out.println("Error: Database is full.");
        }
        
        //Convert list back to array		 		
 	Pet[] tempArray = new Pet[tempList.size()];		 		
 	pets = tempList.toArray(tempArray);
       
    }

    public static void show() {
        int size = pets.length;
	System.out.println("+-------------------+");
	System.out.println("|ID | NAME     |AGE |");
	System.out.println("+-------------------+");
	for(int i=0;i<pets.length;i++) {
            if(pets[i] != null){
            pets[i].show(i);
            }
	}
	System.out.println("+-------------------+");
	System.out.println(Arrays.stream(pets).filter(e -> e != null).count() +" rows in set.");
	System.out.println();
	}

    void update(int id, String name, int age) {
        try {    
            System.out.println(pets[id].getName() + " "+ pets[id].getAge()+  " changed to "+ name+ " "+age);
            pets[id].setName(name);
            pets[id].setAge(age);
            }
        catch(NullPointerException e) 
        { 
            System.out.println("Error: ID not found."); 
        } 
    }

    void remove(int id) {
       // Convert array to list
	List<Pet> listFromArray = Arrays.asList(pets);
        
        // Convert array to list
        List<Pet> tempList = new ArrayList<Pet>(listFromArray);
        
        //Validate that the index value exists.
        if( id > 4 || tempList.get(id)== null ) {
            System.out.println("Error: ID " + id + " does not exist.");
        }
        else {
        System.out.println(pets[id].getName() + " "+ pets[id].getAge()+ " was removed. ");
        tempList.remove(id);
        
        //Convert list back to array		 		
 	Pet[] tempArray = new Pet[tempList.size()];		 		
 	pets = tempList.toArray(tempArray);
        }
    }

    void searchPetByName(String name) {
        int size = pets.length;
        System.out.println("+-------------------+");
	System.out.println("|ID | NAME     |AGE |");
	System.out.println("+-------------------+");
		
	for(int i=0;i<pets.length;i++) {		
            if(pets[i].getName().toUpperCase().equals(name.toUpperCase()))
               pets[i].show(i);
            }
		
	System.out.println("+-------------------+");
	System.out.println(Arrays.stream(pets).filter(e -> e != null).count() +" rows in set.");
	System.out.println();
    }

    void searchPetByAge(int age) {
        int size = pets.length;
        System.out.println("+-------------------+");
	System.out.println("|ID | NAME     |AGE |");
	System.out.println("+-------------------+");
		
	for(int i=0;i<pets.length;i++) {		
            if(pets[i].getAge()==age)
                pets[i].show(i);
            }
		
	System.out.println("+-------------------+");
	System.out.println(Arrays.stream(pets).filter(e -> e != null).count() +" rows in set.");
	System.out.println();
    }
    
}
