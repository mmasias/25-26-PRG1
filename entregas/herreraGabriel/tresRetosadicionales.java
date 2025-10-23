import java.util.Random;
import java.util.Scanner;

public class tresRetosadicionales {
    public static void main(String[] args) {
        final int VIDA_INICIAL_HEROE = 150;
        final int DANO_ARMA_1 = 7;
        final int DANO_ARMA_2 = 15;
        final int DANO_ARMA_3 = 30;
        final int PROBABILIDAD_ARMA_1 = 50;
        final int PROBABILIDAD_ARMA_2 = 25;
        final int PROBABILIDAD_ARMA_3 = 12;
        final int PROBABILIDAD_DEFENSA = 80;
        final int REDUCCION_DEFENSA = 5;
        final int LIMITE_DESMAYO_HEROE = 30;
        final int RECUPERACION_DESMAYO = 2;
        final int TURNOS_POCION = 3;
        
        final int VIDA_INICIAL_VAMPIRO = 60;
        final int DANO_ATAQUE_1 = 5;
        final int DANO_ATAQUE_2 = 10;
        final int DANO_ATAQUE_3 = 20;
        final int PROBABILIDAD_ATAQUE_1 = 90;
        final int PROBABILIDAD_ATAQUE_2 = 60;
        final int PROBABILIDAD_ATAQUE_3 = 40;
        final int LIMITE_DESMAYO_VAMPIRO = 20;
        
        int vidaHeroe = VIDA_INICIAL_HEROE;
        int vidaVampiro = VIDA_INICIAL_VAMPIRO;
        
        int turno = 1;
        boolean batallaEnCurso = true;
        boolean ataqueAcertado = false;
        boolean defensaExitosa = false;
        boolean heroeGanador = false;
        boolean vampiroGanador = false;
        boolean entradaValida = false;
        boolean heroeDesmayado = false;
        boolean vampiroDesmayado = false;
        boolean heroeTomandoPocion = false;
        boolean pocionUsada = false;
        
        int eleccionJugador = 0;
        int eleccionVampiro = 0;
        int danoInfligido = 0;
        int probabilidadActual = 0;
        int turnosPocionRestantes = 0;
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("   BATALLA EPICA: HEROE vs VAMPIRO");
        System.out.println("Heroe: " + vidaHeroe + " HP");
        System.out.println("Vampiro: " + vidaVampiro + " HP");
        System.out.println("\nPrepárate para la batalla!\n");
        
        while (batallaEnCurso) {
            System.out.println("          TURNO " + turno);
            System.out.println("Heroe: " + vidaHeroe + " HP | Vampiro: " + vidaVampiro + " HP\n");
            
            if (heroeTomandoPocion) {
                turnosPocionRestantes = turnosPocionRestantes - 1;
                System.out.println("[POCION] Estas tomando la pocion... Turnos restantes: " + turnosPocionRestantes);
                
                if (turnosPocionRestantes <= 0) {
                    heroeTomandoPocion = false;
                    vidaHeroe = VIDA_INICIAL_HEROE;
                    System.out.println("[POCION] La pocion ha hecho efecto! Energia restaurada a " + vidaHeroe + " HP\n");
                } else {
                    System.out.println("[POCION] No puedes atacar ni defenderte mientras tomas la pocion.\n");
                }
            } else if (heroeDesmayado) {
                System.out.println("[DESMAYO] Estas desmayado y no puedes atacar...");
                vidaHeroe = vidaHeroe + RECUPERACION_DESMAYO;
                System.out.println("[DESMAYO] Recuperas " + RECUPERACION_DESMAYO + " HP. Vida actual: " + vidaHeroe + " HP\n");
                
                if (vidaHeroe >= LIMITE_DESMAYO_HEROE) {
                    heroeDesmayado = false;
                    System.out.println("[RECUPERACION] Te has recuperado del desmayo!\n");
                }
            } else {
                entradaValida = false;
                
                do {
                    System.out.println("--- Tu turno ---");
                    System.out.println("1. Arma 1 (Dano: " + DANO_ARMA_1 + " | Precision: " + PROBABILIDAD_ARMA_1 + "%)");
                    System.out.println("2. Arma 2 (Dano: " + DANO_ARMA_2 + " | Precision: " + PROBABILIDAD_ARMA_2 + "%)");
                    System.out.println("3. Arma 3 (Dano: " + DANO_ARMA_3 + " | Precision: " + PROBABILIDAD_ARMA_3 + "%)");
                    System.out.println("4. Defenderse (Exito: " + PROBABILIDAD_DEFENSA + "% | Reduce: " + REDUCCION_DEFENSA + " dano)");
                    
                    if (!pocionUsada) {
                        System.out.println("5. Tomar pocion (Recupera toda la vida en " + TURNOS_POCION + " turnos)");
                    }
                    
                    System.out.print("Tu eleccion: ");
                    
                    eleccionJugador = scanner.nextInt();
                    
                    if (eleccionJugador >= 1 && eleccionJugador <= 4) {
                        entradaValida = true;
                    } else if (eleccionJugador == 5 && !pocionUsada) {
                        entradaValida = true;
                    } else {
                        System.out.println("Opcion invalida. Intenta de nuevo.\n");
                    }
                } while (!entradaValida);
                
                System.out.println();
                
                if (eleccionJugador == 5) {
                    heroeTomandoPocion = true;
                    pocionUsada = true;
                    turnosPocionRestantes = TURNOS_POCION;
                    System.out.println("Comienzas a tomar la pocion... No podras atacar ni defenderte por " + TURNOS_POCION + " turnos.");
                } else if (eleccionJugador == 4) {
                    System.out.println("Te preparas para defender el proximo ataque...");
                    defensaExitosa = false;
                } else if (!vampiroDesmayado) {
                    if (eleccionJugador == 1) {
                        System.out.print("Atacas con el Arma 1... ");
                        danoInfligido = DANO_ARMA_1;
                        probabilidadActual = PROBABILIDAD_ARMA_1;
                    } else if (eleccionJugador == 2) {
                        System.out.print("Atacas con el Arma 2... ");
                        danoInfligido = DANO_ARMA_2;
                        probabilidadActual = PROBABILIDAD_ARMA_2;
                    } else {
                        System.out.print("Atacas con el Arma 3... ");
                        danoInfligido = DANO_ARMA_3;
                        probabilidadActual = PROBABILIDAD_ARMA_3;
                    }
                    
                    int probabilidadHeroe = random.nextInt(100) + 1;
                    
                    if (probabilidadHeroe <= probabilidadActual) {
                        ataqueAcertado = true;
                    } else {
                        ataqueAcertado = false;
                    }
                    
                    if (ataqueAcertado) {
                        vidaVampiro = vidaVampiro - danoInfligido;
                        System.out.println("IMPACTO! Causas " + danoInfligido + " de dano.");
                        System.out.println("Vida del Vampiro: " + vidaVampiro + " HP");
                        
                        if (vidaVampiro > 0 && vidaVampiro < LIMITE_DESMAYO_VAMPIRO && !vampiroDesmayado) {
                            vampiroDesmayado = true;
                            System.out.println("[DESMAYO] El vampiro se ha desmayado!");
                        }
                    } else {
                        System.out.println("FALLAS! El vampiro esquiva tu ataque.");
                    }
                } else {
                    System.out.println("El vampiro esta desmayado, no puedes atacarlo.");
                }
                
                System.out.println();
            }
            
            if (vidaVampiro <= 0) {
                batallaEnCurso = false;
            } else {
                System.out.println("--- Turno del Vampiro ---");
                
                if (vampiroDesmayado) {
                    System.out.println("[DESMAYO] El vampiro esta desmayado y no puede atacar...");
                    vidaVampiro = vidaVampiro + RECUPERACION_DESMAYO;
                    System.out.println("[DESMAYO] El vampiro recupera " + RECUPERACION_DESMAYO + " HP. Vida actual: " + vidaVampiro + " HP\n");
                    
                    if (vidaVampiro >= LIMITE_DESMAYO_VAMPIRO) {
                        vampiroDesmayado = false;
                        System.out.println("[RECUPERACION] El vampiro se ha recuperado del desmayo!\n");
                    }
                } else {
                    eleccionVampiro = random.nextInt(3) + 1;
                    
                    if (eleccionVampiro == 1) {
                        System.out.print("El Vampiro usa Ataque 1... ");
                        danoInfligido = DANO_ATAQUE_1;
                        probabilidadActual = PROBABILIDAD_ATAQUE_1;
                    } else if (eleccionVampiro == 2) {
                        System.out.print("El Vampiro usa Ataque 2... ");
                        danoInfligido = DANO_ATAQUE_2;
                        probabilidadActual = PROBABILIDAD_ATAQUE_2;
                    } else {
                        System.out.print("El Vampiro usa Ataque 3... ");
                        danoInfligido = DANO_ATAQUE_3;
                        probabilidadActual = PROBABILIDAD_ATAQUE_3;
                    }
                    
                    int probabilidadVampiro = random.nextInt(100) + 1;
                    
                    if (probabilidadVampiro <= probabilidadActual) {
                        ataqueAcertado = true;
                    } else {
                        ataqueAcertado = false;
                    }
                    
                    if (ataqueAcertado) {
                        if (eleccionJugador == 4 && !heroeTomandoPocion && !heroeDesmayado) {
                            int probabilidadDefensa = random.nextInt(100) + 1;
                            
                            if (probabilidadDefensa <= PROBABILIDAD_DEFENSA) {
                                defensaExitosa = true;
                            } else {
                                defensaExitosa = false;
                            }
                            
                            if (defensaExitosa) {
                                int danoReducido = danoInfligido - REDUCCION_DEFENSA;
                                if (danoReducido < 0) {
                                    danoReducido = 0;
                                }
                                vidaHeroe = vidaHeroe - danoReducido;
                                System.out.println("TE GOLPEA! Pero te defiendes exitosamente.");
                                System.out.println("Recibes " + danoReducido + " de dano (reducido de " + danoInfligido + ").");
                                System.out.println("Tu vida: " + vidaHeroe + " HP");
                            } else {
                                vidaHeroe = vidaHeroe - danoInfligido;
                                System.out.println("TE GOLPEA! Tu defensa falla.");
                                System.out.println("Recibes " + danoInfligido + " de dano.");
                                System.out.println("Tu vida: " + vidaHeroe + " HP");
                            }
                        } else {
                            vidaHeroe = vidaHeroe - danoInfligido;
                            System.out.println("TE GOLPEA! Recibes " + danoInfligido + " de dano.");
                            System.out.println("Tu vida: " + vidaHeroe + " HP");
                        }
                        
                        if (vidaHeroe > 0 && vidaHeroe < LIMITE_DESMAYO_HEROE && !heroeDesmayado && !heroeTomandoPocion) {
                            heroeDesmayado = true;
                            System.out.println("[DESMAYO] Te has desmayado!");
                        }
                    } else {
                        System.out.println("LO ESQUIVAS! Te defiendes exitosamente.");
                    }
                    
                    System.out.println();
                }
                
                if (vidaHeroe <= 0) {
                    batallaEnCurso = false;
                }
            }
            
            turno++;
        }
        
        boolean ganadorDeterminado = false;
        
        do {
            if (vidaHeroe > 0 && vidaVampiro <= 0) {
                heroeGanador = true;
                vampiroGanador = false;
                ganadorDeterminado = true;
            } else if (vidaVampiro > 0 && vidaHeroe <= 0) {
                vampiroGanador = true;
                heroeGanador = false;
                ganadorDeterminado = true;
            } else if (vidaHeroe <= 0 && vidaVampiro <= 0) {
                heroeGanador = false;
                vampiroGanador = false;
                ganadorDeterminado = true;
            }
        } while (!ganadorDeterminado);
        
        System.out.println("        FIN DE LA BATALLA");
        
        if (heroeGanador) {
            System.out.println(" VICTORIA! ");
            System.out.println("Has derrotado al vampiro con valentia.");
            System.out.println("Tu vida restante: " + vidaHeroe + " HP");
        } else if (vampiroGanador) {
            System.out.println(" ¡DERROTA! ");
            System.out.println("El vampiro te ha vencido...");
            System.out.println("Vida restante del Vampiro: " + vidaVampiro + " HP");
        } else {
            System.out.println(" EMPATE EPICO! ");
            System.out.println("Ambos luchadores han caido en combate.");
        }
        
        System.out.println("\nTurnos totales: " + turno);
        
        scanner.close();
    }
}