/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.PelDir;
import java.util.List;

/**
 *
 * @author CX
 */
public interface PelDirDAO {
    List<PelDir> obtenerTodos();
    PelDir consulta(int codBuscado);
    void modificar(PelDir unaPelDir);
    void agregar(PelDir unaPelDir);

}
