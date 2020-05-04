package it.polito.tdp.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.GispICT.Farmaco;
import it.polito.tdp.GispICT.FarmacoNelReparto;
import it.polito.tdp.GispICT.Reparto;

public class MartaDAO {

	public List<Reparto>listaReparti(){
		String sql = "SELECT NameWard, IDWard \n" + 
				"FROM magazzinoreparti \n" + 
				"GROUP BY IDWard, NameWard";

		
		List<Reparto> result = new ArrayList<Reparto>();
		
		Connection conn = DBConnectionMarta.getConnection() ;
		
		try {
			PreparedStatement st = conn.prepareStatement(sql) ;
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				result.add(new Reparto(res.getString("NameWard"), res.getInt("IDWard"))) ;
			}
			
			conn.close();
			return result ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}
	}

	public List<Farmaco> listaFarmaci() {
		String sql = "SELECT IDPharma,Name,Conservation,Link,Reorder " + 
				"FROM farmaci ";

		
		List<Farmaco> result = new ArrayList<Farmaco>();
		
		Connection conn = DBConnectionMarta.getConnection() ;
		
		try {
			PreparedStatement st = conn.prepareStatement(sql) ;
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				result.add(new Farmaco(res.getInt("IDPharma"), res.getString("Name"), res.getInt("Conservation"),
						res.getString("Link"),res.getInt("Reorder"))) ;
			}
			
			conn.close();
			return result ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}
	}

	public void aggiungiNuovoFarmaco(FarmacoNelReparto farmacoDaInserire) {
		String sql = "INSERT INTO magazzinoreparti (IDWard,NameWard,IDPharma,NamePharma,Quantity,ExpDate) " + 
				"VALUES (?,?,?,?,?,?) ";

		
		Connection conn = DBConnectionMarta.getConnection() ;
		
		try {
			PreparedStatement st = conn.prepareStatement(sql) ;
			
			st.setInt(1, farmacoDaInserire.getRID());
			st.setString(2, farmacoDaInserire.getNomeR());
			st.setInt(3,farmacoDaInserire.getFID());
			st.setString(4,farmacoDaInserire.getNomeF());
			st.setInt(5, farmacoDaInserire.getQuantita());
			st.setDate(6, Date.valueOf(farmacoDaInserire.getScadenza()));
			st.executeUpdate();
			System.out.println("aggiunto");
			conn.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}

	public String getElencoScadenza(Reparto reparto) {
		String result="";
		
		String sql = "SELECT IDPharma,NamePharma, ExpDate " + 
				"FROM magazzinoreparti " + 
				"WHERE IDWard=? AND ExpDate>'2020-06-30' AND ExpDate < '2020-07-31' ";
	
		Connection conn = DBConnectionMarta.getConnection() ;
		
		try {
			PreparedStatement st = conn.prepareStatement(sql) ;
			st.setInt(1, reparto.getRID());
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				result+=" ["+res.getInt("IDPharma")+"] "+res.getString("NamePharma")+" - Exp: "+res.getDate("ExpDate")+"\n";
			}
			
			conn.close();
			return result ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}
	}
}
