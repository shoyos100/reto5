package reto4.model.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import reto4.model.vo.ComprasVo;
import reto4.util.JDBCUtilities;
import java.util.ArrayList;

public class ComprasDao {
    public List<ComprasVo>listar() throws SQLException{
        List<ComprasVo> respuesta = new ArrayList<ComprasVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT ID_Compra as id, p.Constructora, p.Banco_Vinculado as banco FROM Compra c JOIN Proyecto p ON c.ID_Proyecto = p.ID_Proyecto WHERE Proveedor = 'Homecenter' AND p.Ciudad = 'Salento'";
        try{
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()){
                ComprasVo vo = new ComprasVo();
                vo.setId(rs.getInt("id"));
                vo.setConstructora(rs.getString("constructora"));
                vo.setBanco(rs.getString("banco"));
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
