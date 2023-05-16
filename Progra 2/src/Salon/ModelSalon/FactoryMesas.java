package ModelSalon;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

public class FactoryMesas {
    public static int cantMesas=10;
    public static ArrayList<Mesas> getMesas() {
        ArrayList<Mesas> mesas = new ArrayList<Mesas>();
        for (int i=0; i< cantMesas; i++){
            mesas.add(new Mesas(i));
        }
        return mesas;
    }

    public static JButton[][] matrizMesas() {
        JButton[][] mesas = new JButton[cantMesas/2][cantMesas/2];
        for (int i=0; i< cantMesas/2; i++){
            for (int j=0; j< cantMesas/2; j++){
                JButton btn = new JButton();
                mesas[i][j]=btn;
            }
        }
        return mesas;
    }

    public static JPanel panelMesas(JButton[][] mesas) {
        JPanel pnlMesas=new JPanel();
        for (JButton[] mesa: mesas){
            for (JButton m: mesa){
                pnlMesas.add(m);
            }
        }
        return pnlMesas;
    }
}
