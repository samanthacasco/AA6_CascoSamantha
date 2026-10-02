/**
 * Representa un vehículo que puede pasar por una caseta de peaje.
 *
 * @author Samantha Casco
 * @version 1.0
 */
public class Vehiculo {

  /** Placa del vehículo. */
  private String placa;

  /** Tipo del vehículo (particular, carga liviana, carga o moto). */
  private String tipo;

  /** Marca del vehículo. */
  private String marca;

  /** Modelo del vehículo. */
  private String modelo;

  /** Año de fabricación del vehículo. */
  private int annio;

  /**
   * Construye un vehículo con los datos indicados.
   *
   * @param pPlaca placa del vehículo.
   * @param pTipo tipo del vehículo.
   * @param pMarca marca del vehículo.
   * @param pModelo modelo del vehículo.
   * @param pAnnio año de fabricación del vehículo.
   */
  public Vehiculo(String pPlaca, String pTipo, String pMarca, String pModelo, int pAnnio) {
    placa = pPlaca;
    tipo = pTipo;
    marca = pMarca;
    modelo = pModelo;
    annio = pAnnio;
  }

  /**
   * Consulta el tipo del vehículo.
   *
   * @return el tipo del vehículo.
   */
  public String getTipo() {
    return tipo;
  }

  /**
   * Retorna una representación textual del vehículo con su placa, tipo,
   * marca, modelo y año.
   *
   * @return cadena con los datos del vehículo.
   */
  public String toString() {
    return "Placa= " + placa + "\n"
        + "Tipo= " + tipo + "\n"
        + "Marca= " + marca + "\n"
        + "Modelo= " + modelo + "\n"
        + "Año= " + annio;
  }
}
