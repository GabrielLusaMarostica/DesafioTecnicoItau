package dev.java10x.itauJava10x;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    public void validarTransacao(TransacaoRequest transacaoRequest){
        if(transacaoRequest.getValor() == null){
               throw new IllegalArgumentException("Erro: O valor da transacao nao pode ser nulo");
        }
        if(transacaoRequest.getDataHora() == null){
            throw new IllegalArgumentException("Erro: A data da transacao nao pode ser nula");
        }
        if(transacaoRequest.getValor().compareTo(BigDecimal.ZERO) < 0){
            //transacao nao é valida
            throw new IllegalArgumentException("Erro: Transacoes devem ter valor maior que 0");
        }
        if(transacaoRequest.getDataHora().isAfter(OffsetDateTime.now())){
            throw new IllegalArgumentException("Erro: Transacoes nao podem ser feitas no futuro");
        }

    }

}
