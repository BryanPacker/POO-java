package estudos.exemplo_completo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Interface gráfica completa da Biblioteca
public class BibliotecaGUI extends JFrame {

    // ===== COMPONENTES GUI =====

    // Painel de entrada
    private JTextField campoTitulo;
    private JTextField campoAutor;
    private JTextField campoIsbn;
    private JTextField campoPreco;
    private JTextField campoAno;
    private JButton botaoAdicionar;

    // Painel de busca
    private JTextField campoBuscaTitulo;
    private JTextField campoBuscaAutor;
    private JButton botaoBuscaTitulo;
    private JButton botaoBuscaAutor;
    private JButton botaoMostrarTodos;

    // Painel de exibição
    private JTextArea areaExibicao;

    // Painel de estatísticas
    private JLabel labelTotal;
    private JLabel labelDisponiveis;
    private JLabel labelValorTotal;

    // Painel de gerenciamento
    private JTextField campoIdRemover;
    private JButton botaoRemover;
    private JButton botaoSalvar;
    private JButton botaoCarregar;

    // ===== DADOS =====
    private Biblioteca biblioteca;

    // ===== CONSTRUTOR =====
    public BibliotecaGUI() {
        // Configurações da janela
        setTitle("📚 Sistema de Biblioteca");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Cria objeto da biblioteca
        biblioteca = new Biblioteca("biblioteca.txt");
        biblioteca.carregar();

        // Cria interface visual
        criarInterface();

        // Atualiza exibição inicial
        atualizarExibicao();
        atualizarEstatisticas();

        setVisible(true);
    }

    // ===== CRIAR INTERFACE =====
    private void criarInterface() {
        // Painel principal com abas
        JTabbedPane abas = new JTabbedPane();

        abas.addTab("➕ Adicionar", criarPainelAdicionar());
        abas.addTab("🔍 Buscar", criarPainelBuscar());
        abas.addTab("📊 Visualizar", criarPainelVisualizar());
        abas.addTab("⚙️ Gerenciar", criarPainelGerenciar());

        add(abas, BorderLayout.CENTER);
    }

    // ===== PAINEL 1: ADICIONAR =====
    private JPanel criarPainelAdicionar() {
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Formulário
        JPanel formulario = new JPanel();
        formulario.setLayout(new GridLayout(6, 2, 5, 5));
        formulario.setBorder(BorderFactory.createTitledBorder("Novo Livro"));

        formulario.add(new JLabel("Título:"));
        campoTitulo = new JTextField();
        formulario.add(campoTitulo);

        formulario.add(new JLabel("Autor:"));
        campoAutor = new JTextField();
        formulario.add(campoAutor);

        formulario.add(new JLabel("ISBN:"));
        campoIsbn = new JTextField();
        formulario.add(campoIsbn);

        formulario.add(new JLabel("Preço (R$):"));
        campoPreco = new JTextField();
        formulario.add(campoPreco);

        formulario.add(new JLabel("Ano de Publicação:"));
        campoAno = new JTextField();
        formulario.add(campoAno);

        botaoAdicionar = new JButton("✅ Adicionar à Biblioteca");
        botaoAdicionar.addActionListener(e -> adicionarLivro());
        formulario.add(botaoAdicionar);

        painel.add(formulario, BorderLayout.NORTH);
        painel.add(new JPanel(), BorderLayout.CENTER); // Espaço em branco

        return painel;
    }

    // ===== PAINEL 2: BUSCAR =====
    private JPanel criarPainelBuscar() {
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Painel de filtros
        JPanel filtros = new JPanel();
        filtros.setLayout(new GridLayout(2, 3, 5, 5));
        filtros.setBorder(BorderFactory.createTitledBorder("Filtros de Busca"));

        filtros.add(new JLabel("Buscar por Título:"));
        campoBuscaTitulo = new JTextField();
        filtros.add(campoBuscaTitulo);
        botaoBuscaTitulo = new JButton("🔍 Buscar");
        botaoBuscaTitulo.addActionListener(e -> buscarPorTitulo());
        filtros.add(botaoBuscaTitulo);

        filtros.add(new JLabel("Buscar por Autor:"));
        campoBuscaAutor = new JTextField();
        filtros.add(campoBuscaAutor);
        botaoBuscaAutor = new JButton("🔍 Buscar");
        botaoBuscaAutor.addActionListener(e -> buscarPorAutor());
        filtros.add(botaoBuscaAutor);

        botaoMostrarTodos = new JButton("📋 Mostrar Todos");
        botaoMostrarTodos.addActionListener(e -> atualizarExibicao());
        filtros.add(botaoMostrarTodos);

        // Área de exibição
        areaExibicao = new JTextArea();
        areaExibicao.setEditable(false);
        areaExibicao.setFont(new Font("Monospaced", Font.PLAIN, 11));
        JScrollPane scroll = new JScrollPane(areaExibicao);

        painel.add(filtros, BorderLayout.NORTH);
        painel.add(scroll, BorderLayout.CENTER);

        return painel;
    }

    // ===== PAINEL 3: VISUALIZAR =====
    private JPanel criarPainelVisualizar() {
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Estatísticas
        JPanel stats = new JPanel();
        stats.setLayout(new GridLayout(1, 3, 10, 10));
        stats.setBorder(BorderFactory.createTitledBorder("Estatísticas"));

        labelTotal = new JLabel("Total de Livros: 0");
        labelTotal.setFont(new Font("Arial", Font.BOLD, 14));
        stats.add(labelTotal);

        labelDisponiveis = new JLabel("Disponíveis: 0");
        labelDisponiveis.setFont(new Font("Arial", Font.BOLD, 14));
        stats.add(labelDisponiveis);

        labelValorTotal = new JLabel("Valor Total: R$ 0.00");
        labelValorTotal.setFont(new Font("Arial", Font.BOLD, 14));
        stats.add(labelValorTotal);

        // Botão para atualizar estatísticas
        JButton botaoAtualizar = new JButton("🔄 Atualizar");
        botaoAtualizar.addActionListener(e -> atualizarEstatisticas());

        JPanel botoesStats = new JPanel();
        botoesStats.add(botaoAtualizar);

        painel.add(stats, BorderLayout.NORTH);
        painel.add(botoesStats, BorderLayout.CENTER);

        return painel;
    }

    // ===== PAINEL 4: GERENCIAR =====
    private JPanel criarPainelGerenciar() {
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Painel de remoção
        JPanel remocao = new JPanel();
        remocao.setLayout(new FlowLayout());
        remocao.setBorder(BorderFactory.createTitledBorder("Remover Livro"));

        remocao.add(new JLabel("ID do Livro:"));
        campoIdRemover = new JTextField(10);
        remocao.add(campoIdRemover);

        botaoRemover = new JButton("❌ Remover");
        botaoRemover.addActionListener(e -> removerLivro());
        remocao.add(botaoRemover);

        // Painel de arquivo
        JPanel arquivo = new JPanel();
        arquivo.setLayout(new FlowLayout());
        arquivo.setBorder(BorderFactory.createTitledBorder("Arquivo"));

        botaoSalvar = new JButton("💾 Salvar em Arquivo");
        botaoSalvar.addActionListener(e -> salvarArquivo());
        arquivo.add(botaoSalvar);

        botaoCarregar = new JButton("📂 Carregar do Arquivo");
        botaoCarregar.addActionListener(e -> carregarArquivo());
        arquivo.add(botaoCarregar);

        painel.add(remocao, BorderLayout.NORTH);
        painel.add(arquivo, BorderLayout.CENTER);

        return painel;
    }

    // ===== LÓGICA: ADICIONAR =====
    private void adicionarLivro() {
        try {
            String titulo = campoTitulo.getText();
            String autor = campoAutor.getText();
            String isbn = campoIsbn.getText();
            double preco = Double.parseDouble(campoPreco.getText());
            int ano = Integer.parseInt(campoAno.getText());

            if (titulo.isBlank() || autor.isBlank() || isbn.isBlank()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
                return;
            }

            if (preco <= 0) {
                JOptionPane.showMessageDialog(this, "Preço deve ser maior que 0!");
                return;
            }

            if (ano < 1000 || ano > 2100) {
                JOptionPane.showMessageDialog(this, "Ano inválido!");
                return;
            }

            Livro livro = new Livro(titulo, autor, isbn, preco, ano);
            biblioteca.adicionarLivro(livro);

            campoTitulo.setText("");
            campoAutor.setText("");
            campoIsbn.setText("");
            campoPreco.setText("");
            campoAno.setText("");

            atualizarExibicao();
            atualizarEstatisticas();
            JOptionPane.showMessageDialog(this, "✅ Livro adicionado!");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "❌ Preço e Ano devem ser números!");
        }
    }

    // ===== LÓGICA: BUSCAR =====
    private void buscarPorTitulo() {
        String titulo = campoBuscaTitulo.getText();
        if (titulo.isBlank()) {
            atualizarExibicao();
            return;
        }

        ArrayList<Livro> resultados = biblioteca.buscarPorTitulo(titulo);
        exibirResultados(resultados);
    }

    private void buscarPorAutor() {
        String autor = campoBuscaAutor.getText();
        if (autor.isBlank()) {
            atualizarExibicao();
            return;
        }

        ArrayList<Livro> resultados = biblioteca.buscarPorAutor(autor);
        exibirResultados(resultados);
    }

    // ===== LÓGICA: REMOVER =====
    private void removerLivro() {
        try {
            int id = Integer.parseInt(campoIdRemover.getText());
            if (biblioteca.removerLivroPorId(id)) {
                atualizarExibicao();
                atualizarEstatisticas();
                campoIdRemover.setText("");
                JOptionPane.showMessageDialog(this, "✅ Livro removido!");
            } else {
                JOptionPane.showMessageDialog(this, "❌ Livro não encontrado!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "❌ Digite um ID válido!");
        }
    }

    // ===== LÓGICA: ATUALIZAR EXIBIÇÃO =====
    private void atualizarExibicao() {
        ArrayList<Livro> livros = biblioteca.obterTodosLivros();
        exibirResultados(livros);
    }

    private void exibirResultados(ArrayList<Livro> livros) {
        StringBuilder sb = new StringBuilder();
        sb.append("============ RESULTADOS ============\n");
        sb.append("Total encontrado: ").append(livros.size()).append("\n\n");

        if (livros.isEmpty()) {
            sb.append("(Nenhum resultado)");
        } else {
            for (Livro l : livros) {
                sb.append(l).append("\n");
            }
        }

        areaExibicao.setText(sb.toString());
    }

    // ===== LÓGICA: ESTATÍSTICAS =====
    private void atualizarEstatisticas() {
        int total = biblioteca.obterTodosLivros().size();
        int disponiveis = biblioteca.contarDisponiveis();
        double valor = biblioteca.calcularValorTotal();

        labelTotal.setText("Total de Livros: " + total);
        labelDisponiveis.setText("Disponíveis: " + disponiveis);
        labelValorTotal.setText(String.format("Valor Total: R$ %.2f", valor));
    }

    // ===== LÓGICA: ARQUIVO =====
    private void salvarArquivo() {
        if (biblioteca.salvar()) {
            JOptionPane.showMessageDialog(this, "✅ Biblioteca salva em arquivo!");
        } else {
            JOptionPane.showMessageDialog(this, "❌ Erro ao salvar!");
        }
    }

    private void carregarArquivo() {
        if (biblioteca.carregar()) {
            atualizarExibicao();
            atualizarEstatisticas();
            JOptionPane.showMessageDialog(this, "✅ Biblioteca carregada!");
        } else {
            JOptionPane.showMessageDialog(this, "❌ Erro ao carregar!");
        }
    }

    // ===== MAIN =====
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BibliotecaGUI());
    }
}
