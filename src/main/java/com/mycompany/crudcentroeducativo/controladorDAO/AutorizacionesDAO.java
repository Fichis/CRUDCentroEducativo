/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.crudcentroeducativo.controladorDAO;

import com.mycompany.crudcentroeducativo.entidades.Autorizaciones;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public interface AutorizacionesDAO {
    public int add(Autorizaciones autz) throws SQLException;
    
    public Autorizaciones getById(int id) throws SQLException;
        
    public ArrayList<Autorizaciones> getAll()  throws SQLException;
    
    public int update(Autorizaciones autz)  throws SQLException;
    
    public void delete(int id)  throws SQLException;
}
