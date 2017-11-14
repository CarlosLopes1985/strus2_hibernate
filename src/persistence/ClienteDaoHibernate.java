package persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Cliente;
import jdbc.ClienteDao;

public class ClienteDaoHibernate {
	
	Session session;
	Criteria criteria;
	Query query;
	Transaction transaction;
	
	 public void create(Cliente c)throws Exception{
		 session = HibernateUtil.getSessionFactory().openSession();
           transaction = session.beginTransaction();  	
		     session.save(c);
           transaction.commit();
		 session.close();
	 }
	 //Alterar
	 public void update(Cliente c)throws Exception{
		 session = HibernateUtil.getSessionFactory().openSession();
           transaction = session.beginTransaction();  	
		     session.update(c);
           transaction.commit();
		 session.close();
	 }
	 //Excluir
	 public void delete(Cliente c)throws Exception{
		 session = HibernateUtil.getSessionFactory().openSession();
           transaction = session.beginTransaction();  	
		     session.delete(c);
           transaction.commit();
		 session.close();
	 }
	 //Retorna o Cliente Pelo Código ...

	 public Cliente findByCode(Integer code){
		 session = HibernateUtil.getSessionFactory().openSession();
//		    query = session.createQuery("from Cliente c where idCliente=:param1");
//		    query.setParameter("param1", code);
//		  Cliente resp = (Cliente) query.uniqueResult();  
//ou
		 Cliente resp = (Cliente) session.get(Cliente.class, code);
		 session.close();
		 return resp;
	 }
	 
	 
	 
	 public List<Cliente> findAll(){
		 session = HibernateUtil.getSessionFactory().openSession();
		     //List <Cliente>lst = session.createQuery("from Cliente").list();
		      List <Cliente> lst = session.getNamedQuery("Cliente.findAll").list();
		  session.close();
		  return lst;
	 }
	 
	 public static void main(String[] args) {
		
		 try{
//		  Cliente c1 =new Cliente(null,"capitao america","america@gmail.com","m");
//		  Cliente c2 =new Cliente(null,"vingadores","hulk@gmail.com","m");
//		  Cliente c3 =new Cliente(null,"thor","thor@gmail.com","m");
//		  
//		  ClienteDaoHibernate cd = new ClienteDaoHibernate();
//		      cd.create(c1);
//		      cd.create(c2);
//		      cd.create(c3);
		 new ClienteDaoHibernate().
			       create(new Cliente(null,"luciana","luaiana@gmail.com","f"));
			 new ClienteDao().backup(); //instancia direto pelo Construtor ...
		    System.out.println("Backup ...");
		    
		    
		 }catch(Exception ex){
            System.out.println("Error :" + ex.getMessage());
            ex.printStackTrace();
		 }

		 
	}
	 

}






