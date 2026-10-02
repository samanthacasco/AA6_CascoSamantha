/**
 * Representa una persona pasajera con su condición: regular, estudiante o
 * ciudadano de oro.
 *
 * @author Samantha Casco
 * @version 1.0
 */
public class Persona {

  /** Condición regular: paga la tarifa completa. */
  public static final String CONDICION_REGULAR = "regular";

  /** Condición estudiante: recibe descuento sobre la tarifa. */
  public static final String CONDICION_ESTUDIANTE = "estudiante";

  /** Condición ciudadano de oro: no paga el pasaje. */
  public static final String CONDICION_CIUDADANO_ORO = "ciudadano de oro";

  /** Nombre de la persona. */
  private String nombre;

  /** Condición de la persona. */
  private String condicion;

  /**
   * Construye una persona con su nombre y condición. Una condición
   * desconocida o null se trata como regular.
   *
   * @param pNombre nombre de la persona.
   * @param pCondicion condición de la persona.
   */
  public Persona(String pNombre, String pCondicion) {
    nombre = pNombre;
    condicion = normalizarCondicion(pCondicion);
  }

  /**
   * Construye una persona indicando solo su nombre; su condición es regular.
   *
   * @param pNombre nombre de la persona.
   */
  public Persona(String pNombre) {
    this(pNombre, CONDICION_REGULAR);
  }

  /**
   * Consulta el nombre de la persona.
   *
   * @return el nombre de la persona.
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Consulta la condición de la persona.
   *
   * @return la condición de la persona.
   */
  public String getCondicion() {
    return condicion;
  }

  /**
   * Normaliza la condición recibida. Es un detalle interno: una condición
   * desconocida o null se trata como regular.
   *
   * @param pCondicion condición recibida.
   * @return la condición normalizada.
   */
  private String normalizarCondicion(String pCondicion) {
    if (pCondicion == null) {
      return CONDICION_REGULAR;
    }
    String c = pCondicion.trim().toLowerCase();
    if (c.equals(CONDICION_ESTUDIANTE) || c.equals(CONDICION_CIUDADANO_ORO)) {
      return c;
    }
    return CONDICION_REGULAR;
  }

  /**
   * Retorna una representación textual de la persona con su nombre y condición.
   *
   * @return cadena con los datos de la persona.
   */
  public String toString() {
    return "Persona: " + nombre + " | Condición: " + condicion;
  }
}
