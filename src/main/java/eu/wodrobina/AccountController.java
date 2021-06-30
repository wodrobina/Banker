package eu.wodrobina;

import eu.wodrobina.account.BankAccountNumberGenerator;
import eu.wodrobina.account.model.BankAccount;
import eu.wodrobina.account.model.BankAccountDto;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

@Path("/account")
public class AccountController {

    private final BankAccountNumberGenerator bankAccountNumberGenerator;

    @Inject
    public AccountController(BankAccountNumberGenerator bankAccountNumberGenerator) {
        this.bankAccountNumberGenerator = bankAccountNumberGenerator;
    }

    @GET
    @Path("new")
//    @Produces(MediaType.APPLICATION_JSON)
    public Response createNewBankAccount() throws URISyntaxException {

        final BankAccount openedAccount = BankAccount.open(bankAccountNumberGenerator.generate(), null);

        return Response
//                .created(new URI("wod"))
                .seeOther(new URI("account/2"))
//                .entity(new BankAccountDto(openedAccount))
                .build();

    }

    @GET
    @Path("2")
//    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccount() {

        final BankAccount openedAccount = BankAccount.open(bankAccountNumberGenerator.generate(), null);

        return Response
                .accepted()
                .entity(new BankAccountDto(openedAccount))
                .build();

    }
}
