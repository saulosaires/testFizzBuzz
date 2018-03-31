package com.serviceflow.resources;

import javax.inject.Named;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.serviceflow.service.FizzBuzzServiceImpl;
import com.serviceflow.service.IFizzBuzzService;
import com.serviceflow.util.FizzBuzzLogger;
import com.serviceflow.util.Responses;
import com.serviceflow.util.Utils;

/**
 * FizzBuzzResource resource (exposed at "fizzbuzz" path)
 */
@Path("fizzbuzz")
@Named
public class FizzBuzzResource {

	public static final String FIZZ = "Fizz";
	public static final String BUZZ = "Buzz";
	public static final String INVALID_NUMBER = "This number is invalid: A valid number should be greater then Zero";

	private IFizzBuzzService fizzBuzzService;

	public FizzBuzzResource() {
		this.fizzBuzzService = new FizzBuzzServiceImpl();
	}

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will respect the FizzBuzz rules
	 * @throws BadRequestException
	 *             if the number is null or not greater then Zero
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getfizzBuzzNumber(@QueryParam(value = "number") Integer number) {

		try {

			if (Utils.invalidNumber(number)) {

				return Responses.badRequest(INVALID_NUMBER);
			}

			if (fizzBuzzService.isFizz(number)) {

				return Responses.ok(FIZZ);
			} else if (fizzBuzzService.isBuzz(number)) {
				return Responses.ok(BUZZ);
			} else {
				return Responses.ok(number);
			}

		} catch (Exception e) {
			FizzBuzzLogger.logSevere(e.getMessage());
			return Responses.internalServerError(e.getMessage());
		}

	}
}
