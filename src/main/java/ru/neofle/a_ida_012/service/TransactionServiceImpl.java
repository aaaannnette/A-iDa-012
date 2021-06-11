package ru.neofle.a_ida_012.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.neofle.a_ida_012.dao.TransactionDao;
import ru.neofle.a_ida_012.dto.TransactionDto;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    private TransactionDao transactionDao;

    @Override
    public List<TransactionDto> getTransactions(String accountNumber, LocalDate statementDate) {
        return transactionDao.getTransactionsByAccountNumberAndStatementDate(accountNumber, statementDate);
    }
}
