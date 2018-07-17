package ru.ivmiit.servlets;

import ru.ivmiit.models.User;
import ru.ivmiit.repositories.UsersRepository;
import ru.ivmiit.repositories.UsersRepositoryInMemoryImpl;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;


@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

    private UsersRepository usersRepository;

    @Override
    public void init() throws ServletException {
        this.usersRepository = new UsersRepositoryInMemoryImpl();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> users = usersRepository.findAll();
        req.setAttribute("usersFromServer", users);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/signUp.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));

        User user = new User(name,password,birthDate);
        usersRepository.save(user);

     doGet(req,resp);
    }
}
