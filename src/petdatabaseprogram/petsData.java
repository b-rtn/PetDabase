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
   
    static Pet pets[] = new Pet[' '];
    
    //Method for loading Pet data from file.
    public petsData() throws FileNotFoundException {
        { 
            String[] items = null;
            int i=0;
                try {
		    FileInputStream fstream = new FileInputStream("pets.txt");
		    DataInputStream in = new DataInputStream(fstream);
		    BufferedReader br = new BufferedReader(new InputStreamReader(in));
		    String strLine;
		            
		        while ((strLine = br.readLine()) != null) {
		            items = strLine.split(" ");
		            pets[i++]= new Pet(items[0], Integer.parseInt(items[1])); 
		                
		        }
		            in.close();
		    } 
                    catch(FileNotFoundException e){
				//e.printStackTrace();
                    }
                    catch(ArrayIndexOutOfBoundsException exception) {
                        add(items[0], Integer.parseInt(items[1]));
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

    void add(String name, int age) {
        int listFromArray = 0;
        // Convert array to list
        List<Pet> tempList = new ArrayList<Pet>(listFromArray);
        
        //Convert list back to array		 		
 	Pet[] tempArray = new Pet[tempList.size()];		 		
 	pets = tempList.toArray(tempArray);
       
    }

    public static void remove(String _) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void show() {
		int size=pets.length;
		System.out.println("+-------------------+");
		System.out.println("|ID | NAME     |AGE |");
		System.out.println("+-------------------+");
		for(int i=0;i<size;i++) {
                    if(pets[i] != null){
                    pets[i].show(i);
                    }
		}
		System.out.println("+-------------------+");
		System.out.println(Arrays.stream(pets).filter(e -> e != null).count() +" rows in set.");
		System.out.println();
	}
    
}
