package br.com.alura;

import com.github.gilbertotorrezan.viacep.se.ViaCEPClient;
import com.github.gilbertotorrezan.viacep.shared.ViaCEPEndereco;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;

public class CEP {
    public static void main(String[] args) {
        ViaCEPClient cliente = new ViaCEPClient();
        try {
            ViaCEPEndereco endereco = cliente.getEndereco("13058014");
            System.out.println(endereco.getBairro());
            System.out.println(endereco.getComplemento());
            System.out.println(endereco.getLogradouro());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            URL url = new URL("http://viacep.com.br/ws/13058014/json/");
//            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
//            conexao.setRequestMethod("GET");
//            conexao.getInputStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
