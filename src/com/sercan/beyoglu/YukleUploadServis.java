package com.sercan.beyoglu;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/file")
public class YukleUploadServis {

	
	
	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response yuklemeYap(@FormDataParam("file")InputStream uploadInputStream,
							   @FormDataParam("file") FormDataContentDisposition dosyaDetayi) {
		
		String yuklemeAdresi = "C:\\Users\\Sercan\\Desktop\\"+dosyaDetayi.getFileName();
		kaydet(uploadInputStream,yuklemeAdresi);
		
		String sonuc = "Baþarýlý";
		
		return Response.status(200).entity(sonuc).build();
		
	}//FIUNC
	
	private void kaydet(InputStream inputStream,String yuklemeAdresi) {
		
			try {
				OutputStream uploadInputStream = new FileOutputStream(new File(yuklemeAdresi));
				
				int okuRead = 0;
				byte[] bytes = new byte[1024];
				
				uploadInputStream = new FileOutputStream(new File(yuklemeAdresi));
				
				while((okuRead = inputStream.read(bytes)) != -1)
				{
						uploadInputStream.write(bytes, 0, okuRead);
				}//WHILE
				
				uploadInputStream.flush();
				uploadInputStream.close();
			}catch(Exception et) {
				
			}finally {
				
				
			}
			
		
		
	}
}
