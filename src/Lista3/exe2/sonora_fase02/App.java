package Lista3.exe2.sonora_fase02;

import java.util.Scanner;

public class App {
    Scanner prompt = new Scanner(System.in);
    int escolhaMenu = 9;
    Plataforma p1 = new Plataforma();
    Playlist ultimPlaylist;

    public void Menu(){
        while (true) {
            try {
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
                
                escolhaMenu = Integer.parseInt(prompt.nextLine());
                
                switch (escolhaMenu) {
                    case 0:
                        System.out.println("Bye bye!");
                        return;
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

                } catch (NumberFormatException error) {
                    System.out.println("Valor inválido. Digite um número");
                }
            }
        }

    public void cadastroMusica(){
        prompt.nextLine();
        boolean cadastrou = false;
        while (!cadastrou) {
            try { 
                System.out.println("Qual o nome do artista");
                String nomeArtista = prompt.nextLine();
                System.out.println("Qual o nome da Música?");
                String nomeMusica = prompt.nextLine();
                System.out.println("Qual a duração total da Música(segundos)?");
                int duracaoSegundos = Integer.parseInt(prompt.nextLine());                
                Musica musicaCadastrada = new Musica(nomeMusica, nomeArtista, duracaoSegundos);
                cadastrou = p1.cadastrarMusica(musicaCadastrada);
                } catch (IllegalArgumentException error) {
                    System.out.println("Informações inválidas");
                }            
                prompt.next();
                if (cadastrou == true) {
                    System.out.println("Música cadastrada com sucesso");
                }
                else{
                    System.out.println("Cadastro inválido");
                }
        }
    }

    public void cadastroUsuario(){

        prompt.nextLine();
        boolean cadastrou = false;
        while (!cadastrou) {
            try {
                System.out.println("Qual o nome do usuário");
                String nomeUsuario = prompt.nextLine();
                System.out.println("Qual o email do usuário?");
                String emailUsuario;
                emailUsuario = prompt.nextLine();
                Usuario usuarioCadastrado = new Usuario(nomeUsuario, emailUsuario);
                cadastrou = p1.cadastrarUsuario(usuarioCadastrado);

                if (cadastrou == true) {
                    System.out.println("Usuário cadastrado com sucesso");
                }
                else{
                    System.out.println("Cadastro inválido");
                }            
            }
            catch (IllegalArgumentException error) {
                System.out.println("Erro: " + error.getMessage());
            }
        }        
    }

    public void criarPlaylist(){
        prompt.nextLine();
        Usuario usuarioValido = null;
        String usuarioPlaylist;
        do {
            try {
                System.out.println("Qual o nome da playlist?");
                String nomePlaylist = prompt.nextLine();
                System.out.println("Qual usuário será dono da playlist?");
                usuarioPlaylist = prompt.nextLine();
                
                usuarioValido = p1.buscarUsuario(usuarioPlaylist);

                ultimPlaylist = new Playlist(nomePlaylist, usuarioValido);
                System.out.println("Cadastro concluido, deseja incluir novas músicas?");                
            } catch (IllegalArgumentException error) {
                System.out.println("Error :" + error.getMessage());
            }                        
        } while (usuarioValido == null);
        int opcao = 0;
        do {
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
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
        } while (opcao != 2);
    }

    public void buscarMusicaPorId(){
        prompt.nextLine();
        System.out.println("Qual o id da música que você deseja buscar?");
        Musica valido;
        try {
            do {
                    int idMusica =  Integer.parseInt(prompt.nextLine());        
                    valido = p1.buscarMusicaPorId(idMusica);
                    if (valido == null) {
                        System.out.println("Id inválido");
                    }
                    else{
                        System.out.println("Música           - " + valido.getTitulo());
                        System.out.println("Artista          - " + valido.getArtista());
                        System.out.println("Reproduções      - " + valido.getReproducoes());
                        System.out.println("Duração          - " + valido.getDuracaoFormatada());
                        System.out.println("Duração segundos - " + valido.getDuracaoSegundos());
                        System.out.println("Id música        - " + valido.getId());
                    }
            } while (valido == null);            
        } catch (IllegalArgumentException error) {
            System.out.println("Error: " + error.getMessage());
        }
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
