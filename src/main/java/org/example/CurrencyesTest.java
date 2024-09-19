package org.example;

import org.example.dao.CurrenciesDao;
import org.example.dao.EmployeeDao;
import org.example.db.JPAService;
import org.example.entity.Currencies;
import org.example.entity.Currency;
import org.example.entity.Employee;
import org.example.entity.Employees;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/cur")
public class CurrencyesTest {
    private CurrenciesDao currenciesDao = new CurrenciesDao();

    static {
        JPAService.initialize();
    }

    @GET
    @Path("/show-all-empls")
    @Produces(MediaType.APPLICATION_XML)
    public List<Currency> getAllCur() {
        return currenciesDao.findAll();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_XML)
    public Response createCur(Currency currency) {
        try {
            currenciesDao.create(currency);
            return Response.status(200).entity("Cur created").build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(400).entity("Not created").build();
        }
    }

    @POST
    @Path("/createAll")
    @Consumes(MediaType.APPLICATION_XML)
    public Response createAllCur(Currencies currencies) {
        try {
            currenciesDao.create(currencies.getCurrencies());
            return Response.status(200).entity("Cur created").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(400).entity("Cur Not created").build();
        }
    }




}
