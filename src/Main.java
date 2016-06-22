
import data.Programa;
import view.*;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import view.*;
import data.Cadastro;
import object.Gerente;

public class Main {

    public static void main(String[] args) {
                Programa.carregaPrograma();
                Cadastro.insereGerente("Liviolixoso","livio" , "1234");
                Cadastro.insereUsuario("Pollianna", "pmachado", "123");
                Cadastro.insereUsuario("Lixoso", "lix", "9876");
                
		Login login = new Login();
		login.setVisible(true);
                  
                
	login.setVisible(true);
                  //Programa.salvaPrograma();
        

//                  data.Estoque.insereProduto("1","Banana",8.00F,5);
//                  data.Estoque.insereProduto("1","Banana",8.00F,1);
//                 //Estoque.consultaProduto("Banana");
//                  data.Estoque.consultaProduto("2");
        // Estoque.retiraProduto("Banana", 2);
//                  Estoque.insereProduto(Estoque.estoque, "1", "Abacaxi", 20.00F);
//                  Estoque.insereProduto(Estoque.estoque,"2","Maçã",5.00F);
//                  Estoque.insereProduto(Estoque.estoque,"2","Maçã",5.00F);
//                  Estoque.insereProduto(Estoque.estoque,"2","Maçã",5.00F);
//                  Estoque.insereProduto(Estoque.estoque,"2","Maçã",5.00F);
//                  Estoque.retiraProduto(Estoque.estoque, "Maçã");
//                  Estoque.consultaProduto(Estoque.estoque,"Maçã");
        /* for (i=0;i<Estoque.estoque.size();i++){
                      System.out.println(Estoque.estoque.get(i).getNomeProduto());
                  }*/
    }

}
