package com.bociu;

import com.bociu.dto.BitMarketAccountInfoResponse;
import com.bociu.dto.BitMarketTicker;
import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.SynchronizedValueFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/api2")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.APPLICATION_JSON)
public interface BitMarketAuth extends BitMarket{
    @POST
    @FormParam("method")
    BitMarketAccountInfoResponse info(@HeaderParam("API-Key") String apiKey, @HeaderParam("API-Hash") ParamsDigest signer,
                                      @FormParam("tonce") SynchronizedValueFactory<Long> nonce) throws IOException, BitMarketException;

}
