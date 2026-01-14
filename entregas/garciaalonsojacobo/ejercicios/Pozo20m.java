class Pozo20m {
  public static void main(String[] args) {
    final int PROFUNDIDAD_POZO = 20;
    final String BORDESPOZO = "[__]              [__]";
    final String SUELOPOZO = "  [][][][][][][][][] ";
    final String PAREDPOZO = "  []:. :. :. :. :.[]";
    final String SEPARADOR = " _ __ ";
    System.out.println(BORDESPOZO);
    for (int profundidad = 0; profundidad <= PROFUNDIDAD_POZO; profundidad = profundidad + 1) {
      System.out.println(PAREDPOZO + SEPARADOR + profundidad);
    }

    System.out.println(SUELOPOZO);
  }
}
