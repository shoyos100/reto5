package reto4.model.dao;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import reto4.model.vo.ListarLideresVo;
import reto4.util.JDBCUtilities;
import java.util.ArrayList;

public class ListarLideresDao {
    public List<ListarLideresVo> listar() throws SQLException{
        List<ListarLideresVo> respuesta = new ArrayList<ListarLideresVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String sql = "select id_lider as id, nombre, primer_apellido as apellido, ciudad_residencia as ciudad from lider l order by ciudad_residencia";
        try{
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()){
                ListarLideresVo vo = new ListarLideresVo();
                vo.setId(rs.getInt("id"));
                vo.setNombre(rs.getString("nombre"));
                vo.setApellido(rs.getString("apellido"));
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