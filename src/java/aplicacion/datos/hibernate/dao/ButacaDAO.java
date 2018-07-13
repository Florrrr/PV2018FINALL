/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Butaca;
import aplicacion.modelo.dominio.Sala;
import java.util.List;

/**
 *
 * @author CX
 */
public interface ButacaDAO {
    List<Butaca> obtenerTodos(Sala unaSala);
    List<Butaca> obtenerTudos();
    Butaca consulta(int codBuscado);
    void modificar(Butaca unaButaca);
    void agregar(Butaca unaButaca);
}
