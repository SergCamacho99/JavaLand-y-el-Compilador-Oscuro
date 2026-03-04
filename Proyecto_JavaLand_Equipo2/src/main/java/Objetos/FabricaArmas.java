package Objetos;

public class FabricaArmas {

    Espada[] espadas;
    Escudo[] escudos;
    
    
    public static Espada[] crearEspadas() {

        Espada[] listaEspadas = new Espada[5];

        listaEspadas[0] = new Espada("Espada Zangetsu",10);
        listaEspadas[1] = new Espada("Gun Blade",20);
        listaEspadas[2] = new Espada("Espada Monado",30);
        listaEspadas[3] = new Espada("Espada Excalibur",40);
        listaEspadas[4] = new Espada("Buster Sword",50);

        return listaEspadas;
    }

    public static Escudo[] crearEscudos() {

        Escudo[] listaEscudos = new Escudo[5];

        listaEscudos[0] = new Escudo("Escudo de SOLDADO",10);
        listaEscudos[1] = new Escudo("Escudo de Caballero",20);
        listaEscudos[2] = new Escudo("Escudo Hyliano",30);
        listaEscudos[3] = new Escudo("Escudo Real",40);
        listaEscudos[4] = new Escudo("Escudo del Rey Demonio",50);

        return listaEscudos;
    }
}
