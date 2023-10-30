package dev.ifrs.controller;

import java.util.HashMap;

import dev.ifrs.dto.UserDto;
import dev.ifrs.service.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/user")
public class UserController {
    @Inject
    UserService userService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response
                .ok(userService.findAll())
                .build();
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(UserDto userDto) {
        try {
            Long id = userService.create(userDto);
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
