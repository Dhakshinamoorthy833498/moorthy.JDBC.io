package com.cognizant.moviecruiser.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MoviesDao;
import com.cognizant.moviecruiser.dao.MoviesDaoCollectionImpl;
import com.cognizant.moviecruiser.model.Movies;

/**
 * Servlet implementation class ShowEditMoviesServlet
 */
@WebServlet("/ShowEditMovies")
public class ShowEditMoviesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowEditMoviesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		Long moviesId = Long.parseLong(request.getParameter("id"));
		Movies movies = moviesDao.getMovies(moviesId);
		request.setAttribute("movies", movies);
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit-movies.jsp");
		dispatcher.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
