package eu.wodrobina.account.model.operations;

import eu.wodrobina.account.model.operations.dto.WithdrawOperationDto;

import java.math.BigDecimal;
import java.util.function.Function;

class WithdrawHandler implements AccountHistoryOperationHandler<WithdrawOperationDto> {

    private final static Function<WithdrawOperationDto, BigDecimal> handle = dto -> dto.getValue().negate();

    @Override
    public Function<WithdrawOperationDto, BigDecimal> handle() {
        return handle;
    }

    @Override
    public Class handles() {
        return WithdrawOperationDto.class;
    }
}
