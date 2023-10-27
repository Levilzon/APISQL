package br.apicomsql.levi.main.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.apicomsql.levi.main.perfil.Mensagem;
import br.apicomsql.levi.main.perfil.Perfil;
import br.apicomsql.levi.main.repositorio.Repositorio;

@Service
public class Servico {
    //Conectar as ações do repositório com o serviços
    @Autowired
    private Repositorio acao;
    //Conectar as mensagens com as ações dos serviçoes
    @Autowired
    private Mensagem mensagem;

    //a função vai criar os status da operação de salvar de acordo com as situações
    public ResponseEntity<?> cadastrar(Perfil obj){
        //primeira situação caso não seja preenchido o nome
        if(obj.getNome().equals("")){
            //mensagem que mostra que é obrigatório preencher com o nome
            mensagem.setMensagem("O bloco do nome precisa ser preenchido!");
            //Vai mostrar o status da situação
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
            //segunda situação caso não seja preenchido o sobrenome
        } else if(obj.getSobrenome().equals("")){
            //Mensagem que mostra que é obrigatório preencher com o sobrenome
            mensagem.setMensagem("O bloco do sobrenome precisa ser preenchido!");
            //vai mostrar o status da situação
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
            //situação caso não seja preenchido com o estado
        } else if(obj.getEstado().equals("")){
            //mensagem indicando que precisa preencher com o estado
            mensagem.setMensagem("O bloco do estado precisa ser preenchido!");
            //Status da situação
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
            //caso tudo seja preenchido corretamente
        } else {
            // vai mostrar o status de ter sido cadastrado/criado a nova entidade
            return new ResponseEntity<>(acao.save(obj), HttpStatus.CREATED);

        }
    }
}
