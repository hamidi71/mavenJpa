package nl.programIt.repository;

import nl.programIt.entities.Persoon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IPersoonRepository extends JpaRepository<Persoon, Long> {
	public Persoon findByFirstNameAndLastName(String firstName,String LastName);
}
