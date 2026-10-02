/**
 * Programa principal del sistema de transporte público: registra paradas,
 * rutas, buses y personas pasajeras, cobra pasajes y muestra el estado final.
 *
 * @author Samantha Casco
 * @version 1.0
 */
public class PrincipalTransporte {
  public static void main(String[] args) {
    Parada p1, p2, p3, p4;
    Ruta r1, r2;
    Bus b1, b2, b3;
    Persona pa1, pa2, pa3, pa4;

    p1 = new Parada("P-01", "Terminal Central");
    p2 = new Parada("P-02", "Plaza del Sol");
    p3 = new Parada("P-03", "Universidad");
    p4 = new Parada("P-04", "Mercado Municipal");

    r1 = new Ruta("R-100", "Centro - Universidad", 450);
    r2 = new Ruta("R-200", "Centro - Mercado", 380);

    b1 = new Bus("SJB-1234", 60);
    b2 = new Bus("SJB-5678", 45);
    b3 = new Bus("SJB-9012", 50);

    pa1 = new Persona("María Solano", "estudiante");
    pa2 = new Persona("Jorge Vargas", "ciudadano de oro");
    pa3 = new Persona("Sofía Mora");
    pa4 = new Persona("Andrés Quesada", "estudiante");
    
    System.out.println("Ejecucion por parte de Samantha Casco");
    System.out.println("==== ESTADO INICIAL DE LAS PARADAS ====");
    System.out.println(p1.toString());
    System.out.println(p2.toString());
    System.out.println(p3.toString());
    System.out.println(p4.toString());
    System.out.println();

    System.out.println("==== ESTADO INICIAL DE LAS PERSONAS ====");
    System.out.println(pa1.toString());
    System.out.println(pa2.toString());
    System.out.println(pa3.toString());
    System.out.println(pa4.toString());
    System.out.println();

    // Recorridos: la parada P-01 forma parte de ambas rutas
    r1.agregarParada(p1);
    r1.agregarParada(p2);
    r1.agregarParada(p3);
    r1.agregarParada(p2); // Repetida: debe ignorarse
    r2.agregarParada(p1);
    r2.agregarParada(p4);

    // Horarios de salida
    r1.registrarSalida(5, 30);
    r1.registrarSalida(6);
    r1.registrarSalida(6, 45);
    r1.registrarSalida(25, 10); // Inválido: no debe registrarse
    r2.registrarSalida(7);
    r2.registrarSalida(7, 5);

    System.out.println("==== RECORRIDO Y HORARIOS DE CADA RUTA ====");
    System.out.println(r1.getNombre() + ": " + r1.consultarNombresParadas());
    System.out.println("Salidas: " + r1.consultarHorariosSalida());
    System.out.println(r2.getNombre() + ": " + r2.consultarNombresParadas());
    System.out.println("Salidas: " + r2.consultarHorariosSalida());
    System.out.println();

    System.out.println("==== RUTA DE CADA BUS (ANTES DE ASIGNAR) ====");
    System.out.println(b1.getCodigo() + ": " + b1.consultarNombreRuta());
    System.out.println(b2.getCodigo() + ": " + b2.consultarNombreRuta());
    System.out.println(b3.getCodigo() + ": " + b3.consultarNombreRuta());
    System.out.println();

    b1.asignarRuta(r1);
    b2.asignarRuta(r2);

    // Cobro de pasajes
    b1.cobrarPasaje(pa1);
    b1.cobrarPasaje(pa2);
    b1.cobrarPasaje(pa3);
    b2.cobrarPasaje(pa3);
    b2.cobrarPasaje(pa4);
    b3.cobrarPasaje(pa1); // Sin ruta asignada: no debe cobrar
    b3.asignarRuta(r1);
    b3.cobrarPasaje(pa4);
    b2.asignarRuta(r1); // Cambio de ruta: lo recaudado se conserva

    System.out.println("==== RUTA DE CADA BUS (DESPUÉS DE ASIGNAR) ====");
    System.out.println(b1.getCodigo() + ": " + b1.consultarNombreRuta());
    System.out.println(b2.getCodigo() + ": " + b2.consultarNombreRuta());
    System.out.println(b3.getCodigo() + ": " + b3.consultarNombreRuta());
    System.out.println();

    System.out.println("==== ESTADO FINAL DE LAS RUTAS ====");
    System.out.println(r1.toString());
    System.out.println(r2.toString());
    System.out.println();

    System.out.println("==== ESTADO FINAL DE LOS BUSES ====");
    System.out.println(b1.toString());
    System.out.println(b2.toString());
    System.out.println(b3.toString());
    System.out.println();

    System.out.println("Buses registrados: " + Bus.getCantidadBuses());
  }
}
