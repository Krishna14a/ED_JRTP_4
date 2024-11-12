package com.ED_API.__ED_API.service;

import com.ED_API.__ED_API.binding.EdResponse;
import com.ED_API.__ED_API.entities.*;
import com.ED_API.__ED_API.repositories.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EligServiceImpl implements EligService{

    @Autowired
    private PlanSelRepo planSelRepo;

    @Autowired
    private PlanRepo planRepo;
    @Autowired
    private IncomeRepo incomeRepo;
    @Autowired
    private EducationRepo educationRepo;
    @Autowired
    private KidRepo kidRepo;

    @Autowired
    private EligRepo eligRepo;
    @Override
    public EdResponse determineEligibility(Long caseNum) {

        EdResponse response= new EdResponse();

        PlanSelEntity planSel = planSelRepo.findByCaseNumber(caseNum);
        Integer planId = planSel.getPlanId();
        PlanEntity planEntity = planRepo.findById(planId).get();
        String planName = planEntity.getPlanName();


        IncomeEntity incomeEntity = incomeRepo.findByCaseNum(caseNum);
        EducationEntity educationEntity = educationRepo.findByCaseNum(caseNum);
        List<KidEntity> kidsEntities = kidRepo.findByCaseNum(caseNum);
        response.setPlanName(planName);
        response.setCaseNum(caseNum);

        if ("SNAP".equals(planName)) {

            Double salaryIncome = incomeEntity.getSalaryIncome();
            if (salaryIncome > 300) {
                response.setPlanStatus("DN");
                response.setDenialRsn("High Salary Income");
            } else {
                response.setPlanStatus("AP");
                response.setBenefitAmt(350.00);
                response.setEligStartDate(LocalDate.now());
                response.setEligEndDate(LocalDate.now().plusMonths(6));
            }

        } else if ("CCAP".equals(planName)) {
            // logic
        } else if ("Medicaid".equals(planName)) {
            // logic
        } else if ("Medicare".equals(planName)) {
            // logic
        } else if ("RIW".equals(planName)) {
            // logic
        }

        EligEntity entity = new EligEntity();
        BeanUtils.copyProperties(response, entity);

        eligRepo.save(entity);

        return response;
    }

    @Override
    public boolean generateCo(Long caseNum) {
        return false;
    }
}
