package com.kirkk.loancalc;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.kirkk.loancalc.LoanCalculatorResource;

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
                    
        this.configureCors(environment); 
        
        //1.) Declare the LoanCalculatorResource class as final and create an instance of it 
    	//2.) Register the resource with the environment.
    	
    	final LoanCalculatorHelloResource helloResource = new LoanCalculatorHelloResource(
        	configuration.getTemplate(),
        	configuration.getDefaultName()
    	);    	
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