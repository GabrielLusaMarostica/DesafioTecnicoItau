package dev.java10x.itauJava10x.Transacoes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/transacao")
public class TransacoesController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity adicionar(@RequestBody TransacaoRequest transacaoRequest){
        try{
            log.info("Transacao foi adicionado com sucesso");
            transacaoService.validarTransacao(transacaoRequest);
            transacaoService.salvarDados(transacaoRequest);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch(IllegalArgumentException exception){
            log.error("Erro na validação: " + exception);
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        } catch (Exception e){
            log.error("Erro na validação: " + e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping
    public ResponseEntity deletar(){
        log.info("Todas as transacoes foram excluidas");
        transacaoService.deletarTransacoes();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
