package sw2.clase7spring_ec2_rds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sw2.clase7spring_ec2_rds.dto.EmpleadosPorPaisDto;
import sw2.clase7spring_ec2_rds.dto.EmpleadosRegionDto;
import sw2.clase7spring_ec2_rds.entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select r.regionDescription as regiondescription, count(e.employeeid) as cantidadempleados " +
            "FROM region r\n" +
            "inner join territories t on (r.regionid = t.regionid)\n" +
            "inner join employeeterritories et on (t.territoryid = et.territoryid)\n" +
            "inner join employees e on (e.employeeid = et.employeeid)\n" +
            "group by r.regionid\n", nativeQuery = true)
    List<EmpleadosRegionDto> obtenerEmpleadosPorRegion();

    @Query(value = "SELECT country as pais, count(*) as cantidad FROM employees GROUP BY country",
            nativeQuery = true)
    List<EmpleadosPorPaisDto> obtenerEmpleadosPorPais();

    @Query(value = "SELECT country as pais, count(*) as cantidad FROM employees WHERE country = ?1 GROUP BY country",
            nativeQuery = true)
    List<EmpleadosPorPaisDto> obtenerEmpleadosPorPais(String nombrePais);
}

