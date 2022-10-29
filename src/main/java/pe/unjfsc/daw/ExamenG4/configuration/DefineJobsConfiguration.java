package pe.unjfsc.daw.ExamenG4.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import pe.unjfsc.daw.ExamenG4.entity.CePeajeDTOEntrada;
import pe.unjfsc.daw.ExamenG4.entity.CePeajeDTOSalida;
import pe.unjfsc.daw.ExamenG4.listener.JobLoteMovimientosListener;
import pe.unjfsc.daw.ExamenG4.mapper.CLPeajeMapper;
import pe.unjfsc.daw.ExamenG4.process.CLPeajeProcessor;
import pe.unjfsc.daw.ExamenG4.writer.CDPeajeWriter;

@Configuration
@EnableBatchProcessing
public class DefineJobsConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public DelimitedLineTokenizer getLostPetTokenizer() {
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter(",");
		tokenizer.setNames(new String[]{
				"N","EMPRESA", "RUC",
				"DIRECCION", "UBICACION",
				"FECHA", "HORA",
				"TIPOCOMPROBANTE", "NCOMPROBANTE",
				"CATEGORIA","IMPORTE"});
		return tokenizer;
	}
	
	@Bean
	public DefaultLineMapper<CePeajeDTOEntrada> getPeajeLineMapper(){
		DefaultLineMapper<CePeajeDTOEntrada> lineM = new DefaultLineMapper<CePeajeDTOEntrada>();
		lineM.setLineTokenizer(getLostPetTokenizer());
		lineM.setFieldSetMapper(getLostPetMapper());
		return lineM;
	}
	
	@Bean
	public CLPeajeMapper getLostPetMapper() {
		return new CLPeajeMapper();
	}
	
	@Bean
	public FlatFileItemReader<CePeajeDTOEntrada> getPeajeReader() {
		FlatFileItemReader<CePeajeDTOEntrada> reader = new FlatFileItemReader<CePeajeDTOEntrada>();
		reader.setResource(new ClassPathResource("fuente/input/peajes.csv"));
		reader.setLineMapper(getPeajeLineMapper());
		return reader;
	}
	
	@Bean
	public Job procesarLoteLostPet(JobLoteMovimientosListener listener, Step stepOne) {
		return jobBuilderFactory.get("procesarLoteLostPet")
				.listener(listener)
				.flow(stepOne)
				.end()
				.build();
	}
	
	@Bean
	public Step stepOne() {
		return stepBuilderFactory.get("stepOne")
				.<CePeajeDTOEntrada,CePeajeDTOSalida>chunk(89)
				.reader(getPeajeReader())
				.processor(getCLPeajeProcessor())
				.writer(getCDPeajeWriter())
				.build();
	}
	
	@Bean
	public CLPeajeProcessor getCLPeajeProcessor() {
		return new CLPeajeProcessor();
	}
	
	@Bean
	public CDPeajeWriter getCDPeajeWriter() {
		return new CDPeajeWriter();
	}
	
}
