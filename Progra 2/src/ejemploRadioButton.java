import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ejemploRadioButton extends JFrame implements ChangeListener {

    private JRadioButton radio1, radio2, radio3;
    private ButtonGroup grupoBotones;

    public ejemploRadioButton() {

        //Creo un nuevo grupo de botones
        grupoBotones = new ButtonGroup();

        //Añado los 3 radioButton con su ChangeListener
        radio1=new JRadioButton("640*480");
        radio1.setBounds(10,20,100,30);
        radio1.addChangeListener(this);
        add(radio1);
        grupoBotones.add(radio1);

        radio2=new JRadioButton("800*600");
        radio2.setBounds(10,70,100,30);
        radio2.addChangeListener(this);
        add(radio2);
        grupoBotones.add(radio2);

        radio3=new JRadioButton("1024*768");
        radio3.setBounds(10,120,100,30);
        radio3.addChangeListener(this);
        add(radio3);
        grupoBotones.add(radio3);

        //Configurar y mostrar JFrame
        initPantalla();
    }

    private void initPantalla() {

        setLayout(null); //Layout absoluto
        setTitle("Ejemplo 11"); //Título del JFrame
        setSize(350, 230); //Dimensiones del JFrame
        setResizable(false); //No redimensionable
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar proceso al cerrar ventana
        setVisible(true); //Mostrar JFrame
    }

    public static void main(String[] args) {
        //new ejemploRadioButton();
        // Crear la ventana
        JFrame ventana = new JFrame("Ejemplo de Ventana");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300, 200);

        // Crear el RadioButton
        JRadioButton radioButton = new JRadioButton("Opción");
        radioButton.setBounds(20, 20, 100, 30);

        // Crear el Panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(20, 60, 260, 80);

        // Crear el Label
        JLabel label = new JLabel("Etiqueta");
        label.setBounds(10, 10, 100, 30);

        // Crear el CheckBox
        JCheckBox checkBox = new JCheckBox("Activado");
        checkBox.setBounds(120, 10, 100, 30);

        // Agregar el RadioButton, el Panel y el CheckBox a la ventana
        ventana.add(radioButton);
        panel.add(label);
        panel.add(checkBox);
        ventana.add(panel);

        // Mostrar la ventana
        ventana.setLayout(null);
        ventana.setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {

        if (radio1.isSelected()) {
            setSize(640,480);
        }
        if (radio2.isSelected()) {
            setSize(800,600);
        }
        if (radio3.isSelected()) {
            setSize(1024,768);
        }

    }

}
