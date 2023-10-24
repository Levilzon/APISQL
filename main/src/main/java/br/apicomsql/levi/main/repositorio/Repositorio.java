package br.apicomsql.levi.main.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
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
    //primeiro uso do comando Query em que ele me permite usar códigos do SQL
    //comando usando em questão foi SELECT com filtro de pesquisar quem tem xxx estado
    @Query(value = "SELECT * FROM perfil WHERE estado = :estado", nativeQuery = true)
    List<Perfil> selecionarApenasPorEstado(String estado);
}
