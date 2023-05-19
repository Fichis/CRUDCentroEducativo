/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudcentroeducativo.controladorDAO;

import com.mycompany.crudcentroeducativo.BD.MyDataSource;
import com.mycompany.crudcentroeducativo.entidades.Aula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class AulaDAO_IMP 
            implements AulaDAO{
    
    private static AulaDAO_IMP instance;
    
    static{
        instance=new AulaDAO_IMP();
    }
    
    private AulaDAO_IMP(){ }
    
    public static AulaDAO_IMP getInstance(){
        return instance;
    }

    @Override
    public int add(Aula aula) throws SQLException {
        String sql="""
                   insert into centroeducativo.aula (codigo, descripcion)
                   values(?,?);
                   """;
        try(Connection cn=MyDataSource.getConnection();){
                
            PreparedStatement pstm=cn.prepareStatement(sql);
            pstm.setString(1, aula.getCodigo());
            pstm.setString(2, aula.getDescripcion());
            
            return pstm.executeUpdate();
        }catch(Exception e){
            System.out.println("ERROR add aula: "+e.getMessage());
        }
        return 0;
    }

    @Override
    public Aula getById(int id) throws SQLException {
        String sql="SELECT * FROM centroeducativo.aula WHERE id=?";
        Aula aula=null;
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            if(rs.next()){  //Creamos una instancia para pasar los datos por un id
                aula=new Aula();
                aula.setId(rs.getInt("id"));
                aula.setCodigo(rs.getString("codigo"));
                aula.setDescripcion(rs.getString("descripcion"));
            }
            
        }catch(Exception e){
            System.out.println("ERROR byid aula: "+e.getMessage());
        }
        
        return aula;
    }

    @Override
    public ArrayList<Aula> getAll() throws SQLException {
        ArrayList<Aula> allaulas = new ArrayList<Aula>();

        String sql = "SELECT * FROM centroeducativo.aula";
        Aula aula = null;
        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {  //Creamos una instancia para pasar los datos por un id
                aula = new Aula();
                aula.setId(rs.getInt("id"));
                aula.setCodigo(rs.getString("codigo"));
                aula.setDescripcion(rs.getString("descripcion"));
                allaulas.add(aula);
            }

        } catch (Exception e) {
            System.out.println("ERROR byall aula: " + e.getMessage());
        }

        return allaulas;
    }

    @Override
    public int update(Aula aula) throws SQLException {
        String sql="""
                   update centroeducativo.aula
                   set codigo = ?,
                   descripcion = ?,
                   where id = ?;
                   """;
        
        try(Connection cn=MyDataSource.getConnection();){
                
            PreparedStatement pstm=cn.prepareStatement(sql);
            pstm.setString(1, aula.getCodigo());
            pstm.setString(2, aula.getDescripcion());
            pstm.setInt(3, aula.getId());
            
            return pstm.executeUpdate();
            
        }catch(Exception e){
            System.out.println("ERROR updt aula: "+e.getMessage());
        }
        return 0;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql="""
                   delete from centroeducativo.aula where id=?;
                   """;
        try(Connection cn=MyDataSource.getConnection();){
                
            PreparedStatement pstm=cn.prepareStatement(sql);
            pstm.setInt(1, id);
            
            pstm.executeUpdate();
        }catch(Exception e){
            System.out.println("ERROR delete aula: "+e.getMessage());
        }
    }
    
    
}
