package reto4.controller;

import java.sql.SQLException;
import java.util.List;
import reto4.model.dao.*;
import reto4.model.vo.*;

public class ReportesController {
    private ProyectosDao proyectosDao;
    private ListarLideresDao ListarLideresrDao;
    private ComprasDao comprasDao;

    public ReportesController() {
        proyectosDao = new ProyectosDao();
        ListarLideresrDao = new ListarLideresDao();
        comprasDao = new ComprasDao();
    }

    public List<ProyectosVo> listarProyectos() throws SQLException {
        return proyectosDao.listar();
    }
    
    public List<ListarLideresVo> listarLideres() throws SQLException {
        return ListarLideresrDao.listar();
    }

    public List<ComprasVo> listarCompras() throws SQLException{
        return comprasDao.listar();
    }

}
