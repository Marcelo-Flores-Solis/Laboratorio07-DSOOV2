import java.time.*;

public class Transaccion {

    protected String idTransaccion;
    protected double monto;
    protected LocalDate fecha;
    protected Cuenta cuentaAsociada;
    protected Empleado empleadoResponsable;

    public Transaccion(String idTransaccion, double monto, Cuenta cuentaAsociada, Empleado empleadoResponsable) {
        validarDatos(idTransaccion, monto, cuentaAsociada);
        this.idTransaccion = idTransaccion;
        this.monto = monto;
        this.fecha = LocalDate.now();
        this.cuentaAsociada = cuentaAsociada;
        this.empleadoResponsable = empleadoResponsable;
    }

    public Transaccion(String idTransaccion, double monto, Cuenta cuentaAsociada) {
        validarDatos(idTransaccion, monto, cuentaAsociada);
        this.idTransaccion = idTransaccion;
        this.monto = monto;
        this.fecha = LocalDate.now();
        this.cuentaAsociada = cuentaAsociada;
    }
    
    private void validarDatos(String idTransaccion, double monto, Cuenta cuentaAsociada) {
        if (!Validador.validarNoVacio(idTransaccion)) {
            Validador.datosInvalidos();
        }
        if (!Validador.validarPositivo(monto)) {
            Validador.datosInvalidos();
        }
        if (!Validador.validarNoNulo(cuentaAsociada)) {
            Validador.datosInvalidos();
        }
    }

    // Getters
    public String getIdTransaccion() { return idTransaccion; }
    public double getMonto() { return monto; }
    public LocalDate getFecha() { return fecha; }
    public Cuenta getCuentaAsociada() { return cuentaAsociada; }
    public Empleado getEmpleadoResponsable() { return empleadoResponsable; }
    
    // Setters
    public void setIdTransaccion(String idTransaccion) { 
        if (!Validador.validarNoVacio(idTransaccion)) {
            Validador.datosInvalidos();
        }
        this.idTransaccion = idTransaccion; 
    }
    
    public void setMonto(double monto) { 
        if (!Validador.validarPositivo(monto)) {
            Validador.datosInvalidos();
        }
        this.monto = monto; 
    }
    
    public void setFecha(LocalDate fecha) { 
        if (!Validador.validarNoNulo(fecha)) {
            Validador.datosInvalidos();
        }
        this.fecha = fecha; 
    }
    
    public void setCuentaAsociada(Cuenta cuentaAsociada) { 
        if (!Validador.validarNoNulo(cuentaAsociada)) {
            Validador.datosInvalidos();
        }
        this.cuentaAsociada = cuentaAsociada; 
    }
    
    public void setEmpleadoResponsable(Empleado empleadoResponsable) { 
        this.empleadoResponsable = empleadoResponsable; 
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "idTransaccion='" + idTransaccion + '\'' +
                ", monto=" + monto +
                ", fecha=" + fecha +
                ", cuentaAsociada=" + cuentaAsociada +
                ", empleadoResponsable=" + empleadoResponsable +
                '}';
    }

    public void procesar() {
        System.out.println("Procesando transacción");
    }
}

