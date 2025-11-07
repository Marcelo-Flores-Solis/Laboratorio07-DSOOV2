import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorBanco gestor = new GestorBanco();
        int opcion;

         
        gestor.registrarCliente("Juan", "Pérez", "12121212", "C001", "perez@gmail.com", "activo");
        gestor.registrarCliente("Ana", "Gómez", "21212121", "C002", "ana@gmail.com" , "activo");

        // Empleados predeterminados

        gestor.registrarEmpleado("María", "López", "89898989", "E001", "Cajero");
        gestor.registrarEmpleado("Carlos", "Ramírez", "98989898", "E002", "Gerente");

        gestor.abrirCuenta("21212121", "CU001", "ahorros");
        gestor.abrirCuenta("12121212", "CU002", "corriente");


        do {
            System.out.println("\n====== MENU BANCO ======");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Registrar Empleado");
            System.out.println("3. Abrir Cuenta");
            System.out.println("4. Añadir Titular Secundario");
            System.out.println("5. Realizar Depósito");
            System.out.println("6. Realizar Retiro");
            System.out.println("7. Mostrar Cuentas de un Cliente");
            System.out.println("8. Mostrar Titulares de una Cuenta");
            System.out.println("9. Mostrar Movimientos de un Cliente");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.println("\n--- REGISTRO CLIENTE ---");
                    
                    // Validar nombres
                    String nombres;
                    do {
                        System.out.print("Nombres: ");
                        nombres = sc.nextLine();
                        if (!Validador.validarNombre(nombres)) {
                            Validador.mostrarError("El nombre debe contener solo letras y espacios (mínimo 2 caracteres)");
                        }
                    } while (!Validador.validarNombre(nombres));

                    // Validar apellidos
                    String apellidos;
                    do {
                        System.out.print("Apellidos: ");
                        apellidos = sc.nextLine();
                        if (!Validador.validarApellido(apellidos)) {
                            Validador.mostrarError("El apellido debe contener solo letras y espacios (mínimo 2 caracteres)");
                        }
                    } while (!Validador.validarApellido(apellidos));

                    // Validar DNI
                    String dni;
                    do {
                        System.out.print("DNI (8 dígitos): ");
                        dni = sc.nextLine();
                        if (!Validador.validarDNI(dni)) {
                            Validador.mostrarError("El DNI debe contener exactamente 8 dígitos numéricos");
                        }
                    } while (!Validador.validarDNI(dni));

                    // Validar ID Cliente
                    String idCliente;
                    do {
                        System.out.print("ID Cliente: ");
                        idCliente = sc.nextLine();
                        if (!Validador.validarNoVacio(idCliente)) {
                            Validador.mostrarError("El ID del cliente no puede estar vacío");
                        }
                    } while (!Validador.validarNoVacio(idCliente));

                    // Validar correo
                    String correo;
                    do {
                        System.out.print("Correo: ");
                        correo = sc.nextLine();
                        if (!Validador.validarCorreo(correo)) {
                            Validador.mostrarError("El correo debe tener un formato válido (ejemplo@dominio.com)");
                        }
                    } while (!Validador.validarCorreo(correo));

                    // Validar estado
                    String estado;
                    do {
                        System.out.print("Estado (activo/inactivo): ");
                        estado = sc.nextLine();
                        if (!Validador.validarEstado(estado)) {
                            Validador.mostrarError("El estado debe ser 'activo' o 'inactivo'");
                        }
                    } while (!Validador.validarEstado(estado));

                    // Si todos los datos son válidos, registrar el cliente
                    gestor.registrarCliente(nombres, apellidos, dni, idCliente, correo, estado);
                }

                case 2 -> {
                    System.out.println("\n--- REGISTRO EMPLEADO ---");
                    
                    // Validar nombres
                    String nombres;
                    do {
                        System.out.print("Nombres: ");
                        nombres = sc.nextLine();
                        if (!Validador.validarNombre(nombres)) {
                            Validador.mostrarError("El nombre debe contener solo letras y espacios (mínimo 2 caracteres)");
                        }
                    } while (!Validador.validarNombre(nombres));

                    // Validar apellidos
                    String apellidos;
                    do {
                        System.out.print("Apellidos: ");
                        apellidos = sc.nextLine();
                        if (!Validador.validarApellido(apellidos)) {
                            Validador.mostrarError("El apellido debe contener solo letras y espacios (mínimo 2 caracteres)");
                        }
                    } while (!Validador.validarApellido(apellidos));

                    // Validar DNI
                    String dni;
                    do {
                        System.out.print("DNI (8 dígitos): ");
                        dni = sc.nextLine();
                        if (!Validador.validarDNI(dni)) {
                            Validador.mostrarError("El DNI debe contener exactamente 8 dígitos numéricos");
                        }
                    } while (!Validador.validarDNI(dni));

                    // Validar ID Empleado
                    String idEmpleado;
                    do {
                        System.out.print("ID Empleado: ");
                        idEmpleado = sc.nextLine();
                        if (!Validador.validarNoVacio(idEmpleado)) {
                            Validador.mostrarError("El ID del empleado no puede estar vacío");
                        }
                    } while (!Validador.validarNoVacio(idEmpleado));

                    // Validar cargo
                    String cargo;
                    do {
                        System.out.print("Cargo: ");
                        cargo = sc.nextLine();
                        if (!Validador.validarNoVacio(cargo)) {
                            Validador.mostrarError("El cargo no puede estar vacío");
                        }
                    } while (!Validador.validarNoVacio(cargo));

                    // Si todos los datos son válidos, registrar el empleado
                    gestor.registrarEmpleado(nombres, apellidos, dni, idEmpleado, cargo);
                }

                case 3 -> {
                    System.out.println("\n--- ABRIR CUENTA ---");
                    
                    // Validar DNI del cliente
                    String dniCliente;
                    do {
                        System.out.print("DNI del Cliente: ");
                        dniCliente = sc.nextLine();
                        if (!Validador.validarDNI(dniCliente)) {
                            Validador.mostrarError("El DNI debe contener exactamente 8 dígitos numéricos");
                        }
                    } while (!Validador.validarDNI(dniCliente));

                    // Validar número de cuenta
                    String numeroCuenta;
                    do {
                        System.out.print("Número de Cuenta: ");
                        numeroCuenta = sc.nextLine();
                        if (!Validador.validarNoVacio(numeroCuenta)) {
                            Validador.mostrarError("El número de cuenta no puede estar vacío");
                        }
                    } while (!Validador.validarNoVacio(numeroCuenta));

                    // Validar tipo de cuenta
                    String tipo;
                    do {
                        System.out.print("Tipo (ahorros/corriente): ");
                        tipo = sc.nextLine();
                        if (!Validador.validarTipoCuenta(tipo)) {
                            Validador.mostrarError("El tipo debe ser 'ahorros' o 'corriente'");
                        }
                    } while (!Validador.validarTipoCuenta(tipo));

                    // Si todos los datos son válidos, abrir la cuenta
                    gestor.abrirCuenta(dniCliente, numeroCuenta, tipo);
                }

                case 4 -> {
                    System.out.println("\n--- AÑADIR TITULAR SECUNDARIO ---");
                    
                    // Validar número de cuenta
                    String numeroCuenta;
                    do {
                        System.out.print("Número de Cuenta: ");
                        numeroCuenta = sc.nextLine();
                        if (!Validador.validarNoVacio(numeroCuenta)) {
                            Validador.mostrarError("El número de cuenta no puede estar vacío");
                        }
                    } while (!Validador.validarNoVacio(numeroCuenta));

                    // Validar DNI del cliente
                    String dniCliente;
                    do {
                        System.out.print("DNI del Cliente: ");
                        dniCliente = sc.nextLine();
                        if (!Validador.validarDNI(dniCliente)) {
                            Validador.mostrarError("El DNI debe contener exactamente 8 dígitos numéricos");
                        }
                    } while (!Validador.validarDNI(dniCliente));

                    // Si todos los datos son válidos, agregar titular
                    gestor.agregarTitularSecundario(numeroCuenta, dniCliente);
                }

                case 5 -> {
                    System.out.println("\n--- REALIZAR DEPÓSITO ---");
                    
                    // Validar número de cuenta
                    String numeroCuenta;
                    do {
                        System.out.print("Número de Cuenta: ");
                        numeroCuenta = sc.nextLine();
                        if (!Validador.validarNoVacio(numeroCuenta)) {
                            Validador.mostrarError("El número de cuenta no puede estar vacío");
                        }
                    } while (!Validador.validarNoVacio(numeroCuenta));

                    // DNI empleado (opcional)
                    System.out.print("DNI Empleado (opcional, Enter para omitir): ");
                    String dniEmpleado = sc.nextLine();

                    // Validar monto
                    double monto;
                    do {
                        System.out.print("Monto: ");
                        while (!sc.hasNextDouble()) {
                            Validador.mostrarError("El monto debe ser un número válido");
                            System.out.print("Monto: ");
                            sc.next();
                        }
                        monto = sc.nextDouble();
                        sc.nextLine(); 
                        if (!Validador.validarPositivo(monto)) {
                            Validador.mostrarError("El monto debe ser positivo");
                        }
                    } while (!Validador.validarPositivo(monto));

                    // Validar ID transacción
                    String idTransaccion;
                    do {
                        System.out.print("ID Transacción: ");
                        idTransaccion = sc.next();
                        sc.nextLine();
                        if (!Validador.validarNoVacio(idTransaccion)) {
                            Validador.mostrarError("El ID de transacción no puede estar vacío");
                        }
                    } while (!Validador.validarNoVacio(idTransaccion));

                    // Si todos los datos son válidos, realizar depósito
                    gestor.realizarDeposito(numeroCuenta, dniEmpleado, monto, idTransaccion);
                }

                case 6 -> {
                    System.out.println("\n--- REALIZAR RETIRO ---");
                    
                    // Validar número de cuenta
                    String numeroCuenta;
                    do {
                        System.out.print("Número de Cuenta: ");
                        numeroCuenta = sc.nextLine();
                        if (!Validador.validarNoVacio(numeroCuenta)) {
                            Validador.mostrarError("El número de cuenta no puede estar vacío");
                        }
                    } while (!Validador.validarNoVacio(numeroCuenta));

                    // DNI empleado (opcional)
                    System.out.print("DNI Empleado (opcional, Enter para omitir): ");
                    String dniEmpleado = sc.nextLine();

                    // Validar monto
                    double monto;
                    do {
                        System.out.print("Monto: ");
                        while (!sc.hasNextDouble()) {
                            Validador.mostrarError("El monto debe ser un número válido");
                            System.out.print("Monto: ");
                            sc.next();
                        }
                        monto = sc.nextDouble();
                        sc.nextLine(); 
                        if (!Validador.validarPositivo(monto)) {
                            Validador.mostrarError("El monto debe ser positivo");
                        }
                    } while (!Validador.validarPositivo(monto));

                    // Validar ID transacción
                    String idTransaccion;
                    do {
                        System.out.print("ID Transacción: ");
                        idTransaccion = sc.nextLine();
                        if (!Validador.validarNoVacio(idTransaccion)) {
                            Validador.mostrarError("El ID de transacción no puede estar vacío");
                        }
                    } while (!Validador.validarNoVacio(idTransaccion));

                    // Si todos los datos son válidos, realizar retiro
                    gestor.realizarRetiro(numeroCuenta, dniEmpleado, monto, idTransaccion);
                }

                case 7 -> {
                    System.out.println("\n--- CONSULTAR CUENTAS DE CLIENTE ---");
                    
                    // Validar DNI del cliente
                    String dniCliente;
                    do {
                        System.out.print("DNI del Cliente: ");
                        dniCliente = sc.nextLine();
                        if (!Validador.validarDNI(dniCliente)) {
                            Validador.mostrarError("El DNI debe contener exactamente 8 dígitos numéricos");
                        }
                    } while (!Validador.validarDNI(dniCliente));

                    gestor.mostrarCuentasDeCliente(dniCliente);
                }

                case 8 -> {
                    System.out.println("\n--- CONSULTAR TITULARES DE CUENTA ---");
                    
                    // Validar número de cuenta
                    String numeroCuenta;
                    do {
                        System.out.print("Número de Cuenta: ");
                        numeroCuenta = sc.nextLine();
                        if (!Validador.validarNoVacio(numeroCuenta)) {
                            Validador.mostrarError("El número de cuenta no puede estar vacío");
                        }
                    } while (!Validador.validarNoVacio(numeroCuenta));

                    gestor.mostrarTitularesDeCuenta(numeroCuenta);
                }

                case 9 -> {
                    System.out.println("\n--- CONSULTAR MOVIMIENTOS DE CLIENTE ---");
                    
                    // Validar DNI del cliente
                    String dniCliente;
                    do {
                        System.out.print("DNI del Cliente: ");
                        dniCliente = sc.nextLine();
                        if (!Validador.validarDNI(dniCliente)) {
                            Validador.mostrarError("El DNI debe contener exactamente 8 dígitos numéricos");
                        }
                    } while (!Validador.validarDNI(dniCliente));

                    gestor.mostrarMovimientosDeCliente(dniCliente);
                }

                case 0 -> {
                    System.out.println("\n¡Gracias por usar el sistema bancario!");
                }

                default -> {
                    System.out.println("\nOpción inválida. Por favor, seleccione una opción válida.");
                }
            }
        } while (opcion != 0);

        sc.close();
    }
}
