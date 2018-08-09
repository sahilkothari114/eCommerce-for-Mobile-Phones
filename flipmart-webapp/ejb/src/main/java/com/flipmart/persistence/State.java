package com.flipmart.persistence;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "state")
public class State implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
        @SequenceGenerator(name="state_SEQ", allocationSize=1)
	@Column(name = "state_id")
	private long stateId;

	@Column(name = "state_name")
	private String stateName;

	public long getStateId() {
		return stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

    @Override
    public String toString() {
        return "State{" + "stateId=" + stateId + ", stateName=" + stateName + '}';
    }

}
