/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diego
 */


    public abstract class DaoGenerico<T> {

        @PersistenceContext(name = "PrimeroJSFPU")
        protected EntityManager manager;
        private Class tipo;

        public DaoGenerico(Class t) {
            tipo = t;
        }

        public boolean Salvar(T obj) {
            try {
                //salva o objeto
                manager.merge(obj);
                return true;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return false;
            }
        }

        public T Abrir(Long id) {
            try {
                T obj = (T) manager.find(tipo, id);
                return obj;
                //abrir
            } catch (Exception ex) {
                return null;
            }
        }

        public abstract List<T> Buscar(T obj);

        public boolean Apagar(T obj) {
            try {
                manager.remove(manager.merge(obj));
                return true;
            } catch (Exception ex) {
                return false;
            }
        }
    
}
