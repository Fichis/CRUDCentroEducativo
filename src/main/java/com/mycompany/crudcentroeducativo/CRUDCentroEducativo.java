/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.crudcentroeducativo;

import com.mycompany.crudcentroeducativo.BD.MyDataSource;
import com.mycompany.crudcentroeducativo.controladorDAO.CursoAcademicoDAO_IMP;
import com.mycompany.crudcentroeducativo.entidades.CursoAcademico;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class CRUDCentroEducativo {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Connection cnlocal=MyDataSource.getConnection();
        Test();
    }
    
    public static void Test(){
        CursoAcademicoDAO_IMP caimp1 = CursoAcademicoDAO_IMP.getInstance();
        CursoAcademico c1 = new CursoAcademico(2005, 2006, "Curso 2005-2006");
        
        try{
        CursoAcademico cursoaca = caimp1.getById(1);
            System.out.println(cursoaca);
            
        }catch (Exception e){
            System.out.println("ERROR: "+e.getMessage());
        }
        
        //Probando el add
        /*try {
            caimp1.add(c1);
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCentroEducativo.class.getName()).log(Level.SEVERE, null, ex);
        }*/
            //Probando el delete
            /*try {
            caimp1.delete(4); //El id no lo puedo pasar como c1.getId();
            } catch (SQLException ex) {
            Logger.getLogger(CRUDCentroEducativo.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            
            //Probando el update 1
            /*try{
            c1.setYearinicio(2005);
            c1.setYearfin(2006);
            c1.setDescripcion("Curso 2005 - 2006");
            caimp1.update(c1);
            }catch(SQLException ex) {
            Logger.getLogger(CRUDCentroEducativo.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            
            //Probando el update 2
            /*try{
            caimp1.update(c1, 2001, 2002, "Curso 2001-2002");
            }catch(Exception e) {
            System.out.println("ERROR: "+e.getMessage());
            }*/
            
            //Probando el getAll
            try{
                System.out.println(caimp1.getAll());
            } catch (SQLException ex) {
                Logger.getLogger(CRUDCentroEducativo.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
}
