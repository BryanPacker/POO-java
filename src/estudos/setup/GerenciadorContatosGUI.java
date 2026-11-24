package estudos.setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

// Classe principal: GUI + Arquivo
public class GerenciadorContatosGUI extends JFrame {

    // ===== COMPONENTES GUI =====
    private JTextField campoNome;
    private JTextField campoEmail;
    private JTextField campoTelefone;
    private JButton botaoAdicionar;
    private JButton botaoSalvar;
    private JButton botaoCarregar;
    private JTextArea areaExibicao;

    // ===== DADOS =====
    private ArrayList<Contato> contatos;
    private String nomeArquivo = "contatos.txt";

    // ===== CONSTRUTOR =====
    public GerenciadorContatosGUI() {
        // Configurações básicas da janela
        setTitle("Gerenciador de Contatos");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializa lista de contatos
        contatos = new ArrayList<>();

        // Cria os componentes visuais
        criarComponentes();

        // Carrega contatos que foram salvos antes
        carregarDoArquivo();

        setVisible(true);
    }

    // ===== CRIAR COMPONENTES VISUAIS =====
    private void criarComponentes() {
        // Painel superior para entrada de dados
        JPanel painelEntrada = new JPanel();
        painelEntrada.setLayout(new GridLayout(4, 2, 5, 5));
        painelEntrada.setBorder(BorderFactory.createTitledBorder("Novo Contato"));

        // Labels e campos
        painelEntrada.add(new JLabel("Nome:"));
        campoNome = new JTextField();
        painelEntrada.add(campoNome);

        painelEntrada.add(new JLabel("Email:"));
        campoEmail = new JTextField();
        painelEntrada.add(campoEmail);

        painelEntrada.add(new JLabel("Telefone:"));
        campoTelefone = new JTextField();
        painelEntrada.add(campoTelefone);

        // Botão Adicionar
        botaoAdicionar = new JButton("Adicionar à Lista");
        botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarContato();
            }
        });
        painelEntrada.add(botaoAdicionar);

        // Painel inferior para botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());

        botaoSalvar = new JButton("💾 Salvar em Arquivo");
        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarNoArquivo();
            }
        });
        painelBotoes.add(botaoSalvar);

        botaoCarregar = new JButton("📂 Carregar do Arquivo");
        botaoCarregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregarDoArquivo();
            }
        });
        painelBotoes.add(botaoCarregar);

        // Área para exibir contatos
        areaExibicao = new JTextArea();
        areaExibicao.setEditable(false);
        areaExibicao.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(areaExibicao);

        // Adiciona tudo na janela
        add(painelEntrada, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
    }

    // ===== LÓGICA: ADICIONAR CONTATO À LISTA =====
    private void adicionarContato() {
        String nome = campoNome.getText();
        String email = campoEmail.getText();
        String telefone = campoTelefone.getText();

        // Validação simples
        if (nome.isBlank() || email.isBlank() || telefone.isBlank()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }

        // Cria contato e adiciona à lista
        Contato c = new Contato(nome, email, telefone);
        contatos.add(c);

        // Limpa campos
        campoNome.setText("");
        campoEmail.setText("");
        campoTelefone.setText("");

        // Atualiza exibição
        atualizarExibicao();
    }

    // ===== LÓGICA: ATUALIZAR O QUE APARECE NA TELA =====
    private void atualizarExibicao() {
        StringBuilder texto = new StringBuilder();
        texto.append("===== CONTATOS CARREGADOS =====\n\n");

        if (contatos.isEmpty()) {
            texto.append("(Nenhum contato ainda)");
        } else {
            for (int i = 0; i < contatos.size(); i++) {
                texto.append((i + 1)).append(". ").append(contatos.get(i)).append("\n");
            }
        }

        areaExibicao.setText(texto.toString());
    }

    // ===== ARQUIVO: SALVAR EM ARQUIVO =====
    private void salvarNoArquivo() {
        try {
            // FileWriter cria/abre arquivo para escrita
            FileWriter fw = new FileWriter(nomeArquivo);
            PrintWriter pw = new PrintWriter(fw);

            // Escreve cada contato em uma linha
            for (Contato c : contatos) {
                pw.println(c.paraArquivo());
            }

            // Fecha o arquivo
            pw.close();
            fw.close();

            JOptionPane.showMessageDialog(this,
                "✅ Salvos " + contatos.size() + " contatos em: " + nomeArquivo);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "❌ Erro ao salvar: " + e.getMessage());
        }
    }

    // ===== ARQUIVO: CARREGAR DO ARQUIVO =====
    private void carregarDoArquivo() {
        File arquivo = new File(nomeArquivo);

        // Se arquivo não existe, apenas retorna
        if (!arquivo.exists()) {
            JOptionPane.showMessageDialog(this, "Arquivo não encontrado. Crie um novo.");
            return;
        }

        try {
            // FileReader lê o arquivo
            FileReader fr = new FileReader(nomeArquivo);
            BufferedReader br = new BufferedReader(fr);

            // Limpa lista anterior
            contatos.clear();

            // Lê linha por linha
            String linha;
            while ((linha = br.readLine()) != null) {
                Contato c = Contato.deArquivo(linha);
                if (c != null) {
                    contatos.add(c);
                }
            }

            // Fecha arquivo
            br.close();
            fr.close();

            // Atualiza exibição
            atualizarExibicao();
            JOptionPane.showMessageDialog(this,
                "✅ Carregados " + contatos.size() + " contatos do arquivo");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "❌ Erro ao carregar: " + e.getMessage());
        }
    }

    // ===== MAIN =====
    public static void main(String[] args) {
        new GerenciadorContatosGUI();
    }
}
