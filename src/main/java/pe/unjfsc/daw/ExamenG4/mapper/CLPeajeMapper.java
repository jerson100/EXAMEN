package pe.unjfsc.daw.ExamenG4.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import pe.unjfsc.daw.ExamenG4.entity.CePeajeDTOEntrada;

import org.springframework.batch.item.file.mapping.FieldSetMapper;

public class CLPeajeMapper implements FieldSetMapper<CePeajeDTOEntrada>{
	private static final Logger MOLOG = LoggerFactory.getLogger(CLPeajeMapper.class);
	/*Aquí podemos hacer algunas validaciones también*/
	@Override
	public CePeajeDTOEntrada mapFieldSet(FieldSet fieldSet) throws BindException {
		 MOLOG.info("[DAW] =====[ Start mapFieldSet ]====="); 
	     MOLOG.info("[DAW] read record : {} ", fieldSet.toString()); 
	     CePeajeDTOEntrada oLostEntrada = new CePeajeDTOEntrada(); 
	     oLostEntrada.setEmpresa(fieldSet.readString("EMPRESA")); 
	     oLostEntrada.setRuc(fieldSet.readString("RUC")); 
	     oLostEntrada.setDireccion(fieldSet.readString("DIRECCION")); 
	     oLostEntrada.setUbicacion(fieldSet.readString("UBICACION")); 
	     oLostEntrada.setFecha(fieldSet.readString("FECHA")); 
	     oLostEntrada.setHoraPeaje(fieldSet.readString("HORA")); 
	     oLostEntrada.setTipoComprobante(fieldSet.readString("TIPOCOMPROBANTE")); 
	     oLostEntrada.setNumeroComprobante(fieldSet.readString("NCOMPROBANTE"));
	     oLostEntrada.setCategoria(fieldSet.readString("CATEGORIA"));
	     oLostEntrada.setImporte(fieldSet.readDouble("IMPORTE"));
	     MOLOG.info("[DAW] Mapper to CELostPetDTOEntrada : {}", oLostEntrada.toString()); 
	     return oLostEntrada; 
	} 
}
