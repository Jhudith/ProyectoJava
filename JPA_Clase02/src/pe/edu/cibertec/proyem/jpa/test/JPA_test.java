package pe.edu.cibertec.proyem.jpa.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import pe.edu.cibertec.proyem.jpa.domain.Departamento;
import pe.edu.cibertec.proyem.jpa.domain.Empleado;

public class JPA_test {

	private EntityManager manager;
	
	public JPA_test(EntityManager manager){
		this.manager=manager;
		
	}
	
	public static void main(String [] args){
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("persistenceUni");
		
		EntityManager manager = factory.createEntityManager();
		JPA_test test = new JPA_test(manager);

		EntityTransaction tx=manager.getTransaction();
		tx.begin();
		
		test.crearEmpleados();
		
		test.listarEmpleados();
		test.crearDepartamento();
		test.listarDepartamento();
		test.crearEmpleados2();
		test.listarEmpleados2();
		tx.commit();
	}
	

	private void listarEmpleados2() {
	
		List<Empleado> resultList = manager.createQuery("Select a From Empleado a", Empleado.class).getResultList();
		System.out.println("nro de empleados:" + resultList.size());
		for (Empleado next : resultList) {
			System.out.println("siguiente empleado: " + next);
		}
	}

	private void crearEmpleados2() {
		
		Departamento java = new Departamento("Java");
		
		Empleado emp1=new Empleado("Bob");
		Empleado emp2=new Empleado("Mike");
			
			//List<Empleado> empleado=new ArrayList<Empleado>();
			//empleados.add(emp1);
			//empleados.add(emp2);
			java.setEmpleado(Arrays.asList(emp1,emp2));
			manager.persist(java);
		}
	

	private void listarDepartamento() {
	
		
		List<Empleado> resultList = manager.createQuery("Select a From Empleado a", Empleado.class).getResultList();
		System.out.println("nro de empleados:" + resultList.size());
		for (Empleado next : resultList) {
			System.out.println("siguiente empleado: " + next);
		}
	}

	private void crearDepartamento() {
		
		Departamento departamento = new Departamento("Java");
		manager.persist(departamento);

		manager.persist(new Empleado("Bob",departamento));
		manager.persist(new Empleado("Mike",departamento));

	}

	private void listarEmpleados() {
		List<Empleado> resultList = manager.createQuery("Select a From Empleado a", Empleado.class).getResultList();
		System.out.println("nro de empleados:" + resultList.size());
		for (Empleado next : resultList) {
			System.out.println("siguiente empleado: " + next);
		}
	}

		
	

	private void crearEmpleados() {
		Departamento departamento = new Departamento("Java");
		manager.persist(departamento);

		manager.persist(new Empleado("Bob",departamento));
		manager.persist(new Empleado("Mike",departamento));

	}


		
	}

