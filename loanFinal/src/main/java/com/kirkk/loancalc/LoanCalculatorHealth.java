package com.kirkk.loancalc;

import com.codahale.metrics.health.HealthCheck;

public class LoanCalculatorHealth extends HealthCheck {
    private final LoanCalculator loanCalculator;

    public LoanCalculatorHealth(LoanCalculator loanCalculator) {
        this.loanCalculator = loanCalculator;
    }

    @Override
    protected Result check() throws Exception {
    	String payment = this.loanCalculator.calculatePayment("15000", "3.0", "60");
    	if (!payment.equals("269.54")) {
    		return Result.unhealthy("The loan calculator is not calculating payments correctly.");
    	}
        return Result.healthy();
    }
}