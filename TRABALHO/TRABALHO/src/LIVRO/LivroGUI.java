package LIVRO;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LivroGUI extends JFrame{	
	public int livroQuanti = 0;
	
	
	public LivroGUI() {
		this.setTitle("Controle de Livros");
		this.setSize(300,250);
		this.setResizable(false);		
		
		
		Container tela = this.getContentPane();
		
		
		JPanel painel = new JPanel();
		tela.add(painel);	
		
		// valor 1
		JLabel valor1 = new JLabel("Digite o titulo: ");
		valor1.setToolTipText("Titulo");
		painel.add(valor1);
		
		// Componente JTextField
		JTextField caixa1 = new JTextField(25);
		painel.add(caixa1);
		
		// valor 2
		JLabel valor2 = new JLabel("Digite o numero de paginas: ");
		valor2.setToolTipText("Paginas");
		painel.add(valor2);
		
		JTextField caixa2 = new JTextField(25);
		painel.add(caixa2);
		
		
		JButton adicionar = new JButton("Adicionar");
		painel.add(adicionar);
		
		JButton listar = new JButton("Listar");
		painel.add(listar);
		
		
		Livro[] LivrosList = new Livro[200];	
			
		DefaultListModel livros = new DefaultListModel();
		JList listaDeLivros = new JList (livros);		
		painel.add(listaDeLivros);
		listaDeLivros.setVisible(false);
		
		adicionar.addActionListener(new ActionListener()     // botão +
		{
			public void actionPerformed(ActionEvent e)
			{
				String tituloLivro = caixa1.getText();
				int paginasLivros = Integer.parseInt(caixa2.getText());
				listaDeLivros.setVisible(false);
				LivrosList[livroQuanti++] = new Livro(tituloLivro, paginasLivros);
		        JOptionPane.showMessageDialog (null, "Adicionado com sucesso!");
		        caixa1.setText("");
		        caixa2.setText("");
				
						
		}});
		
		listar.addActionListener(new ActionListener()     // botão +
		{
			public void actionPerformed(ActionEvent e)
			{
				livros.clear();
				for (int i = 0; i < livroQuanti; i++) {
					livros.addElement(LivrosList[i].getLivros());	
				}
				listaDeLivros.setVisible(true);
				listaDeLivros.setVisibleRowCount(10);
								
		}});
				
		
		this.setVisible(true);
	    setLocationRelativeTo(null);
		this.repaint();
	}
}
			
