package atvemsala.redesocial;

import java.util.Scanner;

public class MainRedeSocial {

  public static void main(String[] args) throws Exception {

    Scanner scan = new Scanner(System.in);
    
    Utils utils = new Utils();
    utils.redeSocial(); 

    scan.close();
  }
}
