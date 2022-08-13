package reto4.view;

import java.util.List;
import reto4.model.vo.*;
import reto4.controller.ReportesController;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ReportesView extends JFrame implements ActionListener{

    private ReportesController controller;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem primerInf, segundoInf, tercerInf;
    private JTable tabla;
    private DefaultTableModel modelo;
    private JLabel lblTitulo, lblConsulta;

    public ReportesView(){
        controller = new ReportesController();
        menu();
        etiqueta1();
        etiqueta2();
        tabla();
    }
    
    public void menu(){
        menuBar = new JMenuBar();   
        setJMenuBar(menuBar);
        menu = new JMenu("Informes");
        menuBar.add(menu);
        primerInf = new JMenuItem("Primer informe");
        segundoInf = new JMenuItem("Segundo informe");
        tercerInf = new JMenuItem("Tercer informe");
        menu.add(primerInf);
        menu.add(segundoInf);
        menu.add(tercerInf);
        primerInf.addActionListener(this);
        segundoInf.addActionListener(this);
        tercerInf.addActionListener(this);
    }
    public void etiqueta1(){
        lblTitulo = new JLabel("Informe Reto 5");
        lblTitulo.setPreferredSize(new Dimension(500, 30));
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitulo);
    }
    public void etiqueta2(){
        lblConsulta = new JLabel();
        lblConsulta.setPreferredSize(new Dimension(500, 30)); 
        lblConsulta.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblConsulta);
    }

    public void tabla(){
        tabla = new JTable(modelo);
        tabla.setPreferredScrollableViewportSize(new Dimension(500,200));
        add (tabla);
        JScrollPane pane = new JScrollPane(tabla);
        add(pane);
        }


    


    
    public void segundoInforme() {
            try{
                List<ProyectosVo> proyectos = controller.listarProyectos();
                modelo = new DefaultTableModel();
                modelo.addColumn("id proyecto");
                modelo.addColumn("constructora");
                modelo.addColumn("habitaciones");
                modelo.addColumn("ciudad");
                for (ProyectosVo i: proyectos){
                    Object[] fila = new Object[4];
                    fila[0] = i.getId();
                    fila[1] = i.getConstructora();
                    fila[2] = i.getHabitaciones();
                    fila[3] = i.getCiudad();
                    modelo.addRow(fila);
                }
                tabla.setModel(modelo);
                modelo.fireTableDataChanged();
                
                
            }
            catch(Exception e){
                System.out.println("error: "+ e.getMessage());
            } 
        }
        
    
    public void tercerinforme() {
        
            try {
                List<ComprasVo> compras = controller.listarCompras();
                modelo = new DefaultTableModel();
                modelo.addColumn("id compra");
                modelo.addColumn("constructora");
                modelo.addColumn("banco");
                for (ComprasVo i: compras){
                    Object[] fila = new Object[3];
                    fila[0] = i.getId();
                    fila[1] = i.getConstructora();
                    fila[2] = i.getBanco();
                    modelo.addRow(fila);
                }
                tabla.setModel(modelo);
                modelo.fireTableDataChanged();
                
                
                
                
            }
            catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    
    public void primerInforme() {
        try{
            List<ListarLideresVo> lideres = controller.listarLideres();
            //crear modelo
            modelo = new DefaultTableModel();
            modelo.addColumn("id lider");
            modelo.addColumn("nombre");
            modelo.addColumn("apellido");
            modelo.addColumn("ciudad");
            for (ListarLideresVo i: lideres){
                Object[] fila = new Object[4];
                fila[0] = i.getId();
                fila[1] = i.getNombre();
                fila[2] = i.getApellido();
                fila[3] = i.getCiudad();
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
            modelo.fireTableDataChanged();
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == primerInf){
        primerInforme();
        lblConsulta.setText("consulta de lideres");
       }
       if(e.getSource() == segundoInf){
        segundoInforme();
        lblConsulta.setText("informe de proyectos");

       }
       if(e.getSource() == tercerInf){
        tercerinforme();
        lblConsulta.setText("informe de compras");
       }
        
    }
       
}