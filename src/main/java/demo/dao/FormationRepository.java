package demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import demo.entities.Formation;
@CrossOrigin("*")
@RepositoryRestResource
public interface FormationRepository extends JpaRepository<Formation, Long> {

}
