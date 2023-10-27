package br.apicomsql.levi.main.perfil;

import org.springframework.stereotype.Component;
//Essa classe vai ficar responsável por enviar a mensagem de "erro" na parte dos serviços
@Component
public class Mensagem {
    private String mensagem;

    public String getMensagem(){
        return this.mensagem;
    }

    public void setMensagem(String mensagem){
        this.mensagem = mensagem;
    }
}
