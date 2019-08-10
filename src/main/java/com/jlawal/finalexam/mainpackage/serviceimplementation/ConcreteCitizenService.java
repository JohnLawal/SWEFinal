package com.jlawal.finalexam.mainpackage.serviceimplementation;

import com.jlawal.finalexam.mainpackage.model.Citizen;
import com.jlawal.finalexam.mainpackage.repository.CitizenRepository;
import com.jlawal.finalexam.mainpackage.service.CitizenService;
import com.jlawal.finalexam.mainpackage.utility.AppValues;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.Optional;

@Service
public class ConcreteCitizenService implements CitizenService {
    private CitizenRepository citizenRepository;

    public ConcreteCitizenService(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    @Override
    public Page<Citizen> getAllCitizens(int page) {
        return citizenRepository.findAll(PageRequest.of(page, AppValues.ENTRIES_PER_PAGE.iVal(), Sort.by(AppValues.CITIZEN_SORT_BY.val())));
    }

    @Override
    public Citizen registerCitizen(Citizen citizen) {
        return citizenRepository.save(citizen);
    }

    @Override
    public boolean hasDefaultRecords() {
        return citizenRepository.count() > 0;
    }

    @Override
    public Optional<Citizen> getCitizenById(Long citizenId) {
        return citizenRepository.findById(citizenId);
    }

    @Override
    public Double computeTotalNationalYearlyIncome() {
        return citizenRepository.getSumOfYearlyIncomeForAllCitizens();
    }

    @Override
    public String getTotalNationalYearlyIncomeAsMoney() {
        Double income = computeTotalNationalYearlyIncome();
        NumberFormat usaFormat = NumberFormat.getCurrencyInstance();
        return usaFormat.format(income);
    }
}
