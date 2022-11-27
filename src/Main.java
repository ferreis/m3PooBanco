import br.com.banco.gui.CaixaGUI;
import br.com.banco.interno.Banco;
import br.com.banco.interno.Caixa;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("Caixa", 0);
        CaixaGUI caixaGUI = new CaixaGUI(banco);
        caixaGUI.iniciarAtendimento();
    }
}