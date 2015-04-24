package com.kirkk.loancalc;

import java.math.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class LoanCalculator {
    public String calculatePayment(String principle, String interestRate, String loanTerm) {
    	
    	BigDecimal presentValue = new BigDecimal(principle);
    	BigDecimal rate = new BigDecimal(interestRate);
    	int term = new Integer(loanTerm).intValue();
    	
    	double dPresentValue = presentValue.doubleValue();
		double dRate = rate.doubleValue() / (1200);

		double revisedRate = dRate + 1;
		double dTerm = term;
		double powRate = Math.pow(revisedRate, dTerm);

		double left = powRate * dPresentValue;

		double middle = dRate / (powRate - 1);

		double right = 1 / (1);

		BigDecimal payment = new BigDecimal(left * middle * right);
		return payment.setScale(2, BigDecimal.ROUND_UP).toString();
    }
}