
import view.*;
import controller.Supermercado;

public class Main {

    public static void main(String[] args) {
        Supermercado.getInstancia().carregaSupermercado();
        Leitor leitor1 = new Leitor(100, 10);
        Leitor leitor2 = new Leitor(900, 10);

        
        Supermercado.getInstancia().getCadastro().insereGerente("Liviolixoso", "livio", "1234");
        Supermercado.getInstancia().getCadastro().insereUsuario("Pollianna", "pmachado", "123");
        Supermercado.getInstancia().getCadastro().insereUsuario("Lixoso", "lix", "9876");
        Supermercado.getInstancia().getCadastro().insereGerente("Kaio", "kteixeira", "123");

        Login login = new Login();
        login.setVisible(true);

//       Venda venda1 = new Venda(0, "14/07/2016", Supermercado.getInstancia().getCadastro().getCadastro().get("kteixeira"));
//       venda1.registraItem("1", 1);
//       System.out.println(venda1.getIdVenda());
//       System.out.println(venda1.getData());
//       System.out.println(venda1.getCaixa().getNome());
//       System.out.println(venda1.getItensVenda().get(0).getProduto().getNomeProduto());
//       System.out.println(venda1.getItensVenda().get(0).getProduto().getPreco());
//       System.out.println(venda1.getItensVenda().get(0).getQuantidade());
    }

}
