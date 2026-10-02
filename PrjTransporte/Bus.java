/**
 * Representa un bus que cubre una ruta y cobra el pasaje a las personas
 * pasajeras. Cada bus recibe un código consecutivo único y acumula el total
 * recaudado y la cantidad de personas atendidas, sin importar cuántas veces
 * cambie de ruta. La política de descuentos es un detalle interno del bus.
 *
 * @author Samantha Casco
 * @version 1.0
 */
public class Bus {

  /** Prefijo común de todos los códigos de bus. */
  public static final String PREFIJO_CODIGO = "BUS-";

  /** Texto que se muestra cuando el bus no tiene ruta asignada. */
  public static final String TEXTO_SIN_RUTA = "(sin ruta asignada)";

  /** Descuento de una persona regular: ninguno. */
  public static final double DESCUENTO_REGULAR = 0.0;

  /** Descuento de una persona estudiante: 50 %. */
  public static final double DESCUENTO_ESTUDIANTE = 0.5;

  /** Descuento de una persona ciudadana de oro: 100 %. */
  public static final double DESCUENTO_CIUDADANO_ORO = 1.0;

  /** Cantidad de buses registrados; sirve para el código (atributo de clase). */
  private static int cantidadBuses;

  /** Código único del bus, formado por el prefijo y un consecutivo. */
  private String codigo;

  /** Placa del bus. */
  private String placa;

  /** Capacidad de personas pasajeras del bus. */
  private int capacidad;

  /** Total recaudado por el bus desde su registro, en colones. */
  private double totalRecaudado;

  /** Cantidad de personas pasajeras atendidas desde el registro del bus. */
  private int cantidadPersonasAtendidas;

  /** Ruta que cubre el bus; es null mientras no tenga una asignada. */
  private Ruta miRuta;

  /**
   * Construye un bus sin ruta asignada. Incrementa la cantidad de buses y
   * genera su código consecutivo.
   *
   * @param pPlaca placa del bus.
   * @param pCapacidad capacidad de personas pasajeras.
   */
  public Bus(String pPlaca, int pCapacidad) {
    cantidadBuses++;
    codigo = PREFIJO_CODIGO + cantidadBuses;
    placa = pPlaca;
    capacidad = pCapacidad;
  }

  /**
   * Consulta el código del bus.
   *
   * @return el código del bus.
   */
  public String getCodigo() {
    return codigo;
  }

  /**
   * Consulta la placa del bus.
   *
   * @return la placa del bus.
   */
  public String getPlaca() {
    return placa;
  }

  /**
   * Consulta la capacidad del bus.
   *
   * @return la capacidad de personas pasajeras.
   */
  public int getCapacidad() {
    return capacidad;
  }

  /**
   * Consulta el total recaudado por el bus.
   *
   * @return el total recaudado, en colones.
   */
  public double getTotalRecaudado() {
    return totalRecaudado;
  }

  /**
   * Consulta la cantidad de personas pasajeras atendidas por el bus.
   *
   * @return la cantidad de personas atendidas.
   */
  public int getCantidadPersonasAtendidas() {
    return cantidadPersonasAtendidas;
  }

  /**
   * Consulta la cantidad total de buses registrados.
   * Al ser un método de clase, se invoca directamente sobre Bus.
   *
   * @return la cantidad de buses registrados hasta el momento.
   */
  public static int getCantidadBuses() {
    return cantidadBuses;
  }

  /**
   * Asigna la ruta que cubre el bus. Si ya tenía una, la reemplaza.
   *
   * @param pRuta ruta que pasa a cubrir el bus.
   */
  public void asignarRuta(Ruta pRuta) {
    miRuta = pRuta;
  }

  /**
   * Consulta el nombre de la ruta asignada al bus.
   *
   * @return el nombre de la ruta, o TEXTO_SIN_RUTA si no tiene ruta asignada.
   */
  public String consultarNombreRuta() {
    return (miRuta == null) ? TEXTO_SIN_RUTA : miRuta.getNombre();
  }

  /**
   * Cobra el pasaje a una persona según la tarifa de la ruta y la condición de
   * la persona. Si el bus no tiene ruta asignada, o la persona es null, no
   * cobra ni contabiliza a la persona como atendida.
   *
   * @param pPersona persona pasajera que aborda el bus.
   */
  public void cobrarPasaje(Persona pPersona) {
    if (miRuta == null || pPersona == null) {
      return;
    }
    double descuento = obtenerDescuento(pPersona.getCondicion());
    totalRecaudado += miRuta.getTarifa() * (1 - descuento);
    cantidadPersonasAtendidas++;
  }

  /**
   * Obtiene el descuento que corresponde a una condición. Es un detalle
   * interno del bus: la política de descuentos no la conoce nadie más.
   *
   * @param pCondicion condición de la persona pasajera.
   * @return el descuento como fracción de la tarifa, de 0.0 a 1.0.
   */
  private double obtenerDescuento(String pCondicion) {
    switch (pCondicion) {
      case Persona.CONDICION_ESTUDIANTE:
        return DESCUENTO_ESTUDIANTE;
      case Persona.CONDICION_CIUDADANO_ORO:
        return DESCUENTO_CIUDADANO_ORO;
      default:
        return DESCUENTO_REGULAR;
    }
  }

  /**
   * Retorna una representación textual del bus con su código, placa,
   * capacidad, ruta asignada, personas atendidas y total recaudado.
   *
   * @return cadena con el estado del bus.
   */
  public String toString() {
    String msg = "Bus " + codigo + "\n";
    msg += "  Placa: " + placa + "\n";
    msg += "  Capacidad: " + capacidad + "\n";
    msg += "  Ruta asignada: " + consultarNombreRuta() + "\n";
    msg += "  Personas atendidas: " + cantidadPersonasAtendidas + "\n";
    msg += String.format("  Total recaudado: %.2f colones%n", totalRecaudado);
    return msg;
  }
}
