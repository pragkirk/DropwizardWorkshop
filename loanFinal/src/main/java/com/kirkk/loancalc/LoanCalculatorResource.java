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

    @GET
    @Timed
    public Payment calculateLoan(@QueryParam("principle") @DefaultValue("15000") String principle, 
    							 @QueryParam("rate") @DefaultValue("3.0") String rate, 
    							 @QueryParam("term") @DefaultValue("60") String term) {
        final String value = new LoanCalculator().calculatePayment(principle, rate, term);
        System.out.println("Monthly payment: " + value);
        return new Payment(counter.incrementAndGet(), value);
    }
}