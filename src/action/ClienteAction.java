package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Cliente;
import persistence.ClienteDaoHibernate;

public class ClienteAction extends ActionSupport  implements ModelDriven<Cliente>{
	//ClienteAction herdar ActionSupport 
	//web.xml (alterar)
	//struts.xml
	//jar
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	
	public ClienteAction() {
	   cliente = new Cliente();
	}
	
	@Override
	public Cliente getModel() {
		return cliente;
	}
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	public String cadastrar(){
		HttpServletRequest request = (HttpServletRequest)
		  ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);

		ClienteDaoHibernate cd = new ClienteDaoHibernate();
	         try{
	          cd.create(cliente); 
	                            //grava
	        	                 //limpa os dados do Cliente
	          cliente = new Cliente();
	          request.setAttribute("msg", "Dados Gravados do Cliente");
	         return SUCCESS;	
          }catch(Exception ex){
	         request.setAttribute("msg", "error :" + ex.getMessage());
	         return ERROR;
	      }
	}
	


	
}
