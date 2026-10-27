package ListaPosProvaAV2;

import java.util.concurrent.Semaphore;

public class App {
    public static void main(String[] args) {
        Senha s = new Senha("Caixa");
        System.out.println(s.toString());
        Senha s1 = new Senha("Gerência");
        System.out.println(s1.toString());
        Senha s2 = new Senha("Caixa");
        System.out.println(s2.toString());

        try {
            Senha s3 = new Senha("");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        Senha s4 = new Senha("Caixa");
        System.out.println(s4.toString());
        System.out.println("Emitidas: " + Senha.getTotalEmitidas());
    
    }

}
