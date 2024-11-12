package com.ED_API.__ED_API.service;

import com.ED_API.__ED_API.binding.EdResponse;

public interface EligService {

    public EdResponse determineEligibility(Long caseNum);

    public boolean generateCo(Long caseNum);
}
