package dev.java10x.itauJava10x.Transacoes;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoRequest {

    @NotNull(message = "O valor da transação deve ser igual ou maior a 0")
    @Positive
    private BigDecimal valor;
    private OffsetDateTime dataHora;

}
