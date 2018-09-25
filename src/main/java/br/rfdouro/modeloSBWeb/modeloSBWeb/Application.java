package br.rfdouro.modeloSBWeb.modeloSBWeb;

import java.awt.Desktop;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application {

 public static void main(String[] args) {
  SpringApplication.run(Application.class, args);
  try {

   String sPorta = null;
   for (String x : args) {
    System.out.println("" + x);
    if (x.startsWith("--server.port")) {
     sPorta = x;
     break;
    }
   }
   if (sPorta != null) {
    String porta = sPorta.split("=")[1].trim();
    if (Desktop.isDesktopSupported()) {
     Desktop desktop = java.awt.Desktop.getDesktop();
     URI oURL = new URI("http://localhost:" + porta);
     desktop.browse(oURL);
    } else {
     Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start chrome http://localhost:" + porta});
    }
   }
  } catch (Exception e) {
   e.printStackTrace();
  }
 }
}
