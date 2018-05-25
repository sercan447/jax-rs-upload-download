package com.sercan.beyoglu;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/files")
public class IndirDownloadServis {

	private static String TXT_ADRES= "C:\\Users\\Sercan\\Downloads\\metin.txt";
	private static String RESIM_ADRES= "C:\\Users\\Sercan\\Downloads\\Resim\\WhatsApp Image 2017-05-09 at 23.18.32.jpeg";
	
	
	@GET
	@Path("/belgeindir")
	@Produces("text/plain")
	public Response txtindir() {
		
		File file = new File(TXT_ADRES);
		ResponseBuilder response =Response.ok((Object)file);
		response.header("Content-Disposition","attachment; filename=\"inendosya.txt\"");
		return response.build();
	}
	
	@GET
	@Path("/resimindir")
	@Produces("image/jpeg")
	public Response resimindir() {
		
		File file = new File(RESIM_ADRES);
		ResponseBuilder response =Response.ok((Object)file);
		response.header("Content-Disposition","attachment; filename=\"inendosyaresim.jpeg\"");
		return response.build();
	}
}
