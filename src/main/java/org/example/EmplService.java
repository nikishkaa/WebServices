package org.example;

import org.apache.commons.lang.StringUtils;
import org.example.dao.EmployeeDao;
import org.example.db.JPAService;
import org.example.entity.Employee;
import org.example.entity.Employees;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Path("/empl")
public class EmplService {
    private EmployeeDao employeeDao = new EmployeeDao();

    static {
        JPAService.initialize();
    }

    //work
    @GET
    @Path("/show-all-empls")
    @Produces(MediaType.APPLICATION_XML)
    public List<Employee> getAllEmpls() {
        return employeeDao.findAll();
    }

    @DELETE
    @Path("/remove/{id}")
    public Response deleteById(@PathParam("id") int id) {
        int emplId = Integer.parseInt(String.valueOf(id));
        if (emplId >= 0) {
            if (Objects.isNull(employeeDao.findById(emplId)))
                return Response.status(400).entity("Empl with id" + id + "NOT removed").build();
            employeeDao.deleteById(emplId);
            Response.status(200).entity("Empl with ID" + id + "Successfully removed").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("Empl with id" + id + "NOT removed").build();
    }


    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_XML)
    public Response createEmployee(Employee employee) {
        try {
            employeeDao.create(employee);
            return Response.status(200).entity("Employee created").build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(400).entity("Not created").build();
        }
    }


    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_XML)
    public Response updateEmployee(Employee employee) {
        try {
            employeeDao.update(employee);
            return Response.status(200).entity("Employee successfully updated").build();
        } catch (Exception e) {
            return Response.status(400).entity("Not Updated").build();
        }
    }

    @POST
    @Path("/createAll")
    @Consumes(MediaType.APPLICATION_XML)
    public Response createAllEmployee(Employees employees) {
        try {
            employeeDao.create(employees.getEmployees());
            return Response.status(200).entity("Employees created").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(400).entity("employs Not created").build();
        }
    }

}
