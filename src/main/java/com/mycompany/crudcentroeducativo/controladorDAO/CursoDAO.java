/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.crudcentroeducativo.controladorDAO;

import com.mycompany.crudcentroeducativo.entidades.Curso;
import com.mycompany.crudcentroeducativo.entidades.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public interface CursoDAO {
    public int add(Curso c) 
        throws SQLException;
    
    public Curso getById(int id)
        throws SQLException;
    
    public ArrayList<Curso> getAll()
        throws SQLException;
    
    public int update(Curso c)
        throws SQLException;
    
    public void delete(int id)
        throws SQLException;
    
    public ArrayList<Curso> getAllByCursoAcademico(int idcursoacademico)
        throws SQLException;
}
