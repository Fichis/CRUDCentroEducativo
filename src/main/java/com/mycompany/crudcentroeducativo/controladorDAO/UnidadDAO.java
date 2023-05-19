/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.crudcentroeducativo.controladorDAO;

import com.mycompany.crudcentroeducativo.entidades.Unidad;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public interface UnidadDAO {
    public int add(Unidad uni) throws SQLException;
    
    public Unidad getById(int id) throws SQLException;
        
    public ArrayList<Unidad> getAll()  throws SQLException;
    
    public int update(Unidad uni)  throws SQLException;
    
    public void delete(int id)  throws SQLException;
}
