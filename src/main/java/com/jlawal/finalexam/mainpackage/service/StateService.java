package com.jlawal.finalexam.mainpackage.service;

import com.jlawal.finalexam.mainpackage.model.State;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface StateService {

    List<State> getAllStates();

    Page<State> getAllStatesPaged(int page);

    void createState(State state);

    boolean hasDefaultRecords();

    void saveState(State state);

    Optional<State> getStateById(Long stateId);

    Optional<State> getStateByStateCode(String stateCode);

}
