package Principal;

import Operacoes.FazerCalculo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean running = true;
        while (running) {
            Scanner input = new Scanner(System.in);
            String operador = null;
            System.out.println("--- Calculadora ---");
            System.out.print(">> ");
            String conta = input.nextLine();

            ArrayList<Double> valores = new ArrayList<>();
            String[] valoresSplit = conta.split(" ");

            try {
                valores.add(Double.valueOf(valoresSplit[0]));
                valores.add(Double.valueOf(valoresSplit[2]));
                operador = valoresSplit[1];
            } catch (NumberFormatException e) {
                System.out.println("Os valores devem ser separados por espaço.\n" + e);
                throw new NumberFormatException();
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Você não digitou todos os valores ou digitou valores a mais!\n" + e);
                throw new ArrayIndexOutOfBoundsException();
            }

            FazerCalculo fz = new FazerCalculo(valores.get(0), operador, valores.get(1));
            System.out.println("Resultado da Operação: " + fz.fazCalculo());

            System.out.println("Outro calculo? (y/n)");
            String s = input.nextLine();
            if(s.toLowerCase().equals("n"))
                running = false;
        }
    }
}
