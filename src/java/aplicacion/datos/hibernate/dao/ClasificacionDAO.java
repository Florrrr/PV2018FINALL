/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Clasificacion;
import java.util.List;

/**
 *
 * @author CX
 */
public interface ClasificacionDAO {
    List<Clasificacion> obtenerTodos();
    Clasificacion consulta(int codBuscado);
    void modificar(Clasificacion unaClasificacion);
    void agregar(Clasificacion unaClasificacion);
}
