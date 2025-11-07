import java.util.ArrayList;
import java.util.List;

public class GestorBanco {
    
    private List<Cliente> clientes;
    private List<Empleado> empleados;
    private List<Cuenta> cuentas;
    private List<Transaccion> transacciones;
    private List<Titularidad> titularidades;
    
    public GestorBanco() {
        this.clientes = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.cuentas = new ArrayList<>();
        this.transacciones = new ArrayList<>();
        this.titularidades = new ArrayList<>();
    }
    
    // ========== MÉTODOS PARA CLIENTES ==========
    
    public void registrarCliente(String nombre, String apellido, String dni, String idCliente, String correo, String estado) {
        Cliente nuevoCliente = new Cliente(nombre, apellido, dni, idCliente, correo, estado);
        clientes.add(nuevoCliente);
        System.out.println("Cliente registrado exitosamente");
    }
    
    public Cliente buscarClientePorDNI(String dni) {
        if (!Validador.validarNoVacio(dni)) {
            Validador.datosInvalidos();
        }
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }
        return null;
    }
    
    public Cliente buscarClientePorId(String idCliente) {
        if (!Validador.validarNoVacio(idCliente)) {
            Validador.datosInvalidos();
        }
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente().equals(idCliente)) {
                return cliente;
            }
        }
        return null;
    }
    
    // ========== MÉTODOS PARA EMPLEADOS ==========
    
    public void registrarEmpleado(String nombre, String apellido, String dni, String idEmpleado, String cargo) {
        Empleado nuevoEmpleado = new Empleado(nombre, apellido, dni, idEmpleado, cargo);
        empleados.add(nuevoEmpleado);
        System.out.println("Empleado registrado exitosamente");
    }
    
    public Empleado buscarEmpleadoPorDNI(String dni) {
        if (!Validador.validarNoVacio(dni)) {
            Validador.datosInvalidos();
        }
        for (Empleado empleado : empleados) {
            if (empleado.getDni().equals(dni)) {
                return empleado;
            }
        }
        return null;
    }
    
    public Empleado buscarEmpleadoPorId(String idEmpleado) {
        if (!Validador.validarNoVacio(idEmpleado)) {
            Validador.datosInvalidos();
        }
        for (Empleado empleado : empleados) {
            if (empleado.getIdEmpleado().equals(idEmpleado)) {
                return empleado;
            }
        }
        return null;
    }
    
    // ========== MÉTODOS PARA CUENTAS ==========
    
    public void abrirCuenta(String dniCliente, String numeroCuenta, String tipoCuenta) {
        Cliente cliente = buscarClientePorDNI(dniCliente);
        if (!Validador.validarNoNulo(cliente)) {
            Validador.datosInvalidos();
        }
        
        Cuenta nuevaCuenta = new Cuenta(cliente, numeroCuenta, tipoCuenta);
        cuentas.add(nuevaCuenta);
        
        Titularidad titularidad = new Titularidad("Principal", nuevaCuenta, cliente);
        titularidades.add(titularidad);
        
        System.out.println("Cuenta abierta exitosamente");
    }
    
    public Cuenta buscarCuentaPorNumero(String numeroCuenta) {
        if (!Validador.validarNoVacio(numeroCuenta)) {
            Validador.datosInvalidos();
        }
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumero().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }
    
    // ========== MÉTODOS PARA TITULARIDAD ==========
    
    public void agregarTitularSecundario(String numeroCuenta, String dniCliente) {
        Cuenta cuenta = buscarCuentaPorNumero(numeroCuenta);
        if (!Validador.validarNoNulo(cuenta)) {
            Validador.datosInvalidos();
        }
        
        Cliente cliente = buscarClientePorDNI(dniCliente);
        if (!Validador.validarNoNulo(cliente)) {
            Validador.datosInvalidos();
        }
        
        Titularidad titularidad = new Titularidad("Secundario", cuenta, cliente);
        titularidades.add(titularidad);
        System.out.println("Titular secundario agregado exitosamente");
    }
    
    // ========== MÉTODOS PARA TRANSACCIONES ==========
    
    public void realizarDeposito(String numeroCuenta, String dniEmpleado, double monto, String idTransaccion) {
        Cuenta cuenta = buscarCuentaPorNumero(numeroCuenta);
        if (!Validador.validarNoNulo(cuenta)) {
            Validador.datosInvalidos();
        }
        
        Empleado empleado = null;
        if (Validador.validarNoVacio(dniEmpleado)) {
            empleado = buscarEmpleadoPorDNI(dniEmpleado);
        }
        
        Deposito deposito = new Deposito(idTransaccion, monto, cuenta, empleado);
        deposito.procesar();
        transacciones.add(deposito);
    }
    
    public void realizarRetiro(String numeroCuenta, String dniEmpleado, double monto, String idTransaccion) {
        Cuenta cuenta = buscarCuentaPorNumero(numeroCuenta);
        if (!Validador.validarNoNulo(cuenta)) {
            Validador.datosInvalidos();
        }
        
        Empleado empleado = null;
        if (Validador.validarNoVacio(dniEmpleado)) {
            empleado = buscarEmpleadoPorDNI(dniEmpleado);
        }
        
        Retiro retiro;
        if (empleado != null) {
            retiro = new Retiro(idTransaccion, monto, cuenta, empleado);
        } else {
            retiro = new Retiro(idTransaccion, monto, cuenta);
        }
        
        retiro.procesar();
        transacciones.add(retiro);
    }
    
    // ========== MÉTODOS DE CONSULTA ==========
    
    public void mostrarCuentasDeCliente(String dniCliente) {
        Cliente cliente = buscarClientePorDNI(dniCliente);
        if (!Validador.validarNoNulo(cliente)) {
            Validador.datosInvalidos();
        }
        
        System.out.println("\n=== Cuentas del cliente: " + cliente.getNombre() + " " + cliente.getApellido() + " ===");
        
        for (Titularidad t : titularidades) {
            if (t.getTitular() != null && t.getTitular().getDni().equals(dniCliente)) {
                Cuenta cuenta = t.getCuenta();
                System.out.println("- Cuenta: " + cuenta.getNumero() + 
                                 " | Tipo: " + cuenta.getTipo() + 
                                 " | Saldo: " + cuenta.getSaldo());
            }
        }
    }
    
    public void mostrarTitularesDeCuenta(String numeroCuenta) {
        Cuenta cuenta = buscarCuentaPorNumero(numeroCuenta);
        if (!Validador.validarNoNulo(cuenta)) {
            Validador.datosInvalidos();
        }
        
        System.out.println("\n=== Titulares de la cuenta: " + numeroCuenta + " ===");
        
        for (Titularidad t : titularidades) {
            if (t.getCuenta() != null && t.getCuenta().getNumero().equals(numeroCuenta)) {
                Cliente titular = t.getTitular();
                System.out.println("- " + t.getTipo() + ": " + titular.getNombre() + " " + titular.getApellido());
            }
        }
    }
    
    public void mostrarMovimientosDeCliente(String dniCliente) {
        Cliente cliente = buscarClientePorDNI(dniCliente);
        if (!Validador.validarNoNulo(cliente)) {
            Validador.datosInvalidos();
        }
        
        System.out.println("\n=== Movimientos del cliente: " + cliente.getNombre() + " " + cliente.getApellido() + " ===");
        
        List<String> cuentasCliente = new ArrayList<>();
        for (Titularidad t : titularidades) {
            if (t.getTitular() != null && t.getTitular().getDni().equals(dniCliente)) {
                cuentasCliente.add(t.getCuenta().getNumero());
            }
        }
        
        for (Transaccion transaccion : transacciones) {
            if (cuentasCliente.contains(transaccion.getCuentaAsociada().getNumero())) {
                String tipo = (transaccion instanceof Deposito) ? "DEPÓSITO" : "RETIRO";
                System.out.println("- " + tipo + " | Monto: " + transaccion.getMonto() + 
                                 " | Fecha: " + transaccion.getFecha());
            }
        }
    }
    
    // Getters
    public List<Cliente> getClientes() { return clientes; }
    public List<Empleado> getEmpleados() { return empleados; }
    public List<Cuenta> getCuentas() { return cuentas; }
    public List<Transaccion> getTransacciones() { return transacciones; }
    public List<Titularidad> getTitularidades() { return titularidades; }
}
