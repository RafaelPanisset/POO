package calculadora;

import java.awt.*;
import javax.swing.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calcular extends JFrame 
{
   
   public Calcular() 	//construtor da classe
   {	this.setTitle("Calculadora");
		this.setSize(300,250);
		this.setVisible(true);
		this.setResizable(false);
		
		// Obtem o Container do JFrame
		Container c = this.getContentPane();

		// Inclui o JPanel ao JFrame
		JPanel painel = new JPanel();
		c.add(painel);

		// valor 1
		JLabel valor1 = new JLabel("Valor 1: ");
		valor1.setToolTipText("valor 1");
		painel.add(valor1);
		
		// Componente JTextField
		JTextField caixa1 = new JTextField(25);
		painel.add(caixa1);
		
		// valor 2
		JLabel valor2 = new JLabel("Valor 2: ");
		valor2.setToolTipText("valor 2");
		painel.add(valor2);
		
		JTextField caixa2 = new JTextField(25);
		painel.add(caixa2);
		
		//resultado
		JLabel resultado = new JLabel("Resultado: ");
		resultado.setToolTipText("Resultado:");
		painel.add(resultado);
		
		JTextField caixa3 = new JTextField(25);
		painel.add(caixa3);
		
		
		
		
		// Componentes JButton
		
		JButton botao1 = new JButton("+");
		JButton botao2 = new JButton("-");
		JButton botao3 = new JButton("*");
		JButton botao4 = new JButton("/");
		
		painel.add(botao1);
		painel.add(botao2);
		painel.add(botao3);
		painel.add(botao4);

		// Eventos dos componentes JButton
		
		botao1.addActionListener(new ActionListener()     // botão +
		{	public void actionPerformed(ActionEvent e)
			{	
				int value = Integer.parseInt(caixa1.getText()) + Integer.parseInt(caixa2.getText());
		       	caixa3.setText(Integer.toString(value));
		}});
	
		botao2.addActionListener(new ActionListener()    	// botão -
		{	public void actionPerformed(ActionEvent e)
			{		
				int value = Integer.parseInt(caixa1.getText()) - Integer.parseInt(caixa2.getText());
		       	caixa3.setText(Integer.toString(value));
			}});
	
		botao3.addActionListener(new ActionListener()   	// botão -
		{	public void actionPerformed(ActionEvent e)
			{				    
				caixa3.setText("");
				int value = Integer.parseInt(caixa1.getText()) * Integer.parseInt(caixa2.getText());
		       	caixa3.setText(Integer.toString(value));
			}
		});
		
		botao4.addActionListener(new ActionListener()   	// botão /
		{	public void actionPerformed(ActionEvent e)
			{	
			    caixa3.setText("");
				int value = Integer.parseInt(caixa1.getText()) / Integer.parseInt(caixa2.getText());
		       	caixa3.setText(Integer.toString(value));
			}
		});
			
	

		
		// Metodos do objeto JFrame, usados no final do Construtor
		// para garantir que os novos componentes incluídos apareçam de forma correta
		this.setVisible(true);
		this.repaint();
		
	}
}

