package ru.neofle.a_ida_012.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AmountDto {
    @NotNull
    @Positive /*Сумма*/
    private float amount;

    @NotNull
    @Pattern(regexp = "^\\w[A-Z]{3}$") /*Буквенный ISO-код валюты*/
    private String currencyName;
}
