package com.projects.site.service;

import com.projects.site.model.Carte;
import com.projects.site.model.User;
import com.projects.site.repository.CarteRepository;
import com.projects.site.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ServiceTest {

    public static final Boolean ADMIN= Boolean.TRUE;
    private static final String USERNAME= "Iulia";
    private static final String USERNAMEINEXISTEN= "Doru";
    private static final String PASSW= "ceva";
    private static final String PASSWINEXISTENT= "altcvceva";
    private static final String AUTOR= "Caragiale";
    private static final String NUME= "O noapte furtunoasa";
    private static final int NRPAG = 100;
    private static final int STARE = 5;
    private static final int PRET = 10;
    private static final String AUTORINEXISTENT= "Slavici";
    private static final String NUMEINEXISTENT= "Moara cu noroc";
    private static final int NRPAGINEXISTENT = 1000;
    private static final int STAREINEXISTENT = 6;
    private static final int PRETINEXISTENT = 11;



    private ServiceMasterUserCarte service;
    private ServiceUser service2;
    private ServiceCarte service3;

    @Mock
    private UserRepository userRepository ;
    @Mock
    private CarteRepository carteRepository;
    private User user;
    private Carte carte;

    @BeforeEach
    void init() {
        initMocks(this);
        user = new User();
        user.setName(USERNAME);
        user.setPassw(PASSW);
        user.setAdmin(ADMIN);
        user.setCarteList(new ArrayList<>());
        carte = new Carte();
        carte.setUser(user);
        carte.setPret(PRET);
        carte.setStare(STARE);
        carte.setAutor(AUTOR);
        carte.setName(NUME);
        carte.setNrPag(NRPAG);
        when(this.userRepository.findFirstByName(USERNAME)).thenReturn(user);
        when(this.carteRepository.findFirstByName(NUME)).thenReturn(carte);
        when(this.carteRepository.findFirstByAutor(AUTOR)).thenReturn(carte);
        when(this.carteRepository.findFirstById(1L)).thenReturn(carte);
        when(this.carteRepository.findFirstById(2L)).thenReturn(carte);
        when(this.userRepository.findFirstById(1L)).thenReturn(user);

    }

    @Test
    void givenExistingUsername_whenFindByName_thenFindOne()
    {
        service = new ServiceMasterUserCarte(carteRepository,userRepository);
        service2 = new ServiceUser(userRepository);
        service2.addUser(USERNAME,PASSW,ADMIN);
        User user1= service2.findUserByName(USERNAME);
        assertNotNull(user1);
        assertEquals(USERNAME, user1.getName());
        assertEquals(PASSW,user1.getPassw());
        assertNotEquals(USERNAMEINEXISTEN,user1.getName());
        assertNotEquals(PASSWINEXISTENT,user1.getPassw());
    }

    @Test
    void givenExistingCarte_whenFindByName_thenFindOne(){
        service = new ServiceMasterUserCarte(carteRepository,userRepository);
        service2= new ServiceUser(userRepository);
        service3=new ServiceCarte(carteRepository);
        service2.addUser(USERNAME,PASSW,ADMIN);
        service.addCarte(user,NUME,PRET,NRPAG,STARE,AUTOR);
        Carte carti1 = new Carte();
        carti1= service3.findFirstCarteByName(NUME);
        assertNotNull(carti1);
        assertEquals(carti1.getName(),NUME);
        assertNotEquals(carti1.getName(),NUMEINEXISTENT);
        assertEquals(carti1.getPret(),PRET);
        assertNotEquals(carti1.getPret(),PRETINEXISTENT);
        assertEquals(carti1.getStare(),STARE);
        assertNotEquals(carti1.getStare(),STAREINEXISTENT);
        assertEquals(carti1.getNrPag(),NRPAG);
        assertNotEquals(carti1.getNrPag(),NRPAGINEXISTENT);
        assertEquals(carti1.getAutor(),AUTOR);
        assertNotEquals(carti1.getAutor(),AUTORINEXISTENT);
    }

    @Test
    void test_FindCarteByAutor()
    {
        service = new ServiceMasterUserCarte(carteRepository,userRepository);
        service2 = new ServiceUser(userRepository);
        service3=new ServiceCarte(carteRepository);
        service2.addUser(USERNAME,PASSW,ADMIN);
        service.addCarte(user,NUME,PRET,NRPAG,STARE,AUTOR);
        Carte carte1= service3.findFirstCarteByAutor(AUTOR);
        assertNotNull(carte1);
    }
    @Test
    void test_FindAllByAutor()
    {
        service = new ServiceMasterUserCarte(carteRepository,userRepository);
        service2 = new ServiceUser(userRepository);
        service3 = new ServiceCarte(carteRepository);
        service2.addUser(USERNAME,PASSW,ADMIN);
        service.addCarte(user,NUME,PRET,NRPAG,STARE,AUTOR);
        List<Carte> carte1= service3.findCarteByAutor(AUTOR);
        assertNotNull(carte1);
    }
    @Test
    void test_FindAllByName()
    {
        service = new ServiceMasterUserCarte(carteRepository,userRepository);
        service3=new ServiceCarte(carteRepository);
        service2 = new ServiceUser(userRepository);
        service2.addUser(USERNAME,PASSW,ADMIN);
        service.addCarte(user,NUME,PRET,NRPAG,STARE,AUTOR);
        List<Carte> carte1= service3.findCarteByName(NUME);
        assertNotNull(carte1);
    }

    @Test
    void test_updatePret()
    {
        service = new ServiceMasterUserCarte(carteRepository,userRepository);
        service2 = new ServiceUser(userRepository);
        service3=new ServiceCarte(carteRepository);
        service2.addUser(USERNAME,PASSW,ADMIN);
        service.addCarte(user,NUME,PRET,NRPAG,STARE,AUTOR);
        Carte carte1= new Carte();
        carte1.setPret(carte.getPret());
        service3.updatePret(PRETINEXISTENT,1L);
        Carte carte2= service3.findFirstCarteByName(NUME);
        assertNotEquals(carte1.getPret(),carte2.getPret());
    }

    @Test
    void test_updateStare()
    {
        service = new ServiceMasterUserCarte(carteRepository,userRepository);
        service2 = new ServiceUser(userRepository);
        service3=new ServiceCarte(carteRepository);
        service2.addUser(USERNAME,PASSW,ADMIN);
        service.addCarte(user,NUME,PRET,NRPAG,STARE,AUTOR);
        Carte carte1= new Carte();
        carte1.setStare(carte.getStare());
        service3.updateStare(STAREINEXISTENT,1L);
        Carte carte2= service3.findFirstCarteByName(NUME);
        assertNotEquals(carte1.getStare(),carte2.getStare());
    }

    @Test
    void test_updateParola()
    {
        service = new ServiceMasterUserCarte(carteRepository,userRepository);
        service2 =new ServiceUser(userRepository);
        service2.addUser(USERNAME,PASSW,ADMIN);
        User user1 = new User();
        user1.setPassw(user.getPassw());
        service2.updateParola(PASSWINEXISTENT,1L);
        User user2 = service2.findUserByName(USERNAME);
        assertNotEquals(user1.getPassw(),user2.getPassw());

    }


// test pe tipul 2 de testare
    @Test
    void givenNonExistingMarca_whenFindByMarca_thenThrowException() {
        when(carteRepository.findFirstByName(NUME)).thenReturn(null);
        Exception exception = assertThrows(NullPointerException.class, () -> {
            service3.findFirstCarteByName(NUME);
        });
    }
}
