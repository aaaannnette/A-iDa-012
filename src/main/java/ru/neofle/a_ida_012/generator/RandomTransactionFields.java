package ru.neofle.a_ida_012.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
public class RandomTransactionFields {
    @Autowired
    private Random random;

    private int randomIntInRange(int origin, int bound) {
        return random.ints(origin, bound + 1).findFirst().getAsInt();
    }

    @SafeVarargs
    private <T> T randomPickOf(T... objs) {
        var randomIndex = randomIntInRange(0, objs.length - 1);

        return objs[randomIndex];
    }

    private <T> T randomPickOf(List<T> objs) {
        var randomIndex = randomIntInRange(0, objs.size() - 1);

        return objs.get(randomIndex);
    }

    private String randomNumCharString(int size) {
        var bytes = new byte[size];

        for (var i = 0; i < size; i++) {
            bytes[i] = randomPickOf(randomIntInRange(48, 57), randomIntInRange(65, 90)).byteValue();
        }

        return new String(bytes, Charset.defaultCharset());
    }

    private String randomNumString(int size) {
        var bytes = new byte[size];

        for (var i = 0; i < size; i++) {
            bytes[i] = (byte) randomIntInRange(48, 57);
        }

        return new String(bytes, Charset.defaultCharset());
    }

    private List<String> fileReadAllLines(String fileName) {
        List<String> lines = null;

        try {
            lines = Files.readAllLines(Paths.get("src/main/resources/transactionFields/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
            lines = new ArrayList<>();
        }

        return lines;
    }

    public float amount() {
        return random.nextFloat() * 100000;
    }

    public String currency() {
        return randomPickOf("USD", "EUR", "GBP", "JPY", "CHF", "CNY", "RUB");
    }

    public String beneficiaryBankAccount() {
        return randomPickOf(fileReadAllLines("BankAccount.txt"));
    }

    public String beneficiaryBankName() {
        return randomPickOf(fileReadAllLines("BankName.txt"));
    }

    public String beneficiaryBankOption() {
        return randomPickOf("A", "B", "C", "D");
    }

    public String beneficiaryCustomerAccount() {
        return "/".concat(randomPickOf("RU", "GD", "GL", "HN", "HK", "KZ", "KG", "KE", "CK", "LY", "LI", "MR")).concat(randomNumString(16));
    }

    public String beneficiaryCustomerName() {
        return randomPickOf(fileReadAllLines("CustomerName.txt"));
    }

    public String detailsOfCharges() {
        return randomPickOf("OUR", "SHA", "BEN");
    }

    public String exchangeRate() {
        return String.valueOf(random.nextFloat() * 100);
    }

    public String instructedAmount(String currency) {
        return currency + (random.nextFloat() * 100000);
    }

    public String instructionCode() {
        return randomPickOf("SDVA", "INTC", "REPA", "CORT", "HOLD", "CHQB", "PHOB", "TELB", "PHON", "TELE", "PHOI", "TELI");
    }

    public String intermediaryBankAccount() {
        return randomPickOf(fileReadAllLines("BankAccount.txt"));
    }

    public String intermediaryBankName() {
        return randomPickOf(fileReadAllLines("BankName.txt"));
    }

    public String intermediaryBankOption() {
        return randomPickOf("A", "C", "D");
    }

    public String messageDestinator() {
        return randomNumCharString(8);
    }

    public String messageIdentifier() {
        return "S" + randomNumString(15);
    }

    public String messageOriginator() {
        return randomNumCharString(8);
    }

    public String messageReceiveTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy-MM-dd HH:mm"));
    }

    public String messageSendTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy-MM-dd HH:mm"));
    }

    public String messageType() {
        return randomNumString(3);
    }

    public String orderingCustomerAccount() {
        return "/".concat(randomNumString(18));
    }

    public String orderingCustomerName() {
        return randomPickOf(fileReadAllLines("CustomerName.txt"));
    }

    public String orderingCustomerOption() {
        return randomPickOf("A", "F", "K");
    }

    public String orderingInstitutionAccount() {
        return randomPickOf(fileReadAllLines("BankAccount.txt"));
    }

    public String orderingInstitutionName() {
        return randomPickOf(fileReadAllLines("BankName.txt"));
    }

    public String orderingInstitutionOption() {
        return randomPickOf("A", "D");
    }

    public String charges(String currency) {
        return currency + (random.nextFloat() * 100);
    }

    public String receiverCorrespondentAccount() {
        return randomPickOf(fileReadAllLines("BankAccount.txt"));
    }

    public String receiverCorrespondentName() {
        return randomPickOf(fileReadAllLines("BankName.txt"));
    }

    public String receiverCorrespondentOption() {
        return randomPickOf("A", "B", "D");
    }

    public String regulatoryReporting() {
        return randomPickOf(fileReadAllLines("regulatoryReporting.txt"));
    }

    public String remittanceInformation() {
        return randomPickOf(fileReadAllLines("remittanceInformation.txt"));
    }

    public String senderCorrespondentAccount() {
        return randomPickOf(fileReadAllLines("BankAccount.txt"));
    }

    public String senderCorrespondentName() {
        return randomPickOf(fileReadAllLines("BankName.txt"));
    }

    public String senderCorrespondentOption() {
        return randomPickOf("A", "B", "D");
    }

    public String senderToReceiverInformation() {
        return randomPickOf(fileReadAllLines("senderToReceiverInformation.txt"));
    }

    public String reference() {
        return randomNumCharString(20);
    }

    public String transactionTypeCode() {
        return "S".concat(String.valueOf(randomIntInRange(1, 20)));
    }

    public String urgent() {
        return randomPickOf("URGENT", "NORMAL");
    }

    public String valueDateCurrencyInterbankSettledAmount(String currency) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMddyy")).concat(currency).concat(String.valueOf(random.nextFloat() * 10000));
    }

    public String correspondingAccount() {
        return randomNumString(20);
    }

    public String uuid() {
        return UUID.randomUUID().toString();
    }

    public int transactionId() {
        return random.nextInt(Integer.MAX_VALUE);
    }
}