/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personajes;

import Objetos.Inventario;
import Objetos.PlantaCurativa;
import interfaces.CombateInterface;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author dam125
 */
public class Combate implements CombateInterface {

    Scanner teclado = new Scanner(System.in);
    Random random = new Random();
    public Inventario inventario;
    public boolean tieneExito;
    public int orden;
    public int contadorEspecial;
    public int stun;
    public boolean noHayPlanta;

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
        int numeroAleatorio;
        int numeroAleatorioEspecial;
        double calculo;
        if (this.orden == 0) {

            numeroAleatorio = random.nextInt(101);
            calculo = 4 * monstruo.getHabilidad() - (valiente.getDefensa() + valiente.getDefensa());
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
            int num = 0;
            if (contadorEspecial > 0) {
                contadorEspecial--;
            }
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
                    System.out.println("La habilidad está en cooldown, escoge otra opción");
                }

                switch (num) {
                    case 1:
                        numeroAleatorio = random.nextInt(101);
                        calculo = 4 * valiente.getHabilidad() - (monstruo.getDefensa());
                        if (numeroAleatorio < calculo) {

                            valiente.atacar(monstruo);
                        } else if (numeroAleatorio > calculo) {

                            System.out.println("El ataque ha fallado");
                        } else if (numeroAleatorio == calculo) {
                            System.out.println("El ataque ha fallado");
                        }
                        break;
                    case 2:
                        numeroAleatorioEspecial = random.nextInt(51);
                        calculo = 4 * valiente.getHabilidad() - (monstruo.getDefensa());
                        switch (valiente.getTipo()) {
                            case GUERRERO:
                                if (numeroAleatorioEspecial > calculo) {
                                    System.out.println("La habilidad falló");
                                } else if (numeroAleatorioEspecial <= calculo) {
                                    valiente.usarHabilidadEspecial(monstruo);
                                    stun = 1;
                                    contadorEspecial = 3;
                                }
                                break;
                            case PALADÍN:
                                if (numeroAleatorioEspecial > calculo) {
                                    System.out.println("La habilidad falló");
                                } else if (numeroAleatorioEspecial <= calculo) {
                                    valiente.usarHabilidadEspecial(monstruo);
                                    contadorEspecial = 3;
                                }
                                break;
                            case EXPLORADOR:

                                valiente.usarHabilidadEspecial(monstruo);
                                contadorEspecial = 3;
                                break;
                            case MAGO:
                                if (numeroAleatorioEspecial > calculo) {
                                    System.out.println("La habilidad falló");
                                } else if (numeroAleatorioEspecial <= calculo) {
                                    valiente.usarHabilidadEspecial(monstruo);
                                    contadorEspecial = 3;
                                }

                                break;
                            case PÍCARO:
                                if (numeroAleatorioEspecial > calculo) {
                                    System.out.println("La habilidad falló");
                                } else if (numeroAleatorioEspecial <= calculo) {
                                    valiente.usarHabilidadEspecial(monstruo);
                                    contadorEspecial = 3;
                                }
                                break;

                        }
                        break;
                    case 3:
                        if (valiente.getVida() == valiente.getVida()) {
                            System.out.println("Tu vida esta al maximo, no puedes usar el objeto");

                        } else if (inventario.hayPlanta("Planta curativa") == true) {

                        } else {
                            System.out.println("No hay planta curativa, escoge otra opcion");
                        }
                        break;
                }
            } while (noHayPlanta == true);

        }

    }

    @Override
    public void combateTerminado(Valiente valiente, Monstruo monstruo) {
        if (tieneExito == true) {

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

        } else {

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

        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║            Comienza el combate           ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        do {
            double iniciativa_Monstruo;
            double iniciativa_Valiente;

            double numeroAleatorio = 0.75 + random.nextDouble() * (1 - 0.75);
            iniciativa_Valiente = valiente.getVelocidad() * numeroAleatorio;
            iniciativa_Monstruo = monstruo.getVelocidad() * numeroAleatorio;

            if (iniciativa_Monstruo > iniciativa_Valiente) {
                this.orden = 0;
                System.out.println("Turno del rival");
                turno(valiente, monstruo);
                if (monstruo.getVida() == 0) {

                } else {
                    System.out.println("Es tu turno");
                    this.orden = 1;
                    turno(valiente, monstruo);
                }

                //poner if si ha tenido exito el ataque y mostrar el daño
            } else if (iniciativa_Valiente > iniciativa_Monstruo) {
                this.orden = 1;
                System.out.println("Es tu turno");
                turno(valiente, monstruo);
                if (valiente.getVida() == 0) {

                } else {
                    System.out.println("Turno del rival");
                    this.orden = 0;
                    turno(valiente, monstruo);
                }

                //poner si ha tenido exito el ataque y mostrar el daño
            }

        } while (valiente.getVida() > 0 && monstruo.getVida() > 0);
        if (valiente.getVida() <= 0 && monstruo.getVida() > 0) {
            tieneExito = false;
        } else if (valiente.getVida() > 0 && monstruo.getVida() <= 0) {
            tieneExito = true;
        }

    }

}
