package input_Test;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Test;

import input.Lanceur;

public class Input_Parser_Test {
	
	@Test
	public void testEthernet() throws IOException {
		Lanceur la = new Lanceur("data/exemple7.txt");
		assertTrue(la.ethernetToString().equals("Destination: ff:ff:ff:ff:ff:ff\r\n"
				+ "Source: 00:08:74:4f:36:23\r\n"
				+ "Ethernet Type: IPV4 (0x0800)"));
	}
	
	@Test
	public void testIP() throws FileNotFoundException, IOException {
		Lanceur la = new Lanceur("data/exemple7.txt");
		assertTrue(la.ipHToString().equals("Version: 4 (0x4)\r\n"
				+ "Taille de l'entete (aucune option specifiée): 20 (0x5)\r\n"
				+ "TOS: Non Utilisé dans notre cadre: 0x00\r\n"
				+ "Taille Total du packet IP: 328 octet (0x0148)\r\n"
				+ "Identifiant: 0xb310 (45840) \r\n"
				+ "Flags\r\n"
				+ "    Champ Réservé: 0\r\n"
				+ "    Champ DF: 0\r\n"
				+ "    Champ MF: 0\r\n"
				+ "Offset : 0, Paquet non Fragmenté\r\n"
				+ "TTL (Time to live): 128| max 255 \r\n"
				+ "Protocol : 17 (UDP) (0x11)\r\n"
				+ "Checksum (Non verifiable): 0x8695\r\n"
				+ "Adresse IP Source: 0.0.0.0\r\n"
				+ "Adresse IP Destination: 255.255.255.255"));
	}
	
	/*public static void main(String args[]) throws IOException{
		String path = "data/exemple4.txt";
		Lanceur la=new Lanceur(path);
		String [][] temp=Input_Parser.parse(path);
		System.out.println("\n");
		System.out.println(temp.length);
		System.out.println("\n");
		System.out.println(la.brutToString());
		//System.out.println(la.brutToString());
		String[] tmp=Input_Parser.split(res);
		String[] ethernet=Input_Parser.ethernetData(tmp);
		System.out.println("\n\nTrame Analysé:");
		System.out.println("\n\nEthernet:");
		System.out.println(Input_Parser.ethernetToString(ethernet));
		String[] ipH=Input_Parser.ipHData(tmp);
		System.out.println("\nIP Header:");
		System.out.println(Input_Parser.ipHToString(ipH));
		
		System.out.println("\n\nTRAME 2:\n");
		res=Input_Parser.parse("data/exemple2.txt");
		System.out.println("Trame brut "+res);
		tmp=Input_Parser.split(res);
		ethernet=Input_Parser.ethernetData(tmp);
		System.out.println("\n\nTrame Analysé:");
		System.out.println("\n\nEthernet:");
		System.out.println(Input_Parser.ethernetToString(ethernet));
		ipH=Input_Parser.ipHData(tmp);
		System.out.println("\nIP Header:");
		System.out.println(Input_Parser.ipHToString(ipH));
	}*/
	
}
