package br.apicomsql.levi.main.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.apicomsql.levi.main.perfil.Perfil;

@Repository
public interface Repositorio extends CrudRepository<Perfil, Integer>{
    //vai listar as informações
    List<Perfil> findAll();
    //está sendo usado para pesquisar uma pessoa por meio do id
    Perfil findById(int id);
    //usado para organizar os nomes em ordem alfabética 
    List<Perfil> findByOrderByNome();
    //vai listar apenas pessoas que possuem a inicial escolhida
    List<Perfil> findByNomeStartsWith(String termo);
    //usado para listar apenas pessoas com a letra final do nome(variavel nome)
    List<Perfil> findByNomeEndsWith(String termo);
    
}
