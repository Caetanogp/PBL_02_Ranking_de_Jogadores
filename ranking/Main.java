import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        final BinarySearchTree bst = new BinarySearchTree();
        carregaCSV(bst, "../players.csv");

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal(bst).setVisible(true);
            }
        });
    }

    private static void carregaCSV(BinarySearchTree bst, String caminho) {
        Lista linhas = new Lista();
        BufferedReader leitor = null;
        try {
            leitor = new BufferedReader(new FileReader(caminho));
            String linha = leitor.readLine();
            linha = leitor.readLine();
            while (linha != null) {
                if (!linha.trim().isEmpty()) {
                    linhas.adiciona(linha);
                }
                linha = leitor.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o csv: " + e.getMessage());
            return;
        } finally {
            try {
                if (leitor != null) {
                    leitor.close();
                }
            } catch (IOException e) {
            }
        }

        for (int i = linhas.tamanho() - 1; i >= 0; i--) {
            String linha = linhas.get(i);
            String[] partes = linha.split(",");
            if (partes.length < 2) {
                continue;
            }
            try {
                String nick = partes[0].trim();
                int rank = Integer.parseInt(partes[1].trim());
                bst.insert(new Player(nick, rank));
            } catch (NumberFormatException e) {
            }
        }
    }
}
