/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudcentroeducativo.controladorDAO;

import com.mycompany.crudcentroeducativo.BD.MyDataSource;
import com.mycompany.crudcentroeducativo.entidades.Personal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class PersonalDAO_IMP 
            implements PersonalDAO{
    
    private static PersonalDAO_IMP instance;
    
    static{
        instance=new PersonalDAO_IMP();
    }
    
    private PersonalDAO_IMP(){ }
    
    public static PersonalDAO_IMP getInstance(){
        return instance;
    }

    @Override
    public int add(Personal pers) throws SQLException {
        String sql="""
                   insert into centroeducativo.personal(dni, nombre, apellido1, apellido2, direccion, cp, poblacion, provincia, telefono, email, tipo)
                   values (?,?,?,?,?,?,?,?,?,?,?);
                   """;
        try(Connection cn=MyDataSource.getConnection();){
                
            PreparedStatement pstm=cn.prepareStatement(sql);
            pstm.setString(1, pers.getDni());
            pstm.setString(2, pers.getNombre());
            pstm.setString(3, pers.getApellido1());
            pstm.setString(4, pers.getApellido2());
            pstm.setString(5, pers.getDireccion());
            pstm.setString(6, pers.getCp());
            pstm.setString(7, pers.getPoblacion());
            pstm.setString(8, pers.getProvincia());
            pstm.setString(9, pers.getTelefono());
            pstm.setString(10, pers.getEmail());
            pstm.setInt(11, pers.getTipo());
            
            return pstm.executeUpdate();
        }catch(Exception e){
            System.out.println("ERROR add pers: "+e.getMessage());
        }
        return 0;
    }

    @Override
    public Personal getById(int id) throws SQLException {
        String sql="SELECT * FROM centroeducativo.personal WHERE id=?";
        Personal pers=null;
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            if(rs.next()){  //Creamos una instancia para pasar los datos por un id
                pers=new Personal();
                pers.setId(rs.getInt("id"));
                pers.setDni(rs.getString("dni"));
                pers.setNombre(rs.getString("nombre"));
                pers.setApellido1(rs.getString("apellido1"));
                pers.setApellido2(rs.getString("apellido2"));
                pers.setDireccion(rs.getString("direccion"));
                pers.setCp(rs.getString("cp"));
                pers.setPoblacion(rs.getString("poblacion"));
                pers.setProvincia(rs.getString("provincia"));
                pers.setTelefono(rs.getString("telefono"));
                pers.setEmail(rs.getString("email"));
                pers.setTipo(rs.getInt("tipo"));
            }
            
        }catch(Exception e){
            System.out.println("ERROR byid pers: "+e.getMessage());
        }
        
        return pers;
    }

    @Override
    public ArrayList<Personal> getAll() throws SQLException {
        ArrayList<Personal> allpers = new ArrayList<Personal>();

        String sql = "SELECT * FROM centroeducativo.personal";
        Personal pers = null;
        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {  //Creamos una instancia para pasar los datos por un id
                pers = new Personal();
                pers.setId(rs.getInt("id"));
                pers.setDni(rs.getString("dni"));
                pers.setNombre(rs.getString("nombre"));
                pers.setApellido1(rs.getString("apellido1"));
                pers.setApellido2(rs.getString("apellido2"));
                pers.setDireccion(rs.getString("direccion"));
                pers.setCp(rs.getString("cp"));
                pers.setPoblacion(rs.getString("poblacion"));
                pers.setProvincia(rs.getString("provincia"));
                pers.setTelefono(rs.getString("telefono"));
                pers.setEmail(rs.getString("email"));
                pers.setTipo(rs.getInt("tipo"));
                allpers.add(pers);
            }

        } catch (Exception e) {
            System.out.println("ERROR byall pers: " + e.getMessage());
        }

        return allpers;
    }

    @Override
    public int update(Personal pers) throws SQLException {
        String sql="""
                   update centroeducativo.personal
                   set dni = ?,
                   nombre = ?,
                   apellido1 = ?,
                   apellido2 = ?,
                   direccion = ?,
                   cp = ?,
                   poblacion = ?,
                   provincia = ?,
                   telefono = ?,
                   email = ?,
                   tipo = ?,
                   where id = ?;
                   """;
        
        try(Connection cn=MyDataSource.getConnection();){
                
            PreparedStatement pstm=cn.prepareStatement(sql);
            pstm.setString(1, pers.getDni());
            pstm.setString(2, pers.getNombre());
            pstm.setString(3, pers.getApellido1());
            pstm.setString(4, pers.getApellido2());
            pstm.setString(5, pers.getDireccion());
            pstm.setString(6, pers.getCp());
            pstm.setString(7, pers.getPoblacion());
            pstm.setString(8, pers.getProvincia());
            pstm.setString(9, pers.getTelefono());
            pstm.setString(10, pers.getEmail());
            pstm.setInt(11, pers.getTipo());
            pstm.setInt(12, pers.getId());
            
            return pstm.executeUpdate();
            
        }catch(Exception e){
            System.out.println("ERROR updt pers: "+e.getMessage());
        }
        return 0;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql="""
                   delete from centroeducativo.personal where id=?;
                   """;
        try(Connection cn=MyDataSource.getConnection();){
                
            PreparedStatement pstm=cn.prepareStatement(sql);
            pstm.setInt(1, id);
            
            pstm.executeUpdate();
        }catch(Exception e){
            System.out.println("ERROR delete pers: "+e.getMessage());
        }
    }
    
    
}
