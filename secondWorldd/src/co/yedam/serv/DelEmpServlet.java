package co.yedam.serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.EmpDAO;

@WebServlet("/delEmpServlet")
public class DelEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DelEmpServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String delId = request.getParameter("delId");
		
		EmpDAO dao = new EmpDAO();
		if(dao.deleteEmployee(delId) != -1) {
			// 처리한 결과를 json 타입으로 넘겨주기
			// {"returnCode":"success", "id":delId}
			out.println("{\"returnCode\":\"success\", \"id\":"+delId+"}");
		} else {
			// {"returnCode":"fail"}
			out.println("{\"returnCode\":\"fail\"}");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}