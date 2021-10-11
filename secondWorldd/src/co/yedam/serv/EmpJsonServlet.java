package co.yedam.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.EmpDAO;
import co.yedam.common.Employee;

@WebServlet("/empJsonServlett")
public class EmpJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EmpJsonServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmpList();
		
		//{"name":"Hongkildong", "age":15, "score":80}
		//out.println("{\"name\":\"Hongkildong\", \"age\":15, \"score\":80}");
		//{"empId":"?", "lname":"?","email":"?", "hiteDate":"?", "job":"?"}
		int cnt = 0, lastCnt = list.size();
		
		out.println("[");
		for (Employee emp : list ) {
			out.println("{\"empId\":\""+emp.getEmployeeId()
			+"\", \"lname\":\""+emp.getLastName()
			+"\", \"email\":\""+ emp.getEmail()
			+"\", \"hiteDate\":\""+emp.getHireDate()
			+"\", \"job\":\""+emp.getJobId()+"\"}");
			//마지막 건수 (,)
			cnt++;
			if (cnt != lastCnt) {
				out.println(",");
			}
		}
		out.println("]");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}