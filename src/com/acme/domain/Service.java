package com.acme.domain;

public class Service implements Product {
	private String name;
	private int estimatedTaskDuration;
	private boolean timeAndMaterials;
	
	public Service(String n, int dur, boolean tAndM) {
		this.estimatedTaskDuration = dur;
		this.name = n;
		this.timeAndMaterials = tAndM;
	}
	
	public String toString() {
		return name + "(a " + estimatedTaskDuration + " day service)";
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;		
	}
}
