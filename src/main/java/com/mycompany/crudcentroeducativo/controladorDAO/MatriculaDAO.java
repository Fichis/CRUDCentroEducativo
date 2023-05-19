/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.crudcentroeducativo.controladorDAO;

import com.mycompany.crudcentroeducativo.entidades.Matricula;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public interface MatriculaDAO {
    public int add(Matricula matr) throws SQLException;
    
    public Matricula getById(int id) throws SQLException;
        
    public ArrayList<Matricula> getAll()  throws SQLException;
    
    public int update(Matricula matr)  throws SQLException;
    
    public void delete(int id)  throws SQLException;
}
