public class Persona {

    protected String dni;
    protected String nombre;
    protected String apellido;

    public Persona(String nombre, String apellido, String dni) {
        validarDatos(nombre, apellido, dni);
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
    
    private void validarDatos(String nombre, String apellido, String dni) {
        if (!Validador.validarNoVacio(nombre)) {
            Validador.datosInvalidos();
        }
        if (!Validador.validarNoVacio(apellido)) {
            Validador.datosInvalidos();
        }
        if (!Validador.validarNoVacio(dni)) {
            Validador.datosInvalidos();
        }
    }

    public String mostrarDatos() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
    
    // Getters y Setters
    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    
    public void setDni(String dni) { 
        if (!Validador.validarNoVacio(dni)) {
            Validador.datosInvalidos();
        }
        this.dni = dni; 
    }
    
    public void setNombre(String nombre) { 
        if (!Validador.validarNoVacio(nombre)) {
            Validador.datosInvalidos();
        }
        this.nombre = nombre; 
    }
    
    public void setApellido(String apellido) { 
        if (!Validador.validarNoVacio(apellido)) {
            Validador.datosInvalidos();
        }
        this.apellido = apellido; 
    }
}
