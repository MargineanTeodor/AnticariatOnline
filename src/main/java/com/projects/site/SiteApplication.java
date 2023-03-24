package com.projects.site;


import com.projects.site.repository.CarteRepository;
import com.projects.site.repository.UserRepository;
import com.projects.site.service.Service;
import com.projects.site.ui.UI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan
@EnableJpaRepositories
@SpringBootApplication
public class SiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiteApplication.class, args);
	}

	@Bean
	CommandLineRunner init(CarteRepository carteRepository, UserRepository userRepository) {
		return args -> {
			Service service = new Service(carteRepository, userRepository);
			//UI ui= new UI(service);
			//ui.start();
			service.addUser("Iulia", "pufuleti", Boolean.TRUE);
			service.addUser("Doru", "pufuleticusare", Boolean.TRUE);
			service.addCarte(service.findUserByName("Iulia"),"bibliografie",10,10,6,"Doru");
			service.addCarte(service.findUserByName("Doru"),"bibliografie",10,10,6,"Iulia");
			service.deleteCarte(1L);
			service.deleteUser(1L,service.findUserByName("Doru"));
			service.updatePret(15,2L);
			service.updateStare(10,2L);
			service.updateParola("parola noua",2L);
		};
	}

}