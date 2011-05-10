package test.bean;

import java.util.HashSet;


public class Info {
	HashSet<Quality> qualities;

	private String animal;


	public HashSet<Quality> getQualities() {
		return qualities;
	}

	public void setQualities(HashSet<Quality> qualities) {
		this.qualities = qualities;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}
}
