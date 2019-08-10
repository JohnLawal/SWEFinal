package com.jlawal.finalexam.mainpackage.repository;

import com.jlawal.finalexam.mainpackage.model.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {
    @Query("SELECT sum(yearlyIncome) FROM Citizen ")
    public Double getSumOfYearlyIncomeForAllCitizens();
}
