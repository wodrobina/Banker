package eu.wodrobina;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import eu.wodrobina.account.BankAccountNumberGenerator;
import eu.wodrobina.account.model.BankAccount;

@Path("/account")
public class AccountController {

    private BankAccountNumberGenerator bankAccountNumberGenerator;

    public AccountController(BankAccountNumberGenerator bankAccountNumberGenerator) {
        this.bankAccountNumberGenerator = bankAccountNumberGenerator;
    }

    @GET
    @Path("new")
    @Produces(MediaType.APPLICATION_JSON)
    public BankAccount createNewBankAccount() {
        return BankAccount.open(bankAccountNumberGenerator.generate());
    }
}
