package pe.egcc.app.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="mensaje")
public class MensajeDto {

	private int codigo;
	private String mensaje;

	public MensajeDto() {
	}

	public MensajeDto(int codigo, String mensaje) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
