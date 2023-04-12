package out.com.JavaAvanzado.Ejercicios.Ejercicios910y11.Ejercicio1;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static EmpleadoCRUD empleadoCRUD = new EmpleadoCRUDMySQL();

    public static void main(String[] args) throws SQLException {

        List<Empleado> empleados = new ArrayList<>();

        //Añadir empleados a la lista
        empleados.add(new Empleado(1, "Juan", "Pérez"));
        empleados.add(new Empleado(2, "María", "Gómez"));
        empleados.add(new Empleado(3, "Ernesto", "de la Cruz"));

        //Guardar empleados en la lista
        for(Empleado empleado: empleados) {
            empleadoCRUD.save(empleado);
        }

        //Obtener todos los elementos y mostrarlos
        List<Empleado> empleadoEnDB = empleadoCRUD.findAll();
        for (Empleado empleado : empleadoEnDB) {
            System.out.println(empleado.toString());
        }


    }
}
