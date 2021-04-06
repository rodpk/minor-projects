import java.util.ArrayList;

public class Verifica {
    private String cpf;
    ArrayList<Integer> numerosCpf = new ArrayList<>();

    public Verifica(String cpf) {
        this.cpf = cpf;
        pegaNumsCpf();

    }

    public void pegaNumsCpf(){
        for(int i =0;i<cpf.length();i++){
            numerosCpf.add(Character.getNumericValue(cpf.charAt(i)));
        }
    }

    public boolean verificaDigitoUm(){
        int soma = 0;
        int multiplicador = 10;
        int i = 0;

        for(multiplicador = 10; multiplicador >= 2; multiplicador--){
            soma += numerosCpf.get(i) * multiplicador;
            i++;
        }

        soma = (soma * 10);
        Integer resto = soma % 11;
        return resto.equals(numerosCpf.get(9));
    }

    public boolean verificaDigitoDois(){
        int soma = 0;
        int multiplicador = 11;
        int i = 0;

        for(multiplicador = 11; multiplicador >= 2; multiplicador--){
            soma += numerosCpf.get(i) * multiplicador;
            i++;
        }

        soma = (soma * 10);
        Integer resto = soma % 11;
        return resto.equals(numerosCpf.get(10));
    }

    public boolean verificadorCPF(){
        return verificaDigitoUm() && verificaDigitoDois();
    }


    @Override
    public String toString() {
        return "CPF: " + numerosCpf;
    }
}
