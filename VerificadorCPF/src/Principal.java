import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String cpf;

        System.out.print("Informe seu cpf: ");
        cpf = input.nextLine();
        System.out.println(cpf);

        if(cpf.length()>11)
            System.out.println("valor invalido.");

        Verifica vf = new Verifica(cpf);

        System.out.println("CPF é valido? \n");
        boolean ehValido = vf.verificadorCPF();

        vf.pegaNumsCpf();
        if (ehValido)
            System.out.println("O CPF " + cpf + " é valido!");
        else
            System.out.println("O CPF " + cpf + " não é válido!");

    }
}
