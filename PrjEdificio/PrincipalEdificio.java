public class PrincipalEdificio {
  public static void main(String[] args) {
    // ====== Edificio 1 ======
    Edificio e1 = new Edificio("Computación", "Edificio Administrativo y Académico");
    e1.registrarPiso(500.0, 200, "Aulas");
    e1.registrarPiso(350.0, "Laboratorios");
    e1.registrarPiso(275.5, 120, "Administrativo");
    System.out.println("==== EDIFICIO 1 ====");
    System.out.println(e1.toString());
    System.out.println("Capacidad total e1: " + e1.consultarCapacidadTotalDelEdificio());
    System.out.println("Área piso 2 e1: " + e1.consultarAreaDeUnPiso(2));
    System.out.println("Uso piso 1 e1: " + e1.consultarUsoDeUnPiso(1));
    System.out.println();

    // ====== Edificio 2 ======
    Edificio e2 = new Edificio("Biblioteca", "Servicios y lectura");
    e2.registrarPiso(600.0, "Salas de lectura"); // capacidad por omisión = 100
    e2.registrarPiso(400.0, 90, "Archivo");
    System.out.println("==== EDIFICIO 2 ====");
    System.out.println(e2.toString());
    System.out.println("Capacidad total e2: " + e2.consultarCapacidadTotalDelEdificio());
    System.out.println("Área piso 1 e2: " + e2.consultarAreaDeUnPiso(1));
    System.out.println("Uso piso 2 e2: " + e2.consultarUsoDeUnPiso(2));
    System.out.println();
    System.out.println("Edificios creados: " + Edificio.getCantidadEdificios());
  }
}