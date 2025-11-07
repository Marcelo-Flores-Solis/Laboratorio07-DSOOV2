public class Deposito extends Transaccion {

    public Deposito(String idTransaccion, double monto, Cuenta cuenta, Empleado empleado) {
        super(idTransaccion, monto, cuenta, empleado);
    }

    @Override
    public String toString() {
        return "--- DEPOSITO --- " + super.toString();
    }

    @Override
    public void procesar() {
        double saldoActual = cuentaAsociada.getSaldo();
        cuentaAsociada.setSaldo(saldoActual + monto);
        System.out.println("Depósito procesado exitosamente");
    }
}
