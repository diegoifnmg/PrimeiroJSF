/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import DomainModel.Funcao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Diego
 */
@Stateless
public class FuncaoDAO extends DaoGenerico<Funcao> {

    public FuncaoDAO() {
        super(Funcao.class);
    }

    @Override
    public List<Funcao> Buscar(Funcao obj) {
        String Consulta = "select l from Funcao l";
        if(obj != null){
            Consulta = Consulta + " where l.nome like '%" + obj.getNome() + "%'";
        }
        Query q = manager.createQuery(Consulta);
        return q.getResultList();
    }
}
