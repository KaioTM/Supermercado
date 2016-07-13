
import view.*;
import controller.Supermercado;

public class Main {

    public static void main(String[] args) {

        Leitor leitor1 = new Leitor(100, 10);
        Leitor leitor2 = new Leitor(900, 10);

        Supermercado.getInstancia().carregaSupermercado();
        Supermercado.getInstancia().getCadastro().insereGerente("Liviolixoso", "livio", "1234");
        Supermercado.getInstancia().getCadastro().insereUsuario("Pollianna", "pmachado", "123");
        Supermercado.getInstancia().getCadastro().insereUsuario("Lixoso", "lix", "9876");
        Supermercado.getInstancia().getCadastro().insereGerente("Kaio", "kteixeira", "123");

        Login login = new Login();
        login.setVisible(true);
        System.out.print(Supermercado.getInstancia().getRelatorios().getMudancaEstoque().get(0).getObservacao());
                

//        PagamentoDinheiro d1 = new PagamentoDinheiro();
//        d1.Troco(30,50);
//            Caixa C1 = new Caixa();
//            C1.setVisible(true);
    }

}
