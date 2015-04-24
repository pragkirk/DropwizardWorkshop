package com.kirkk.loancalc;

import com.kirkk.loancalc.Payment;
import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/loan")
@Produces(MediaType.APPLICATION_JSON)
public class LoanCalculatorResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public LoanCalculatorResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

	//1.) Define a calculateLoan method that accepts three parameters - principle, rate, term
	//2.) Create the LoanCalculator class and call the calculatePayment method.
	//3.) Create and return the Payment representation using the result from 2.
}