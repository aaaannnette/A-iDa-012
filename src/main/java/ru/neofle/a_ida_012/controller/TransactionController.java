package ru.neofle.a_ida_012.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.neofle.a_ida_012.dto.TransactionDto;
import ru.neofle.a_ida_012.service.TransactionService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/account/{accountNumber}/transactions")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<TransactionDto>> getTransactions(@PathVariable String accountNumber, @RequestParam String statementDate){
        var date = LocalDate.parse(statementDate);

        List<TransactionDto> transactions = transactionService.getTransactions(accountNumber, date);

        return ResponseEntity.ok(transactions);
    }
}
