package com.flipmart.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "state")
public class State {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "state_id")
	private long stateId;

	@Column(name = "state_name")
	private String stateName;

	public State(String stateName) {
		super();
		this.stateName = stateName;
	}

	public long getStateId() {
		return stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}
}
