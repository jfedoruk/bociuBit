package com.bociu;

import com.bociu.dto.BitMarketTicker;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/json")
@Produces(MediaType.APPLICATION_JSON)
public interface BitMarket {

    @GET
    @Path("{currencyPair}/ticker.json")
    public BitMarketTicker getTicker(@PathParam("currencyPair") String currency) throws IOException;
}
