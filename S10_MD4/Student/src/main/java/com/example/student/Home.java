package com.example.student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Home")
public class Home extends HttpServlet {
    public List<Student> getStudentList = new ArrayList<>();
    Student student = new Student();

    @Override
    public void init( ) throws ServletException {
        getStudentList.add(new Student(1, "Hieu", "Hieu@gmail.com"));
        getStudentList.add(new Student(2, "Giang", "Giang@gmail.com"));
        getStudentList.add(new Student(3, "Long", "Long@gmail.com"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            getStudents(req, resp);
        } else {
            switch (action) {
                case "delete":
                    getStudentList.remove(findById(Integer.parseInt(req.getParameter("id"))));
                    break;
                case "edit":
                    updateStudents(req, resp);
                    break;
                default:
                    break;
            }
            getStudents(req, resp);
        }
    }

    public void getStudents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("students", getStudentList);
        req.getRequestDispatcher("new/ListStudent.jsp").forward(req, resp);
    }
    public void updateStudents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        Student student1 = findById(id);
        RequestDispatcher dispatcher;
        if (student1 == null) {
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            req.setAttribute("students", getStudentList);
            dispatcher= req.getRequestDispatcher("new/update.jsp");
        }try {
            dispatcher.forward(req, resp);
        }catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        switch (action) {
            case "submit":
                String name = req.getParameter("name");
                String email = req.getParameter("email");
                int id = getnewId();
                getStudentList.add(new Student(id, name, email));
                getStudents(req, resp);
                break;
            case "update":
                updateStudent(req,resp);
            default:
                break;
        }
    }
    public void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        Student studentToUpdate = findById(id);

        if (studentToUpdate == null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("error-404.jsp");
            dispatcher.forward(req, resp);
            return;
        }

        studentToUpdate.setName(name);
        studentToUpdate.setEmail(email);


        resp.sendRedirect(req.getContextPath() + "/Home");
    }

    public int getnewId() {
        int maxid = 0;
        for (Student s : getStudentList) {
            if (s.getId() > maxid) {
                maxid = s.getId();
            }
        }
        return maxid + 1;
    }

    public Student findById(int id) {
        for (Student s : getStudentList) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
}
