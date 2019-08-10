package com.jlawal.finalexam.mainpackage.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "states")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stateId;

    @Column(nullable = false)
    @NotBlank(message = "State Code is Required")
    private String stateCode;

    @NotBlank(message = "Please enter the state's name")
    @Column(nullable = false)
    private String stateName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "join_state_citizen")
    private List<Citizen> citizenList = new ArrayList<>();

    public State() {

    }

    public State(String stateCode, String stateName, List<Citizen> citizenList) {
        this.stateCode = stateCode;
        this.stateName = stateName;
        this.citizenList = citizenList;
    }

    public State(String stateCode, String stateName) {
        this.stateCode = stateCode;
        this.stateName = stateName;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public List<Citizen> getCitizenList() {
        return citizenList;
    }

    public void setCitizenList(List<Citizen> citizenList) {
        this.citizenList = citizenList;
    }

    public void addCitizen(Citizen citizen){
        this.citizenList.add((citizen));
    }

    @Override
    public String toString() {
        return "State{" +
                "stateId=" + stateId +
                ", stateCode=" + stateCode +
                ", stateName='" + stateName + '\'' +
                ", citizenList=" + citizenList +
                '}';
    }
}
