package out.com.JavaAvanzado.Ejercicios.Ejercicios910y11.Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoCRUDExcel implements EmpleadoCRUD{

    private List<Empleado> empleados;

    public EmpleadoCRUDExcel() {

        this.empleados = new ArrayList<>();
    }

    @Override
    public void save(Empleado empleado) {
        this.empleados.add(empleado);
        System.out.println("Empleado guardado en Excel: " + empleado.getNombre());
    }

    @Override
    public List<Empleado> findAll() {
        return this.empleados;
    }

    @Override
    public void delete(Empleado empleado) {
        this.empleados.remove(empleado);
        System.out.println("Empleado eliminado de Excel: " + empleado.getNombre());
    }
}
