package com.mycompany.listadecompras;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;

public class ListaDeCompras {
    private static int indice = 0;
    ArrayList<Compras> vItem = new ArrayList<>();
    
    public static void main(String[] args) {

       JFrame janela = new JFrame("Lista de Compras");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(600, 500);
        janela.setLayout(new GridLayout(1, 2));

        // Primeiro painel
        
        JPanel painel1 = new JPanel();
        painel1.setLayout(null);
        
        JLabel lblNomeItem1 = new JLabel("Nome do Item:");
        lblNomeItem1.setBounds(20, 20, 100, 20);
        painel1.add(lblNomeItem1);

        JTextField txtNomeItem = new JTextField();
        txtNomeItem.setBounds(120, 20, 150, 20);
        painel1.add(txtNomeItem);

        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(20, 50, 100, 20);
        painel1.add(lblQuantidade);

        JTextField txtQuantidade = new JTextField();
        txtQuantidade.setBounds(120, 50, 150, 20);
        painel1.add(txtQuantidade);
        
        JLabel lblValor = new JLabel("Valor pretendido:");
        lblValor.setBounds(20, 80, 100, 20);
        painel1.add(lblValor);

        JTextField txtValor = new JTextField();
        txtValor.setBounds(120, 80, 150, 20);
        painel1.add(txtValor);
        
        JLabel lblTipo = new JLabel("Tipo do produtor");
        lblTipo.setBounds(20, 110, 100, 20);
        painel1.add(lblTipo);

        JTextField txtTipo = new JTextField();
        txtTipo.setBounds(120, 110, 150, 20);
        painel1.add(txtTipo);

  
        JButton btnSubmeter = new JButton("Submeter");
        btnSubmeter.setBounds(120, 140, 100, 30);
        painel1.add(btnSubmeter);

        JTextArea txtResultado = new JTextArea("Lista de Compras");
        txtResultado.setBounds(20, 190, 250, 250);
        painel1.add(txtResultado);

        janela.add(painel1);

        // Segundo painel
        
        JPanel painel2 = new JPanel();
        painel2.setLayout(null);

        JLabel lblNomeItem2 = new JLabel("Consulta Item");
        lblNomeItem2.setBounds(20, 20, 100, 20);
        painel2.add(lblNomeItem2);
        
        JTextField txtNomeItem2 = new JTextField();
        txtNomeItem2.setBounds(120, 20, 150, 20);
        painel2.add(txtNomeItem2);
        
        JButton btnSubmeter2 = new JButton("Submeter");
        btnSubmeter2.setBounds(120, 50, 100, 30);
        painel2.add(btnSubmeter2);

        JLabel lblQuantidade2 = new JLabel("Deletar Item");
        lblQuantidade2.setBounds(20, 90, 100, 20);
        painel2.add(lblQuantidade2);

        JTextField txtQuantidade2 = new JTextField();
        txtQuantidade2.setBounds(120, 90, 150, 20);
        painel2.add(txtQuantidade2);
        
         JButton btnSubmeter3 = new JButton("Submeter");
        btnSubmeter3.setBounds(120, 120, 100, 30);
        painel2.add(btnSubmeter3);

        JTextArea txtResultado2 = new JTextArea("Consulta dos itens \n");
        txtResultado2.setBounds(20, 170, 250, 270);
        painel2.add(txtResultado2);

        janela.add(painel2);
        
        //Logica
        
        ArrayList<Compras> vItem = new ArrayList<>();
           
        //Botao 1
        
        btnSubmeter.addActionListener(e -> {
            
            String nomeItem = txtNomeItem.getText();
            int quantidade = Integer.parseInt(txtQuantidade.getText());
            double valor = Double.parseDouble(txtValor.getText());
            String tipo = txtTipo.getText();
            
            txtNomeItem.setText("");
            txtQuantidade.setText("");
            txtValor.setText("");
            txtTipo.setText("");
            
            vItem.add(new Compras(nomeItem, quantidade, valor, tipo));
            indice++;

            StringBuilder resultado = new StringBuilder();
            
            for (int i = 0; i < indice; i++) {
                resultado.append(i + " - " + vItem.get(i).ImprimiDados());
            }
             txtResultado.setText(resultado.toString());
        });
        
        //Botao 2
        
        btnSubmeter2.addActionListener(e -> {
            String Consulta = txtNomeItem2.getText();
            
           txtResultado2.setText("");
            
           for(int i = 0; i < vItem.size() ; i++){
                if (Consulta.equals(Integer.toString(i))) {
                txtResultado2.append(vItem.get(i).ConsultaDados());
                break;
                }
            }
        });
        
        //Botao 3
        
       btnSubmeter3.addActionListener(e -> {
            String removeDado = txtQuantidade2.getText();
            int indiceRemocao = Integer.parseInt(removeDado);

            if (indiceRemocao >= 0 && indiceRemocao < indice) {
                vItem.remove(indiceRemocao);
                indice--;
                txtResultado.setText("Item removido com sucesso.");

                // Limpa a área de texto
                txtResultado.setText("");

                // Exibe novamente todos os itens restantes
                StringBuilder resultado = new StringBuilder();
                for (int i = 0; i < indice; i++) {
                    resultado.append(i + " - " + vItem.get(i).ImprimiDados());
                }
                txtResultado.setText(resultado.toString());
            } else {
                txtResultado.setText("Índice inválido. O item não foi removido.");
            }
        });

        janela.setVisible(true);        
        }
    }

