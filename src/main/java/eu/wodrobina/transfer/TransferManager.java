package eu.wodrobina.transfer;


import eu.wodrobina.account.model.events.CashFlow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TransferManager {

    private Map<Class<?>, TransferTask<?, ?>> tasks;

    public TransferManager(List<TransferTask<?, ?>> tasks) {
        this.tasks = tasks.stream()
                .collect(Collectors.toMap(TransferTask::handles, Function.identity()));
    }

    public String birthday(CashFlow cashFlow) {
        Object chainObject = cashFlow;
        List<Class<?>> cycleRecorder = new ArrayList<>();
        cycleRecorder.add(chainObject.getClass());
        while (tasks.get(chainObject.getClass()) != null) {
            TransferTask birthdayTask = tasks.get(chainObject.getClass());
            chainObject = birthdayTask.perform(chainObject);
            if (cycleRecorder.contains(chainObject.getClass())) {
                throw new IllegalStateException("Birthday tasks has cycle " + cycleRecorder.toString());
            } else {
                cycleRecorder.add(chainObject.getClass());
            }
        }
        return chainObject.toString();
    }
}


;


