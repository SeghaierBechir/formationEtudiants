package demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import demo.dao.EtudiantRepository;
import demo.dao.FormationRepository;
import demo.entities.Etudiant;
import demo.entities.Formation;

@SpringBootApplication
public class FormationEtudiantApplication implements CommandLineRunner {
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private FormationRepository formationRepository;
	@Autowired
	private RepositoryRestConfiguration configuration;

	public static void main(String[] args) {
		SpringApplication.run(FormationEtudiantApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		configuration.exposeIdsFor(Etudiant.class,Formation.class);
		// TODO Auto-generated method stub
		Formation f1=formationRepository.save(new Formation(null,"PHP",30,null));
		Formation f2=formationRepository.save(new Formation(null,"JAVA",40,null));
		Formation f3=formationRepository.save(new Formation(null,"PYTHON",20,null));
		DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
		etudiantRepository.save(new Etudiant(null,"anaîs","dupont",df.parse("1999-07-12"),f1));
		etudiantRepository.save(new Etudiant(null,"bruel","Anis",df.parse("1982-04-12"),f2));
		etudiantRepository.save(new Etudiant(null,"jack","Kamel",df.parse("1998-08-22"),f3));
		
		etudiantRepository.save(new Etudiant(null,"lionel","dupont",df.parse("1999-07-12"),f1));
		etudiantRepository.save(new Etudiant(null,"Imen","Anis",df.parse("1982-04-12"),f2));
		etudiantRepository.save(new Etudiant(null,"kamel","Kamel",df.parse("1998-08-22"),f3));
		
	}

}
