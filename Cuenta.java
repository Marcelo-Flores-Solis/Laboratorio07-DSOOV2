public class Cuenta {

    private Cliente propietario;
    private String numero;
    private double saldo;
    private String tipo;

    public Cuenta(Cliente propietario, String numero, String tipo) {
        validarDatos(propietario, numero, tipo);
        this.propietario = propietario;
        this.numero = numero;
        this.tipo = tipo;
        this.saldo = 0.0;
    }
    
    private void validarDatos(Cliente propietario, String numero, String tipo) {
        if (!Validador.validarNoNulo(propietario)) {
            Validador.datosInvalidos();
        }
        if (!Validador.validarNoVacio(numero)) {
            Validador.datosInvalidos();
        }
        if (!Validador.validarNoVacio(tipo)) {
            Validador.datosInvalidos();
        }
    }

    public void consultarSaldo() {
        System.out.println("Saldo: " + this.saldo);
    }

    // Getters
    public Cliente getPropietario() { return propietario; }
    public String getNumero() { return numero; }
    public double getSaldo() { return saldo; }
    public String getTipo() { return tipo; }
    
    // Setters
    public void setPropietario(Cliente propietario) { 
        if (!Validador.validarNoNulo(propietario)) {
            Validador.datosInvalidos();
        }
        this.propietario = propietario; 
    }
    
    public void setNumero(String numero) { 
        if (!Validador.validarNoVacio(numero)) {
            Validador.datosInvalidos();
        }
        this.numero = numero; 
    }
    
    public void setSaldo(double saldo) { 
        this.saldo = saldo; 
    }
    
    public void setTipo(String tipo) { 
        if (!Validador.validarNoVacio(tipo)) {
            Validador.datosInvalidos();
        }
        this.tipo = tipo; 
    }
}

