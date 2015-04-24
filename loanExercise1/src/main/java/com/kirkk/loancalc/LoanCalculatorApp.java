package com.kirkk.loancalc;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.eclipse.jetty.servlets.CrossOriginFilter;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration.Dynamic;
import java.util.EnumSet;

public class LoanCalculatorApp extends Application<LoanCalculatorConf> {
    public static void main(String[] args) throws Exception {
        new LoanCalculatorApp().run(args);
    }

    @Override
    public void initialize(Bootstrap<LoanCalculatorConf> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(LoanCalculatorConf configuration,
                    Environment environment) {
                    
    	//Create our resource and register it with the environment.
    	final LoanCalculatorHelloResource helloResource = new LoanCalculatorHelloResource(
        	configuration.getTemplate(),
        	configuration.getDefaultName()
    	);    	
    	environment.jersey().register(helloResource);
    }

}