/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Sala;
import java.util.List;

/**
 *
 * @author CX
 */
public interface SalaDAO {
    List<Sala> obtenerTodos();
    Sala consulta(int codBuscado);
    void modificar(Sala unaSala);
    void agregar(Sala unaSala);
}
