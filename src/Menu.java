import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
	public static JButton opcao1,opcao2,opcao3;

	
	public static void menu_inicial(){
		
		Menu inicial = new Menu();
		opcao1 = new JButton("Controlar estoque");
		opcao2 = new JButton("Efetuar venda");
		opcao3 = new JButton("Relatórios");
		
		inicial.setLayout(new FlowLayout(FlowLayout.LEFT));
		inicial.add(opcao1);
		inicial.add(opcao2);
		opcao2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento){
				if(evento.getSource() == opcao2){
					Venda.realizar_venda();
					
				}
			}
		}
				);
		
		inicial.add(opcao3);
		
		inicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inicial.setSize(500,500);
		inicial.setVisible(true);
		inicial.setResizable(false);
		inicial.setLocationRelativeTo(null);
		
	}

}
