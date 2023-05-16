package com.projects.site;


import com.projects.site.DTO.CarteDTO;
import com.projects.site.DTO.ComandaDTO;
import com.projects.site.config.WebConfig;
import com.projects.site.controller.CarteController;
import com.projects.site.mapper.*;
import com.projects.site.model.Carte;
import com.projects.site.repository.*;
import com.projects.site.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EntityScan
@EnableJpaRepositories
@SpringBootApplication
public class SiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiteApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ReviewRepository reviewRepository, ReviewMapper reviewMapper, LoggedMapper loggedMapper, LoggedRepository loggedRepository, CarteRepository carteRepository, UserRepository userRepository, ComandaRepository comandaRepository, CarteMapper carteMapper, UserMapper userMapper, ComandaMapper comandaMapper) {
		return args -> {
			WebConfig webConfig =new WebConfig();
			webConfig.corsConfigurer();
			ServiceMasterUserCarte service = new ServiceMasterUserCarte(carteRepository, carteMapper,userMapper,userRepository);
			ServiceUser service2 =new ServiceUser(userRepository,userMapper);
			ServiceCarte service3 = new ServiceCarte(carteRepository,carteMapper);
			ServiceComanda service4 = new ServiceComanda(comandaRepository,comandaMapper,userRepository,carteRepository);
			LoggedService service5 = new LoggedService(loggedRepository,loggedMapper);
			ReviewService service6 = new ReviewService(reviewRepository,reviewMapper);
			service2.addUser("Carmen","cevaaa",Boolean.FALSE);
			service2.addUser("Iulia", "pufuleti", Boolean.TRUE);
			service2.updateParola("parola",2L);
			service2.addUser("Doruu", "pufuleticusare", Boolean.TRUE);
			service.addCarte(2L,"bibliografie",10,23,3,"Doru");
			service.addCarte(3L,"2",10,10,6,"Iulia");
			service.addCarte(3L,"sa nu mor prost",10,22,6,"Dc mergi");
			service.deleteCarte(3L);
			service.addCarte(2L,"sa nu mor prost",10,35,6,"Dc mergi");
			service3.updatePret(15,2L);
			service3.updateStare(10,2L);
			service2.updateParola("parola noua",2L);
			service4.createComanda(15);
			ComandaDTO comanda= service4.ffindFirstById(1);
			System.out.println(comanda.getPret());
			if(service2.login("Iulia","parola noua"))
				System.out.println("Da a mers login");
			else
				System.out.println("Nu a mers login");
			service5.login(1L);
			service5.logout(1L);
			service5.saveUserToXML(1L);
			service6.addReview(2l,"e de treaba");
		};
	}

}