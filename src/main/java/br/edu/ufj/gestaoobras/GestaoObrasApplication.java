package br.edu.ufj.gestaoobras;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import br.edu.ufj.gestaoobras.models.Item;
import br.edu.ufj.gestaoobras.models.Obra;
import br.edu.ufj.gestaoobras.models.Proprietario;
import br.edu.ufj.gestaoobras.models.SubItem;
import br.edu.ufj.gestaoobras.repositories.ItemDAO;
import br.edu.ufj.gestaoobras.repositories.ObraDAO;
import br.edu.ufj.gestaoobras.repositories.ProprietarioDAO;
import br.edu.ufj.gestaoobras.repositories.SubItemDAO;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class GestaoObrasApplication implements CommandLineRunner {
	
    @Autowired
	private ProprietarioDAO propDAO;
	@Autowired
	private ObraDAO obraDAO;
	@Autowired
	private ItemDAO itemDAO;
	@Autowired
	private SubItemDAO subitemDAO;
	
	public static void main(String[] args) {
		SpringApplication.run(GestaoObrasApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
	
		Proprietario prop1 = new Proprietario(1, "vitin", "123", "vitor@gmail.com");
		Proprietario prop2 = new Proprietario(2, "maria", "123", "maria@gmail.com");
		Proprietario prop3 = new Proprietario(3, "artur", "123", "artur@gmail.com");
	    propDAO.save(prop1);
		propDAO.save(prop2);
		propDAO.save(prop3);
 
		Obra obra1 = new Obra(1,"casa","rua10","obra3",prop2);
		obraDAO.save(obra1);
		
		Item item1 = new Item(1,"material-basico","");
		Item item2 = new Item(2,"mao-de-obra","");
		Item item3 = new Item(3,"pintura","");
		Item item4 = new Item(4,"acabamento","");
		Item item5 = new Item(5,"parte-eletrica","");
		itemDAO.saveAll(Arrays.asList(item1,item2,item3,item4,item5));
		
		SubItem subItem1 = new SubItem(1,"tijolo","",item1);
		SubItem subItem2 = new SubItem(2,"areia","",item1);
		SubItem subItem3 = new SubItem(3,"assentamento de piso","",item2);
		
		subitemDAO.saveAll(Arrays.asList(subItem1,subItem2,subItem3));
	}

}
