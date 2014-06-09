/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import DataAccess.PessoaDAO;
import DomainModel.Pessoa;
import DomainModel.Pessoa_;
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
@Named(value = "pessoaController")
@SessionScoped
public class PessoaController implements Serializable {

    /**
     * Creates a new instance of PessoaController
     */
    @EJB
    PessoaDAO dao;
    private Pessoa entidade,filtro;
    
    private List<Pessoa> listagem;

    public PessoaController() {

        entidade = new Pessoa();
        filtro = new Pessoa();
    }
    
    public List<Pessoa> autoCompletar(String texto){
        Pessoa tmp = new Pessoa();
        tmp.setNome(texto);
        return dao.Buscar(tmp);
    }
    
    public void filtrar(){
        listagem = dao.Buscar(filtro);
    }

    public String novo(){
        entidade = new Pessoa();
        return "editarPessoa.xhtml";
    }
    
    public PessoaDAO getDao() {
        return dao;
    }

    public void setDao(PessoaDAO dao) {
        this.dao = dao;
    }

    public Pessoa getEntidade() {
        return entidade;
    }

    public void setEntidade(Pessoa entidade) {
        this.entidade = entidade;
    }

    public Pessoa getFiltro() {
        return filtro;
    }

    public void setFiltro(Pessoa filtro) {
        this.filtro = filtro;
    }
    
    

    public List<Pessoa> getListagem() {
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
            entidade = new Pessoa();
        } else {
            exibirMensagem("Falha!");
        }
    }
}
