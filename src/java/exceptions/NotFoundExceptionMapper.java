/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletContext;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author kaspe
 */
@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException>
{

    Gson g = new GsonBuilder().setPrettyPrinting().create();
    @Context
    ServletContext context;

    @Override
    public Response toResponse(NotFoundException e)
    {
        ErrorMessage err = new ErrorMessage("The requested service does not exist", 404);
        if (context.getInitParameter("debug").equals("true"))
        {
            String stackTrace;
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            stackTrace = sw.toString();
            err = new ErrorMessage("The requested service does not exist", 404, stackTrace);
            Response out = Response.status(404).entity(g.toJson(err)).type(MediaType.APPLICATION_JSON).build();
            return out;
        }

        Response out = Response.status(404).entity(g.toJson(err)).type(MediaType.APPLICATION_JSON).build();
        return out;
    }

}
