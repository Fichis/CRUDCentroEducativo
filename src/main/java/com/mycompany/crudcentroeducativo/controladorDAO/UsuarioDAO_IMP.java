/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudcentroeducativo.controladorDAO;

import com.mycompany.crudcentroeducativo.BD.MyDataSource;
import com.mycompany.crudcentroeducativo.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class UsuarioDAO_IMP 
            implements UsuarioDAO{
    private static UsuarioDAO_IMP instance;
    static{
        instance = new UsuarioDAO_IMP();
    }
    
    private UsuarioDAO_IMP(){
    }
    
    public static UsuarioDAO_IMP getInstance(){
        return instance;
    }

    @Override
    public int add(Usuario user) throws SQLException {
        String sql="""
                   insert into centroeducativo.usuario (usuario, password)
                   values(?,?);
                   """;
        try(Connection cn=MyDataSource.getConnection();){
                
            PreparedStatement pstm=cn.prepareStatement(sql);
            pstm.setString(1, user.getUsuario());
            pstm.setString(2, user.getPassword());
            
            return pstm.executeUpdate();
        }catch(Exception e){
            System.out.println("ERROR add us: "+e.getMessage());
        }
        return 0;
    }

    @Override
    public Usuario getById(int id) throws SQLException {
        String sql="SELECT * FROM centroeducativo.usuario WHERE id=?";
        Usuario users=null;
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            if(rs.next()){  //Creamos una instancia para pasar los datos por un id
                users=new Usuario();
                users.setId(rs.getInt("id"));
                users.setUsuario(rs.getString("usuario"));
                users.setPassword(rs.getString("password"));
            }
            
        }catch(Exception e){
            System.out.println("ERROR byid us: "+e.getMessage());
        }
        
        return users;
    }

    @Override
    public ArrayList<Usuario> getAll() throws SQLException {

        ArrayList<Usuario> allusers = new ArrayList<Usuario>();

        String sql = "SELECT * FROM centroeducativo.usersdemico";
        Usuario users = null;
        try ( Connection cn = MyDataSource.getConnection();  PreparedStatement pstm = cn.prepareStatement(sql);) {

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {  //Creamos una instancia para pasar los datos por un id
                users = new Usuario();
                users.setId(rs.getInt("id"));
                users.setUsuario(rs.getString("usuario"));
                users.setUsuario(rs.getString("password"));
                allusers.add(users);
            }

        } catch (Exception e) {
            System.out.println("ERROR byall us: " + e.getMessage());
        }

        return allusers;
    }

    @Override
    public int update(Usuario user) throws SQLException {
        String sql="""
                   update centroeducativo.usuario
                   set usuario = ?,
                   password = ?,
                   where id = ?;
                   """;
        
        try(Connection cn=MyDataSource.getConnection();){
                
            PreparedStatement pstm=cn.prepareStatement(sql);
            pstm.setString(1, user.getUsuario());
            pstm.setString(2, user.getPassword());
            pstm.setInt(3, user.getId());
            
            return pstm.executeUpdate();
            
        }catch(Exception e){
            System.out.println("ERROR updt us: "+e.getMessage());
        }
        return 0;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql="""
                   delete from centroeducativo.usuario where id=?;
                   """;
        try(Connection cn=MyDataSource.getConnection();){
                
            PreparedStatement pstm=cn.prepareStatement(sql);
            pstm.setInt(1, id);
            
            pstm.executeUpdate();
        }catch(Exception e){
            System.out.println("ERROR delete us: "+e.getMessage());
        }
    }

    @Override
    public boolean valida(String user, String pass) throws SQLException {
        String sql="SELECT * FROM centroeducativo.usuario WHERE usuario = ? and password = ?";
        
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            pstm.setString(1, user);
            pstm.setString(2, pass);
            
            ResultSet rs=pstm.executeQuery();
            if(rs.next()){  //Creamos una instancia para pasar los datos por un id
                return true;
            }
            
        }catch(Exception e){
            System.out.println("ERROR valida us: "+e.getMessage());
        }
        
        return false;
    }
    
    
}
