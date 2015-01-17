
package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.jboss.security.auth.spi.Util;
/**
 * La clase Usuario representa a los usuarios del sistema.
 */
@Entity
@XmlRootElement
@Table(name = "usuarios")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1329756096802348478L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	private String usuario;

	private String password;

	private Integer telefono;

	private String correo;

	@OneToOne(orphanRemoval = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "rol_id", unique = false)
	private Rol rol;

	public Usuario() {
	}
	
	/**
	 * @return el rol al que pertenece el usuario
	 */
	public Rol getRol() {
		return rol;
	}

	/**
	 * @param rol
	 * 			el rol a asignar
	 */
	public void setRol(Rol rol) {
		this.rol = rol;
	}

	
	/**
	 * @return el identificador del usuario
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 * 			el identificador a asignar
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return el nombre del usuario
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 * 				el nombre a asignar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return el nombre de usuario para inicio de sesión
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 * 				el nombre de usuario para inicio de sesión a asignar
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return la contraseña encriptada del usuario
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 * 				el string de la constraseña a encriptar y asignar
	 */
	public void setPassword(String password) {
		String passHash = Util.createPasswordHash("SHA-256", "base64", null,
				null, password);
		this.password = passHash;
	}

	/**
	 * @return el teléfono del usuario
	 */
	public Integer getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono
	 * 				el teléfono a asignar
	 */
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return la dirección de mail del usuario
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo
	 * 				la dirección de mail a asignar
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nombre=" + nombre + ", usuario="
				+ usuario + ", password=" + password + ", telefono=" + telefono
				+ ", correo=" + correo + ", rol=" + rol + "]";
	}
}
