package Lista3.exe1.sonora_fase01;

import java.util.Scanner;

public class App {
    Scanner prompt = new Scanner(System.in);
    int escolhaMenu = 9;
    Plataforma p1 = new Plataforma();
    Playlist ultimPlaylist;

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

            if (prompt.hasNextInt()) {                
                
                escolhaMenu = prompt.nextInt();

                switch (escolhaMenu) {
                    case 0:
                        System.out.println("Bye bye!");
                        break;
                    case 1:
                        cadastroMusica();
                    break;
                    case 2:
                        cadastroUsuario();                        
                        break;
                    case 3:
                        criarPlaylist();                
                        break;
                    case 4:
                        buscarMusicaPorId();                        
                        break;
                    case 5:
                        buscarMusicaPorTitulo();
                        break;
                    case 6:
                        reproduzirMusica();
                        break;
                    case 7:
                        mostrarAcervo();
                        break;

                    default:
                        System.out.println("Digite um número válido");
                        break;
                }
            }
            else{
                prompt.next();
                System.out.println("Digite um *Número*");
            }
        } while (escolhaMenu != 0);
    }

    public void cadastroMusica(){
        
        prompt.nextLine();
        
        System.out.println("Qual o nome do artista");
        String nomeArtista = prompt.nextLine();
        System.out.println("Qual o nome da Música?");
        String nomeMusica = prompt.nextLine();
        System.out.println("Qual a duração total da Música(segundos)?");
        int duracaoSegundos = 0;
        
        do {
            if (prompt.hasNextInt()) {  
                
                duracaoSegundos = prompt.nextInt();                
        
                if (duracaoSegundos < 1) {
                System.out.println("Digite um número maior que 0");
                }

            }
            else{
                prompt.next();
                System.out.println("Digite um número");
            }
        } while (duracaoSegundos < 1);
        
        Musica musicaCadastrada = new Musica(nomeMusica, nomeArtista, duracaoSegundos);
        boolean cadastrou = p1.cadastrarMusica(musicaCadastrada);
        
        if (cadastrou == true) {
            System.out.println("Música cadastrada com sucesso");
        }
        else{
            System.out.println("Cadastro inválido");
        }
    }

    public void cadastroUsuario(){

        prompt.nextLine();
        
        System.out.println("Qual o nome do usuário");
        String nomeUsuario = prompt.nextLine();
        System.out.println("Qual o email do usuário?");
        String emailUsuario;
        do {
            emailUsuario = prompt.nextLine();
            if (!emailUsuario.contains("@")) {
                System.out.println("Digite um email válido");
            }
        } while (!emailUsuario.contains("@"));
        Usuario usuarioCadastrado = new Usuario(nomeUsuario, emailUsuario);
        boolean cadastrou = p1.cadastrarUsuario(usuarioCadastrado);

        if (cadastrou == true) {
            System.out.println("Usuário cadastrado com sucesso");
        }
        else{
            System.out.println("Cadastro inválido");
        }
    }

    public void criarPlaylist(){
        prompt.nextLine();
        System.out.println("Qual o nome da playlist?");
        String nomePlaylist = prompt.nextLine();
        System.out.println("Qual usuário será dono da playlist?");
        Usuario usuarioValido;
        String usuarioPlaylist;
        do {
            usuarioPlaylist = prompt.nextLine();
            usuarioValido = p1.buscarUsuario(usuarioPlaylist);

            if (usuarioValido == null) {
                System.out.println("Usuário inválido");
        }    
        } while (usuarioValido == null);
        ultimPlaylist = new Playlist(nomePlaylist, usuarioValido);
        System.out.println("Cadastro concluido, deseja incluir novas músicas?");
        int opcao = 0;
        do {
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            if (prompt.hasNextInt()) {
                opcao = prompt.nextInt();
                prompt.nextLine();
                switch (opcao) {
                    case 1:
                        Musica valida;
                        System.out.println("Que música você gostaria de adicionar? Busca por titulo");
                        do {
                            String adicionarMusica = prompt.nextLine();
                            valida = p1.buscarMusica(adicionarMusica);
                            if (valida != null) {
                                boolean adicionou = ultimPlaylist.adicionar(valida);
                                if (adicionou) {
                                    System.out.println("Música adicionada à playlist");
                                    System.out.println("Adicionar uma nova música?");
                                }
                                else{
                                    System.out.println("Não foi possível adicionar (playlist cheia)");
                                }
                            }
                            else{
                                System.out.println("Música inválida");
                            }
                        } while (valida == null);
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("Digite 1 ou 2");
                        break;
                }
            }
            else{
                prompt.nextLine();
                System.out.println("Digite um número!");
            }
        } while (opcao != 2);
    }

    public void buscarMusicaPorId(){
        System.out.println("Qual o id da música que você deseja buscar?");
        int idMusica;
        Musica valido;
        do {
            if (prompt.hasNextInt()) {
                idMusica =  prompt.nextInt();        
                valido = p1.buscarMusicaPorId(idMusica);
                if (valido == null) {
                    System.out.println("Id inválido");
                }
                else{
                    System.out.println("Música - " + valido.getTitulo());
                    System.out.println("Artista - " + valido.getArtista());
                    System.out.println("Reproduções - " + valido.getReproducoes());
                    System.out.println("Duração - " + valido.getDuracaoFormatada());
                    System.out.println("Duração segundos - " + valido.getDuracaoSegundos());
                    System.out.println("Id música - " + valido.getId());
                }
            }
            else{
                throw new IllegalArgumentException("Digite somente números");
            }
        } while (valido == null);
    }

    public void buscarMusicaPorTitulo(){
        prompt.nextLine();
        System.out.println("Qual o título da música que você deseja buscar?");
        String tituloMusica;
        Musica valido;
        do {
            tituloMusica =  prompt.nextLine();        
            valido = p1.buscarMusica(tituloMusica);
            if (valido == null) {
                System.out.println("Id inválido");
            }
            
            else{
                System.out.println("Música - " + valido.getTitulo());
                System.out.println("Artista - " + valido.getArtista());
                System.out.println("Reproduções - " + valido.getReproducoes());
                System.out.println("Duração - " + valido.getDuracaoFormatada());
                System.out.println("Duração segundos - " + valido.getDuracaoSegundos());
                System.out.println("Id música - " + valido.getId());
                }    
        } while (valido == null);
    }
    
    public void reproduzirMusica(){
        prompt.nextLine();
        System.out.println("Qual o título da música que você deseja reproduzir?");
        String tituloMusica;
        Musica valido;
        do {
            tituloMusica =  prompt.nextLine();        
            valido = p1.buscarMusica(tituloMusica);
            if (valido == null) {
                System.out.println("Id inválido");
            }
            else{
                valido.reproduzir();
                System.out.println("Reproduzindo!");
            }            
        } while (valido == null);
    }

    public void mostrarAcervo(){
        for (int i = 0; i < p1.getTotalMusicas(); i++) {
            Musica musicas = p1.buscarMusicaPorId(i + 1);
            System.out.println((i+1) + " - " + musicas.getTitulo());
        }
    }
    public static void main(String[] args) {
        App exe = new App();
        exe.Menu();  
    }
}
