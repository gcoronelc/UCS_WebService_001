/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eurekabank.service.test;

import java.sql.Connection;
import java.util.List;
import pe.eurekabank.db.AccesoDB;
import pe.eurekabank.entity.Movimiento;
import pe.eurekabank.servicio.CuentaService;

/**
 *
 * @author CSarmiento
 */
public class CuentaServiceTest {
    
    public static void main(String[] args) {
        try {
            CuentaService cuentaService = new CuentaService();
            List<Movimiento> cuentas = cuentaService.leerMovimientos("00100001");
            for (int i = 0; i < cuentas.size(); i++) {
                Movimiento cuenta = cuentas.get(i);
                System.out.println(cuenta.getTipo());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
  }
}
