/**
 * 
 */
package org.papinha.spark;

import static spark.Spark.get;
import static spark.Spark.post;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * Ejemplo de Login harcodeado
 * 
 * @author Juan Manuel Mougan - juanmougan@gmail.com
 *
 */
public class Login {
	
	public static final String USER_NAME = "papinha";
	public static final String USER_PASS = "secreta";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		get(new Route("/") {
	         @Override
	         public Object handle(Request request, Response response) {
	        	 // Devolver HTML
	        	 String html = "<!DOCTYPE html>" +
	        		 			"<html>" +
	        		 			"<head>" +
	        		 			"<title>Login</title>" +
	        		 			"</head>" +
	        		 			"<body>" +

	        		 			"<form action=\"/login\"  method=\"post\">" +
	        		 			"Usuario:<input type=\"text\" name=\"userName\"><br>" +
	        		 			"Contraseña: <input type=\"password\" name=\"userPass\"><br>" +
	        		 			"<input type=\"submit\">" +
	        		 			"</form>" +

	        	 				"</body>" +
	        	 				"</html>";
	        	 return html;
	         }
	      });
		
		post(new Route("/login") {
			
			@Override
			public Object handle(Request request, Response response) {
				// Pido los parametros
	        	String userName = request.queryParams("userName");
	        	String userPass = request.queryParams("userPass");
	        	// Validacion "sofisticada"
	        	boolean authenticate = USER_NAME.equals(userName) && USER_PASS.equals(userPass);
	        	if (!authenticate) {
					halt(403, "Usuario o contraseña incorrectos");
					return null;
				}
	        	else {
	        		// Setear el tipo de respuesta
		        	response.type("text/html");
		        	// Devolver HTML
		        	String html = "<!DOCTYPE HTML>" +
		        		 				"<html>" +
		        		 				"<body>" +
		        		 				"<h2>Hola " + userName + ", esto es Spark</h2>" +
		        		 				"</body>" +
		        	 					"</html>";
		        	return html;
	        	}
	        	
			}
		});

	}

}
