package br.apicomsql.levi.main.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/lista")
    public List<Perfil> selecionar(){
        return acao.findAll();
    }

    @GetMapping("/lista/{id}")
    public Perfil selecionarId(@PathVariable int id){
        return acao.findById(id);
    }

    @PutMapping("/salvar")
    public Perfil editar(@RequestBody Perfil obj){
        return acao.save(obj);

    }

    @PostMapping("/salvar")
    public Perfil cadastrar(@RequestBody Perfil obj){
        return acao.save(obj);
    }

    @DeleteMapping("/lista/delete/{id}")
    public void remover(@PathVariable int id){
        Perfil obj = selecionarId(id);
        acao.delete(obj);

    }

    @GetMapping("/lista/contador")
    public long contador(){
        return acao.count();

    }
    
    
}
