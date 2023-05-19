/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.crudcentroeducativo.controladorDAO;

import com.mycompany.crudcentroeducativo.entidades.Personal;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public interface PersonalDAO {
    public int add(Personal pers) throws SQLException;
    
    public Personal getById(int id) throws SQLException;
        
    public ArrayList<Personal> getAll()  throws SQLException;
    
    public int update(Personal pers)  throws SQLException;
    
    public void delete(int id)  throws SQLException;
}
