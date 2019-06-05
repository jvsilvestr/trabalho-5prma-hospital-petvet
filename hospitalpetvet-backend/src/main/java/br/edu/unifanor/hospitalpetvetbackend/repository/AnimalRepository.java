package br.edu.unifanor.hospitalpetvetbackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.unifanor.hospitalpetvetbackend.entity.Animal;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long> {

}