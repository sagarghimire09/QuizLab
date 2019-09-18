package edu.mum.cs;

import edu.mum.cs.model.Quiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/nextqn")
public class NextQnServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Quiz quiz = new Quiz();
        HttpSession session = req.getSession();
        int score = (int)session.getAttribute("score");
        int answer = Integer.parseInt(req.getParameter("answer"));
        if(answer == quiz.getAnswers()[0]) {
            score += 1;
            session.setAttribute("score", score);
        }
    }
}
