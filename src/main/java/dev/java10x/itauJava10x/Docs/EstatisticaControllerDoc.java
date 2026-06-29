package dev.java10x.itauJava10x.Docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Estatisticas",
        description = "Endingpoints responsaveis por calcular estatisticas de transacoes")
public interface EstatisticaControllerDoc {

    @Operation(summary = "Calcula estatisticas",
            description = "Calcula estatistica e retorna para o cliente")
    @ApiResponse(responseCode = "200",
            description = "Estatisticas calculadas com sucesso")
    ResponseEntity<Void> estatistica();

}
