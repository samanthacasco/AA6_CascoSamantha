/**
 * Representa una caseta de peaje que cobra a los vehículos que pasan por ella
 * según su tipo. Cada caseta recibe un número consecutivo único y acumula el
 * total cobrado. Los montos de cobro son constantes de la clase y la política
 * de tarifas es un detalle interno de la caseta.
 *
 * @author Samantha Casco
 * @version 1.0
 */
public class CasetaPeaje {

  /** Tipo de vehículo: particular. */
  public static final String TIPO_PARTICULAR = "particular";

  /** Tipo de vehículo: carga liviana. */
  public static final String TIPO_CARGA_LIVIANA = "carga liviana";

  /** Tipo de vehículo: carga. */
  public static final String TIPO_CARGA = "carga";

  /** Tipo de vehículo: moto. */
  public static final String TIPO_MOTO = "moto";

  /** Monto que paga un vehículo particular. */
  public static final double MONTO_PARTICULAR = 100;

  /** Monto que paga un vehículo de carga liviana. */
  public static final double MONTO_CARGA_LIVIANA = 200;

  /** Monto que paga un vehículo de carga. */
  public static final double MONTO_CARGA = 500;

  /** Monto que paga una moto. */
  public static final double MONTO_MOTO = 75;

  /** Monto que se cobra cuando el tipo de vehículo no se reconoce. */
  public static final double MONTO_TIPO_DESCONOCIDO = 0;

  /** Número consecutivo único de la caseta. */
  private int numeroCaseta;

  /** Nombre de la autopista donde está la caseta. */
  private String nombreAutopista;

  /** Total cobrado por la caseta hasta el momento, en colones. */
  private double totalCobrado;

  /** Cantidad de casetas creadas; sirve para numerarlas (atributo de clase). */
  private static int cantidadCasetas;

  /**
   * Construye una caseta con el nombre de la autopista indicado. Incrementa
   * la cantidad de casetas y le asigna su número consecutivo.
   *
   * @param pNombreAutopista nombre de la autopista donde está la caseta.
   */
  public CasetaPeaje(String pNombreAutopista) {
    cantidadCasetas++;
    numeroCaseta = cantidadCasetas;
    nombreAutopista = pNombreAutopista;
  }

  /**
   * Cobra el peaje al vehículo recibido según su tipo y lo acumula en el total
   * cobrado. Si el vehículo es null no cobra nada. El vehículo no se modifica.
   *
   * @param obj vehículo al que se le cobra el peaje.
   */
  public void cobrarPeaje(Vehiculo obj) {
    if (obj == null) {
      return;
    }
    totalCobrado += obtenerMontoPorTipo(obj.getTipo());
  }

  /**
   * Obtiene el monto del peaje para un tipo de vehículo. Es un detalle interno
   * de la tarifa: ningún otro objeto necesita conocerlo.
   *
   * @param pTipo tipo del vehículo.
   * @return el monto a cobrar, o MONTO_TIPO_DESCONOCIDO si el tipo no se reconoce.
   */
  private double obtenerMontoPorTipo(String pTipo) {
    switch (pTipo.toLowerCase()) {
      case TIPO_PARTICULAR:
        return MONTO_PARTICULAR;
      case TIPO_CARGA_LIVIANA:
        return MONTO_CARGA_LIVIANA;
      case TIPO_CARGA:
        return MONTO_CARGA;
      case TIPO_MOTO:
        return MONTO_MOTO;
      default:
        return MONTO_TIPO_DESCONOCIDO;
    }
  }

  /**
   * Consulta el total cobrado por la caseta.
   *
   * @return el total cobrado, en colones.
   */
  public double getTotalCobrado() {
    return totalCobrado;
  }

  /**
   * Consulta la cantidad total de casetas creadas.
   * Al ser un método de clase, se invoca directamente sobre CasetaPeaje.
   *
   * @return la cantidad de casetas creadas hasta el momento.
   */
  public static int getCantidadDeCasetasPeaje() {
    return cantidadCasetas;
  }

  /**
   * Retorna una representación textual de la caseta con su número, autopista
   * y total cobrado.
   *
   * @return cadena con los datos de la caseta.
   */
  public String toString() {
    return "Caseta de Peaje número: " + numeroCaseta + "\n"
        + "Autopista= " + nombreAutopista + "\n"
        + "Total Cobrado= " + totalCobrado + "\n";
  }
}
