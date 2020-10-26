package eu.wodrobina;

import eu.wodrobina.account.BankAccountNumberGenerator;
import eu.wodrobina.account.model.BankAccount;
import eu.wodrobina.account.model.BankAccountDto;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/account")
public class AccountController {

    private final BankAccountNumberGenerator bankAccountNumberGenerator;

    @Inject
    public AccountController(BankAccountNumberGenerator bankAccountNumberGenerator) {
        this.bankAccountNumberGenerator = bankAccountNumberGenerator;
    }

    @GET
    @Path("new")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createNewBankAccount() {

        final BankAccount openedAccount = BankAccount.open(bankAccountNumberGenerator.generate());

        return Response.ok()
                .entity(new BankAccountDto(openedAccount))
                .build();

    }
}
