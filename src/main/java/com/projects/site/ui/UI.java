package com.projects.site.ui;

import com.projects.site.service.Service;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class UI {

    Service service;

    public UI(Service service) {
        this.service = service;
    }

    public static int afisare() {
        System.out.println("0.Oprire;");
        System.out.println("1.Creare User;");
        Scanner scn = new Scanner(System.in);
        int optiune;
        System.out.println("Introduceti optiunea:");
        optiune = scn.nextInt();
        scn.close();
        return optiune;
    }

    public void start() {
        Boolean oprire= true;
        while (oprire) {
            int optiune = this.afisare();
            switch (optiune) {
                case 1: {
                    service.addUser("user", "passw", Boolean.TRUE);
                    break;
                }
                case 0: {
                    oprire = false;
                    break;
                }
            }
        }
    }
}
