//src/main/java
//Baddi 18-08-2016
package nl.programIt.service.interfaces;

import java.util.List;
import nl.programIt.entities.Persoon;

public interface IPersoonService {
	public void AddPersoon(Persoon per);
	public void deletePersoon(Long id);
	public List<Persoon> findAllPesoon();
	public Persoon findPersoonByFirstNameLastName(String firstName,String lastName);
	
}
