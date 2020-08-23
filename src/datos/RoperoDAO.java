/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Ropero;

/**
 *
 * @author ever
 */
public class RoperoDAO implements IDAO {

    Connection con = null;
    List<Ropero> lista = new ArrayList<>();
    Ropero ropero = null;
    PreparedStatement ps = null;

    public RoperoDAO() {
        con = new Conexion().conectar();
    }

    @Override
    public List<Ropero> listar(String condicion) {

        try {
            String SSQL = "SELECT * FROM roperos " + condicion;

            ps = con.prepareStatement(SSQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                ropero = new Ropero(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("tipoMadera"),
                        rs.getString("descripcion"),
                        rs.getString("dimension"),
                        rs.getBigDecimal("precio")
                );
                lista.add(ropero);

            }

            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    @Override
    public void insertar(Ropero r) {
        try {

            String SSQL = "INSERT INTO roperos (marca,tipoMadera,descripcion,dimension,precio) VALUES (?, ?, ?, ?,?);";
            ps = con.prepareStatement(SSQL);
            ps.setString(1, r.getMarca());
            ps.setString(2, r.getTipoMadera());
            ps.setString(3, r.getDescripcion());
            ps.setString(4, r.getDimension());
            ps.setBigDecimal(5, r.getPrecio());
            ps.execute();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void modificar(Ropero r) {
        try {
            String SSQL = "UPDATE roperos "
                    + "       SET marca=?,"
                    + "           tipoMadera=?,"
                    + "           descripcion=?,"
                    + "           dimension=?,"
                    + "           precio=?"
                    + "     WHERE id=?;";

            ps = con.prepareStatement(SSQL);

            ps.setString(1, r.getMarca());
            ps.setString(2, r.getTipoMadera());
            ps.setString(3, r.getDescripcion());
            ps.setString(4, r.getDimension());
            ps.setBigDecimal(5, r.getPrecio());
            ps.setInt(6, r.getId());

            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void eliminar(Ropero r) {
        try {
            String SSQL = "DELETE FROM roperos WHERE id=?;";

            ps = con.prepareStatement(SSQL);
            ps.setInt(1, r.getId());

            ps.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

}
