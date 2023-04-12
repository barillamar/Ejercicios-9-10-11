package out.com.JavaAvanzado.Ejercicios.Ejercicios910y11.Ejercicio1;

import java.sql.SQLException;
import java.util.List;

public interface EmpleadoCRUD {

    void save(Empleado empleado);
    List<Empleado> findAll() throws SQLException;
    void delete(Empleado empleado) throws SQLException;
}
