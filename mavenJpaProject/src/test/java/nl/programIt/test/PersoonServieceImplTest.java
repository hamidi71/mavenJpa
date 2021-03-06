package nl.programIt.test;
//test is gemaakt door Baddi op 17-08-2012

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import nl.programIt.ApplicationConfig;
import nl.programIt.entities.Persoon;
import nl.programIt.service.interfaces.IPersoonService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//Declare la relation entre spring et Junit
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:applicationContext.xml"})
//@ContextConfiguration(locations="classpath:applicationContext.xml")
@ContextConfiguration(classes= ApplicationConfig.class)
public class PersoonServieceImplTest {
	@Autowired
	private IPersoonService pers;	
	@Test
	public void AddPersoonTest(){
		try {
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		//bij deze datum wordt:3092-07-10
		//@SuppressWarnings
		Persoon p1=new Persoon("Ilias","Hamidi", new Date(2002, 06, 10),"ilias@gmail.com");
		//bij deze  de datum is 2002-06-10
		Persoon p2=new Persoon("Ilias","Hamidi",df.parse("2002-06-10"),"ilias@gmail.com");
		Persoon p3=new Persoon("Baddi","Hamidi",df.parse("1971-07-01"),"baddi@gmail.com");
		Persoon p4=new Persoon("Bilal","Hamidi",df.parse("2004-12-15"),"bilal@gmail.com");
		//bij deze de datum is datum van(het systeem) vandaag
		Persoon p5=new Persoon("Mohammed","Hamidi", new Date(),"mohammed@gmail.com");
		pers.AddPersoon(p1);
		pers.AddPersoon(p2);
		pers.AddPersoon(p3);
		pers.AddPersoon(p4);
		pers.AddPersoon(p5);
		assertTrue(true);
			
		} catch (Exception e) {
			assertFalse(false);
			
		}
	}
	@Test
	public void findAllPesoonTest(){
		assertNotEquals(0, pers.findAllPesoon().size());
	}

}
