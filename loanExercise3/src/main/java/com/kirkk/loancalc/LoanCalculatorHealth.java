package com.kirkk.loancalc;

import com.codahale.metrics.health.HealthCheck;

public class LoanCalculatorHealth extends HealthCheck {
    private final LoanCalculator loanCalculator;

    public LoanCalculatorHealth(LoanCalculator loanCalculator) {
        this.loanCalculator = loanCalculator;
    }

    @Override
    protected Result check() throws Exception {
    	//Create the Health Check
    	return null;
    }
}