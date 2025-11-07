import java.util.List;
import java.util.ArrayList;

public class Cliente extends Persona {

    private String idCliente;
    private String correo;
    private String estado;
    private List<Cuenta> cuentas;

    public Cliente(String nombre, String apellido, String dni, String idCliente, String correo, String estado) {
        super(nombre, apellido, dni);
        validarDatos(idCliente, correo, estado);
        this.idCliente = idCliente;
        this.correo = correo;
        this.estado = estado;
        this.cuentas = new ArrayList<>();
    }
    
    private void validarDatos(String idCliente, String correo, String estado) {
        if (!Validador.validarNoVacio(idCliente)) {
            Validador.datosInvalidos();
        }
        if (!Validador.validarNoVacio(correo)) {
            Validador.datosInvalidos();
        }
        if (!Validador.validarNoVacio(estado)) {
            Validador.datosInvalidos();
        }
    }

    public void registrarCliente() {
        System.out.println("Cliente registrado exitosamente");
    }

    public void actualizarDatos(String nuevoCorreo, String nuevoEstado) {
        setCorreo(nuevoCorreo);
        setEstado(nuevoEstado);
    }

    public List<Cuenta> consultarCuentas() {
        return this.cuentas;
    }
    
    public void agregarCuenta(Cuenta cuenta) {
        if (!Validador.validarNoNulo(cuenta)) {
            Validador.datosInvalidos();
        }
        this.cuentas.add(cuenta);
    }
    
    // Getters
    public String getIdCliente() { return idCliente; }
    public String getCorreo() { return correo; }
    public String getEstado() { return estado; }
    public List<Cuenta> getCuentas() { return cuentas; }
    
    // Setters
    public void setIdCliente(String idCliente) { 
        if (!Validador.validarNoVacio(idCliente)) {
            Validador.datosInvalidos();
        }
        this.idCliente = idCliente; 
    }
    
    public void setCorreo(String correo) { 
        if (!Validador.validarNoVacio(correo)) {
            Validador.datosInvalidos();
        }
        this.correo = correo; 
    }
    
    public void setEstado(String estado) { 
        if (!Validador.validarNoVacio(estado)) {
            Validador.datosInvalidos();
        }
        this.estado = estado; 
    }
}
