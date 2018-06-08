package model;

import java.util.ArrayList;
import java.util.HashMap;

public class School {
	private ArrayList<String> stuName;
	private ArrayList<Bus> busList;
	private HashMap<String, Bus> busMap;
	public ArrayList<String> getStuName() {
		return stuName;
	}
	public void setStuName(ArrayList<String> stuName) {
		this.stuName = stuName;
	}
	public ArrayList<Bus> getBusList() {
		return busList;
	}
	public void setBusList(ArrayList<Bus> busList) {
		this.busList = busList;
	}
	public HashMap<String, Bus> getBusMap() {
		return busMap;
	}
	public void setBusMap(HashMap<String, Bus> busMap) {
		this.busMap = busMap;
	}
	
	
}
