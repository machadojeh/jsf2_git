package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;

@ManagedBean(name = "user")
@SessionScoped
public class UserBean {

	private String name = "";
	private String password = "";
	private ArrayList<String> items = new ArrayList<String>();

	public UserBean() {
		super();
		items.add("Igor");
		items.add("Jesga");
		items.add("Nina");
	}

	public ArrayList<String> getItems() {
		return items;
	}

	public void setItems(ArrayList<String> items) {
		this.items = items;
	}

	public UserBean(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean testeTexto() {
		if (name.compareTo("mimimi") == 0)
			return true;
		return false;
	}

	public String getOla() {
		return "Ola " + name;
	}

	public String deleteRow(String value) {
		items.remove(value);
		return null;
	}

	public String conexao() {
		
		String retorno ="mimimi";

		Connection connection = null;
		try {

			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/jesga",
							"postgres", "123");
				PreparedStatement passwordQuery = connection
						//.prepareStatement("SELECT * FROM coiso WHERE atrib1 = ?");
				//passwordQuery.setString(1, "coiso1");
						.prepareStatement("SELECT * FROM coiso");
				
				ResultSet result = passwordQuery.executeQuery();

				while (result.next()){ 
					retorno+= ", " + result.getString("atrib1");
				}	
				connection.close();

		}catch (SQLException e) {
			return e.getMessage();
		}
		
		return retorno;
	}
}
