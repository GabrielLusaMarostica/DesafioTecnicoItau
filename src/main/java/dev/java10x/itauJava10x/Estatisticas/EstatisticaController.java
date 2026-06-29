package dev.java10x.itauJava10x.Estatisticas;

import dev.java10x.itauJava10x.Docs.EstatisticaControllerDoc;
import dev.java10x.itauJava10x.Transacoes.TransacaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@Slf4j
@RestController
@RequestMapping("/estatistica")
public class EstatisticaController implements EstatisticaControllerDoc {
    @Autowired
    private EstatisticasProperties estatisticasProperties;

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping
    public ResponseEntity estatistica(){

        // log de requisicao criado via lombok
        log.info("Calculando estatisticas de transacoes dos ultimos " + estatisticasProperties.segundos());

        //calcular quantas transacoes acontecem em N segundos
        final var horaInicial = OffsetDateTime.now().minusSeconds(estatisticasProperties.segundos());
        return ResponseEntity.ok(transacaoService.estatistica(horaInicial));
    }

}
