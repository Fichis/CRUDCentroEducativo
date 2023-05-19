/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudcentroeducativo.controladorDAO;

import com.mycompany.crudcentroeducativo.BD.MyDataSource;
import com.mycompany.crudcentroeducativo.entidades.CursoAcademico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class CursoAcademicoDAO_IMP 
             implements CursoAcademicoDAO{
    
    private static CursoAcademicoDAO_IMP instance;
    static{
        instance = new CursoAcademicoDAO_IMP();
    }
    
    private CursoAcademicoDAO_IMP(){
    }
    
    public static CursoAcademicoDAO_IMP getInstance(){
        return instance;
    }

    @Override
    public int add(CursoAcademico c) throws SQLException {
        String sql="""
                   insert into centroeducativo.cursoacademico (yearinicio, yearfin, descripcion)
                   values(?,?,?);
                   """;
        try(Connection cn=MyDataSource.getConnection();){
                
            PreparedStatement pstm=cn.prepareStatement(sql);
            pstm.setInt(1, c.getYearinicio());
            pstm.setInt(2, c.getYearfin());
            pstm.setString(3, c.getDescripcion());
            
            return pstm.executeUpdate();
        }catch(Exception e){
            System.out.println("ERROR add ca: "+e.getMessage());
        }
        return 0;
    }
    
    @Override
    public CursoAcademico getById(int id) throws SQLException {
        String sql="SELECT * FROM centroeducativo.cursoacademico WHERE id=?";
        CursoAcademico cursoaca=null;
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            if(rs.next()){  //Creamos una instancia para pasar los datos por un id
                cursoaca=new CursoAcademico();
                cursoaca.setId(rs.getInt("id"));
                cursoaca.setYearinicio(rs.getInt("yearinicio"));
                cursoaca.setYearfin(rs.getInt("yearfin"));
                cursoaca.setDescripcion(rs.getString("descripcion"));
            }
            
        }catch(Exception e){
            System.out.println("ERROR byid ca: "+e.getMessage());
        }
        
        return cursoaca;
    }

    @Override
    public ArrayList<CursoAcademico> getAll() throws SQLException {
        ArrayList<CursoAcademico> allcursos = new ArrayList<CursoAcademico>();
        
        String sql="SELECT * FROM centroeducativo.cursoacademico";
        CursoAcademico cursoaca=null;
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);) {
            
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){  //Creamos una instancia para pasar los datos por un id
                cursoaca=new CursoAcademico();
                cursoaca.setId(rs.getInt("id"));
                cursoaca.setYearinicio(rs.getInt("yearinicio"));
                cursoaca.setYearfin(rs.getInt("yearfin"));
                cursoaca.setDescripcion(rs.getString("descripcion"));
                allcursos.add(cursoaca);
            }
            
        }catch(Exception e){
            System.out.println("ERROR byall ca: "+e.getMessage());
        }
        
        return allcursos;
    }
    
    @Override
    public int update(CursoAcademico c) throws SQLException {
        
        String sql="""
                   update centroeducativo.cursoacademico
                   set yearinicio = ?,
                   yearfin = ?,
                   descripcion = ?
                   where id = ?;
                   """;
        
        try(Connection cn=MyDataSource.getConnection();){
                
            PreparedStatement pstm=cn.prepareStatement(sql);
            pstm.setInt(1, c.getYearinicio());
            pstm.setInt(2, c.getYearfin());
            pstm.setString(3, c.getDescripcion());
            pstm.setInt(4, c.getId());
            
            return pstm.executeUpdate();
            
        }catch(Exception e){
            System.out.println("ERROR updt ca: "+e.getMessage());
        }
        return 0;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql="""
                   delete from centroeducativo.cursoacademico where id=?;
                   """;
        try(Connection cn=MyDataSource.getConnection();){
                
            PreparedStatement pstm=cn.prepareStatement(sql);
            pstm.setInt(1, id);
            
            pstm.executeUpdate();
        }catch(Exception e){
            System.out.println("ERROR delt ca: "+e.getMessage());
        }
        
    }
}
