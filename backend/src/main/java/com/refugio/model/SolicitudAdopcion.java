package com.refugio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "solicitudes_adopcion")
public class SolicitudAdopcion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Debes indicar el nombre del animal")
  private String nombreAnimal;

  @NotBlank(message = "El nombre y apellidos son obligatorios")
  private String nombreApellidos;

  @NotBlank(message = "El DNI es obligatorio")
  private String dni;

  private String fechaNacimiento;
  private String domicilio;
  private String codigoPostal;
  private String municipio;
  private String provincia;
  private String telefonoFijo;

  @NotBlank(message = "El teléfono móvil es obligatorio")
  private String telefonoMovil;

  @Email(message = "El formato del email no es válido")
  private String email;

  public SolicitudAdopcion() {}

  // Getters y Setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getNombreAnimal() { return nombreAnimal; }
  public void setNombreAnimal(String nombreAnimal) { this.nombreAnimal = nombreAnimal; }
  public String getNombreApellidos() { return nombreApellidos; }
  public void setNombreApellidos(String nombreApellidos) { this.nombreApellidos = nombreApellidos; }
  public String getDni() { return dni; }
  public void setDni(String dni) { this.dni = dni; }
  public String getFechaNacimiento() { return fechaNacimiento; }
  public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
  public String getDomicilio() { return domicilio; }
  public void setDomicilio(String domicilio) { this.domicilio = domicilio; }
  public String getCodigoPostal() { return codigoPostal; }
  public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }
  public String getMunicipio() { return municipio; }
  public void setMunicipio(String municipio) { this.municipio = municipio; }
  public String getProvincia() { return provincia; }
  public void setProvincia(String provincia) { this.provincia = provincia; }
  public String getTelefonoFijo() { return telefonoFijo; }
  public void setTelefonoFijo(String telefonoFijo) { this.telefonoFijo = telefonoFijo; }
  public String getTelefonoMovil() { return telefonoMovil; }
  public void setTelefonoMovil(String telefonoMovil) { this.telefonoMovil = telefonoMovil; }
  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }
}
