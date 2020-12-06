package aplicacaoConsole;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import modelo.Cliente;
import modelo.Funcionario;
import modelo.Produto;
import modelo.Venda;




public class Cadastrar {
	private static EntityManager manager;
	
	public Cadastrar(){
		Cliente c1;
		Funcionario f1;
		Venda v1;
		Produto p1;
		
		// INSTANCIAÇÃO DO MANAGER--------------------------------
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("projeto2-eclipselink-postgres");
				//Persistence.createEntityManagerFactory("agenda-eclipselink-mysql");
//				Persistence.createEntityManagerFactory("agenda-hibernate-postgres");
				//Persistence.createEntityManagerFactory("agenda-hibernate-mysql");

		manager = factory.createEntityManager();


		//	PERSISTÊNCIA DOS OBJETOS NO BANCO-----------------------
		
		manager.getTransaction().begin();
		c1 = new Cliente("Maria","122222","rua tal","maria@gmail.com","124578");
		manager.persist(c1);
		manager.getTransaction().commit();
		System.out.println("cadastrou "+c1);

		manager.getTransaction().begin();
		c1 = new Cliente("Pedro","122222","rua tal","pedro@gmail.com","124578");
		manager.persist(c1);	
		manager.getTransaction().commit();
		System.out.println("cadastrou "+c1);

		manager.getTransaction().begin();
		c1 = new Cliente("Paulo","122222","rua tal","p@gmail.com","124578");
		manager.persist(c1);	
		manager.getTransaction().commit();
		System.out.println("cadastrou "+c1);


//		PERSISTÊNCIA DOS OBJETOS NO BANCO FUNCIONÁRIO-----------------------
			manager.getTransaction().begin();
			f1 = new Funcionario("122225","Joao Pedro",25,"joao@gmail.com");
			manager.persist(f1);
			manager.getTransaction().commit();
			System.out.println("cadastrou "+f1);
			
			manager.getTransaction().begin();
			f1 = new Funcionario("122228","Maria Clara",20,"maria@gmail.com");
			manager.persist(f1);
			manager.getTransaction().commit();
			System.out.println("cadastrou "+f1);
			
			manager.getTransaction().begin();
			f1 = new Funcionario("122229","Clara",30,"clara@gmail.com");
			manager.persist(f1);
			manager.getTransaction().commit();
			System.out.println("cadastrou "+f1);

		
//PERSISTÊNCIA DOS OBJETOS NO BANCO VENDA -----------------------
				manager.getTransaction().begin();
				v1 = new Venda("122225","Joao Pedro","16-11-2020",20.0);
				manager.persist(v1);
				manager.getTransaction().commit();
				System.out.println("cadastrou "+v1);
				
				manager.getTransaction().begin();
				v1 = new Venda("122228","Maria Clara","17-11-2020",30.0);
				manager.persist(v1);
				manager.getTransaction().commit();
				System.out.println("cadastrou "+v1);


//PERSISTÊNCIA DOS OBJETOS NO BANCO Produto -----------------------
				manager.getTransaction().begin();
				p1 = new Produto("Camisa",50,"Camisa Preta",20.0);
				manager.persist(p1);
				manager.getTransaction().commit();
				System.out.println("cadastrou "+p1);
				
				manager.getTransaction().begin();
				p1 = new Produto("Camisa Branca",50,"Camisa Branca etc",20.0);
				manager.persist(p1);
				manager.getTransaction().commit();
				System.out.println("cadastrou "+p1);
				
				manager.getTransaction().begin();
				p1 = new Produto("Vestido",100,"Vestido etc",30.0);
				manager.persist(p1);
				manager.getTransaction().commit();
				System.out.println("cadastrou "+p1);
				
				
		manager.close();
		factory.close();

		System.out.println("fim do programa");
	}

//
	//=================================================
	public static void main(String[] args) {
		new  Cadastrar();
	}


}
