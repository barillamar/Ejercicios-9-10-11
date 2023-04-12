package out.com.JavaAvanzado.Ejercicios.Ejercicios910y11.Ejercicio1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoCRUDMySQL implements EmpleadoCRUD {

    private Connection conn;

    public EmpleadoCRUDMySQL() {
        try {
            String url = "nuestra/url";
            String user = "root";
            String password = "micontraseña";
            this.conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Empleado empleado) {

        try {
            PreparedStatement statement = this.conn.prepareStatement("INSERT INTO empleados (nombre, apellido, email) VALUES (?, ?, ?)");
            statement.setString(1, empleado.getNombre());
            statement.setString(2, empleado.getApellido());
            statement.executeUpdate();
            System.out.println("Empleado guardado en MySQL: " + empleado.getNombre() + " " + empleado.getApellido());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Empleado> findAll() throws SQLException {
        List<Empleado> empleados = new ArrayList<>();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM empleados");
        while (resultSet.next()) {
            String nombre = resultSet.getString("nombre");
            String apellido = resultSet.getString("edad");
            Empleado empleado = new Empleado();
            empleados.add(empleado);
        }
        System.out.println("Empleados encontrados en MySQL: " + empleados.size());
        return empleados;
    }

    @Override
    public void delete(Empleado empleado) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("DELETE FROM empleados WHERE nombre = ?");
        statement.setString(1, empleado.getNombre());
        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Empleado eliminado de MySQL");
        } else {
            System.out.println("No se encontró el empleado en MySQL");
        }
    }
}
