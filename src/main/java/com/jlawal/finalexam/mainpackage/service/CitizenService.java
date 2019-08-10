package com.jlawal.finalexam.mainpackage.service;

import com.jlawal.finalexam.mainpackage.model.Citizen;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface CitizenService {

    Page<Citizen> getAllCitizens(int page);

    Citizen registerCitizen(Citizen citizen);

    boolean hasDefaultRecords();

    Optional<Citizen> getCitizenById(Long citizenId);

    Double computeTotalNationalYearlyIncome();

    String getTotalNationalYearlyIncomeAsMoney();
}
