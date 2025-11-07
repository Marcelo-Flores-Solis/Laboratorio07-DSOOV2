public class Retiro extends Transaccion {

    public Retiro(String idTransaccion, double monto, Cuenta cuenta, Empleado empleado) {
        super(idTransaccion, monto, cuenta, empleado);
    }

    public Retiro(String idTransaccion, double monto, Cuenta cuenta) {
        super(idTransaccion, monto, cuenta);
    }

    @Override
    public String toString() {
        return "--- RETIRO ---" + super.toString();
    }

    @Override
    public void procesar() {
        double saldoActual = cuentaAsociada.getSaldo();
        if (monto > saldoActual) {
            System.out.println("Error: Fondos insuficientes");
            return;
        }
        cuentaAsociada.setSaldo(saldoActual - monto);
        System.out.println("Retiro procesado exitosamente");
    }
}

