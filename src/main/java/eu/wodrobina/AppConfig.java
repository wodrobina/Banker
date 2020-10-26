package eu.wodrobina;

import eu.wodrobina.account.BankAccountNumberGenerator;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class AppConfig extends ResourceConfig {

    public AppConfig() {
        packages("eu.wodrobina");
        register(JacksonFeature.class);
        register(BankAccountNumberGenerator.class);
        register(new ApplicationBinder());
    }
}