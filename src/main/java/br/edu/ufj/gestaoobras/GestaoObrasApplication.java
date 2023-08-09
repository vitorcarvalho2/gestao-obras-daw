package br.edu.ufj.gestaoobras;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ufj.gestaoobras.models.Obra;
import br.edu.ufj.gestaoobras.models.Proprietario;
import br.edu.ufj.gestaoobras.repositories.ObraDAO;
import br.edu.ufj.gestaoobras.repositories.ProprietarioDAO;

@SpringBootApplication
public class GestaoObrasApplication implements CommandLineRunner {
	
    @Autowired
	private ProprietarioDAO propDAO;
	@Autowired
	private ObraDAO obraDAO;
	
	public static void main(String[] args) {
		SpringApplication.run(GestaoObrasApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		Proprietario prop1 = new Proprietario(1, "vitu", "123", "vitor@gmail.com");
		Proprietario prop2 = new Proprietario(2, "maria", "123", "maria@gmail.com");
		Proprietario prop3 = new Proprietario(3, "artur", "123", "artur@gmail.com");
		propDAO.save(prop1);
		propDAO.save(prop2);
		propDAO.save(prop3);
 
		Obra obra1 = new Obra(1,"casa","rua10","obra3",prop1);
		obraDAO.save(obra1);
	}

}
