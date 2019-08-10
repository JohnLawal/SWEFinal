package com.jlawal.finalexam.mainpackage.repository;

import com.jlawal.finalexam.mainpackage.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
    public Optional<State> findStateByStateCodeEquals(String stateCode);
}
