package Operacoes;

public class FazerCalculo {

    private double res;
    private double num1;
    private String operador;
    private double num2;

    public FazerCalculo(double num1, String operador, double num2){
        this.num1 = num1;
        this.operador = operador;
        this.num2 = num2;
    }

    public double fazCalculo(){
        descobreOperador(this.num1, this.operador, this.num2);
        return this.res;
    }

    private void descobreOperador(double num1, String operador, double num2) {
        switch(operador){
            case "*":
                this.res = multiplicacao(num1, num2);
                break;
            case "+":
                this.res = soma(num1, num2);
                break;
            case "-":
                this.res = subtracao(num1, num2);
                break;
            case "/":
                this.res = divisao(num1, num2);
                break;
            case "**":
                this.res = eleva(num1, num2);
                break;
            default:
                System.out.println("Operador invalido!");
                break;
        }
    }

    private double eleva(double num1, double num2) {
        return Math.pow(num1, num2);
    }

    private double divisao(double num1, double num2) {
        return num1/num2;
    }

    private double subtracao(double num1, double num2) {
        return num1-num2;
    }

    private double soma(double num1, double num2) {
        return num1+num2;
    }

    private double multiplicacao(double num1, double num2) {
        return num1*num2;
    }

}
