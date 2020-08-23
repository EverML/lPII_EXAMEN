/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.List;
import modelo.Ropero;

/**
 *
 * @author ever
 */
public interface IDAO {
   
    public List<Ropero> listar( String condicion );
    public void insertar ( Ropero r );
    public void modificar ( Ropero r );
    public void eliminar ( Ropero r );
    
    


}
