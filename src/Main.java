import view.*;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import view.*;
import controller.Cadastro;
import controller.Supermercado;
import model.Gerente;

public class Main {
    
   
    
    public static void main(String[] args) {
        
                Leitor leitor1 = new Leitor(100,10);
                Leitor leitor2 = new Leitor(1100,10);

                
                Supermercado.getInstancia().carregaSupermercado();
                //Supermercado.getInstancia().getEstoque().itens();
                
                Supermercado.getInstancia().getCadastro().insereGerente("Liviolixoso","livio" , "1234");
                Supermercado.getInstancia().getCadastro().insereUsuario("Pollianna", "pmachado", "123");
                Supermercado.getInstancia().getCadastro().insereUsuario("Lixoso", "lix", "9876");
                Supermercado.getInstancia().getCadastro().insereGerente("Kaio", "kteixeira", "123");
                
		Login login = new Login();
		login.setVisible(true);
        
    }

}
