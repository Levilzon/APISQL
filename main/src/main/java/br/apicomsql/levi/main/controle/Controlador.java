package br.apicomsql.levi.main.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.apicomsql.levi.main.perfil.Perfil;
import br.apicomsql.levi.main.repositorio.Repositorio;

@RestController
@RequestMapping(value = "/pcaminho")
public class Controlador {
    
    @Autowired
    private Repositorio acao;
    @GetMapping("/teste")
    public String olaMundo(){
        return "ola mundo";
    }

    @PostMapping("/salvar")
    public Perfil cadastrar(@RequestBody Perfil obj){
        return acao.save(obj);
    }

    
    
}
