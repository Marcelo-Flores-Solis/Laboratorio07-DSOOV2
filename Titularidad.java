import java.time.LocalDate;

public class Titularidad {

    private String tipo;
    private LocalDate fecha;
    private Cuenta cuenta;
    private Cliente titular;

    public Titularidad(String tipo) {
        validarTipo(tipo);
        this.tipo = tipo;
        this.fecha = LocalDate.now();
    }

    public Titularidad(String tipo, Cuenta cuenta, Cliente titular) {
        validarDatos(tipo, cuenta, titular);
        this.tipo = tipo;
        this.fecha = LocalDate.now();
        this.cuenta = cuenta;
        this.titular = titular;
    }
    
    private void validarTipo(String tipo) {
        if (!Validador.validarNoVacio(tipo)) {
            Validador.datosInvalidos();
        }
    }
    
    private void validarDatos(String tipo, Cuenta cuenta, Cliente titular) {
        if (!Validador.validarNoVacio(tipo)) {
            Validador.datosInvalidos();
        }
        if (!Validador.validarNoNulo(cuenta)) {
            Validador.datosInvalidos();
        }
        if (!Validador.validarNoNulo(titular)) {
            Validador.datosInvalidos();
        }
    }

    public void asignarTitular(Cliente cliente, Cuenta cuenta) {
        if (!Validador.validarNoNulo(cliente)) {
            Validador.datosInvalidos();
        }
        if (!Validador.validarNoNulo(cuenta)) {
            Validador.datosInvalidos();
        }
        this.cuenta = cuenta;
        this.titular = cliente;
    }

    // Getters
    public String getTipo() { return tipo; }
    public LocalDate getFecha() { return fecha; }
    public Cuenta getCuenta() { return cuenta; }
    public Cliente getTitular() { return titular; }
    
    // Setters
    public void setTipo(String tipo) { 
        if (!Validador.validarNoVacio(tipo)) {
            Validador.datosInvalidos();
        }
        this.tipo = tipo; 
    }
    
    public void setFecha(LocalDate fecha) { 
        if (!Validador.validarNoNulo(fecha)) {
            Validador.datosInvalidos();
        }
        this.fecha = fecha; 
    }
    
    public void setCuenta(Cuenta cuenta) { 
        if (!Validador.validarNoNulo(cuenta)) {
            Validador.datosInvalidos();
        }
        this.cuenta = cuenta; 
    }
    
    public void setTitular(Cliente titular) { 
        if (!Validador.validarNoNulo(titular)) {
            Validador.datosInvalidos();
        }
        this.titular = titular; 
    }

    @Override
    public String toString() {
        return "Titularidad [tipo=" + tipo + ", fecha=" + fecha + ", cuenta=" + cuenta + ", titular=" + titular + "]";
    }
}

