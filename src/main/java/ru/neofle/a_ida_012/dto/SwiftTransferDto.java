package ru.neofle.a_ida_012.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SwiftTransferDto {
    @NotNull/*Код банковской операции (формат MT103)*/
    @Pattern(regexp = "CRED")
    private String bankOperationCode;

    @Nullable/*Номер счета банка бенефициара*/
    private String beneficiaryBankAccount;

    @Nullable/*Код BIC, расположение или название и адрес банка бенефициара*/
    private String beneficiaryBankName;

    @Nullable
    @Pattern(regexp = "^\\w[A-Z]$")/*Признак вида поля банка бенефициара*/
    private String beneficiaryBankOption;

    @Nullable/*Номер счета бенефициара*/
    private String beneficiaryCustomerAccount;

    @Nullable/*Код BIC/BEI или название и адрес бенефициара*/
    private String beneficiaryCustomerName;

    @Nullable
    @Pattern(regexp = "^\\w[A-Z]{3}$")/*Сведения о расходах*/
    private String detailsOfCharges;

    @Nullable
    @Pattern(regexp = "^\\d*.\\d{1,2}$")/*Курс конвертации*/
    private String exchangeRate;

    @Nullable/*Валюта/сумма по инструкции*/
    private String instructedAmount;

    @Nullable
    @Pattern(regexp = "^\\w[A-Z]{4}$")/*Код инструкции*/
    private String instructionCode;

    @Nullable
    @Pattern(regexp = "^\\w[A-Z]{8}$")/*Номер счета банка-посредника*/
    private String intermediaryBankAccount;

    @Nullable/*Код BIC или название банка-посредника*/
    private String intermediaryBankName;

    @Nullable
    @Pattern(regexp = "^\\w[A-Z]$")/*Признак вида поля банка-посредника*/
    private String intermediaryBankOption;

    @Nullable/*Получатель сообщения SWIFT*/
    private String messageDestinator;

    @Nullable/*Уникальный системный номер сообщения SWIFT*/
    private String messageIdentifier;

    @Nullable/*Отправитель сообщения SWIFT*/
    private String messageOriginator;

    @Nullable
    @DateTimeFormat(pattern = "yy-MM-dd HH:mm")
    @Pattern(regexp = "^\\d\\d-\\d\\d-\\d\\d \\d:\\d$")/*Дата и время получения сообщения SWIFT*/
    private String messageReceiveTime;

    @Nullable
    @DateTimeFormat(pattern = "yy-MM-dd HH:mm")
    @Pattern(regexp = "^\\d\\d-\\d\\d-\\d\\d \\d:\\d$")/*Дата и время отправки сообщения SWIFT*/
    private String messageSendTime;

    @Nullable/*Тип сообщения SWIFT*/
    private String messageType;

    @Nullable/*Номер счета плательщика в формате*/
    private String orderingCustomerAccount;

    @Nullable/*Код BIC/BEI или название и адрес плательщика*/
    private String orderingCustomerName;

    @Nullable
    @Pattern(regexp = "^\\w[A-Z]$")/*Признак вида поля плательщика*/
    private String orderingCustomerOption;

    @Nullable/*Номер счета банка плательщика*/
    private String orderingInstitutionAccount;

    @Nullable/*Код BIC или название и адрес банка плательщика*/
    private String orderingInstitutionName;

    @Nullable
    @Pattern(regexp = "^\\w[A-Z]$")/*Признак вида поля банка плательщика*/
    private String orderingInstitutionOption;

    @Nullable
    @Pattern(regexp = "^\\w[A-Z]{3}\\d+,\\d{1,2}$")/*Расходы получателя*/
    private String receiverCharges;

    @Nullable/*Номер счета корреспондента получателя*/
    private String receiverCorrespondentAccount;

    @Nullable/*Код BIC, расположение или название и адрес корреспондента получателя*/
    private String receiverCorrespondentName;

    @Nullable
    @Pattern(regexp = "^\\w[A-Z]$")/*Признак вида поля корреспондента*/
    private String receiverCorrespondentOption;

    @Nullable/*Контрольная отчетность*/
    private String regulatoryReporting;

    @Nullable/*Сведения о переводе*/
    private String remittanceInformation;

    @Nullable
    @Pattern(regexp = "^\\w[A-Z]{3}\\d+,\\d{1,2}$")/*Расходы отправителя*/
    private String senderCharges;

    @Nullable/*Номер счета корреспондента отправителя*/
    private String senderCorrespondentAccount;

    @Nullable/*Код BIC, расположение или название и адрес корреспондента отправителя*/
    private String senderCorrespondentName;

    @Nullable
    @Pattern(regexp = "^\\w[A-Z]$")/*Признак вида поля корреспондента отправителя*/
    private String senderCorrespondentOption;

    @Nullable/*Информация отправителя получателю*/
    private String senderToReceiverInformation;

    @Nullable/*Референс операции*/
    private String transactionReferenceNumber;

    @Nullable/*Связанный референс*/
    private String transactionRelatedReference;

    @Nullable/*Код типа операции*/
    private String transactionTypeCode;

    @Nullable
    @Pattern(regexp = "^\\w[A-Z]{6}$")/*Признак срочности операции*/
    private String urgent;

    @Nullable/*Дата валютирования, код валюты, сумма межбанковского расчета*/
    private String valueDateCurrencyInterbankSettledAmount;
}
