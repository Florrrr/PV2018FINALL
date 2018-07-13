/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Cartelera;
import aplicacion.modelo.dominio.Pelicula;
import java.util.Date;
import java.util.List;

/**
 *
 * @author CX
 */
public interface CarteleraDAO {
    List<Cartelera> obtenerTodos();
    Cartelera consulta(Pelicula unaPelicula,Date unaFecha);
    void modificar(Cartelera unaCartelera);
    void agregar(Cartelera unaCartelera);
}
