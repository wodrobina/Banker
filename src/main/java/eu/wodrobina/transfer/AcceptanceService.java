package eu.wodrobina.transfer;

import eu.wodrobina.account.model.events.CashFlow;

public class AcceptanceService implements TransferTask<CashFlow, AcceptedTransferTask> {

    @Override
    public AcceptedTransferTask perform(CashFlow source) {
        return new AcceptedTransferTask(source, false);
    }

    @Override
    public Class<CashFlow> handles() {
        return CashFlow.class;
    }
}
