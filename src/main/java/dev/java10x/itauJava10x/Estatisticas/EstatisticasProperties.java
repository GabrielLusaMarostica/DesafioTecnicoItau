package dev.java10x.itauJava10x.Estatisticas;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "estatistica")
public record EstatisticasProperties(@NotNull(message = "Os segundos não podem ser nulos")
                                     @Min(value = 1, message = "O tempo deve ser de no mínimo 1 segundo")
                                     Integer segundos) {
}
