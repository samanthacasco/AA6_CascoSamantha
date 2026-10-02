import java.util.ArrayList;

/**
 * Representa una ruta de autobús. Agrega las paradas de su recorrido (que
 * existen por sí solas) y compone sus horarios de salida: estos solo se
 * registran y consultan a través de la ruta y desaparecen con ella.
 *
 * @author Samantha Casco
 * @version 1.0
 */
public class Ruta {

  /** Hora mínima permitida para un horario de salida. */
  public static final int HORA_MINIMA = 0;

  /** Hora máxima permitida para un horario de salida. */
  public static final int HORA_MAXIMA = 23;

  /** Minuto mínimo permitido para un horario de salida. */
  public static final int MINUTO_MINIMO = 0;

  /** Minuto máximo permitido para un horario de salida. */
  public static final int MINUTO_MAXIMO = 59;

  /** Minuto que se usa cuando un horario se registra solo con la hora. */
  public static final int MINUTO_POR_OMISION = 0;

  /** Separador que se usa al listar paradas y horarios. */
  public static final String SEPARADOR = ", ";

  /** Código de la ruta, por ejemplo R-100. */
  private String codigo;

  /** Nombre de la ruta. */
  private String nombre;

  /** Tarifa del pasaje regular, en colones. */
  private double tarifa;

  /** Paradas del recorrido, en el orden en que se agregaron. */
  private ArrayList<Parada> misParadas;

  /** Horarios de salida de la ruta, en el orden en que se registraron. */
  private ArrayList<HorarioSalida> misHorarios;

  /**
   * Construye una ruta sin paradas ni horarios de salida.
   *
   * @param pCodigo código de la ruta.
   * @param pNombre nombre de la ruta.
   * @param pTarifa tarifa del pasaje regular, en colones.
   */
  public Ruta(String pCodigo, String pNombre, double pTarifa) {
    codigo = pCodigo;
    nombre = pNombre;
    tarifa = pTarifa;
    misParadas = new ArrayList<>();
    misHorarios = new ArrayList<>();
  }

  /**
   * Consulta el código de la ruta.
   *
   * @return el código de la ruta.
   */
  public String getCodigo() {
    return codigo;
  }

  /**
   * Consulta el nombre de la ruta.
   *
   * @return el nombre de la ruta.
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Consulta la tarifa del pasaje regular de la ruta.
   *
   * @return la tarifa, en colones.
   */
  public double getTarifa() {
    return tarifa;
  }

  /**
   * Agrega una parada al final del recorrido. Ignora la solicitud si la
   * parada es null o si ya forma parte del recorrido.
   *
   * @param pParada parada que se agrega al recorrido.
   */
  public void agregarParada(Parada pParada) {
    if (pParada != null && !existeParada(pParada)) {
      misParadas.add(pParada);
    }
  }

  /**
   * Registra un horario de salida. Si la hora o el minuto están fuera de
   * rango, el horario no se registra.
   *
   * @param pHora hora de salida, de 0 a 23.
   * @param pMinuto minuto de salida, de 0 a 59.
   */
  public void registrarSalida(int pHora, int pMinuto) {
    if (esHorarioValido(pHora, pMinuto)) {
      misHorarios.add(new HorarioSalida(pHora, pMinuto));
    }
  }

  /**
   * Registra un horario de salida en punto; el minuto es MINUTO_POR_OMISION.
   *
   * @param pHora hora de salida, de 0 a 23.
   */
  public void registrarSalida(int pHora) {
    registrarSalida(pHora, MINUTO_POR_OMISION);
  }

  /**
   * Consulta los nombres de las paradas del recorrido, en orden.
   *
   * @return los nombres de las paradas separados por coma.
   */
  public String consultarNombresParadas() {
    String msg = "";
    for (int i = 0; i < misParadas.size(); i++) {
      if (i > 0) {
        msg += SEPARADOR;
      }
      msg += misParadas.get(i).getNombre();
    }
    return msg;
  }

  /**
   * Consulta los horarios de salida con formato HH:MM.
   *
   * @return los horarios separados por coma.
   */
  public String consultarHorariosSalida() {
    String msg = "";
    for (int i = 0; i < misHorarios.size(); i++) {
      if (i > 0) {
        msg += SEPARADOR;
      }
      msg += misHorarios.get(i).toString();
    }
    return msg;
  }

  /**
   * Indica si una parada ya forma parte del recorrido, comparando por código.
   *
   * @param pParada parada que se busca.
   * @return true si la parada ya está en el recorrido; false en caso contrario.
   */
  private boolean existeParada(Parada pParada) {
    for (Parada p : misParadas) {
      if (p.getCodigo().equals(pParada.getCodigo())) {
        return true;
      }
    }
    return false;
  }

  /**
   * Indica si la hora y el minuto están dentro de los rangos permitidos.
   *
   * @param pHora hora que se valida.
   * @param pMinuto minuto que se valida.
   * @return true si ambos están en rango; false en caso contrario.
   */
  private boolean esHorarioValido(int pHora, int pMinuto) {
    return pHora >= HORA_MINIMA && pHora <= HORA_MAXIMA
        && pMinuto >= MINUTO_MINIMO && pMinuto <= MINUTO_MAXIMO;
  }

  /**
   * Retorna una representación textual de la ruta con su código, nombre,
   * tarifa, paradas y horarios de salida.
   *
   * @return cadena con el estado de la ruta.
   */
  public String toString() {
    String msg = "Ruta " + codigo + "\n";
    msg += "  Nombre: " + nombre + "\n";
    msg += String.format("  Tarifa: %.2f colones%n", tarifa);
    msg += "  Paradas: " + consultarNombresParadas() + "\n";
    msg += "  Cantidad de horarios de salida: " + misHorarios.size() + "\n";
    for (HorarioSalida h : misHorarios) {
      msg += "   - " + h.toString() + "\n";
    }
    return msg;
  }
}
