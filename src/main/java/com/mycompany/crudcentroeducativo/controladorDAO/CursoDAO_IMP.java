/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudcentroeducativo.controladorDAO;

import com.mycompany.crudcentroeducativo.BD.MyDataSource;
import com.mycompany.crudcentroeducativo.entidades.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class CursoDAO_IMP 
            implements CursoDAO{
    private static CursoDAO_IMP instance;
    
    static{
        instance=new CursoDAO_IMP();
    }
    
    private CursoDAO_IMP(){ }
    
    public static CursoDAO_IMP getInstance(){
        return instance;
    }

    @Override
    public int add(Curso c) throws SQLException {
        String sql = """
        insert into centroeducativo.curso(codigo, nombre, Observaciones, idcursoacademico)
        values (?,?,?,?);
        """;
        
        try(Connection cn = MyDataSource.getConnection();){
            PreparedStatement pstm=cn.prepareStatement(sql);
            
            pstm.setString(1, c.getCodigo());
            pstm.setString(2, c.getNombre());
            pstm.setString(3, c.getObservaciones());
            pstm.setInt(4, c.getIdcursoacademico());
        }catch(Exception e){
            System.out.println("ERORR add curso: "+e.getMessage());
        }
        return 0;
    }

    @Override
    public Curso getById(int id) throws SQLException {
            String sql="SELECT * FROM centroeducativo.curso WHERE id=?";
        Curso cu=null;
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            if(rs.next()){  //Creamos una instancia para pasar los datos por un id
                cu=new Curso();
                cu.setId(rs.getInt("id"));
                cu.setCodigo(rs.getString("codigo"));
                cu.setNombre(rs.getString("nombre"));
                cu.setObservaciones(rs.getString("Observaciones"));
                cu.setIdcursoacademico(rs.getInt("idcursoacademico"));
            }
            
        }catch(Exception e){
            System.out.println("ERROR byid curso: "+e.getMessage());
        }
        
        return cu;
    }

    @Override
    public ArrayList<Curso> getAll() throws SQLException {
        ArrayList<Curso> allcurso = new ArrayList<Curso>();
        String sql="SELECT * FROM centroeducativo.curso";
        Curso cu=null;
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);) {
            
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){  //Creamos una instancia para pasar los datos 
                cu=new Curso();
                cu.setId(rs.getInt("id"));
                cu.setCodigo(rs.getString("codigo"));
                cu.setNombre(rs.getString("nombre"));
                cu.setObservaciones(rs.getString("Observaciones"));
                cu.setIdcursoacademico(rs.getInt("idcursoacademico"));
                
                allcurso.add(cu);
            }
            
        }catch(Exception e){
            System.out.println("ERROR byall curso: "+e.getMessage());
        }
        
        return allcurso;
    }

    @Override
    public int update(Curso c) throws SQLException {
        String sql="""
                   update centroeducativo.curso
                   set codigo = ?,
                   nombre = ?,
                   Observaciones = ?,
                   idcursoacademico = ?
                   where id = ?;
                   """;
        
        try(Connection cn=MyDataSource.getConnection();){
                
            PreparedStatement pstm=cn.prepareStatement(sql);
            pstm.setString(1, c.getCodigo());
            pstm.setString(2, c.getNombre());
            pstm.setString(3, c.getObservaciones());
            pstm.setInt(4, c.getIdcursoacademico());
            pstm.setInt(5, c.getId());
            
            return pstm.executeUpdate();
            
        }catch(Exception e){
            System.out.println("ERROR updt curso: "+e.getMessage());
        }
        return 0;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql="""
                   delete from centroeducativo.curso where id=?;
                   """;
        try(Connection cn=MyDataSource.getConnection();){
                
            PreparedStatement pstm=cn.prepareStatement(sql);
            pstm.setInt(1, id);
            
            pstm.executeUpdate();
        }catch(Exception e){
            System.out.println("ERROR delt curso: "+e.getMessage());
        }
    }

    @Override
    public ArrayList<Curso> getAllByCursoAcademico(int idcursoacademico) throws SQLException {
        ArrayList<Curso> allcursobyCA = new ArrayList<Curso>();
        String sql="SELECT * FROM centroeducativo.curso where idcursoacademico = ?";
        Curso cu=null;
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);) {
            
            pstm.setInt(1, idcursoacademico);
            
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){  //Creamos una instancia para pasar los datos 
                cu=new Curso();
                cu.setId(rs.getInt("id"));
                cu.setCodigo(rs.getString("codigo"));
                cu.setNombre(rs.getString("nombre"));
                cu.setObservaciones(rs.getString("Observaciones"));
                cu.setIdcursoacademico(idcursoacademico);
                
                allcursobyCA.add(cu);
            }
            
        }catch(Exception e){
            System.out.println("ERROR byCA curso: "+e.getMessage());
        }
        
        return allcursobyCA;
    }
    
    
}
