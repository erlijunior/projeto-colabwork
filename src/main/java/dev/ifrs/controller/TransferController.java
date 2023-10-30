package dev.ifrs.controller;

import dev.ifrs.dto.TransferDto;
import dev.ifrs.service.TransferService;
 
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.HashMap;
 
@Path("/transfer")
public class TransferController {
 
    @Inject
    TransferService transferService;
 
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response
                .ok(transferService.findAll())
                .build();
    }
 
    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(TransferDto transferDto) {
        try {
            Long id = transferService.create(transferDto);
            return Response // 200
                    .ok(
                            new HashMap() {{
                                put("id", id);
                            }})
                    .build();
        } catch (Exception ex) {
            return Response // error 400
                    .status(400).entity(
                            new HashMap() {{
                                put("error", "failed to insert");
                            }})
                    .build();
        }
    }
 
}
