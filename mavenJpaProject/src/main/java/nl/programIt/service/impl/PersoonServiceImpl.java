//src/main/java
package nl.programIt.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.programIt.entities.Persoon;
import nl.programIt.repository.IPersoonRepository;
import nl.programIt.service.interfaces.IPersoonService;
@Service
@Transactional
public class PersoonServiceImpl implements IPersoonService {
	
	//PersoonDaoImpl per=new PersoonDaoImpl();	
	@Autowired
	private IPersoonRepository persoonRepository;
	@Override
	public void AddPersoon(Persoon per) {
		persoonRepository.save(per);//add call persist
	}

	@Override
	public void deletePersoon(Long id) {
		persoonRepository.delete(id);
	}
	@Override
	public List<Persoon> findAllPesoon() {
		List<Persoon> list=persoonRepository.findAll();
		return list;
	}

	@Override
	public Persoon findPersoonByFirstNameLastName(String firstName,
			String LastName) {
		Persoon p=persoonRepository.findByFirstNameAndLastName(firstName, LastName);
		return p;
	}

}
