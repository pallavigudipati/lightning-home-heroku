package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cmu.sphinx.api.Configuration;

@WebServlet(
        name = "SpeechRecognizer", 
        urlPatterns = {"/speech"}
    )
public class SpeechRecognizer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        out.write("hello speech".getBytes());
        String outStr = edu.cmu.sphinx.linguist.allphone.AllphoneLinguist.PROP_ACOUSTIC_MODEL;
        out.write(outStr.getBytes());
        out.flush();
        out.close();
    }
    
}
