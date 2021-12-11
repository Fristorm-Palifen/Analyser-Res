package input;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Cette classe permet de controller Input_Parser
 * @author Fristorm, Sorabush 
 */
public class Lanceur {
	
	private final String[][] datas;
	
	private String [] select;
	
	private int actuel;
	
	public Lanceur(String path) throws IOException,FileNotFoundException {
		this.datas=Input_Parser.parse(path);
		this.setectData(0);
	}
	
	public void setectData(int choix) throws RuntimeException {
		if(choix< datas.length && choix>=0) {
			select=datas[choix];
			actuel=choix;
		}else {
			//throw new RuntimeException("Aucune trame correspond à cette valeur");
		}
		
	}
	
	public String ethernetToString() {
		try {
			return Input_Parser.ethernetToString(Input_Parser.ethernetData(select));
		}catch (Exception e) {
			//e.printStackTrace();
			//e.getMessage();
			return "Ethernet Error parsing "+e.getMessage();
		}
	}
	
	public String ipHToString() {
		try {
			StringBuilder res=new StringBuilder().append(Input_Parser.ipHToString(Input_Parser.ipHData(select)));
			if (Input_Parser.getIpOptTaille(Input_Parser.ipHData(select))==0) {
				return res.toString();
			}else if (Input_Parser.getIpOptTaille(Input_Parser.ipHData(select))>0) {
				return res.toString()+Input_Parser.ipOptToString(Input_Parser.ipOptData(select, Input_Parser.getIpOptTaille(Input_Parser.ipHData(select))), Input_Parser.getIpOptTaille(Input_Parser.ipHData(select)));
			}else {
				return res.toString()+"\noption Invalide\n";
			}
			
		}catch (Exception e) {
			//e.printStackTrace();
			//e.getMessage();
			return "IP Error Parsing "+e.getMessage();
		}
	}
	
	public String brutToString() {
		String res ="";
		for (int i = 0;i<select.length;i++) {
			res=res+select[i]+" ";
		}
		return res;
	}
	public String protocoleToString() {
		try{
			if (Input_Parser.protocolenameToString(Input_Parser.ipHData(select)).equals("UDP")) {
				return Input_Parser.protocoleHToString(Input_Parser.protocoleHData(select, Input_Parser.protocoleHStartByIP(Input_Parser.ipHData(select))));
			}else {
				return "Le Protocole: \""+Input_Parser.protocolenameToString(Input_Parser.ipHData(select))+"\" n'est pas pris en charge par ce projet!";
			}
		}catch (Exception e) {
			//e.printStackTrace();
			//e.getMessage();
			return "Error Parsing du protocole "+e.getMessage();
		}
		
	}
	
	public String protocolNameToString() {
		try{
			return Input_Parser.protocolenameToString(Input_Parser.ipHData(select));
		}catch (Exception e) {
			//e.printStackTrace();
			//e.getMessage();
			return "Unknown";
		}
	}
	
	public String dNameToString() {
		try{
			return Input_Parser.dNameToString(Input_Parser.protocoleHData(select, Input_Parser.protocoleHStartByIP(Input_Parser.ipHData(select))));
		}catch (Exception e) {
			//e.printStackTrace();
			//e.getMessage();
			return "Unknown D";
		}
	}
	
	public String dToString() {
		try{
			if (this.dNameToString().equals("DHCP")) {
				return Input_Parser.dhcpToString(Input_Parser.dhcpData(select, Input_Parser.dStartByIP(Input_Parser.ipHData(select))),Input_Parser.udpLong(Input_Parser.protocoleHData(select, Input_Parser.protocoleHStartByIP(Input_Parser.ipHData(select)))));
			}else if (this.dNameToString().equals("DNS")) {
				return Input_Parser.dnsToString(Input_Parser.dnsData(select, Input_Parser.dStartByIP(Input_Parser.ipHData(select))),Input_Parser.udpLong(Input_Parser.protocoleHData(select, Input_Parser.protocoleHStartByIP(Input_Parser.ipHData(select)))));
			}else {return "Un Protocole Non Pris en charge est Détecter!";}
		}catch (Exception e) {
			//e.printStackTrace();
			//e.getMessage();
			return "Error Parsing de: "+this.dNameToString()+" "+e.getMessage();
		}
		
	}
	
	public int nbChoix() {
		
		return datas.length;
	}
	
	public int getActuel() {
		return actuel;
	}
}
