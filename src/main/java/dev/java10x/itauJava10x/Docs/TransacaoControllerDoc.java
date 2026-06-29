package dev.java10x.itauJava10x.Docs;

import dev.java10x.itauJava10x.Transacoes.TransacaoRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Transações",
        description = "Endingpoints responsaveis por criar transacoes")
public interface TransacaoControllerDoc {

    @Operation(summary = "Cria transacoes",
            description = "Recebe uma transacao valida e adiciona em uma lista")
    @ApiResponse(responseCode = "201",
            description = "Transacao criada com sucesso")
    @ApiResponse(responseCode = "422",
            description = "Erro de validação capturado")
    @ApiResponse(responseCode = "400",
            description = "Erro inesperado no servidor")
    ResponseEntity<Void> adicionar(@RequestBody TransacaoRequest transacaoRequest);

    @Operation(summary = "Remove todas as transacoes",
            description = "Remove todas as transacoes que existem na lista")
    @ApiResponse(responseCode = "200",
            description = "Transacaoes deletadas com sucesso")
    ResponseEntity<Void> deletar();


}
