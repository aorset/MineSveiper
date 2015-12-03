import java.util.Scanner;
import java.util.Random;

public class Sveip{

  Sveip(){
    this.meny();
  }

  private void meny(){
    Scanner inn = new Scanner(System.in);
    System.out.println("Velkommen til minesveiper.");
    System.out.println("Trykk -1 for å avslutte og ENTER for å fortsette.");

    String input = inn.nextLine();
    int poeng = 0;
    while(!input.equals("-1")){
      String koordinater = spoerBruker();
      if(koordinater.equals("9,9")){
        spoerBruker();
      }
      poeng = poeng + sjekkBomber(koordinater);
      System.out.println("Antall treff: " + poeng);
    }
  }

  private boolean returnBoolean(){
    Random random = new Random();
    return random.nextBoolean();
  }


  public int sjekkBomber(String koordinater){
    int kolonne = Character.getNumericValue(koordinater.charAt(0))-1;
    int rad = Character.getNumericValue(koordinater.charAt(2))-1;
    if(kolonne >= 4 || rad >= 4){
      return 0;
    }

    boolean[][] bomber = {
      { this.returnBoolean(), this.returnBoolean(), this.returnBoolean(), this.returnBoolean() },
      { this.returnBoolean(), this.returnBoolean(), this.returnBoolean(), this.returnBoolean() },
      { this.returnBoolean(), this.returnBoolean(), this.returnBoolean(), this.returnBoolean() },
      { this.returnBoolean(), this.returnBoolean(), this.returnBoolean(), this.returnBoolean() }
    };
    if(bomber[rad][kolonne] == true){
      System.out.println("Traff");
      return 1;
    }else{
      System.out.println("Ingenting");
      return 0;
    }
  }

  public String spoerBruker(){
  String[][] havet = {
      { "~", "~", "~", "~" },
      { "~", "~", "~", "~" },
      { "~", "~", "~", "~" },
      { "~", "~", "~", "~" }
    };

  System.out.println();
  for(int i=0; i < 4; i++){
    int j = 0;
    while(j < 4){
      for(int k=0; k <= 8; k++){
        if(k % 2 == 0){
          System.out.print("|");
        }
        if(k % 2 != 0){
          System.out.print(havet[i][j]);
          j++;
        }
      }
    }
    System.out.println();
  }
  System.out.println("");
  System.out.println("");
  System.out.println("Hvor er det bombe?");
  Scanner inn = new Scanner(System.in);
  System.out.print("[Kolonne]...1-4...?");
  String kolonne = inn.nextLine();
  int kolonneInput = Integer.parseInt(kolonne);
  if(kolonneInput > 4 || kolonneInput < 1){
    System.out.println("Havet er ikke så stort");
    return "9,9";
  }
  System.out.println("[" + kolonne + "]" + " [rad]...1-4...?");
  String rad = inn.nextLine();
  int radInput = Integer.parseInt(rad);
  if(radInput > 4 || radInput < 1){
    System.out.println("Havet er ikke så stort");
    return "9,9";
  }
  return kolonne + "," + rad;
  }
}
