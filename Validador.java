public class Validador {

    public static boolean validarNoVacio(String valor) {
        return valor != null && !valor.trim().isEmpty();
    }

    public static boolean validarPositivo(double valor) {
        return valor > 0;
    }

    public static boolean validarNoNulo(Object objeto) {
        return objeto != null;
    }

    public static boolean validarNombre(String nombre) {
        if (!validarNoVacio(nombre)) {
            return false;
        }
        return nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{2,50}$");
    }

    public static boolean validarApellido(String apellido) {
        if (!validarNoVacio(apellido)) {
            return false;
        }
        return apellido.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{2,50}$");
    }

    public static boolean validarDNI(String dni) {
        if (!validarNoVacio(dni)) {
            return false;
        }
        return dni.matches("^\\d{8}$");
    }

    public static boolean validarCorreo(String correo) {
        if (!validarNoVacio(correo)) {
            return false;
        }
        return correo.matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }

    public static boolean validarEstado(String estado) {
        if (!validarNoVacio(estado)) {
            return false;
        }
        return estado.equalsIgnoreCase("activo") || estado.equalsIgnoreCase("inactivo");
    }

    public static boolean validarTipoCuenta(String tipo) {
        if (!validarNoVacio(tipo)) {
            return false;
        }
        return tipo.equalsIgnoreCase("ahorros") || tipo.equalsIgnoreCase("corriente");
    }

    public static void datosInvalidos() {
        System.out.println("DATO INVALIDO");
        System.exit(0);
    }

    public static void mostrarError(String mensaje) {
        System.out.println("Error: " + mensaje);
    }
}
