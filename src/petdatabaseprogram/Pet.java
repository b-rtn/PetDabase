/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petdatabaseprogram;

/**
 *
 * @author ratnabarot
 */
public class Pet {
    
    private String name;
	private int age;
    int length;
	
	public Pet() {
		this.name = " ";
		this.age = 0;
	}
	
	public Pet(String name, int age) {
		
		this.name = name;
		this.age = age;
	}


	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void show(int ind) {
		System.out.format("|%3d|%10s|%4d|\n", ind, name, age);
	}
    
}
