package utng.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utng.dom.ExperimentDOM;
import utng.model.Experiment;

/**
 * Servlet implementation class ExperimentController
 */
@WebServlet("/ExperimentController")
public class ExperimentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Experiment experiment;
	private List<Experiment> experiments;
	private ExperimentDOM experimentDOM; 
	private List<String> ids = new ArrayList<String>();
	
    /**
     * 
     * @see HttpServlet#HttpServlet()
     */
    public ExperimentController() {
        super();
        experiment = new Experiment();
        experiments = new ArrayList<Experiment>();
		experimentDOM = new ExperimentDOM();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("btn_save") != null) {
				experiment.setTitle(request.getParameter("title"));
				experiment.setDescription(request.getParameter("description"));
				experiment.setCreationDate(request.getParameter("creationDate"));
				experiment.setModificationDate(request.getParameter("modificationDate"));

			if (experiment.getId() == "") {
				String newId = "Exp"+String.format("%05d", 1);
				experiment.setId(newId);
				if(experiments.size()>0) {
					ids.clear();
					for(Experiment e: experiments) {
						ids.add(e.getId());
					}
					for(int i=0;i<=ids.size();i++) {
						newId = "Exp"+String.format("%05d", i+1);
						if(!ids.contains(newId)) {
							experiment.setId(newId);
							break;
						}
					}
				}
				
				experimentDOM.add(experiment);
			} else {
				experimentDOM.update(experiment);
			}
			
			experiments = experimentDOM.getExperiments();
			request.setAttribute("experiments", experiments);
			request.getRequestDispatcher("experiment_list.jsp").forward(request, response);
		} else if (request.getParameter("btn_new") != null) {
			experiment = new Experiment();
			request.getRequestDispatcher("experiment_from.jsp").forward(request, response);
		}else if(request.getParameter("btn_edit")!=null) {
			try {
				String id = request.getParameter("id");
				experiment = experimentDOM.findById(id);
			}catch(Exception e) {
				experiment = new Experiment();
			}
			request.setAttribute("experiment", experiment);
			request.getRequestDispatcher("experiment_from.jsp").forward(request, response);
		}else if(request.getParameter("btn_delete")!=null) {
			try {
				String id = request.getParameter("id");
				experimentDOM.delete(id);
				experiments = experimentDOM.getExperiments();
			}catch(Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("experiments", experiments);
			request.getRequestDispatcher("experiment_list.jsp").forward(request, response);
		}else {
			experiments = experimentDOM.getExperiments();
			request.setAttribute("experiments", experiments);
			request.getRequestDispatcher("experiment_list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}