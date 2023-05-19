/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudcentroeducativo.controladorDAO;

import com.mycompany.crudcentroeducativo.BD.MyDataSource;
import com.mycompany.crudcentroeducativo.entidades.Autorizaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class AutorizacionesDAO_IMP 
            implements AutorizacionesDAO{
    
    private static AutorizacionesDAO_IMP instance;
    
    static{
        instance=new AutorizacionesDAO_IMP();
    }
    
    private AutorizacionesDAO_IMP(){ }
    
    public static AutorizacionesDAO_IMP getInstance(){
        return instance;
    }

    @Override
    public int add(Autorizaciones autz) throws SQLException {
        String sql="""
                   insert into centroeducativo.autorizaciones (idalumno, idautorizado)
                   values(?,?);
                   """;
        try(Connection cn=MyDataSource.getConnection();){
                
            PreparedStatement pstm=cn.prepareStatement(sql);
            pstm.setInt(1, autz.getIdalumno());
            pstm.setInt(2, autz.getIdautorizado());
            
            return pstm.executeUpdate();
        }catch(Exception e){
            System.out.println("ERROR add autz: "+e.getMessage());
        }
        return 0;
    }

    @Override
    public Autorizaciones getById(int id) throws SQLException {
        String sql="SELECT * FROM centroeducativo.autorizaciones WHERE idalumno = ?";
        Autorizaciones autz=null;
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            if(rs.next()){  //Creamos una instancia para pasar los datos por un id
                autz=new Autorizaciones();
                autz.setIdalumno(rs.getInt("idalumno"));
                autz.setIdautorizado(rs.getInt("idautorizado"));
            }
            
        }catch(Exception e){
            System.out.println("ERROR byid autz: "+e.getMessage());
        }
        
        return autz;
    }

    @Override
    public ArrayList<Autorizaciones> getAll() throws SQLException {
        ArrayList<Autorizaciones> allautzs = new ArrayList<Autorizaciones>();

        String sql = "SELECT * FROM centroeducativo.autorizaciones";
        Autorizaciones autz = null;
        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {  //Creamos una instancia para pasar los datos por un id
                autz = new Autorizaciones();
                autz.setIdalumno(rs.getInt("idalumno"));
                autz.setIdautorizado(rs.getInt("idautorizado"));
                allautzs.add(autz);
            }

        } catch (Exception e) {
            System.out.println("ERROR byall autz: " + e.getMessage());
        }

        return allautzs;
    }

    @Override
    public int update(Autorizaciones autz) throws SQLException {
        String sql="""
                   update centroeducativo.autorizaciones
                   set idautorizado = ?,
                   where idalumno = ?;
                   """;
        
        try(Connection cn=MyDataSource.getConnection();){
                
            PreparedStatement pstm=cn.prepareStatement(sql);
            pstm.setInt(1, autz.getIdautorizado());
            pstm.setInt(2, autz.getIdalumno());
            
            return pstm.executeUpdate();
            
        }catch(Exception e){
            System.out.println("ERROR updt autz: "+e.getMessage());
        }
        return 0;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql="""
                   delete from centroeducativo.autorizaciones where idalumno = ?;
                   """;
        try(Connection cn=MyDataSource.getConnection();){
                
            PreparedStatement pstm=cn.prepareStatement(sql);
            pstm.setInt(1, id);
            
            pstm.executeUpdate();
        }catch(Exception e){
            System.out.println("ERROR delete autz: "+e.getMessage());
        }
    }
    
    
    
}
