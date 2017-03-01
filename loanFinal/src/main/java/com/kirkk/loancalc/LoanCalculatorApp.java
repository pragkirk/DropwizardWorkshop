package com.kirkk.loancalc;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import com.kirkk.loancalc.LoanCalculatorResource;
import com.kirkk.loancalc.LoanCalculatorHealth;

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
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
                                                   new EnvironmentVariableSubstitutor()
                )
        );
    }

    @Override
    public void run(LoanCalculatorConf configuration,
                    Environment environment) {
                    
        this.configureCors(environment); 
        
        final LoanCalculatorResource loanResource = new LoanCalculatorResource(
        	configuration.getTemplate(),
        	configuration.getDefaultName()
    	);
    	
    	final LoanCalculatorHelloResource helloResource = new LoanCalculatorHelloResource(
        	configuration.getTemplate(),
        	configuration.getDefaultName()
    	);
    	
    	final LoanCalculatorHealth healthCheck =
        	new LoanCalculatorHealth(new LoanCalculator());
    	environment.healthChecks().register("loanCalculator", healthCheck);
    	environment.jersey().register(loanResource);
    	environment.jersey().register(helloResource);
    }
    
    //Enable CORS
    private void configureCors(Environment environment) {
    	Dynamic filter = environment.servlets().addFilter("CORS", CrossOriginFilter.class);
	    filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    	filter.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,PUT,POST,DELETE,OPTIONS");
	    filter.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
    	filter.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");
	    filter.setInitParameter("allowedHeaders", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin");
    	filter.setInitParameter("allowCredentials", "true");
  }

}