/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.crudcentroeducativo.controladorDAO;

import com.mycompany.crudcentroeducativo.entidades.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public interface UsuarioDAO {
    public int add(Usuario user) 
        throws SQLException;
    
    public Usuario getById(int id)
        throws SQLException;
    
    public ArrayList<Usuario> getAll()
        throws SQLException;
    
    public int update(Usuario user)
        throws SQLException;
    
    public void delete(int id)
        throws SQLException;
    
    public boolean valida(String user, String pass)
        throws SQLException;
}
