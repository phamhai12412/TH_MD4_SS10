package com.example.thuchanh;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet (value ="/translate")
public  class TranslateServlet extends HttpServlet {
    @Override
    protected void  doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException{
        Map<String, String> dictionary  = new HashMap<> ();
        dictionary.put("Hello", "Xin chao");
        dictionary.put("How", "The Nao");
        dictionary.put("Book", "Sach");
        dictionary.put("Computuer","May tinh");
        String search = request.getParameter("txtsearch");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");

        String result =dictionary.get(search);
        if(result != null){
            writer.println("Word" + search);
            writer.println("Result" +result);
        }else {
            writer.println("Not Found");
        }
        writer.println("</html>");
    }
}