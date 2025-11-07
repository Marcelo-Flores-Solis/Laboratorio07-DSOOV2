public class Empleado extends Persona {

    private String idEmpleado;
    private String cargo;

    public Empleado(String nombre, String apellido, String dni, String idEmpleado, String cargo) {
        super(nombre, apellido, dni);
        validarDatos(idEmpleado, cargo);
        this.idEmpleado = idEmpleado;
        this.cargo = cargo;
    }
    
    private void validarDatos(String idEmpleado, String cargo) {
        if (!Validador.validarNoVacio(idEmpleado)) {
            Validador.datosInvalidos();
        }
        if (!Validador.validarNoVacio(cargo)) {
            Validador.datosInvalidos();
        }
    }

    public void procesarTransaccion(Transaccion transaccion) {
        if (!Validador.validarNoNulo(transaccion)) {
            Validador.datosInvalidos();
        }
        transaccion.procesar();
    }

    public void registrarCliente(Cliente cliente) {
        if (!Validador.validarNoNulo(cliente)) {
            Validador.datosInvalidos();
        }
        cliente.registrarCliente();
    }
    
    // Getters
    public String getIdEmpleado() { return idEmpleado; }
    public String getCargo() { return cargo; }
    
    // Setters
    public void setIdEmpleado(String idEmpleado) { 
        if (!Validador.validarNoVacio(idEmpleado)) {
            Validador.datosInvalidos();
        }
        this.idEmpleado = idEmpleado; 
    }
    
    public void setCargo(String cargo) { 
        if (!Validador.validarNoVacio(cargo)) {
            Validador.datosInvalidos();
        }
        this.cargo = cargo; 
    }
}
