import java.util.Scanner;
public class Troco {
    public static void descobrir_troco(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Entre com o valor do troco: ");
        int moedas1 = teclado.nextInt();
       
        int moedas100 = moedas1 / 100;
        moedas1 -= 100 * moedas100;
        int moedas50 = moedas1 / 50;
        moedas1 -= 50 * moedas50;
        int moedas25 = moedas1 / 25;
        moedas1 -= 25 * moedas25;
        int moedas10 = moedas1 / 10;
        moedas1 -= 10 * moedas10;
        int moedas5 = moedas1 / 5;
        moedas1 -= 5 * moedas5;
 
        System.out.println("Moedas de 1 real: " + moedas100);
        System.out.println("Moedas de 50 centavos: " + moedas50);
        System.out.println("Moedas de 25 centavos: " + moedas25);
        System.out.println("Moedas de 10 centavos: " + moedas10);
        System.out.println("Moedas de 5 centavos: " + moedas5);
        System.out.println("Moedas de 1 centavo: " + moedas1);
    }
}