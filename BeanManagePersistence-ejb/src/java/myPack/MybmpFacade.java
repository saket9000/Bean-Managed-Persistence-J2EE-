/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MybmpFacade extends AbstractFacade<Mybmp> implements MybmpFacadeLocal {

    @PersistenceContext(unitName = "BeanManagePersistence-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MybmpFacade() {
        super(Mybmp.class);
    }

    @Override
    public void addEmp(int id, String name) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "admin");
            Statement stmt = conn.createStatement();
            stmt.execute("insert into MYBMP(id, name) values (" + id + ",'" + name +"')");
        } catch (SQLException ex) {
            Logger.getLogger(MybmpFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
