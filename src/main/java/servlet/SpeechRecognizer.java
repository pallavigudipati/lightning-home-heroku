package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cmu.sphinx.api.Configuration;
import lightningHome.SpellRecognition;

@WebServlet(
        name = "SpeechRecognizer", 
        urlPatterns = {"/speech"}
    )
public class SpeechRecognizer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        out.write("hello speech\n".getBytes());
        String outStr = edu.cmu.sphinx.linguist.allphone.AllphoneLinguist.PROP_ACOUSTIC_MODEL + "\n";
        out.write(outStr.getBytes());
        String testStr = SpellRecognition.getConfiguration().getDictionaryPath();
        out.write(testStr.getBytes());
        out.flush();
        out.close();
    }
}
