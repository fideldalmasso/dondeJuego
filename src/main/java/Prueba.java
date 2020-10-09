import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import daos.LugarRealizacionDao;
import dominio.Competencia;
import dominio.Deporte;
import dominio.LugarRealizacion;
import dominio.Pair;
import dominio.Participante;
import dominio.RenglonTabla;
import dominio.Usuario;
import dtos.CompetenciaDTO;
import gestores.GestorCompetencia;

public class Prueba {
	private static SessionFactory factory; 
	   public static void main(String[] args) {
	      /*
	      try {
	         factory = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	      */
	      Pair p = new Pair(1,1,1);
	      List<Pair> lp = new ArrayList<Pair>();
	      lp.add(p);
	     
	      GestorCompetencia gc = new GestorCompetencia();
	      Deporte dep = gc.crearDeporte("Polo");
	      
	      Set<Deporte> deportes = new HashSet<Deporte>();
	      deportes.add(dep);
	      LugarRealizacionDao ld =  new LugarRealizacionDao();
	      ld.saveLugarRealizacion(new LugarRealizacion("Nuevo Gasometro","Estadio temporal",null,deportes));
	      
	      CompetenciaDTO c = new CompetenciaDTO("Fede",dep.getId(),lp,"Liga","Vale todo",false,0,3,1);
	      
	      System.out.println(gc.crearCompetencia(c).getId());
	     
	   }
	   
	   /* Method to CREATE an employee in the database */
	   public Integer addRt(){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      Integer depId = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Competencia rt = new Competencia();
	         rt.setNombre("Basket");
	         depId = (Integer) session.save(rt); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return depId;
	   }
	   
	   /* Method to  READ all the employees */
	   public void listEmployees( ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         List employees = session.createQuery("FROM Employee").list(); 
	         for (Iterator iterator = employees.iterator(); iterator.hasNext();){
	            Employee employee = (Employee) iterator.next(); 
	            System.out.print("First Name: " + employee.getFirstName()); 
	            System.out.print("  Last Name: " + employee.getLastName()); 
	            System.out.println("  Salary: " + employee.getSalary()); 
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   /* Method to UPDATE salary for an employee */
	   public void updateEmployee(Integer EmployeeID, int salary ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
	         employee.setSalary( salary );
			 session.update(employee); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   /* Method to DELETE an employee from the records */
	   public void deleteEmployee(Integer EmployeeID){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
	         session.delete(employee); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
}
