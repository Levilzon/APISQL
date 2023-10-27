package br.apicomsql.levi.main.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import br.apicomsql.levi.main.servico.Servico;


@RestController
@RequestMapping(value = "/pcaminho")
public class Controlador {
    //conexão das ações do repositório com o controlador
    @Autowired
    private Repositorio acao;
    
    //A partir daqui as ações da api vão começar a mostrar o seus status de ação
    //por meio dos serviços (CREATED, BAD_REQUEST,etc)
    @Autowired
    private Servico serv;
    
    
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
    //vai salvar uma nova entidade
    @PostMapping("/salvar")
    public ResponseEntity<?> editar(@RequestBody Perfil obj){
        //implementação do serviço CREATED e
        // caso não seja atendido algumas regras(BAD_REQUEST)
        return serv.cadastrar(obj);

    }
    //vai editar as informações da entidade selecionada
    @PutMapping("/salvar")
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
    //vai ser usado para pesquisar e filtrar pessoas que estão no mesmo estado
    @GetMapping("/lista/estado/{estado}")
    public List<Perfil> selecionarPorEstado(@PathVariable String estado){
        return acao.selecionarApenasPorEstado(estado);
    }
    @GetMapping("/status")
    public String status(){
        return "configurando status";
    }
}
