package com.training.pastries.controller;

import com.training.pastries.dao.DaoFactory;
import com.training.pastries.dao.PastryDao;
import com.training.pastries.dao.entity.Pastry;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/pastries")
public class PastryController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Pastry> pastries = DaoFactory.getPastryDao().getAll();
        return Response
                .status(Response.Status.OK)
                .entity(pastries)
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id) {
        Optional<Pastry> pastry = DaoFactory.getPastryDao().get(id);
        if (pastry.isEmpty()) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }
        return Response
                .status(Response.Status.OK)
                .entity(pastry.get())
                .build();
    }

    //ADD
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Pastry pastry) {
        DaoFactory.getPastryDao().create(pastry);

        return Response
                .status(Response.Status.CREATED)
                .entity(pastry)
                .build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        PastryDao dao = (PastryDao) DaoFactory.getPastryDao();
        Optional<Pastry> pastry = dao.get(id);

        if (pastry.isEmpty()) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }

        dao.delete(pastry.get());

        return  Response
                .status(Response.Status.OK)
                .build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOrUpdate(@PathParam("id") Long id, Pastry pastry) {
        PastryDao dao = (PastryDao) DaoFactory.getPastryDao();
        Optional<Pastry> optPastry = dao.get(id);
        if (optPastry.isEmpty()) {
            dao.create(pastry);
            return Response
                    .status(Response.Status.CREATED)
                    .build();
        }

        Pastry p = optPastry.get();
        p.setName(pastry.getName());
        p.setDescription(pastry.getDescription());
        dao.update(p);

        return Response
                .status(Response.Status.OK)
                .build();
    }

    @PATCH
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, Pastry pastry) {
        PastryDao dao = (PastryDao) DaoFactory.getPastryDao();
        Optional<Pastry> optPastry = dao.get(id);

        if (optPastry.isEmpty()) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }

        Pastry p = optPastry.get();
        if (pastry.getName() != null)
            p.setName(pastry.getName());
        if (pastry.getDescription() != null)
            p.setDescription(pastry.getDescription());

        dao.update(p);

        return Response
                .status(Response.Status.OK)
                .build();
    }
}
