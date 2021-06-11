package ru.neofle.a_ida_012.dao;

import ru.neofle.a_ida_012.dto.TransactionDto;

import java.time.LocalDate;
import java.util.List;

public interface TransactionDao {
    List<TransactionDto> getTransactionsByAccountNumberAndStatementDate(String accountNumber, LocalDate statementDate);
}
