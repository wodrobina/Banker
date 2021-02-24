package eu.wodrobina.transfer;

public class StatisticService implements TransferTask<AcceptedTransferTask, StatisticsTransferTask> {

    @Override
    public StatisticsTransferTask perform(AcceptedTransferTask source) {
        return new StatisticsTransferTask();
    }

    @Override
    public Class<AcceptedTransferTask> handles() {
        return AcceptedTransferTask.class;
    }
}
