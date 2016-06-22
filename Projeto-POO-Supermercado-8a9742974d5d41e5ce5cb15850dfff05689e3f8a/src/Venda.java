import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Venda extends JFrame {
	private static JLabel label_pgto,label_pagar,label_total;
	private static JTextField valor_pgto,valor_pagar,valor_total;
	
	public static void realizar_venda(){
		
		//Criação da Janela
		Venda janela_venda = new Venda();
		janela_venda.setLayout(new FlowLayout(FlowLayout.LEFT));
		janela_venda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela_venda.setSize(500,500);
		janela_venda.setVisible(true);
		janela_venda.setResizable(false);
		janela_venda.setLocationRelativeTo(null);
		
		//Criação das Labels
		label_pagar = new JLabel("Valor a pagar: ");
		janela_venda.add(label_pagar);
		
		valor_pagar = new JTextField(10);
		janela_venda.add(valor_pagar);
		
	}

}
