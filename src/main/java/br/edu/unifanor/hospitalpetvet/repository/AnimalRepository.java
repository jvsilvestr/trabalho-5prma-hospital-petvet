package br.edu.unifanor.hospitalpetvet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.unifanor.hospitalpetvet.entity.Animal;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long> {
	
}
