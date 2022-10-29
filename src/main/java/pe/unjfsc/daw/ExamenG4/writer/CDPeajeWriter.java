package pe.unjfsc.daw.ExamenG4.writer;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

import org.springframework.batch.item.ItemWriter;

import pe.unjfsc.daw.ExamenG4.entity.CePeajeDTOSalida;

public class CDPeajeWriter implements ItemWriter<CePeajeDTOSalida> { 


	  private static final Logger LOG = LoggerFactory.getLogger(CDPeajeWriter.class); 

	  /*
	   * La salidas puede ser en distintos formatos...
	   * */
	  public void write(List<? extends CePeajeDTOSalida> poPeajeSalida) throws Exception { 

	     LOG.info("[DAW] =====[ Start write ]====="); 

	     LOG.info("[DAW] Object output : {} ", poPeajeSalida.toString()); 

	     for(CePeajeDTOSalida lostPet:poPeajeSalida) { 

	        LOG.info("[DAW] lostPet read  : {}", lostPet.toString()); 

	     } 
	     
	     /*String fileName = JOptionPane.showInputDialog("Ingrese el nombre del archivo en el que se guardará,"
	     		+ "\nSi no ingresa nada se generará con la fecha");
	     
	     if(fileName.isEmpty()) {
	    	 fileName = "" + new Date().getTime();
	     }*/
	     
	     //writeFileInSystem(poPeajeSalida, new Date().getTime()+".txt");
	     cargarData(poPeajeSalida);

	  }
	  
	  public static void cargarData(List<? extends CePeajeDTOSalida> poPeajeSalida) throws Exception {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// Elemento raíz
			org.w3c.dom.Document doc = docBuilder.newDocument();
			org.w3c.dom.Element rootElement = doc.createElement("root");
			doc.appendChild(rootElement);

			for (CePeajeDTOSalida o : poPeajeSalida) {
				org.w3c.dom.Element tag = doc.createElement("PEAJE");
				rootElement.appendChild(tag);
				Element fac = doc.createElement("RUC");
				fac.setTextContent(o.getRuc());
				tag.appendChild(fac);
				Element datos = doc.createElement("DIRECCION");
				datos.setTextContent(o.getDireccion());
				tag.appendChild(datos);
				Element correo = doc.createElement("UBICACION");
				correo.setTextContent(o.getUbicacion());
				tag.appendChild(correo);
				Element ciclo = doc.createElement("FECHA");
				ciclo.setTextContent(o.getFecha());
				tag.appendChild(ciclo);
				Element proc = doc.createElement("HORAPEAJE");
				proc.setTextContent(o.getHoraPeaje());
				tag.appendChild(proc);
				Element edad = doc.createElement("TIPOCOMPROBANTE");
				edad.setTextContent(o.getTipoComprobante());
				tag.appendChild(edad);
				Element curso = doc.createElement("NUMERO_COMPROBANTE");
				curso.setTextContent(o.getNumeroComprobante());
				tag.appendChild(curso);
				Element mod = doc.createElement("CATEGORIA");
				mod.setTextContent(o.getCategoria());
				Element importe = doc.createElement("IMPORTE");
				importe.setTextContent(""+o.getImporte());
				tag.appendChild(importe);
				
				Element porcentajeDescuento = doc.createElement("PORCENTAJE_DESCUENTO");
				porcentajeDescuento.setTextContent(""+o.getPorcentajeDescuento());
				tag.appendChild(porcentajeDescuento);
				
				Element totalD = doc.createElement("TOTAL_DESCUENTO");
				totalD.setTextContent(""+o.getTotalDescuento());
				tag.appendChild(totalD);
			}
			// Se escribe el contenido del XML en un archivo
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("src/main/resources/fuente/output/matriculados.xml"));
			transformer.transform(source, result);
			LOG.info("[EVL] Se ha cargado los datos.");
		}


	} 