package Lista3.exe1.sonora_fase01;

import java.util.Scanner;

public class App {
    Scanner prompt = new Scanner(System.in);
    int escolhaMenu = 999;

    public void Menu(){
        
        do {

            System.out.println("------------ Sonora ------------");    
            System.out.println("1 - Cadastrar música manualmente");    
            System.out.println("2 - Cadastrar usuário");    
            System.out.println("3 - Criar playlist e adicionar músicas");    
            System.out.println("4 - Buscar música por id");    
            System.out.println("5 - Buscar música por título");    
            System.out.println("6 - Reproduzir uma música");    
            System.out.println("7 - Listar acervo");    
            System.out.println("0 - Sair");    
            System.out.println("--------------------------------");

            if (prompt.hasNextInt(escolhaMenu)) {                
                
                escolhaMenu = prompt.nextInt();

                switch (escolhaMenu) {
                    case 0:
                        System.out.println("Bye bye!");
                        break;
                    case 1:
                        
                        break;
                    case 2:
                        
                        break;
                    case 3:
                        
                        break;
                    case 4:
                        
                        break;
                    case 5:
                        
                        break;
                    case 6:
                        
                        break;
                    case 7:
                        
                        break;

                    default:
                        System.out.println("Digite um número válido");
                        break;
                }
            }

            else{
                System.out.println("Digite um *Número*");
            }
        } while (escolhaMenu != 0);
    }
    public static void main(String[] args) {
        new App() = new App();
    }
}
