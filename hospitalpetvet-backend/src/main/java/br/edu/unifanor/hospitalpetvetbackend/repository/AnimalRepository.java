package br.edu.unifanor.hospitalpetvetbackend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.unifanor.hospitalpetvetbackend.entity.Animal;
import br.edu.unifanor.hospitalpetvetbackend.entity.Tutor;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long> {
    List<Animal> findAllByTutor(Tutor tutor);
}