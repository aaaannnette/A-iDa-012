package ru.neofle.a_ida_012.service;

import ru.neofle.a_ida_012.dto.TransactionDto;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService {
    List<TransactionDto> getTransactions(String accountNumber, LocalDate statementDate);
}
