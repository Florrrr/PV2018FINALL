/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Director;
import java.util.List;

/**
 *
 * @author CX
 */
public interface DirectorDAO {
    List<Director> obtenerTodos();
    Director consulta(int codBuscado);
    void modificar(Director unDirector);
    void agregar(Director unDirector);

}
