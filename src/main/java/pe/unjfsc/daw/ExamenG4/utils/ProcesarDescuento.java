package pe.unjfsc.daw.ExamenG4.utils;

import java.util.HashMap;
import java.util.Map;

import pe.unjfsc.daw.ExamenG4.entity.CePeajeDTOEntrada;
import pe.unjfsc.daw.ExamenG4.entity.CePeajeDTOSalida;

public class ProcesarDescuento {

	private final Map<String, Double> descuentos = new HashMap<String, Double>();
	
	public ProcesarDescuento() {
		descuentos.put("VILLA", 5.0);
		descuentos.put("PUNTA NEGRA", 6.0);
		descuentos.put("ACCESO SAN PEDRO", 7.0);
		descuentos.put("CHILLÓN", 15.0);
		descuentos.put("ACCESO ARICA", 25.0);
		descuentos.put("PARAÍSO", 35.0);
		descuentos.put("VARIANTE", 15.0);
		descuentos.put("CONCHAN", 17.0);
		descuentos.put("CHILCA", 20.0);
	}
	
	/*
	 *  VILLA	5,00%
		PUNTA NEGRA	6,00%
		ACCESO SAN PEDRO	7,00%
		CHILLÓN	15,00%
		ACCESO ARICA	25,00%
		PARAÍSO	35,00%
		VARIANTE	15,00%
		CONCHAN	17,00%
		CHILCA	20,00%
	 * 
	 * 
	 * */
	
	
	public CePeajeDTOSalida calcularDescuento(CePeajeDTOEntrada entrada) {
		CePeajeDTOSalida objSalida = new CePeajeDTOSalida();
		objSalida.setEmpresa(entrada.getEmpresa());
		objSalida.setRuc(entrada.getRuc());
		objSalida.setDireccion(entrada.getDireccion());
		objSalida.setUbicacion(entrada.getUbicacion());
		objSalida.setFecha(entrada.getFecha());
		objSalida.setHoraPeaje(entrada.getHoraPeaje());
		objSalida.setTipoComprobante(entrada.getTipoComprobante());
		objSalida.setNumeroComprobante(entrada.getTipoComprobante());
		objSalida.setNumeroComprobante(entrada.getNumeroComprobante());
		objSalida.setCategoria(entrada.getCategoria());
		objSalida.setImporte(entrada.getImporte());
		objSalida.setPorcentajeDescuento(getPorcentajeDescuento(entrada.getUbicacion()));
		objSalida.setTotalDescuento(objSalida.getImporte() - (objSalida.getPorcentajeDescuento() / 100) *  objSalida.getImporte());
		return objSalida;
	};
	
	
	public double getPorcentajeDescuento(String ubicacion) {
		return descuentos.get(ubicacion).doubleValue();
	}
	
}
