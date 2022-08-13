package reto4.model.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import reto4.model.vo.ProyectosVo;
import reto4.util.JDBCUtilities;
import java.util.ArrayList;

public class ProyectosDao {
    public List<ProyectosVo>listar() throws SQLException{
        List<ProyectosVo> respuesta = new ArrayList<ProyectosVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT ID_Proyecto as id, Constructora, Numero_Habitaciones as habitaciones, Ciudad from Proyecto p         where Clasificacion = 'Casa Campestre' and ciudad in('Santa Marta', 'Cartagena', 'Barranquilla');";
        
        try{
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()){
                ProyectosVo vo = new ProyectosVo();
                vo.setId(rs.getInt("id"));
                vo.setConstructora(rs.getString("constructora"));
                vo.setHabitaciones(rs.getInt("habitaciones"));
                vo.setCiudad(rs.getString("ciudad"));
                
                respuesta.add(vo);
            }
        }
        finally{
            if (rs != null){
                rs.close();
            } 
            if (stm != null){
                stm.close();
            }
            if (conn != null){
                conn.close();
            }


        }
        return respuesta;
    }
    
}
