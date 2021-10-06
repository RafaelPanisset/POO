package ADIVINHE;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JOptionPane;

public class Adivinhe extends JFrame 
{
	
	
	int valorAleatorio = gerarValor(), valorAntigo = 100000000;
	
	// Funcao para gerar o número aleátorio
	public int gerarValor() {
		return (int)(Math.random() * 100);
	}
	

	
	//retornar 1 se tiver perto, zero se nao e 2 se acertou
	public int verificarSeTaPerto(JTextField caixa1) {
		int valorDigitado =  Integer.parseInt(caixa1.getText());
		int diff = Math.abs(valorDigitado - valorAleatorio);

		if (valorDigitado == valorAleatorio) {
			return 2;
		}
		else if (diff <= valorAntigo && valorDigitado <= 100 && valorDigitado >= 1) {
			valorAntigo = diff;
			return 1;
		}
		else {
			valorAntigo = diff;
			return 0;
		}
	}
	
	public Adivinhe() 	//construtor da classe
   {	this.setTitle("ADIVINHE");
		this.setSize(480,200);
		this.setVisible(true);
		this.setResizable(false);
		
		// Obtem o Container do JFrame
		Container c = this.getContentPane();

		// Inclui o JPanel ao JFrame
		JPanel painel = new JPanel();
		c.add(painel);

		// valor 1
		JLabel valor1 = new JLabel("Eu tenho um número entre 1 e 100,\r\n"
				+ " você pode adivinhá-lo? Entre com seu chute!");
		valor1.setToolTipText("valor 1");
		painel.add(valor1);
		
		// Componente JTextField
		JTextField caixa1 = new JTextField(25);
		painel.add(caixa1);
		
			
		
		// Componentes JButton
		
		JButton botao1 = new JButton("Verificar");
		JButton botao2 = new JButton("Criar novo jogo");
		
		
		painel.add(botao1);
		painel.add(botao2);
	

		//botao verificar
		botao1.addActionListener(new ActionListener()     
		{	public void actionPerformed(ActionEvent e)
			{			       	
				
				
				int resultado = verificarSeTaPerto(caixa1);
				if (resultado == 2) {
			        caixa1.setEditable(false);
			        JOptionPane.showMessageDialog (null, "Parabéns! Você acertou!");
					
				}
				else if (resultado == 1) {
					painel.setBackground(Color.RED);
			        JOptionPane.showMessageDialog(null, "Mais perto");

				}
				else {
					painel.setBackground(Color.BLUE);
			        JOptionPane.showMessageDialog(null, "Mais longe");

				}
			
		}});
	
		//botao iniciar novo jogo
		botao2.addActionListener(new ActionListener()    	
		{	public void actionPerformed(ActionEvent e)
			{		
				valorAleatorio = gerarValor();
				valorAntigo = 100000000;
				caixa1.setEditable(true);
				caixa1.setText("");
				painel.setBackground(Color.GRAY);		
		}});
	
		// Metodos do objeto JFrame, usados no final do Construtor
		// para garantir que os novos componentes incluídos apareçam de forma correta
		this.setVisible(true);
		this.repaint();
		painel.setBackground(Color.GRAY);
	    setLocationRelativeTo(null);

	}
}