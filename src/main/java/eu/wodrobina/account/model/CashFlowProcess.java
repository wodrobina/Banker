package eu.wodrobina.account.model;

import eu.wodrobina.account.model.events.CashTransfer;
import io.reactivex.Observable;

@FunctionalInterface
public interface CashFlowProcess {
    Observable<CashTransfer> apply(Observable<CashTransfer> cashFlowObservable);

}
