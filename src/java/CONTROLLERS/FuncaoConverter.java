/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import DataAccess.FuncaoDAO;
import DomainModel.Funcao;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
 
@Named(value = "funcaoConverter")
@SessionScoped
public class FuncaoConverter implements Serializable, Converter {
 
    @EJB
    FuncaoDAO dao;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            Long id = Long.parseLong(value);
            return dao.Abrir(id) ;
        }
        else {
            return null;
        }
    }
 
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return ((Funcao)object).getId().toString();
        }
        else {
            return null;
        }
    }   
}     