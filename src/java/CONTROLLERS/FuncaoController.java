/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import DataAccess.FuncaoDAO;
import DomainModel.Funcao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Diego
 */
@Named(value = "funcaoController")
@SessionScoped
public class FuncaoController implements Serializable {

    /**
     * Creates a new instance of FuncaoController
     */
    @EJB
    FuncaoDAO dao;
    private Funcao entidade,filtro;
    
    private List<Funcao> listagem;

    public FuncaoController() {

        entidade = new Funcao();
        filtro = new Funcao();
    }
    
    public void filtrar(){
        listagem = dao.Buscar(filtro);
    }

    public String novo(){
        entidade = new Funcao();
        return "editarFuncao.xhtml";
    }
    
    public FuncaoDAO getDao() {
        return dao;
    }

    public void setDao(FuncaoDAO dao) {
        this.dao = dao;
    }

    public Funcao getEntidade() {
        return entidade;
    }

    public void setEntidade(Funcao entidade) {
        this.entidade = entidade;
    }

    public Funcao getFiltro() {
        return filtro;
    }

    public void setFiltro(Funcao filtro) {
        this.filtro = filtro;
    }
    
    

    public List<Funcao> getListagem() {
        if(listagem == null){
            listagem = dao.Buscar(null);
        }
        return listagem;
    }
    
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }

    public void salvar() {
        if (dao.Salvar(entidade)) {
            exibirMensagem("Salvo com sucesso!");
        } else {
            exibirMensagem("Falha!");
        }
    }
}
