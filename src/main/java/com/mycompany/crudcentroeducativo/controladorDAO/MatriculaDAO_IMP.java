/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudcentroeducativo.controladorDAO;

import com.mycompany.crudcentroeducativo.BD.MyDataSource;
import com.mycompany.crudcentroeducativo.entidades.Matricula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class MatriculaDAO_IMP 
            implements MatriculaDAO{
    
    private static MatriculaDAO_IMP instance;
    
    static{
        instance=new MatriculaDAO_IMP();
    }
    
    private MatriculaDAO_IMP(){ }
    
    public static MatriculaDAO_IMP getInstance(){
        return instance;
    }

    @Override
    public int add(Matricula matr) throws SQLException {
        String sql="""
                   insert into centroeducativo.matricula (idalumno, idunidad, descripcion, fMatricula, fBaja)
                   values(?,?,?,?,?);
                   """;
        try(Connection cn=MyDataSource.getConnection();){
                
            PreparedStatement pstm=cn.prepareStatement(sql);
            pstm.setInt(1, matr.getIdalumno());
            pstm.setInt(2, matr.getIdunidad());
            pstm.setString(3, matr.getDescripcion());
            pstm.setDate(4, matr.getfMatricula());
            pstm.setDate(5, matr.getfBaja());
            
            return pstm.executeUpdate();
        }catch(Exception e){
            System.out.println("ERROR add matr: "+e.getMessage());
        }
        return 0;
    }

    @Override
    public Matricula getById(int id) throws SQLException {
        String sql="SELECT * FROM centroeducativo.matricula WHERE idmatricula = ?";
        Matricula matr=null;
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            if(rs.next()){  //Creamos una instancia para pasar los datos por un id
                matr=new Matricula();
                matr.setIdalumno(rs.getInt("idalumno"));
                matr.setIdunidad(rs.getInt("idunidad"));
                matr.setDescripcion(rs.getString("descripcion"));
                matr.setfMatricula(rs.getDate("fMatricula"));
                matr.setfBaja(rs.getDate("fBaja"));
            }
            
        }catch(Exception e){
            System.out.println("ERROR byid matr: "+e.getMessage());
        }
        
        return matr;
    }

    @Override
    public ArrayList<Matricula> getAll() throws SQLException {
        ArrayList<Matricula> allmatriculas = new ArrayList<Matricula>();

        String sql = "SELECT * FROM centroeducativo.matricula";
        Matricula matr = null;
        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {  //Creamos una instancia para pasar los datos por un id
                matr = new Matricula();
                matr.setIdalumno(rs.getInt("idalumno"));
                matr.setIdunidad(rs.getInt("idunidad"));
                matr.setDescripcion(rs.getString("descripcion"));
                matr.setfMatricula(rs.getDate("fMatricula"));
                matr.setfBaja(rs.getDate("fBaja"));
            }

        } catch (Exception e) {
            System.out.println("ERROR byall matr: " + e.getMessage());
        }

        return allmatriculas;
    }

    @Override
    public int update(Matricula matr) throws SQLException {
        String sql="""
                   update centroeducativo.matricula
                   set idalumno = ?,
                   idunidad = ?,
                   descripcion = ?,
                   fMatricula = ?,
                   fBaja = ?
                   where idmatricula = ?;
                   """;
        
        try(Connection cn=MyDataSource.getConnection();){
                
            PreparedStatement pstm=cn.prepareStatement(sql);
            pstm.setInt(1, matr.getIdalumno());
            pstm.setInt(2, matr.getIdunidad());
            pstm.setString(3, matr.getDescripcion());
            pstm.setDate(4, matr.getfMatricula());
            pstm.setDate(5, matr.getfBaja());
            pstm.setInt(6, matr.getIdmatricula());
            
            return pstm.executeUpdate();
            
        }catch(Exception e){
            System.out.println("ERROR updt matr: "+e.getMessage());
        }
        return 0;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql="""
                   delete from centroeducativo.matr where idmatricula = ?;
                   """;
        try(Connection cn=MyDataSource.getConnection();){
                
            PreparedStatement pstm=cn.prepareStatement(sql);
            pstm.setInt(1, id);
            
            pstm.executeUpdate();
        }catch(Exception e){
            System.out.println("ERROR delete matr: "+e.getMessage());
        }
    }
    
}
