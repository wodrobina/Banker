package eu.wodrobina.account.model.operations;

import eu.wodrobina.account.model.operations.dto.DepositOperationDto;

import java.math.BigDecimal;
import java.util.function.Function;

class DepositHandler implements AccountHistoryOperationHandler<DepositOperationDto> {

    private final static Function<DepositOperationDto, BigDecimal> handle = dto -> dto.getValue();

    @Override
    public Function<DepositOperationDto, BigDecimal> handle() {
        return handle;
    }

    @Override
    public Class handles() {
        return DepositOperationDto.class;
    }
}
