/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myPack;

import java.util.List;
import javax.ejb.Local;

@Local
public interface MybmpFacadeLocal {

    void create(Mybmp mybmp);

    void edit(Mybmp mybmp);

    void remove(Mybmp mybmp);

    Mybmp find(Object id);

    List<Mybmp> findAll();

    List<Mybmp> findRange(int[] range);

    int count();

    void addEmp(int id, String name);
    
}
