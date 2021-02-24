package eu.wodrobina.transfer;

import eu.wodrobina.account.model.events.CashFlow;

public record AcceptedTransferTask(CashFlow cashFlow, boolean isFailed) {
}
