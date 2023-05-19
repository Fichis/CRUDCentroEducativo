/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudcentroeducativo.controladorDAO;

import com.mycompany.crudcentroeducativo.BD.MyDataSource;
import com.mycompany.crudcentroeducativo.entidades.Unidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class UnidadDAO_IMP 
            implements UnidadDAO {
    private static UnidadDAO_IMP instance;
    
    static{
        instance=new UnidadDAO_IMP();
    }
    
    private UnidadDAO_IMP(){ }
    
    public static UnidadDAO_IMP getInstance(){
        return instance;
    }

    @Override
    public int add(Unidad uni) throws SQLException {
        String sql="""
                   insert into centroeducativo.unidad (codigo, nombre, Observaciones, idcurso, idtutor, idaula)
                   values(?,?,?,?,?,?);
                   """;
        try(Connection cn=MyDataSource.getConnection();){
                
            PreparedStatement pstm=cn.prepareStatement(sql);
            pstm.setString(1, uni.getCodigo());
            pstm.setString(2, uni.getNombre());
            pstm.setString(3, uni.getObservaciones());
            pstm.setInt(4, uni.getIdcurso());
            pstm.setInt(5, uni.getIdtutor());
            pstm.setInt(6, uni.getIdaula());
            
            return pstm.executeUpdate();
        }catch(Exception e){
            System.out.println("ERROR add uni: "+e.getMessage());
        }
        return 0;
    }

    @Override
    public Unidad getById(int id) throws SQLException {
        String sql="SELECT * FROM centroeducativo.unidad WHERE id=?";
        Unidad uni=null;
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            if(rs.next()){  //Creamos una instancia para pasar los datos por un id
                uni =new Unidad();
                uni.setId(rs.getInt("id"));
                uni.setCodigo(rs.getString("codigo"));
                uni.setNombre(rs.getString("nombre"));
                uni.setObservaciones(rs.getString("Observaciones"));
                uni.setIdcurso(rs.getInt("idcurso"));
                uni.setIdtutor(rs.getInt("idtutor"));
                uni.setIdaula(rs.getInt("idaula"));
            }
            
        }catch(Exception e){
            System.out.println("ERROR byid uni: "+e.getMessage());
        }
        
        return uni;
    }

    @Override
    public ArrayList<Unidad> getAll() throws SQLException {
        ArrayList<Unidad> allunis = new ArrayList<Unidad>();

        String sql = "SELECT * FROM centroeducativo.unidad";
        Unidad uni = null;
        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {  //Creamos una instancia para pasar los datos por un id
                uni = new Unidad();
                uni.setId(rs.getInt("id"));
                uni.setCodigo(rs.getString("codigo"));
                uni.setNombre(rs.getString("nombre"));
                uni.setObservaciones(rs.getString("Observaciones"));
                uni.setIdcurso(rs.getInt("idcurso"));
                uni.setIdtutor(rs.getInt("idtutor"));
                uni.setIdaula(rs.getInt("idaula"));
                allunis.add(uni);
            }

        } catch (Exception e) {
            System.out.println("ERROR byall uni: " + e.getMessage());
        }

        return allunis;
    }

    @Override
    public int update(Unidad uni) throws SQLException {
        String sql="""
                   update centroeducativo.unidad
                   set codigo = ?,
                   nombre = ?,
                   Observaciones = ?,
                   idcurso = ?,
                   idtutor = ?,
                   idaula = ?,
                   where id = ?;
                   """;
        
        try(Connection cn=MyDataSource.getConnection();){
                
            PreparedStatement pstm=cn.prepareStatement(sql);
            pstm.setString(1, uni.getCodigo());
            pstm.setString(2, uni.getNombre());
            pstm.setString(3, uni.getObservaciones());
            pstm.setInt(4, uni.getIdcurso());
            pstm.setInt(5, uni.getIdtutor());
            pstm.setInt(6, uni.getIdaula());
            pstm.setInt(7, uni.getId());
            
            return pstm.executeUpdate();
            
        }catch(Exception e){
            System.out.println("ERROR updt uni: "+e.getMessage());
        }
        return 0;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql="""
                   delete from centroeducativo.unidad where id=?;
                   """;
        try(Connection cn=MyDataSource.getConnection();){
                
            PreparedStatement pstm=cn.prepareStatement(sql);
            pstm.setInt(1, id);
            
            pstm.executeUpdate();
        }catch(Exception e){
            System.out.println("ERROR delete uni: "+e.getMessage());
        }
    }
    
    
}
