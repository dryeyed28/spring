package model;

import java.util.ArrayList;

public class Dormitory implements Residence {
	private String schoolName;
	private ArrayList<Book> library;
	
	@Override
	public void reside() {
		System.out.println("ÇÐ±³¸í : " + getSchoolName() + " " + library.toString());
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public ArrayList<Book> getLibrary() {
		return library;
	}

	public void setLibrary(ArrayList<Book> library) {
		this.library = library;
	}
	
	

}
