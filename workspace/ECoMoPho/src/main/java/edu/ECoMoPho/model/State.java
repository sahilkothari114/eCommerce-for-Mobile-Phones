package edu.ECoMoPho.model;

public class State {
	private int stateId;
	private String stateName;
	
	public State(String stateName) {
		super();
		this.stateName = stateName;
	}
	
	public int getStateId() {
		return stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	} 
	
}
