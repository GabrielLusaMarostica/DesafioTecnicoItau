package dev.java10x.itauJava10x.Transacoes;

import dev.java10x.itauJava10x.Estatisticas.EstatisticaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {


    @Autowired
    TransacaoRepository transacaoRepository;


    public void validarTransacao(TransacaoRequest transacaoRequest) {
        if (transacaoRequest.getValor() == null) {
            throw new IllegalArgumentException("Erro: O valor da transacao nao pode ser nulo");
        }
        if (transacaoRequest.getDataHora() == null) {
            throw new IllegalArgumentException("Erro: A data da transacao nao pode ser nula");
        }
        if (transacaoRequest.getValor().compareTo(BigDecimal.ZERO) < 0) {
            //transacao nao é valida
            throw new IllegalArgumentException("Erro: Transacoes devem ter valor maior que 0");
        }
        if (transacaoRequest.getDataHora().isAfter(OffsetDateTime.now())) {
            throw new IllegalArgumentException("Erro: Transacoes nao podem ser feitas no futuro");
        }
    }

    public void salvarDados(TransacaoRequest transacaoRequest) {
        transacaoRepository.salvarDados(transacaoRequest);
    }

    public void deletarTransacoes() {
        transacaoRepository.deletarDados();
    }

    public EstatisticaDTO estatistica(OffsetDateTime horaInicial) {

        if (transacaoRepository.listaDeTransacoes.isEmpty()) {
            return new EstatisticaDTO(0L, 0, 0, 0, 0);
        }

        //pega a lista inteira e especifica as transacoes que estao nos ultimos 60 segundos, depois usa um metodo que fornece varios calculos automaticos pra fazer
        final var summary = transacaoRepository.listaDeTransacoes.stream()
                .filter(t ->
                        t.getDataHora().isAfter(horaInicial) || t.getDataHora().isEqual(horaInicial)
                )
                .mapToDouble(t -> t.getValor().doubleValue())
                //summarystatistics serve para fazer varios calculos que serao feitos na sequencia
                .summaryStatistics();

        return new EstatisticaDTO(
                summary.getCount(),
                summary.getAverage(),
                summary.getMax(),
                summary.getMin(),
                summary.getSum()
        );

    }


}
