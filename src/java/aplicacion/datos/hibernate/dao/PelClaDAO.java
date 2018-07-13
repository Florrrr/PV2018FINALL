/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.PelCla;

/**
 *
 * @author CX
 */
public interface PelClaDAO {
    void modificar(PelCla unaPelCla);
    void agregar(PelCla unaPelCla);
}
