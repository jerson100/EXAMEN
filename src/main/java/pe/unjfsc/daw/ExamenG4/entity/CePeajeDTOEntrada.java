package pe.unjfsc.daw.ExamenG4.entity;

public class CePeajeDTOEntrada {

	private String empresa;
	private String ruc;
	private String direccion;
	private String ubicacion;
	private String fecha;
	private String horaPeaje;
	private String tipoComprobante;
	private String numeroComprobante;
	private String Categoria;
	private double importe;
	
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHoraPeaje() {
		return horaPeaje;
	}
	public void setHoraPeaje(String horaPeaje) {
		this.horaPeaje = horaPeaje;
	}
	public String getTipoComprobante() {
		return tipoComprobante;
	}
	public void setTipoComprobante(String tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}
	public String getNumeroComprobante() {
		return numeroComprobante;
	}
	public void setNumeroComprobante(String numeroComprobante) {
		this.numeroComprobante = numeroComprobante;
	}
	public String getCategoria() {
		return Categoria;
	}
	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CePeajeDTOEntrada [empresa=");
		builder.append(empresa);
		builder.append(", ruc=");
		builder.append(ruc);
		builder.append(", direccion=");
		builder.append(direccion);
		builder.append(", ubicacion=");
		builder.append(ubicacion);
		builder.append(", fecha=");
		builder.append(fecha);
		builder.append(", horaPeaje=");
		builder.append(horaPeaje);
		builder.append(", tipoComprobante=");
		builder.append(tipoComprobante);
		builder.append(", numeroComprobante=");
		builder.append(numeroComprobante);
		builder.append(", Categoria=");
		builder.append(Categoria);
		builder.append(", importe=");
		builder.append(importe);
		builder.append("]");
		return builder.toString();
	}
	
}
