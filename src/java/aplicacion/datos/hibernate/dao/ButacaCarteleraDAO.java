/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.ButacaCartelera;
import java.util.List;

/**
 *
 * @author CX
 */
public interface ButacaCarteleraDAO{
    List<ButacaCartelera> obtenerTodos();
    ButacaCartelera consulta(int codBuscado);
    void modificar(ButacaCartelera unaButacaCartelera);
    void agregar(ButacaCartelera unaButacaCartelera);
}
