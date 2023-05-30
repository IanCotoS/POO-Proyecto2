package ViewSalon;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import Comida.Hamburguesa.*;
import Comida.Ingredientes.*;
import ModelSalon.FactoryMesas;
import Orden.Orden;

public class vistaSalon implements ChangeListener{
    public JButton[][] mesas; 
    private Hamburguesa hambur; 
    private JRadioButton hambuerguesa;//hamburguesa basica
    public  JButton enviarOrden; 
    private JScrollPane jScrollPane3;
    public JButton factura; // realiza el pago de la cuenta dentro de la tabla
    public JTable facturar; // muestra todas las mesas y ordenes
    private JFrame ventana; 
    private JPanel pnlMesas;
    private JLabel extrasLabel;
    private JLabel orden;
    private JButton agregarOrden;
    private JPanel pnlDerecho;
    private JCheckBox lechuga,tomate, cebolla, pepinillos,jalapeno,mayonesa,ketchup,queso;
    private JCheckBox huevoFrito, aguacate, tocino; 
    public DefaultTableModel model; 

    public Orden pedido;
    
    public vistaSalon() {
        ventana = new JFrame("Salon");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        agregarComponentes();
        ventana.pack();
        ventana.setVisible(true);
        ventana.setSize(900, 500);
    }

    private void agregarComponentes(){
        pedido = new Orden();
        enviarOrden = new JButton("Enviar Orden");
        agregarOrden = new JButton("Agregar Orden");
        agregarOrden.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarHamburguesa(agregarOrden);
            }
        });
        factura = new JButton("Pagar");
        orden = new JLabel("Selecciona tu orden:");
        extrasLabel = new JLabel("Selecciona los extras:");
        hambuerguesa = new JRadioButton("Hamburguesa Basica");
        pnlMesas = new JPanel();
        agregarMesas();
        pnlMesas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlMesas.setLayout(new GridLayout( FactoryMesas.cantMesas/2, FactoryMesas.cantMesas/2));
        pnlDerecho = new JPanel();
        pnlDerecho.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlDerecho.add(orden);
        lechuga= new JCheckBox("Lechuga"); tomate= new JCheckBox("Tomate"); cebolla=new JCheckBox("Cebolla"); 
        pepinillos = new JCheckBox("Pepinillos"); jalapeno= new JCheckBox("Jalapeño"); 
        mayonesa= new JCheckBox("Mayonesa"); ketchup = new JCheckBox("Ketchup");
        queso = new JCheckBox("Queso"); tocino= new JCheckBox("Tocino"); 
        huevoFrito = new JCheckBox("Huevo Frito");aguacate = new JCheckBox("Aguacate");

        //.addChangeListener de los ckeckbox;
        lechuga.addChangeListener(this); tomate.addChangeListener(this); cebolla.addChangeListener(this); 
        pepinillos.addChangeListener(this); jalapeno.addChangeListener(this); mayonesa.addChangeListener(this); 
        ketchup.addChangeListener(this); queso.addChangeListener(this); tocino.addChangeListener(this); 
        huevoFrito.addChangeListener(this);aguacate.addChangeListener(this);

        confiPnlDerecho();
        facturar = new JTable();
        model = new DefaultTableModel( ){
            //filas no editables
            public boolean isCellEditable (int row, int column) {
                return false;
            }
        };
        model.addColumn("Mesa");
        model.addColumn("Orden");
        model.addColumn("Estado");
        facturar.setModel(model);
        jScrollPane3 = new JScrollPane();
        jScrollPane3.setViewportView(facturar);

        GroupLayout layout = new javax.swing.GroupLayout(ventana.getContentPane());
        ventana.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addGap(28, 28, 28)
                        .addComponent(factura, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlDerecho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlMesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDerecho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(factura)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }

    private void confiPnlDerecho(){
        GroupLayout jpDerechoLayout = new javax.swing.GroupLayout(pnlDerecho);
        pnlDerecho.setLayout(jpDerechoLayout);
        jpDerechoLayout.setHorizontalGroup(
            jpDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDerechoLayout.createSequentialGroup()
                .addGroup(jpDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDerechoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(extrasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpDerechoLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jpDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tomate)
                                    .addComponent(jalapeno)
                                    .addComponent(queso))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpDerechoLayout.createSequentialGroup()
                                        .addComponent(tocino)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(huevoFrito)
                                        .addGap(18, 18, 18))
                                    .addGroup(jpDerechoLayout.createSequentialGroup()
                                        .addComponent(cebolla)
                                        .addGap(20, 20, 20)
                                        .addComponent(lechuga)
                                        .addGap(18, 18, 18)
                                        .addComponent(aguacate))
                                    .addGroup(jpDerechoLayout.createSequentialGroup()
                                        .addComponent(pepinillos)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(mayonesa)
                                        .addGap(18, 18, 18)
                                        .addComponent(ketchup))
                                    .addGroup(jpDerechoLayout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(enviarOrden)
                                        .addGap(18, 18, 18)
                                        .addComponent(agregarOrden))))))
                    .addGroup(jpDerechoLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(hambuerguesa))
                    .addGroup(jpDerechoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(orden, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jpDerechoLayout.setVerticalGroup(
            jpDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDerechoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(orden, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hambuerguesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(extrasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tomate)
                    .addComponent(lechuga)
                    .addComponent(cebolla)
                    .addComponent(aguacate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jalapeno)
                    .addComponent(pepinillos)
                    .addComponent(mayonesa)
                    .addComponent(ketchup))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(queso)
                    .addComponent(tocino)
                    .addComponent(huevoFrito)
                    .addComponent(aguacate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGap(29, 29, 29)
                .addGroup(jpDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enviarOrden)
                    .addComponent(agregarOrden))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void agregarMesas(){
        mesas = new JButton[FactoryMesas.cantMesas/2][FactoryMesas.cantMesas/2];
        for (int i=0; i< FactoryMesas.cantMesas/2; i++){
            for (int j=0; j< FactoryMesas.cantMesas/2; j++){
                JButton btn = new JButton();
                btn.setSize(50, 50);
                ImageIcon imagenIcono = new ImageIcon("Progra 2/src/Imagenes/mesas.png");
                Image imagen = imagenIcono.getImage();
                Image imagenEscalada = imagen.getScaledInstance(btn.getWidth(), btn.getHeight(), Image.SCALE_SMOOTH);
                btn.setIcon(new ImageIcon(imagenEscalada));
                mesas[i][j] = btn;
                pnlMesas.add(btn);
            }
        }
    }
    
    private void agregarHamburguesa(JButton btn){
        if (hambur == null ){ 
            String mens = "Debes seleccionar un tipo de orden y sus ingredientes extras.";
            JOptionPane.showMessageDialog(null,mens, "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }else{
            pedido.agregarHamburguesa(hambur);
            System.out.println(pedido.getDescripcion());
        }
    };
    
    @Override
    public void stateChanged(ChangeEvent e) {
        if (hambuerguesa.isSelected()){
            hambur = new HamburguesaBase();
        }if (tomate.isSelected()){
            hambur = new Tomate(hambur);
        }if (cebolla.isSelected()){
            hambur = new Cebolla(hambur);
        }if (lechuga.isSelected()){
            hambur = new Lechuga(hambur);
        }if (pepinillos.isSelected()){
            hambur = new Pepinillos(hambur);
        }if (mayonesa.isSelected()){
            hambur = new Mayonesa(hambur);
        }if (queso.isSelected()){
           hambur = new Queso(hambur); 
        }if (ketchup.isSelected()){
            hambur = new Ketchup(hambur);
        }if (tocino.isSelected()){
            hambur = new Tocino(hambur);
        }if (huevoFrito.isSelected()){
            hambur = new HuevoFrito(hambur);
        }if (aguacate.isSelected()){
            hambur = new Aguacate(hambur);
        }if (jalapeno.isSelected()){
            hambur = new Jalapeno(hambur);
        }
    }

    public int[] posicionMesa(JButton btn){
        for (int i=0; i< FactoryMesas.cantMesas/2; i++){
            for (int j=0; j< FactoryMesas.cantMesas/2; j++){
                if (mesas[i][j] == btn){
                    return new int[]{i,j};
                }
            }
        }
        return null; 
    }
    
    public static void main(String[] args) {
        new vistaSalon();
    }
    
}