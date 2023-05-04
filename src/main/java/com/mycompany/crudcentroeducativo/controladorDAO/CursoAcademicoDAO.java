/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.crudcentroeducativo.controladorDAO;

import com.mycompany.crudcentroeducativo.entidades.CursoAcademico;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public interface CursoAcademicoDAO {
    public int add(CursoAcademico c) 
        throws SQLException;
    
    public CursoAcademico getById(int id)
        throws SQLException;
    
    public ArrayList<CursoAcademico> getAll()
        throws SQLException;
    
    public int update(CursoAcademico c)
        throws SQLException;
    
    void delete(int id)
        throws SQLException;
    
    
}
