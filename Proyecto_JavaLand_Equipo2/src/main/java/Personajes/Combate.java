/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personajes;

import Objetos.Inventario;
import Objetos.Objeto;
import Objetos.PlantaCurativa;
import interfaces.CombateInterface;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author dam125
 */
public class Combate implements CombateInterface {
    //declaro varios atributos, tiene exito para saber quien gana el combate, orden para el orden de los turnos
    //contador especial para el cooldow de las habilidades, stun para una habilidad y no hayplanta para saber si puedes curarte o no
    Scanner teclado = new Scanner(System.in);
    Random random = new Random();
    public Inventario inventario;
    public boolean tieneExito;
    public int orden;
    public int contadorEspecial;
    public int stun;
    public boolean noHayPlanta;
    //en el constructor introducimos el inventario para poder usar la planta curativa e inicializo los atributos a lo que se necesita para empezar un combate
    public Combate(Inventario inventario) {
        this.inventario = inventario;
        tieneExito = false;
        orden = 0;
        contadorEspecial = 0;
        stun = 0;
        noHayPlanta = false;
    }

    @Override
    public void turno(Valiente valiente, Monstruo monstruo) {
        //estos dos atributos son numeros para saber si se acierta, la habilidad especial tiene el doble de posibilidades de acertar
        //el calculo es el numero que tiene que superar el numeroaleatorio para acertar
        int numeroAleatorio;
        int numeroAleatorioEspecial;
        double calculo;
        if (this.orden == 0) {
            //aqui dependiendo del orden es el turno de uno o de otro asi que calculamos lo que hace el monstruo, si esta stun no puede atacar 
            //y dependiendo del numero aleatorio ataca o falla
            numeroAleatorio = random.nextInt(101);
            calculo = 4 * monstruo.getHabilidad() - (valiente.getDefensaTotal()); //
            if (numeroAleatorio < calculo && stun == 1) {
                System.out.println("El monstruo no puede atacar, está estuneado");
                stun = 0;
            } else if (numeroAleatorio < calculo) {

                monstruo.atacar(valiente);

            } else if (numeroAleatorio > calculo) {

                System.out.println("El ataque ha fallado");
            } else if (numeroAleatorio == calculo) {
                System.out.println("El ataque ha fallado");
            }
        } else if (this.orden == 1) {
            //aqui es lo que pasa en el turno del valiente
            int num = 0;
            //si la habilidad esta en cooldown, se lo reducimos un turno
            if (contadorEspecial > 0) {
                contadorEspecial--;
            }
            //aqui tengo dos do while, el de dentro te hace que se repita el menu si no has introducido un numero valido con varios try catch para prevenir fallos
            //el de fuera es para que si escoges una opcion que no se puede usar(habilidad en cooldown o no tener planta curativa) que se repita el menusin pasar de turno
            do {
                try {
                    do {

                        System.out.println("╔════════════════════════════════════════════════╗");
                        System.out.println("║             Menu de acciones:            ║");
                        System.out.println("║                                          ║");
                        System.out.println("║ 1. Ataque normal                         ║");
                        System.out.println("║                                          ║");
                        System.out.println("║ 2. Ataque especial                       ║");
                        System.out.println("║  (doble de posibilidades de acertar)     ║");
                        System.out.println("║  (el explorador no puede fallar)         ║");
                        System.out.println("║                                          ║");
                        System.out.println("║ 3. Usar Planta curativa                  ║");
                        System.out.println("║                                          ║");
                        System.out.println("╚════════════════════════════════════════════════╝\n");

                        System.out.println("Introduce tu accion deseada:");
                        num = Integer.parseInt(teclado.nextLine());
                        if (contadorEspecial != 0 && num == 2) {
                            throw new CooldownException("");
                        }
                        if (num < 1 || num > 3) {
                            throw new IllegalArgumentException("");
                        }
                    } while (num < 1 || num > 3);
                } catch (NumberFormatException e) {
                    System.out.println("Has introducido una letra en vez de un número");
                } catch (IllegalArgumentException e) {
                    System.out.println("Has introducido un valor no válido");
                } catch (CooldownException e) {
                    System.out.println("La habilidad está en cooldown, podras usarla en "+contadorEspecial+" turnos. Escoge otra opción");
                }
                //menu con 3 opciones
                switch (num) {
                    // case 1 es el ataque normal del valiente que puede fallar o acertar dependiendo del numeroaleatorio y el calculo
                    case 1:
                        numeroAleatorio = random.nextInt(101);
                        calculo = 4 * valiente.getHabilidad() - (monstruo.getDefensa());
                        if (numeroAleatorio < calculo) {
                            noHayPlanta=false;
                            valiente.atacar(monstruo);
                        } else if (numeroAleatorio > calculo) {
                            noHayPlanta=false;
                            System.out.println("El ataque ha fallado");
                        } else if (numeroAleatorio == calculo) {
                            noHayPlanta=false;
                            System.out.println("El ataque ha fallado");
                        }
                        break;
                    case 2:
                        //en el case 2 es la habilidad especial, calculamos si acierta y dependiendo del tipo de valiente hace lo que haga la habilidad
                        numeroAleatorioEspecial = random.nextInt(51);
                        calculo = 4 * valiente.getHabilidad() - (monstruo.getDefensa());
                        switch (valiente.getTipo()) {
                            case GUERRERO:
                                if (numeroAleatorioEspecial > calculo) {
                                    System.out.println("La habilidad falló");
                                    contadorEspecial = 3;
                                    noHayPlanta=false;
                                } else if (numeroAleatorioEspecial <= calculo) {
                                    valiente.usarHabilidadEspecial(monstruo);
                                    stun = 1;
                                    contadorEspecial = 3;
                                    noHayPlanta=false;
                                }
                                break;
                            case PALADÍN:
                                if (numeroAleatorioEspecial > calculo) {
                                    System.out.println("La habilidad falló");
                                    contadorEspecial = 3;
                                    noHayPlanta=false;
                                } else if (numeroAleatorioEspecial <= calculo) {
                                    valiente.usarHabilidadEspecial(monstruo);
                                    contadorEspecial = 3;
                                    noHayPlanta=false;
                                }
                                break;
                            case EXPLORADOR:

                                valiente.usarHabilidadEspecial(monstruo);
                                contadorEspecial = 3;
                                noHayPlanta=false;
                                break;
                            case MAGO:
                                if (numeroAleatorioEspecial > calculo) {
                                    System.out.println("La habilidad falló");
                                    contadorEspecial = 3;
                                    noHayPlanta=false;
                                } else if (numeroAleatorioEspecial <= calculo) {
                                    valiente.usarHabilidadEspecial(monstruo);
                                    contadorEspecial = 3;
                                    noHayPlanta=false;
                                }

                                break;
                            case PÍCARO:
                                if (numeroAleatorioEspecial > calculo) {
                                    System.out.println("La habilidad falló");
                                    contadorEspecial = 3;
                                    noHayPlanta=false;
                                } else if (numeroAleatorioEspecial <= calculo) {
                                    valiente.usarHabilidadEspecial(monstruo);
                                    contadorEspecial = 3;
                                    noHayPlanta=false;
                                }
                                break;

                        }
                        break;
                    case 3:
                        //el case 3 es para usar la planta curativa, si la vida del valiente esta al maximo o si no hay planta, te dice que no se puede usar
                        //si tienes planta y te falta vida, te pone en maximo de vida si la planta cura mas de lo que falta y si te falta mas que lo qu cura, te cura todo lo que puede curar
                        if (valiente.getVida() == valiente.getVidaMaxima()) {
                            System.out.println("Tu vida esta al maximo, no puedes usar el objeto");
                            noHayPlanta=true;
                        } else if (inventario.hayPlanta("Planta curativa") == true) {
                            
                            Objeto objeto = new PlantaCurativa(10);
                            objeto.usar(valiente);  
                            inventario.eliminarObjetoInventario(objeto.getnombre());
                            noHayPlanta=false;
                            /*if(valiente.getVida()<=(valiente.getVidaMaxima()-25)){
                                valiente.setVida(valiente.getVida()+25);
                                
                            }else{
                                valiente.setVida(valiente.getVidaMaxima());
                            }*/
                        } else {
                            System.out.println("No hay planta curativa, escoge otra opcion");
                            noHayPlanta=true;
                        }
                        break;
                }
            } while (noHayPlanta == true);

        }

    }

    @Override
    public void combateTerminado(Valiente valiente, Monstruo monstruo) {
        if (tieneExito == false) {
            //si el valiente ha ganado te sale victoria y la mejora de estadisticas
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║              Fin del combate             ║");
            System.out.println("║                                          ║");
            System.out.println("║              ¡¡¡VICTORIA!!!              ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            valiente.subirNivel();
            System.out.println("Tu nivel es: " + valiente.getNivel());
            System.out.println("Tu fuerza es: " + valiente.getFuerza());
            System.out.println("Tu vida es: " + valiente.getVida());
            System.out.println("Tu defensa es: " + valiente.getDefensa());
            System.out.println("Tu habilidad es: " + valiente.getHabilidad());
            System.out.println("Tu velocidad es: " + valiente.getVelocidad());

        } else if(tieneExito==true){
            //si el valiente pierde te pone has perdido
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║              Fin del combate             ║");
            System.out.println("║                                          ║");
            System.out.println("║                HAS PERDIDO               ║");
            System.out.println("╚════════════════════════════════════════════════╝");
        }
    }

    /**
     *
     * @param valiente
     * @param monstruo
     */
    @Override
    public void iniciarCombate(Valiente valiente, Monstruo monstruo) {
        //aqui empieza el combate, calculando la iniciativa de cada uno para saber el orden de ataque
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║            Comienza el combate           ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println(monstruo.getNivel());
        do {
            double iniciativa_Monstruo;
            double iniciativa_Valiente;
            
            double numeroAleatorio = 0.75 + random.nextDouble() * (1 - 0.75);
            iniciativa_Valiente = valiente.getVelocidad() * numeroAleatorio;
            iniciativa_Monstruo = monstruo.getVelocidad() * numeroAleatorio;
            
            //dependiendo de la iniciativa ataca uno u otro y dentro estan los turnos de los dos poniendo el orden a 1 o a 0 para que cuando se llame al turno, ataqueel que 
            //queramos que ataque
            if (iniciativa_Monstruo > iniciativa_Valiente) {
                this.orden = 0;
                System.out.println("Turno del rival");
                turno(valiente, monstruo);
                if (valiente.getVida() <= 0) {
                    //aqui pongo otro if para que si en el turno primero alguien muere, que no empiece el turno del segundo y pueda hacer daño o llegar a matar estando muerto
                    combateTerminado(valiente, monstruo);
                } else {
                    System.out.println("Es tu turno");
                    this.orden = 1;
                    turno(valiente, monstruo);
                }

                
            } else if (iniciativa_Valiente >= iniciativa_Monstruo) {
                this.orden = 1;
                System.out.println("Es tu turno");
                turno(valiente, monstruo);
                if (monstruo.getVida() <= 0) {
                    
                    combateTerminado(valiente, monstruo);
                    
                } else {
                    System.out.println("Turno del rival");
                    this.orden = 0;
                    turno(valiente, monstruo);
                }

                
            
            }
            //todo dentro de un do while mientras la vida de los 2 sea mayor que 0 y dependiendo quien haya ganado ponemos tieneexito en true o false para que el metodo de terminar combate lo gestione
        } while (valiente.getVida() > 0 && monstruo.getVida() > 0);
        if (valiente.getVida() <= 0 && monstruo.getVida() > 0) {
            tieneExito = false;
        } else if (valiente.getVida() > 0 && monstruo.getVida() <= 0) {
            tieneExito = true;
        }

    }

}
