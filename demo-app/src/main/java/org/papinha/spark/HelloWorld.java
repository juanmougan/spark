/**
 * 
 */
package org.papinha.spark;

import static spark.Spark.*;
import spark.*;

public class HelloWorld {

   public static void main(String[] args) {
      
      get(new Route("/hello") {
         @Override
         public Object handle(Request request, Response response) {
        	 // Nombre de la variable de entorno
        	 String nombre = request.queryParams("nombre");
        	 // Setear el tipo de respuesta
        	 response.type("text/html");
        	 // Devolver HTML
        	 String html = "<!DOCTYPE HTML>" +
        		 				"<html>" +
        		 				"<body>" +
        		 				"<h2>Hola " + nombre + ", esto es Spark</h2>" +
        		 				"</body>" +
        	 					"</html>";
        	 return html;
         }
      });

   }

}
