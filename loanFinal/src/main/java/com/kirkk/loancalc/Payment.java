package com.kirkk.loancalc;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Payment {
    private long id;

    @Length(max = 3)
    private String paymentValue;

    public Payment() {
        // Jackson deserialization
    }

    public Payment(long id, String paymentValue) {
        this.id = id;
        this.paymentValue = paymentValue;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getPaymentValue() {
        return this.paymentValue;
    }
}