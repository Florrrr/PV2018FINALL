/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Pelicula;
import java.util.List;

/**
 *
 * @author CX
 */
public interface PeliculaDAO {
    List<Pelicula> obtenerTodos();
    Pelicula consulta(int codBuscado);
    void modificar(Pelicula unaPelicula);
    void agregar(Pelicula unaPelicula);
}
