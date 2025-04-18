import java.io.IOException;
import java.util.Scanner;

public abstract class Main {
    public static void main(String[] args) throws IOException, Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite seu cep");
        var meuCep = scanner.nextLine();
        Requisicao req = new Requisicao();
        try{
        GeradorJson gerador = new GeradorJson();
        ConsultaCEP cep = req.BuscarCep(meuCep);
        gerador.salvaJson(cep);
        System.out.println(cep);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new Exception("cep invalido");
        }
    }
}