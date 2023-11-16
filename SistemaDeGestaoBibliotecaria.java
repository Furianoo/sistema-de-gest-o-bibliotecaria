import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SistemaDeGestaoBibliotecaria extends JFrame implements ActionListener {
    private JLabel rotulo1, rotulo2, rotulo3, rotulo4, rotulo5, rotulo6, rotulo7;
    private JTextField campoTexto1, campoTexto2, campoTexto3, campoTexto4, campoTexto5, campoTexto6, campoTexto7;
    private JButton botaoAdicionar, botaoVisualizar, botaoEditar, botaoExcluir, botaoLimpar, botaoSair;
    private JPanel painel;
    private ArrayList<String[]> livros = new ArrayList<String[]>();

    public SistemaDeGestaoBibliotecaria() {
        setTitle("Sistema de Gestão Bibliotecária");
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        rotulo1 = new JLabel("ID do Livro");
        rotulo2 = new JLabel("Título do Livro");
        rotulo3 = new JLabel("Autor");
        rotulo4 = new JLabel("Editora");
        rotulo5 = new JLabel("Ano de Publicação");
        rotulo6 = new JLabel("ISBN");
        rotulo7 = new JLabel("Número de Cópias");

        campoTexto1 = new JTextField(10);
        campoTexto2 = new JTextField(20);
        campoTexto3 = new JTextField(20);
        campoTexto4 = new JTextField(20);
        campoTexto5 = new JTextField(10);
        campoTexto6 = new JTextField(20);
        campoTexto7 = new JTextField(10);

        botaoAdicionar = new JButton("Adicionar");
        botaoVisualizar = new JButton("Visualizar");
        botaoEditar = new JButton("Editar");
        botaoExcluir = new JButton("Excluir");
        botaoLimpar = new JButton("Limpar");
        botaoSair = new JButton("Sair");

        botaoAdicionar.addActionListener(this);
        botaoVisualizar.addActionListener(this);
        botaoEditar.addActionListener(this);
        botaoExcluir.addActionListener(this);
        botaoLimpar.addActionListener(this);
        botaoSair.addActionListener(this);

        painel = new JPanel(new GridLayout(10, 2));
        painel.add(rotulo1);
        painel.add(campoTexto1);
        painel.add(rotulo2);
        painel.add(campoTexto2);
        painel.add(rotulo3);
        painel.add(campoTexto3);
        painel.add(rotulo4);
        painel.add(campoTexto4);
        painel.add(rotulo5);
        painel.add(campoTexto5);
        painel.add(rotulo6);
        painel.add(campoTexto6);
        painel.add(rotulo7);
        painel.add(campoTexto7);
        painel.add(botaoAdicionar);
        painel.add(botaoVisualizar);
        painel.add(botaoEditar);
        painel.add(botaoExcluir);
        painel.add(botaoLimpar);
        painel.add(botaoSair);

        add(painel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoAdicionar) {
            String[] livro = new String[7];
            livro[0] = campoTexto1.getText();
            livro[1] = campoTexto2.getText();
            livro[2] = campoTexto3.getText();
            livro[3] = campoTexto4.getText();
            livro[4] = campoTexto5.getText();
            livro[5] = campoTexto6.getText();
            livro[6] = campoTexto7.getText();
            livros.add(livro);
            JOptionPane.showMessageDialog(this, "Livro adicionado com sucesso");
            limparCampos();
        } else if (e.getSource() == botaoVisualizar) {
            String[] colunas = {"ID do Livro", "Título do Livro", "Autor", "Editora", "Ano de Publicação", "ISBN", "Número de Cópias"};
            Object[][] dados = new Object[livros.size()][7];
            for (int i = 0; i < livros.size(); i++) {
                dados[i][0] = livros.get(i)[0];
                dados[i][1] = livros.get(i)[1];
                dados[i][2] = livros.get(i)[2];
                dados[i][3] = livros.get(i)[3];
                dados[i][4] = livros.get(i)[4];
                dados[i][5] = livros.get(i)[5];
                dados[i][6] = livros.get(i)[6];
            }
            JTable tabela = new JTable(dados, colunas);
            JScrollPane painelRolagem = new JScrollPane(tabela);
            JFrame frame = new JFrame("Visualizar Livros");
            frame.add(painelRolagem);
            frame.setSize(800, 400);
            frame.setVisible(true);
        } else if (e.getSource() == botaoEditar) {
            String idLivro = JOptionPane.showInputDialog(this, "Digite o ID do livro para editar:");
            for (int i = 0; i < livros.size(); i++) {
                if (livros.get(i)[0].equals(idLivro)) {
                    String[] livro = new String[7];
                    livro[0] = idLivro;
                    livro[1] = campoTexto2.getText();
                    livro[2] = campoTexto3.getText();
                    livro[3] = campoTexto4.getText();
                    livro[4] = campoTexto5.getText();
                    livro[5] = campoTexto6.getText();
                    livro[6] = campoTexto7.getText();
                    livros.set(i, livro);
                    JOptionPane.showMessageDialog(this, "Livro editado com sucesso");
                    limparCampos();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Livro não encontrado");
        } else if (e.getSource() == botaoExcluir) {
            String idLivro = JOptionPane.showInputDialog(this, "Digite o ID do livro para excluir:");
            for (int i = 0; i < livros.size(); i++) {
                if (livros.get(i)[0].equals(idLivro)) {
                    livros.remove(i);
                    JOptionPane.showMessageDialog(this, "Livro excluído com sucesso");
                    limparCampos();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Livro não encontrado");
        } else if (e.getSource() == botaoLimpar) {
            limparCampos();
        } else if (e.getSource() == botaoSair) {
            System.exit(0);
        }
    }

    private void limparCampos() {
        campoTexto1.setText("");
        campoTexto2.setText("");
        campoTexto3.setText("");
        campoTexto4.setText("");
        campoTexto5.setText("");
        campoTexto6.setText("");
        campoTexto7.setText("");
    }

    public static void main(String[] args) {
        new SistemaDeGestaoBibliotecaria();
    }
}
