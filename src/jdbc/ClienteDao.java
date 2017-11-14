package jdbc;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ClienteDao extends Dao {
	
	     //Executar o Backup .... Transformando em Excel ...
	
	public void backup() throws Exception{
		open();
		
		String msg2=    "  select idCliente,nome,email,sexo   "
                      + "  Into Outfile 'c:/temp/ExcelClientedc" + 
			new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()) + ".csv'" 
				      + "  fields terminated  BY ';' "
                      + "  Lines  terminated  BY '\n'  "
				      + "  from cliente ";
				
		 Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				                               ResultSet.CONCUR_UPDATABLE);
		  stmt1.execute(msg2);
		 stmt1.close();
		 close();
	}
	
	
	
	
	

}
