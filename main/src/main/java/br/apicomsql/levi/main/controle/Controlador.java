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
    //conexão das ações do repositório com o controlador
    @Autowired
    private Repositorio acao;
    //Função para saber se a API está funcionando
    @GetMapping("/teste")
    public String olaMundo(){
        return "ola mundo";
    }
    //vai mostrar as informações add no banco 
    @GetMapping("/lista")
    public List<Perfil> selecionar(){
        return acao.findAll();
    }
    //vai listar as informações do banco por ordem alfabética
    @GetMapping("/lista/ordenarnomes")
    public List<Perfil> ordenarPorNome(){
        return acao.findByOrderByNome();
    }
    //usado para pesquisar a entidade por meio do ID
    @GetMapping("/lista/{id}")
    public Perfil selecionarId(@PathVariable int id){
        return acao.findById(id);
    }
    //vai editar a informação de alguma entidade
    @PutMapping("/salvar")
    public Perfil editar(@RequestBody Perfil obj){
        return acao.save(obj);

    }
    //vai salvar uma nova entidade
    @PostMapping("/salvar")
    public Perfil cadastrar(@RequestBody Perfil obj){
        return acao.save(obj);
    }
    //vai deletar uma entidade
    @DeleteMapping("/lista/delete/{id}")
    public void remover(@PathVariable int id){
        Perfil obj = selecionarId(id);
        acao.delete(obj);

    }
    //vai contar a quantidade de entidades que tem presente no banco
    @GetMapping("/lista/contador")
    public long contador(){
        return acao.count();

    }
    //vai mostrar a entidades que possuem tal inicial
    @GetMapping("/lista/pesquisarinicial/{termo}")
    public List<Perfil> pesquisarInicialDoNome(@PathVariable String termo){
        return acao.findByNomeStartsWith(termo);
    }
    //vai mostrar as entidades que possuem a letra final que for utilizada
    @GetMapping("/lista/pesquisarfinal/{termo}")
    public List<Perfil> pesquisarComLetraFinalDoNome(@PathVariable String termo){
        return acao.findByNomeEndsWith(termo);
    }
    
}
