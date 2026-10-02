/**
 * Representa un horario de salida de una ruta. Solo la clase Ruta lo construye
 * y lo conoce: no tiene sentido fuera de la ruta a la que pertenece.
 *
 * @author Samantha Casco
 * @version 1.0
 */
public class HorarioSalida {

  /** Hora de salida, de 0 a 23. */
  private int hora;

  /** Minuto de salida, de 0 a 59. */
  private int minuto;

  /**
   * Construye un horario de salida. La ruta es quien valida los rangos
   * antes de crearlo.
   *
   * @param pHora hora de salida.
   * @param pMinuto minuto de salida.
   */
  public HorarioSalida(int pHora, int pMinuto) {
    hora = pHora;
    minuto = pMinuto;
  }

  /**
   * Retorna el horario con formato HH:MM, siempre con dos dígitos para la
   * hora y dos para el minuto (por ejemplo 06:05).
   *
   * @return el horario como cadena en formato HH:MM.
   */
  public String toString() {
    return String.format("%02d:%02d", hora, minuto);
  }
}
