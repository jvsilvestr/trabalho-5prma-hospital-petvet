package br.edu.unifanor.hospitalpetvet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.unifanor.hospitalpetvet.entity.Tutor;

@Repository
public interface TutorRepository extends CrudRepository<Tutor, Long> {
	
}
