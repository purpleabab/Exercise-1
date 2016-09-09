package com.matc.controller;

import com.matc.persistence.UserData;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A simple servlet to welcome the user.
 *
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/searchUser"}
)

public class SearchUser extends HttpServlet {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("rah, rah, in the doGet of SearchUser");
logger.warn("WOW!  a warning!!");
        UserData userData = new UserData();
        req.setAttribute("users", userData.getAllUsers());
        req.setAttribute("searchAll", true);
        //req.setAttribute("userSearched", userData.getUserByLastName();
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserData userData = new UserData();
        String lastNameSearchedInputValue = req.getParameter("lastNameSearch");
        //System.out.println("lastNameSearchedInputValue" + lastNameSearchedInputValue);
        req.setAttribute("userSearched", userData.getUserByLastName(lastNameSearchedInputValue));
        req.setAttribute("searchAll", false);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}