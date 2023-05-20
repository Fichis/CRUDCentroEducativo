/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudcentroeducativo.controladorDAO;

import com.mycompany.crudcentroeducativo.BD.MyDataSource;
import com.mycompany.crudcentroeducativo.entidades.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class AlumnoDAO_IMP 
            implements AlumnoDAO {
    private static AlumnoDAO_IMP instance;
    
    static{
        instance=new AlumnoDAO_IMP();
    }
    
    private AlumnoDAO_IMP(){ }
    
    public static AlumnoDAO_IMP getInstance(){
        return instance;
    }
    

    @Override
    public int add(Alumno a) throws SQLException {
        String sql="""
                   insert into alumno(dni, nombre, apellido1, apellido2, fNacimiento, telefono, email, direccion, cp, poblacion, provincia)
                   values(?,?,?,?,?,?,?,?,?,?,?);
                   """;
        try(Connection cn=MyDataSource.getConnection();){
                
            PreparedStatement pstm=cn.prepareStatement(sql);
            pstm.setString(1, a.getDni());
            pstm.setString(2, a.getNombre());
            pstm.setString(3, a.getApellido1());
            pstm.setString(4, a.getApellido2());
            pstm.setDate(5, a.getFechanacimiento());
            pstm.setString(6, a.getTelefono());
            pstm.setString(7, a.getEmail());
            pstm.setString(8, a.getDireccion());
            pstm.setString(9, a.getCodpostal());
            pstm.setString(10, a.getPoblacion());
            pstm.setString(11, a.getProvincia());
            
            return pstm.executeUpdate();
        }catch(Exception e){
            System.out.println("ERROR add al:"+e.getMessage());
        }
        return 0;
    }

    @Override
    public Alumno getById(int id) throws SQLException {
        String sql="SELECT * FROM centroeducativo.alumno WHERE id=?";
        Alumno alumn=null;
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            if(rs.next()){  //Creamos una instancia para pasar los datos por un id
                alumn=new Alumno();
                alumn.setId(rs.getInt("id"));
                alumn.setNombre(rs.getString("Nombre"));
                alumn.setApellido1(rs.getString("Apellido1"));
                alumn.setApellido2(rs.getString("Apellido2"));
                alumn.setDni(rs.getString("DNI"));
                alumn.setFechanacimiento(rs.getDate("fNacimiento"));
                alumn.setTelefono(rs.getString("telefono"));
                alumn.setEmail(rs.getString("email"));
                alumn.setDireccion(rs.getString("direccion"));
                alumn.setCodpostal(rs.getString("cp"));
                alumn.setProvincia(rs.getString("provincia"));
                alumn.setPoblacion(rs.getString("poblacion"));
            }
            
        }catch(Exception e){
            System.out.println("ERROR byid al: "+e.getMessage());
        }
        
        return alumn;
    }

    @Override
    public ArrayList<Alumno> getAll() throws SQLException {
        ArrayList<Alumno> allalumn = new ArrayList<Alumno>();
        
        String sql="SELECT * FROM centroeducativo.alumno";
        Alumno alumn=null;
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);) {
            
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){  //Creamos una instancia para pasar los datos por un id
                alumn=new Alumno();
                alumn.setId(rs.getInt("id"));
                alumn.setNombre(rs.getString("Nombre"));
                alumn.setApellido1(rs.getString("Apellido1"));
                alumn.setApellido2(rs.getString("Apellido2"));
                alumn.setDni(rs.getString("DNI"));
                alumn.setFechanacimiento(rs.getDate("fNacimiento"));
                alumn.setTelefono(rs.getString("telefono"));
                alumn.setEmail(rs.getString("email"));
                alumn.setDireccion(rs.getString("direccion"));
                alumn.setCodpostal(rs.getString("cp"));
                alumn.setProvincia(rs.getString("provincia"));
                alumn.setPoblacion(rs.getString("poblacion"));
                
                allalumn.add(alumn);
            }
            
        }catch(Exception e){
            System.out.println("ERROR byall al: "+e.getMessage());
        }
        
        return allalumn;
    }

    @Override
    public int update(Alumno a) throws SQLException {
        String sql="""
                   update centroeducativo.alumno
                   set dni = ?,
                   nombre = ?,
                   apellido1 = ?,
                   apellido2 = ?,
                   fNacimiento = ?,
                   telefono = ?,
                   email = ?,
                   direccion = ?,
                   cp = ?,
                   poblacion = ?,
                   provincia = ?
                   where id = ?;
                   """;
        
        try(Connection cn=MyDataSource.getConnection();){
                
            PreparedStatement pstm=cn.prepareStatement(sql);
            
            pstm.setString(1, a.getDni());
            pstm.setString(2, a.getNombre());
            pstm.setString(3, a.getApellido1());
            pstm.setString(4, a.getApellido2());
            pstm.setDate(5, a.getFechanacimiento());
            pstm.setString(6, a.getTelefono());
            pstm.setString(7, a.getEmail());
            pstm.setString(8, a.getDireccion());
            pstm.setString(9, a.getCodpostal());
            pstm.setString(10, a.getPoblacion());
            pstm.setString(11, a.getProvincia());
            pstm.setInt(12, a.getId());
            
            return pstm.executeUpdate();
            
        }catch(Exception e){
            System.out.println("ERROR updt al: "+e.getMessage());
        }
        return 0;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql="""
                   delete from centroeducativo.alumno where id=?;
                   """;
        try(Connection cn=MyDataSource.getConnection();){
                
            PreparedStatement pstm=cn.prepareStatement(sql);
            pstm.setInt(1, id);
            
            pstm.executeUpdate();
        }catch(Exception e){
            System.out.println("ERROR delet al: "+e.getMessage());
        }
    }
    
    
    
}
