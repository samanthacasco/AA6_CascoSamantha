/**
 * Piso de un edificio. Su número lo asigna el Edificio que lo contiene.
 */
public class Piso {
  private static int cantidadPisos = 0;
  private int numeroPiso;
  private double area;
  private int capacidad;
  private String uso;

  public Piso(int pNumeroPiso, double pArea, int pCapacidad, String pUso) {
    cantidadPisos++;
    numeroPiso = pNumeroPiso;
    area = pArea;
    capacidad = pCapacidad;
    uso = pUso;
  }

  public int getNumeroPiso() {
    return numeroPiso;
  }

  public double getArea() {
    return area;
  }

  public int getCapacidad() {
    return capacidad;
  }

  public String getUso() {
    return uso;
  }

  public static int getCantidadPisos() {
    return cantidadPisos;
  }

  public String toString() {
    String msg = "Piso #" + numeroPiso + " | ";
    msg += "Área: " + area + " m2 | ";
    msg += "Capacidad: " + capacidad + " | ";
    msg += "Uso: " + uso;
    return msg;
  }
}
