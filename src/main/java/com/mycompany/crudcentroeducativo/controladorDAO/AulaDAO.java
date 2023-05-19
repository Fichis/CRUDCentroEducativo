/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.crudcentroeducativo.controladorDAO;

import com.mycompany.crudcentroeducativo.entidades.Aula;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public interface AulaDAO {
    public int add(Aula aula) throws SQLException;
    
    public Aula getById(int id) throws SQLException;
        
    public ArrayList<Aula> getAll()  throws SQLException;
    
    public int update(Aula aula)  throws SQLException;
    
    public void delete(int id)  throws SQLException;
}
