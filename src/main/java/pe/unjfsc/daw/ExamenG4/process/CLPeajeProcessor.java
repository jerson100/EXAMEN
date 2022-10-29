package pe.unjfsc.daw.ExamenG4.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;

import pe.unjfsc.daw.ExamenG4.entity.CePeajeDTOEntrada;
import pe.unjfsc.daw.ExamenG4.entity.CePeajeDTOSalida;
import pe.unjfsc.daw.ExamenG4.utils.ProcesarDescuento;

public class CLPeajeProcessor implements ItemProcessor<CePeajeDTOEntrada, CePeajeDTOSalida> { 

	  private static final Logger MOLOG = LoggerFactory.getLogger(CLPeajeProcessor.class); 

	  public CLPeajeProcessor() {
	  }
	  
	  public CePeajeDTOSalida process(CePeajeDTOEntrada poItemPeaje) throws Exception { 

	     MOLOG.info("[DAW] =====[ Start process ]====="); 

	     MOLOG.info("[DAW] Data received input : {} ", poItemPeaje.toString()); 

	     CePeajeDTOSalida oPeajeSalida = getProcesarDescuento().calcularDescuento(poItemPeaje);
	     
	     MOLOG.info("[DAW] New CELostPetDTOSalida : {} ", oPeajeSalida.toString()); 

	     return oPeajeSalida; 

	  } 
	  
	  @Bean
		public ProcesarDescuento getProcesarDescuento() {
			return new ProcesarDescuento();
		}

} 