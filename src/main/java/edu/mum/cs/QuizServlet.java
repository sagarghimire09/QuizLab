package edu.mum.cs;

import edu.mum.cs.model.Quiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class QuizServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Quiz quiz = new Quiz();
        int score = 0;
        HttpSession session = req.getSession();
        if(session.getAttribute("quiz") == null) {
            session.setAttribute("quiz", quiz);
        }else {
            quiz = (Quiz)session.getAttribute("quiz");
        }

        out.println("<h1>The Number Quiz</h1>");
        out.println("<p>Your current score is "+score+"</p>");
        out.println("<p>"+quiz.getQuestions()[0]+"</p>");
        out.println("<form action=\"nextqn\" method=\"post\">");
        out.println("<input type=\"number\" name=\"answer\"><br><br>");
        out.println("<input type=\"submit\" value=\"Submit\">");
        out.println("</form>");
    }
}
