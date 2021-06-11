package ru.neofle.a_ida_012.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.neofle.a_ida_012.dto.AmountDto;
import ru.neofle.a_ida_012.dto.SwiftTransferDto;
import ru.neofle.a_ida_012.dto.TransactionDto;
import ru.neofle.a_ida_012.generator.RandomTransactionFields;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionDaoMockImpl implements TransactionDao {
    @Autowired
    private RandomTransactionFields random;

    @Override
    public List<TransactionDto> getTransactionsByAccountNumberAndStatementDate(String accountNumber, LocalDate statementDate) {
        List<TransactionDto> transactions = new ArrayList<>();
        var loopQuantity = (int) (Math.random() * 20);

        for (var i = 0; i < loopQuantity; i++) {
            transactions.add(generateTransaction());
        }

        return transactions;
    }

    private TransactionDto generateTransaction() {
        var transaction = new TransactionDto();

        transaction
                .setAmount(generateAmount())
                .setCorrespondingAccount(random.correspondingAccount())
                .setSwiftTransfer(generateSwiftTransfer(transaction.getAmount().getCurrencyName()))
                .setUuid(random.uuid())
                .setTransactionId(random.transactionId());

        return transaction;
    }

    private AmountDto generateAmount() {
        var amount = new AmountDto();

        amount
                .setAmount(random.amount())
                .setCurrencyName(random.currency());

        return amount;
    }

    private SwiftTransferDto generateSwiftTransfer(String currency) {
        var swiftTransfer = new SwiftTransferDto();

        swiftTransfer
                .setBankOperationCode("CRED");
        if (randomB()) {
            swiftTransfer
                    .setBeneficiaryBankAccount(random.beneficiaryBankAccount())
                    .setBeneficiaryBankName(random.beneficiaryBankName())
                    .setBeneficiaryBankOption(random.beneficiaryBankOption())
                    .setBeneficiaryCustomerAccount(random.beneficiaryCustomerAccount())
                    .setBeneficiaryCustomerName(random.beneficiaryCustomerName());
        }
        if (randomB()) {
            swiftTransfer
                    .setDetailsOfCharges(random.detailsOfCharges());
        }
        if (randomB()) {
            swiftTransfer
                    .setExchangeRate(random.exchangeRate());
        }
        if (randomB()) {
            swiftTransfer
                    .setInstructedAmount(random.instructedAmount(currency))
                    .setInstructionCode(random.instructionCode());
        }
        if (randomB()) {
            swiftTransfer
                    .setIntermediaryBankAccount(random.intermediaryBankAccount())
                    .setIntermediaryBankName(random.intermediaryBankName())
                    .setIntermediaryBankOption(random.intermediaryBankOption());
        }
        if (randomB()) {
            swiftTransfer
                    .setMessageDestinator(random.messageDestinator())
                    .setMessageIdentifier(random.messageIdentifier())
                    .setMessageOriginator(random.messageOriginator())
                    .setMessageReceiveTime(random.messageReceiveTime())
                    .setMessageSendTime(random.messageSendTime())
                    .setMessageType(random.messageType());
        }
        if (randomB()) {
            swiftTransfer
                    .setOrderingCustomerAccount(random.orderingCustomerAccount())
                    .setOrderingCustomerName(random.orderingCustomerName())
                    .setOrderingCustomerOption(random.orderingCustomerOption())
                    .setOrderingInstitutionAccount(random.orderingInstitutionAccount())
                    .setOrderingInstitutionName(random.orderingInstitutionName())
                    .setOrderingInstitutionOption(random.orderingInstitutionOption());
        }
        if (randomB()) {
            swiftTransfer
                    .setReceiverCharges(random.charges(currency))
                    .setReceiverCorrespondentAccount(random.receiverCorrespondentAccount())
                    .setReceiverCorrespondentName(random.receiverCorrespondentName())
                    .setReceiverCorrespondentOption(random.receiverCorrespondentOption());
        }
        if (randomB()) {
            swiftTransfer
                    .setRegulatoryReporting(random.regulatoryReporting());
        }
        if (randomB()) {
            swiftTransfer
                    .setRemittanceInformation(random.remittanceInformation());
        }
        if (randomB()) {
            swiftTransfer
                    .setSenderCharges(random.charges(currency))
                    .setSenderCorrespondentAccount(random.senderCorrespondentAccount())
                    .setSenderCorrespondentName(random.senderCorrespondentName())
                    .setSenderCorrespondentOption(random.senderCorrespondentOption())
                    .setSenderToReceiverInformation(random.senderToReceiverInformation());
        }
        if (randomB()) {
            swiftTransfer
                    .setTransactionReferenceNumber(random.reference())
                    .setTransactionRelatedReference(random.reference());
        }
        if (randomB()) {
            swiftTransfer
                    .setTransactionTypeCode(random.transactionTypeCode());
        }
        if (randomB()) {
            swiftTransfer
                .setUrgent(random.urgent());
        }
        if (randomB()) {
            swiftTransfer
                    .setValueDateCurrencyInterbankSettledAmount(random.valueDateCurrencyInterbankSettledAmount(currency));
        }

        return swiftTransfer;
    }

    private boolean randomB() {
        return Math.random() > 0.5;
    }
}
