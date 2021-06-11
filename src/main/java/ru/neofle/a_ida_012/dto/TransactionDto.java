package ru.neofle.a_ida_012.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDto {
    @NotNull/**/
    private AmountDto amount;

    @NotNull
    @Pattern(regexp = "\\d{20}$")/*Корреспондирующий счёт*/
    private String correspondingAccount;

    @NotNull/**/
    private SwiftTransferDto swiftTransfer;

    @NotNull
    @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")/*UUID*/
    private String uuid;

    @NotNull/*Идентификатор операции*/
    private int transactionId;
}
