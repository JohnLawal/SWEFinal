package com.jlawal.finalexam.mainpackage.serviceimplementation;

import com.jlawal.finalexam.mainpackage.model.State;
import com.jlawal.finalexam.mainpackage.repository.StateRepository;
import com.jlawal.finalexam.mainpackage.service.StateService;
import com.jlawal.finalexam.mainpackage.utility.AppValues;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConcreteStateService implements StateService {
    private StateRepository stateRepository;

    public ConcreteStateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public List<State> getAllStates() {
        return stateRepository.findAll(Sort.by("stateName"));
    }

    @Override
    public Page<State> getAllStatesPaged(int page) {
        return stateRepository.findAll(PageRequest.of(page, AppValues.ENTRIES_PER_PAGE.iVal(), Sort.by(AppValues.STATE_SORT_BY.val())));
    }

    @Override
    public void createState(State state) {
        stateRepository.save(state);
    }

    @Override
    public boolean hasDefaultRecords() {
        return stateRepository.count() > 0;
    }

    @Override
    public void saveState(State state) {
        stateRepository.save(state);
    }

    @Override
    public Optional<State> getStateById(Long stateId) {
        return stateRepository.findById(stateId);
    }

    @Override
    public Optional<State> getStateByStateCode(String stateCode) {
        return stateRepository.findStateByStateCodeEquals(stateCode);
    }
}
