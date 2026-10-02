/**
 * Representa una parada de autobús. Existe de forma independiente de las
 * rutas: primero se registra y luego las rutas la incorporan a su recorrido.
 *
 * @author Samantha Casco
 * @version 1.0
 */
public class Parada {

  /** Código de la parada, por ejemplo P-01. */
  private String codigo;

  /** Nombre de la parada. */
  private String nombre;

  /**
   * Construye una parada con el código y el nombre indicados.
   *
   * @param pCodigo código de la parada.
   * @param pNombre nombre de la parada.
   */
  public Parada(String pCodigo, String pNombre) {
    codigo = pCodigo;
    nombre = pNombre;
  }

  /**
   * Consulta el código de la parada.
   *
   * @return el código de la parada.
   */
  public String getCodigo() {
    return codigo;
  }

  /**
   * Consulta el nombre de la parada.
   *
   * @return el nombre de la parada.
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Retorna una representación textual de la parada con su código y nombre.
   *
   * @return cadena con los datos de la parada.
   */
  public String toString() {
    return "Parada " + codigo + " | " + nombre;
  }
}
