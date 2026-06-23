package dev.java10x.itauJava10x;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Component
@Repository
public class TransacaoRepository {

    List<TransacaoRequest> listaDeTransacoes = new ArrayList<>();

    //salvar os dados em uma lista
    public void salvarDados(TransacaoRequest transacaoRequest){
        listaDeTransacoes.add(transacaoRequest);
    }

    // apagar essa lista depois de 60 segundos
    public void limparDados(TransacaoRequest transacaoRequest){


    }

    //apagar todas as transacoes da lista
    public void deletarDados(){
        listaDeTransacoes.clear();
    }

}
