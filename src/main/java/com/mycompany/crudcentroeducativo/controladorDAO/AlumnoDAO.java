/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.crudcentroeducativo.controladorDAO;

import com.mycompany.crudcentroeducativo.entidades.Alumno;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public interface AlumnoDAO {
    public int add(Alumno a) throws SQLException;
    
    public Alumno getById(int id) throws SQLException;
        
    public ArrayList<Alumno> getAll()  throws SQLException;
    
    public int update(Alumno a)  throws SQLException;
    
    public void delete(int id)  throws SQLException;
}
