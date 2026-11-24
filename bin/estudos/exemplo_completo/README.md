# 📚 Sistema de Biblioteca - Exemplo Completo

Um exemplo prático de **GUI + Persistência em Arquivo** em Java que você pode usar como referência na prova.

---

## 📂 Arquivos do Projeto

| Arquivo | Descrição |
|---------|-----------|
| `Livro.java` | Classe modelo: representa um livro com atributos |
| `Biblioteca.java` | Gerenciador de dados: salva/carrega do arquivo, busca, etc |
| `BibliotecaGUI.java` | Interface gráfica: Swing com 4 abas |
| `TesteBiblioteca.java` | Testes de lógica (sem GUI) |

---

## 🎯 O que Aprender Aqui

### **1. Classe Modelo** (Livro.java)
```java
✅ Atributos privados
✅ Construtor com validação
✅ Getters/Setters
✅ Método toString()
✅ Serialização: paraArquivo() / deArquivo()
✅ ID automático com static
```

### **2. Gerenciador de Dados** (Biblioteca.java)
```java
✅ ArrayList de objetos
✅ Busca por atributo
✅ Salvar em arquivo (FileWriter + PrintWriter)
✅ Carregar do arquivo (FileReader + BufferedReader)
✅ Cálculos/Estatísticas
✅ Tratamento de exceções (try-catch)
```

### **3. Interface Gráfica** (BibliotecaGUI.java)
```java
✅ JFrame - Janela principal
✅ JTabbedPane - Abas
✅ Componentes: JTextField, JTextArea, JButton, JLabel
✅ Layouts: GridLayout, FlowLayout, BorderLayout
✅ ActionListener para cliques
✅ JOptionPane para mensagens
✅ Validação de entrada
```

---

## 🚀 Como Usar

### **Compilar:**
```bash
javac -d bin src/estudos/exemplo_completo/*.java
```

### **Rodar GUI (com interface gráfica):**
```bash
java -cp bin estudos.exemplo_completo.BibliotecaGUI
```

### **Rodar testes (sem GUI):**
```bash
java -cp bin estudos.exemplo_completo.TesteBiblioteca
```

---

## 💾 Arquivos Gerados

- `biblioteca.txt` - Arquivo gerado pela GUI
- `biblioteca_teste.txt` - Arquivo gerado pelos testes

Formato do arquivo:
```
ID,TITULO,AUTOR,ISBN,PRECO,ANO,DISPONIVEL
1,1984,George Orwell,ISBN001,45.9,1949,true
2,Dom Casmurro,Machado de Assis,ISBN002,32.5,1899,true
```

---

## 🎨 Estrutura da GUI

### **Aba 1: ➕ Adicionar**
- Formulário para novo livro
- Validação de campos vazios
- Validação de números

### **Aba 2: 🔍 Buscar**
- Buscar por título (parcial)
- Buscar por autor (parcial)
- Mostrar todos os livros

### **Aba 3: 📊 Visualizar**
- Total de livros
- Livros disponíveis
- Valor total do acervo

### **Aba 4: ⚙️ Gerenciar**
- Remover livro por ID
- Salvar em arquivo
- Carregar do arquivo

---

## 🔑 Conceitos Principais

### **Padrão Model-View-Controller (MVC)**
```
Livro (Model) 
  ↓
Biblioteca (Controller)
  ↓
BibliotecaGUI (View)
```

### **Separação de Responsabilidades**
- `Livro`: Dados (atributos, getters, setters)
- `Biblioteca`: Lógica (CRUD, busca, arquivo)
- `BibliotecaGUI`: Interface (componentes, eventos)

### **Arquivo CSV**
- Simples de ler/escrever
- Fácil de debugar (abre em editor de texto)
- Separador: `,`
- Uma linha por objeto

---

## 📝 Exemplos de Código para Copiar na Prova

### **Validar entrada**
```java
if (campo.isBlank()) {
    JOptionPane.showMessageDialog(this, "Preencha o campo!");
    return;
}
```

### **Salvar em arquivo**
```java
FileWriter fw = new FileWriter("dados.txt");
PrintWriter pw = new PrintWriter(fw);
for (Objeto obj : lista) {
    pw.println(obj.paraArquivo());
}
pw.close();
```

### **Carregar do arquivo**
```java
BufferedReader br = new BufferedReader(new FileReader("dados.txt"));
lista.clear(); // ⚠️ IMPORTANTE!
String linha;
while ((linha = br.readLine()) != null) {
    Objeto obj = Objeto.deArquivo(linha);
    lista.add(obj);
}
br.close();
```

### **Buscar em ArrayList**
```java
for (Livro l : livros) {
    if (l.getTitulo().contains(termo)) {
        resultado.add(l);
    }
}
```

### **ActionListener**
```java
botao.addActionListener(e -> {
    // Código executado ao clicar
});
```

---

## ⚠️ Erros Comuns

| Erro | Solução |
|------|---------|
| `FileNotFoundException` | Arquivo não existe - criar ou verificar caminho |
| `NumberFormatException` | Campo contém texto não numérico - usar try-catch |
| `NullPointerException` | Objeto não encontrado - verificar antes de usar |
| Dados duplicados ao carregar | Usar `lista.clear()` antes de carregar |
| Arquivo não salva | Fechar arquivo com `close()` |

---

## 🎓 Pronto para a Prova!

Copie estrutura desse projeto e adapte para sua entidade específica:
1. Renomeie `Livro` → sua classe (Produto, Contato, etc)
2. Adapte `Biblioteca` → seus atributos e cálculos
3. Customize `BibliotecaGUI` → suas operações

Boa sorte! 🚀
