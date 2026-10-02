import java.util.ArrayList;

public class Edificio {
  private String codigo;
  private String nombre;
  private String descripcion;
  public static final String PREFIJO_CODIGO = "Edf-";
  public static final int CAPACIDAD_POR_OMISION = 100;
  private static int cantidadEdificios;
  private ArrayList<Piso> misPisos;

  public Edificio(String pNombre, String pDescripcion) {
    cantidadEdificios++;
    codigo = PREFIJO_CODIGO + cantidadEdificios;
    nombre = pNombre;
    descripcion = pDescripcion;
    misPisos = new ArrayList<>();
  }

  /** Registra un piso con área, capacidad y uso. El número de piso lo asigna el edificio. */
  public void registrarPiso(double pArea, int pCapacidad, String pUso) {
    int numeroPiso = misPisos.size() + 1;
    misPisos.add(new Piso(numeroPiso, pArea, pCapacidad, pUso));
  }

  /** Registra un piso con área y uso; capacidad por omisión = CAPACIDAD_POR_OMISION. */
  public void registrarPiso(double pArea, String pUso) {
    registrarPiso(pArea, CAPACIDAD_POR_OMISION, pUso);
  }

  public int consultarCapacidadTotalDelEdificio() {
    int total = 0;
    for (Piso p : misPisos) total += p.getCapacidad();
    return total;
  }

  public double consultarAreaDeUnPiso(int pNumeroPiso) {
    Piso p = buscarPiso(pNumeroPiso);
    return (p == null) ? -1.0 : p.getArea();
  }

  public String consultarUsoDeUnPiso(int pNumeroPiso) {
    Piso p = buscarPiso(pNumeroPiso);
    return (p == null) ? "(desconocido)" : p.getUso();
  }

  private Piso buscarPiso(int numero) {
    if (numero <= 0) return null;
    for (Piso p : misPisos) {
      if (p.getNumeroPiso() == numero) return p;
    }
    return null;
  }

  public static int getCantidadEdificios() {
    return cantidadEdificios;
  }

  public String toString() {
    String msg = "Edificio\n";
    msg += "  Codigo: " + codigo + "\n";
    msg += "  Nombre: " + nombre + "\n";
    msg += "  Descripcion: " + descripcion + "\n";
    msg += "  Pisos: " + misPisos.size() + "\n";
    msg += "  Detalle de pisos:\n";
    for (Piso p : misPisos) {
      msg += "   - " + p.toString() + "\n";
    }
    msg += "  Capacidad total: " + consultarCapacidadTotalDelEdificio();
    return msg;
  }
}
