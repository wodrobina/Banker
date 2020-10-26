package eu.wodrobina;

import eu.wodrobina.account.BankAccountNumberGenerator;
import org.glassfish.jersey.internal.inject.AbstractBinder;

public class ApplicationBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(BankAccountNumberGenerator.class).to(BankAccountNumberGenerator.class);
    }
}