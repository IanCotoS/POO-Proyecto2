package ViewSalon;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Comida.Hamburguesa.*;
import Comida.Ingredientes.*;
import ModelSalon.FactoryMesas;

public class vistaSalon implements ChangeListener{
    private JButton[][] mesas;
    private Hamburguesa hambur;
    private ButtonGroup grupoBotones;
    private JRadioButton hambuerguesa;//hamburguesa basica
    private JButton enviarOrden;
    private JButton factura; // realiza el pago de la cuenta dentro de la tabla
    private JTable facturar; // muestra todas las mesas y ordenes
    private JFrame ventana;
    private JPanel pnlMesas;
    private JLabel extrasLabel;
    private JLabel orden;
    private JPanel pnlDerecho;
    private JCheckBox pan, carne, lechuga,tomate, cebolla, pepinillos,jalapeño,mostaza,ketchup,queso;
    private JCheckBox huevoFrito, aguacate, tocino;
    
    public vistaSalon() {
        //hambur = new HamburguesaBase();
        ventana = new JFrame("Salon");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        agregarComponentes();
        ventana.pack();
        ventana.setVisible(true);
        ventana.setSize(900, 500);
    }

    private void agregarComponentes(){
        enviarOrden = new JButton("Enviar Orden");
        enviarOrden.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                enviar(enviarOrden);
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
        pan = new JCheckBox("Pan"); carne=new JCheckBox("Carne"); lechuga= new JCheckBox("Lechuga");
        tomate= new JCheckBox("Tomate"); cebolla=new JCheckBox("Cebolla"); pepinillos = new JCheckBox("Pepinillos");
        jalapeño= new JCheckBox("Jalapeño"); mostaza= new JCheckBox("Mayonesa");ketchup = new JCheckBox("Ketchup");
        queso = new JCheckBox("Queso"); tocino= new JCheckBox("Tocino"); huevoFrito = new JCheckBox("Huevo Frito");
        aguacate = new JCheckBox("Aguacate");

        //.addChangeListener de los ckeckbox;
        pan.addChangeListener(this); carne.addChangeListener(this); lechuga.addChangeListener(this);
        tomate.addChangeListener(this); cebolla.addChangeListener(this); pepinillos.addChangeListener(this);
        jalapeño.addChangeListener(this); mostaza.addChangeListener(this); ketchup.addChangeListener(this);
        queso.addChangeListener(this); tocino.addChangeListener(this); huevoFrito.addChangeListener(this);
        aguacate.addChangeListener(this);

        confiPnlDerecho();
        GroupLayout layout = new GroupLayout(ventana.getContentPane());
        ventana.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMesas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlDerecho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlMesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDerecho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                            .addComponent(extrasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpDerechoLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jpDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tomate)
                                    .addComponent(carne)
                                    .addComponent(queso))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpDerechoLayout.createSequentialGroup()
                                        .addComponent(tocino)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(huevoFrito)
                                        .addGap(18, 18, 18)
                                        .addComponent(aguacate))
                                    .addGroup(jpDerechoLayout.createSequentialGroup()
                                        .addComponent(cebolla)
                                        .addGap(20, 20, 20)
                                        .addComponent(lechuga)
                                        .addGap(18, 18, 18)
                                        .addComponent(pan))
                                    .addGroup(jpDerechoLayout.createSequentialGroup()
                                        .addComponent(pepinillos)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(mostaza)
                                        .addGap(18, 18, 18)
                                        .addComponent(ketchup))
                                    .addGroup(jpDerechoLayout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jalapeño)
                                        .addComponent(enviarOrden))))))
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
                    .addComponent(pan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carne)
                    .addComponent(pepinillos)
                    .addComponent(mostaza)
                    .addComponent(ketchup))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(queso)
                    .addComponent(tocino)
                    .addComponent(huevoFrito)
                    .addComponent(aguacate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jalapeño)
                .addGap(29, 29, 29)
                .addComponent(enviarOrden)
                .addContainerGap(29, Short.MAX_VALUE))
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
                btn.addActionListener(new ActionListener() 
                { 
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Click(btn);
                    }
                });
                mesas[i][j]=btn;
                pnlMesas.add(btn);
            }
        }
    }
    private void Click(JButton btn) {
        System.out.println("Me has presionado");
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (hambuerguesa.isSelected()){
            hambur = new HamburguesaBase();
        }if (tomate.isSelected()){
            hambur = new Tomate(new HamburguesaBase());
            System.out.println("hambur tomate: "+ hambur.getDescripcion());

        }if (cebolla.isSelected()){
            
        }if (lechuga.isSelected()){
            
        }if (carne.isSelected()){
            
        }if (pepinillos.isSelected()){
            
        }if (mostaza.isSelected()){
            
        }if (queso.isSelected()){
            
        }if (pan.isSelected()){
            
        }if (ketchup.isSelected()){
            
        }if (tocino.isSelected()){
            
        }if (huevoFrito.isSelected()){
            
        }if (aguacate.isSelected()){
            
        }if (jalapeño.isSelected()){
            
        }
    }

    public void enviar(JButton btn){
        System.out.println("Hamburguesa: \n"+ hambur.getDescripcion());
    }
    

    
    public static void main(String[] args) {
        new vistaSalon();
    }

    
}
