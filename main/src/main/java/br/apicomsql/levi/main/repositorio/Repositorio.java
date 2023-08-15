package br.apicomsql.levi.main.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.apicomsql.levi.main.perfil.Perfil;

@Repository
public interface Repositorio extends CrudRepository<Perfil, Integer>{

    //Object save = null;

    
}
