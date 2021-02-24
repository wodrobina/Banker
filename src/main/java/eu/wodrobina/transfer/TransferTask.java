package eu.wodrobina.transfer;

public interface TransferTask<T, U> {
    U perform(T source);

    Class<T> handles();
}
