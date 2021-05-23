package eu.wodrobina.transfer;

import eu.wodrobina.transfer.dto.MoneyTransfer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class TransferManager {

    private Map<Class<?>, TransferTask<?, ?>> tasks;

    public TransferManager(List<TransferTask<?, ?>> tasks) {
        this.tasks = tasks.stream()
                .collect(Collectors.toMap(TransferTask::handles, Function.identity()));
    }

    public MoneyTransfer performTransfer(MoneyTransfer moneyTransfer) {
        MoneyTransfer chainObject = moneyTransfer;
        List<Class<?>> cycleRecorder = new ArrayList<>();
        cycleRecorder.add(chainObject.getClass());

        while (tasks.get(chainObject.getClass()) != null) {
            TransferTask moneyTransferTask = tasks.get(chainObject.getClass());

            chainObject = moneyTransferTask.perform(chainObject);

            checkFoCycle(chainObject, cycleRecorder);
        }

        return chainObject;
    }

    private void checkFoCycle(MoneyTransfer chainObject, List<Class<?>> cycleRecorder) {
        if (cycleRecorder.contains(chainObject.getClass())) {
            throw new IllegalStateException("Birthday tasks has cycle " + cycleRecorder.toString());
        } else {
            cycleRecorder.add(chainObject.getClass());
        }
    }
}


;


