package com.projects.site;


import com.projects.site.mapper.CarteMapper;
import com.projects.site.mapper.ComandaMapper;
import com.projects.site.mapper.UserMapper;
import com.projects.site.repository.CarteRepository;
import com.projects.site.repository.ComandaRepository;
import com.projects.site.repository.UserRepository;
import com.projects.site.service.ServiceComanda;
import com.projects.site.service.ServiceMasterUserCarte;
import com.projects.site.service.ServiceCarte;
import com.projects.site.service.ServiceUser;
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
	CommandLineRunner init(CarteRepository carteRepository, UserRepository userRepository, ComandaRepository comandaRepository, CarteMapper carteMapper, UserMapper userMapper, ComandaMapper comandaMapper) {
		return args -> {
			ServiceMasterUserCarte service = new ServiceMasterUserCarte(carteRepository, carteMapper,userMapper,userRepository);
			ServiceUser service2 =new ServiceUser(userRepository,userMapper);
			ServiceCarte service3 = new ServiceCarte(carteRepository,carteMapper);
			ServiceComanda service4 = new ServiceComanda(comandaRepository,comandaMapper);
			//UI ui= new UI(service);
			//ui.start();
			service2.addUser("Iulia", "pufuleti", Boolean.TRUE);
			service2.addUser("Carmen","ceva",Boolean.FALSE);
			service2.updateParola("parola",2L);
			//service.addUser("Doru", "pufuleticusare", Boolean.FALSE);
			service2.addUser("Doru", "pufuleticusare", Boolean.TRUE);
			service.addCarte(service2.findUserByName("Iulia"),"bibliografie",10,10,6,"Doru");
			service.addCarte(service2.findUserByName("Doru"),"bibliografie",10,10,6,"Iulia");
			service3.updatePret(15,2L);
			service3.updateStare(10,2L);
			service2.updateParola("parola noua",2L);
			service4.createComanda(service2.findUserByName("Doru"),UserMapper.mapDtoToModel(service2.findUserByName("Doru")).getCarteList());
			service4.updatePlata(1);
			if(service2.login("Iulia","pufuleti"))
			//if(service2.login("Iulia","pufulei"))
				System.out.println("Da a mers login");
			else
				System.out.println("Nu a mers login");
		};
	}

}