/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import datos.IDAO;
import datos.RoperoDAO;
import java.util.List;
import modelo.Ropero;

/**
 *
 * @author ever
 */
public class RoperoControl  implements IDAO{

    @Override
    public List<Ropero> listar(String condicion) {
        return new RoperoDAO().listar(condicion);
    }

    @Override
    public void insertar(Ropero r) {
        new RoperoDAO().insertar(r);
    }

    @Override
    public void modificar(Ropero r) {
        new RoperoDAO().modificar(r);
    }

    @Override
    public void eliminar(Ropero r) {
        new RoperoDAO().eliminar(r);
    }
    
}
