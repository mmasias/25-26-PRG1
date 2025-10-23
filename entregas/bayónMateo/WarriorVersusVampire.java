
import java.util.Scanner;

public class WarriorVersusVampire {

    public static void main(String[] args) {

        int warriorHP = 150;

        int vampireHP = 60;

        boolean oneDead = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("[Narrator] You walk into a dark forest...");
        System.out.println("(Press ENTER to continue)");
        String enter1 = scanner.nextLine();
        System.out.println("[Narrator] ... You feel a dark presence surround you...");
        String enter2 = scanner.nextLine();
        System.out.println("[Narrator] ... You hear steps coming towards you...");
        String enter3 = scanner.nextLine();
        System.out.println("[Narrator] ... It's Count Totemir! The most evil vampire in the country!");
        String enter4 = scanner.nextLine();
        System.out.println("[Count Totemir] ... I'm Count Totemir, and I want to fight! Do YOU want to fight?");
        System.out.println("(Type 1 (Yes) or 2 (No) to continue)");

        int answer = scanner.nextInt();

        if (answer == 1) {
            System.out.println("[Count Totemir] Cool!");
            do {
                System.out.println();
                System.out.println("-------------------------------[Warrior Versus Vampire (Developed by Mateo Bayón)]");
                System.out.println("[Your HP] " + warriorHP);
                System.out.println("[Count Totemir's HP] " + vampireHP);
                System.out.println("----------------------------------------------------------------------------------");
                System.out.println("Your turn! How do yow wish to attack?");
                System.out.println("(1) Knife [7 DMG][50% Success rate]");
                System.out.println("(2) Sword [15 DMG][25% Success rate]");
                System.out.println("(3) Axe [30 DMG][12% Success rate]");
                System.out.println("----------------------------------------------------------------------------------");

                int attack = scanner.nextInt();
                System.out.println("-----------------------------------------------------------------------[Your Turn]");

                double chance = Math.random();

                if (attack == 1) {
                    if (chance < 0.5) {
                        System.out.println("[Narrator] You stab him with your knife.");
                        System.out.println("[Count Totemir] Ouch! You like stabbing, huh?");
                        vampireHP = vampireHP - 7;
                    } else {
                        System.out.println("[Narrator] He dodges your knife.");
                        System.out.println("[Count Totemir] Ha! Nice try! That knife sucks.");
                    }
                } else if (attack == 2) {
                    if (chance < 0.25) {
                        System.out.println("[Narrator] You slice him with your sword.");
                        System.out.println("[Count Totemir] Dang! That sword is pretty sharp!");
                        vampireHP = vampireHP - 15;
                    } else {
                        System.out.println("[Narrator] He dodges your sword.");
                        System.out.println("[Count Totemir] Did you buy that off sale at the stupid store?");
                    }
                } else if (attack == 3) {
                    if (chance < 0.12) {
                        System.out.println("[Narrator] You chop him with your Axe.");
                        System.out.println("[Count Totemir] Whoa! That's just taking it too far!");
                        vampireHP = vampireHP - 30;
                    } else {
                        System.out.println("[Narrator] He dodges your axe.");
                        System.out.println("[Count Totemir] What a bum! Did your granny teach you how to use that?");
                    }
                } else {
                    System.out.println("[Narrator] What type of attack is that? You just lost a turn!");
                }

                System.out.println("------------------------------------------------------------[Count Totemir's Turn]");
                double vampireAttackType = Math.random() * 3;
                double vampireAttackChance = Math.random();

                if (vampireAttackType <= 1) {
                    if (vampireAttackChance < 0.9) {
                        System.out.println("[Narrator] He bites you.");
                        System.out.println("[Count Totemir] That's pretty tasty... But you should watch your cholesterol.");
                        warriorHP = warriorHP - 5;
                    } else {
                        System.out.println("[Narrator] You dodge his bite.");
                        System.out.println("[Count Totemir] Come on, man. Just let me have one bite!");
                    }
                } else if (vampireAttackType <= 2) {
                    if (vampireAttackChance < 0.6) {
                        System.out.println("[Narrator] He slashes you with his claws.");
                        System.out.println("[Count Totemir] I just had these puppies done yesterday.");
                        warriorHP = warriorHP - 15;
                    } else {
                        System.out.println("[Narrator] You dodge his claws.");
                        System.out.println("[Count Totemir] You had something on your shirt, I was just trying to clean it off.");
                    }
                } else if (vampireAttackType <= 3) {
                    if (vampireAttackChance < 0.4) {
                        System.out.println("[Narrator] He hypnotizes you and makes you stab yourself with your knife.");
                        System.out.println("[Count Totemir] Stop stabbing yourself, stop stabbing yourself!");
                        warriorHP = warriorHP - 30;
                    } else {
                        System.out.println("[Narrator] He tries to hypnotize you, but fails.");
                        System.out.println("[Count Totemir] There's not a lot to control there anyways.");
                    }
                } else if (vampireHP <= 0) {
                    System.out.println("[Count Totemir] GAH! I'M DEAD!");
                }

                if (vampireHP <= 0 || warriorHP <= 0) {
                    oneDead = true;
                }
            } while (oneDead == false);
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println(vampireHP <= 0 ? "[Narrator] Congratulations! You've slain the terrible Count Totemir!" : "[Narrator] You've died. GAME OVER, MAN! GAME OVER!");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("THE END");
        } else if (answer == 2) {
            System.out.println("[Count Totemir] Alright, fair enough. Bye!");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("THE END");
        } else {
            System.out.println("[Count Totemir] I don't know what you're talking about...");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("THE END");
        }
    }
}
