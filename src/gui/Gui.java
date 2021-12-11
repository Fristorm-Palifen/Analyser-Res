package gui;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.io.IOException;

import input.*;
import output.output_parser;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.UIManager;

/**
 * Cette classe permet de crée des interfaces plus poussée que son homologue "Question" | Version V1.0.2
 * @author Fristorm  
 */
public class Gui {

	private JFrame frmAnalyserReseau;
	private static Lanceur la;
	private static int val=0;

	/**
	 * Lance La fenetre et Appel Lanceur de Input et demande avant le path du fichier à analyser.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String path=Question.getrep("Donnez le Path du TXT (si rien n'est donnee alors un txt de demo sera charge)", "./data/exemple8.txt");
					//String path = "data/exemple6.txt"; //en mode editeur activer ce path pour eviter le crash parser gui
					try{
						la=new Lanceur(path);
						Gui window = new Gui(path);
						window.frmAnalyserReseau.setVisible(true);//a changer
					}catch (FileNotFoundException e) {
						Question.warn("Le fichier Specifier est introuvable, merci de relancer le programme en specifiant un fichier existant ou en prenant un fichier d'exemple contenue dans le dossier data.");
						val =1;
					}
					if (val==1) {
						val=0;
						main(args);
						return;
					}
					
				} catch (Exception e) {
					//e.printStackTrace();
					//e.getMessage();
					Question.warn(e.toString());
					Question.info("Veuillez relancer le programme en ayant verifier la ligne de l'erreur!");
				}
			}
			
		});
		
	}

	/**
	 * Initialise et Lance la fenetre graphique.
	 * @param path Le path du fichier
	 */
	public Gui(String path) {
		initialize(path);
	}

	/**
	 * Gère la fenetre écrite dans les differentes sections et changent dynamiquement les trames.
	 * @param path Le path du fichier
	 */
	private void initialize(String path) {
		frmAnalyserReseau = new JFrame();
		frmAnalyserReseau.setResizable(false);
		frmAnalyserReseau.setTitle("Analyseur Reseau ("+path+")");
		frmAnalyserReseau.setBounds(100, 100, 870, 502);
		frmAnalyserReseau.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmAnalyserReseau.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel Trame = new JPanel();
		tabbedPane.addTab("Choix de la Trame", null, Trame, null);
		SpringLayout sl_Trame = new SpringLayout();
		Trame.setLayout(sl_Trame);
		
		/*Choice choice = new Choice();
		sl_Trame.putConstraint(SpringLayout.NORTH, choice, 158, SpringLayout.NORTH, Trame);
		sl_Trame.putConstraint(SpringLayout.WEST, choice, 37, SpringLayout.WEST, Trame);
		sl_Trame.putConstraint(SpringLayout.SOUTH, choice, -271, SpringLayout.SOUTH, Trame);
		sl_Trame.putConstraint(SpringLayout.EAST, choice, -712, SpringLayout.EAST, Trame);
		for (int i=0;i<la.nbChoix();i++) {
			choice.add("Trame: "+(i+1));
		}
		Trame.add(choice);*/
		
		String [] choix= new String[la.nbChoix()+1];
		choix[0]="Non choisie";
		for (int i=1;i<la.nbChoix()+1;i++) {
			choix[i]="Trame N°"+(i);
		}
		
		JComboBox<String> comboBox = new JComboBox<>(choix);
		//JComboBox comboBox = new JComboBox();
		sl_Trame.putConstraint(SpringLayout.EAST, comboBox, -359, SpringLayout.EAST, Trame);
		((JLabel)comboBox.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
		Trame.add(comboBox);
		
		JScrollPane bigBrut = new JScrollPane();
		tabbedPane.addTab("Brut", null, bigBrut, null);
		
		JTextPane Brut = new JTextPane();
		bigBrut.setViewportView(Brut);
		Brut.setEditable(false);
		Brut.setText("Veuillez Charger la Trame de votre choix dans \"Choix de la Trame\"");
		
		JScrollPane bigEthernet = new JScrollPane();
		tabbedPane.addTab("Ethernet", null, bigEthernet, null);
		
		JTextPane Ethernet = new JTextPane();
		bigEthernet.setViewportView(Ethernet);
		Ethernet.setText("Veuillez Charger la Trame de votre choix dans \"Choix de la Trame\"");
		Ethernet.setEditable(false);
		
		JScrollPane bigIP = new JScrollPane();
		tabbedPane.addTab("IP", null, bigIP, null);
		
		JTextPane IP = new JTextPane();
		bigIP.setViewportView(IP);
		IP.setText("Veuillez Charger la Trame de votre choix dans \"Choix de la Trame\"");
		IP.setEditable(false);
		
		JScrollPane bigProtocol = new JScrollPane();
		tabbedPane.addTab("Protocole", null, bigProtocol, null);
		
		JTextPane Protocole = new JTextPane();
		bigProtocol.setViewportView(Protocole);
		Protocole.setEditable(false);
		Protocole.setText("Veuillez Charger la Trame de votre choix dans \"Choix de la Trame\"");
		
		JScrollPane biglesD = new JScrollPane();
		tabbedPane.addTab("DNS/DHCP", null, biglesD, null);
		
		JTextPane lesD = new JTextPane();
		biglesD.setViewportView(lesD);
		lesD.setText("Veuillez Charger la Trame de votre choix dans \"Choix de la Trame\"");
		lesD.setEditable(false);
		
		Button credits = new Button("Credits");
		sl_Trame.putConstraint(SpringLayout.NORTH, credits, 44, SpringLayout.SOUTH, comboBox);
		sl_Trame.putConstraint(SpringLayout.WEST, credits, 344, SpringLayout.WEST, Trame);
		sl_Trame.putConstraint(SpringLayout.EAST, credits, -399, SpringLayout.EAST, Trame);
		credits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Question.info("Ce programme a été codé par:\n Sorabush \n et\n Fristorm \n Pour Sorbonne Science UE LU3IN033 2021-2022");
			}
		});
		Trame.add(credits);
		
		JLabel lblNewLabel = new JLabel("Bienvenue sur L'analyseur réseau de Fristorm et Sorabush ");
		sl_Trame.putConstraint(SpringLayout.NORTH, comboBox, 97, SpringLayout.SOUTH, lblNewLabel);
		sl_Trame.putConstraint(SpringLayout.NORTH, lblNewLabel, 90, SpringLayout.NORTH, Trame);
		sl_Trame.putConstraint(SpringLayout.WEST, lblNewLabel, 199, SpringLayout.WEST, Trame);
		sl_Trame.putConstraint(SpringLayout.EAST, lblNewLabel, -197, SpringLayout.EAST, Trame);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Trame.add(lblNewLabel);
		
		JButton bprinter = new JButton("Analyse to file");
		sl_Trame.putConstraint(SpringLayout.NORTH, bprinter, 97, SpringLayout.SOUTH, lblNewLabel);
		sl_Trame.putConstraint(SpringLayout.WEST, comboBox, 28, SpringLayout.EAST, bprinter);
		sl_Trame.putConstraint(SpringLayout.EAST, bprinter, -567, SpringLayout.EAST, Trame);
		sl_Trame.putConstraint(SpringLayout.WEST, bprinter, 142, SpringLayout.WEST, Trame);
		bprinter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=comboBox.getSelectedIndex()-1;
				if (a==-1) {
					Question.info("Veuillez Choisir une trame dans le selecteur avant de cliquer sur Valider");
					return;
				}
				int b=la.getActuel();
				la.setectData(a);
				String pathi=Question.getrep("Mettez le path exacte du fichier a ecrire (par defaut nous ecrirons dans ./reseau_Trame_"+(a+1)+".txt)", "./reseau_Trame_"+(a+1)+".txt");
				String txt="";
				try {
					txt="Trame ne"+(a+1)+"\n\n Analyse de la trame: \n\n\nEthernet:\n\n"+la.ethernetToString()+"\n\n\nIP:\n\n"+la.ipHToString()+"\n\n\n"+la.protocolNameToString()+":\n\n"+la.protocoleToString()+"\n\n\n"+la.dNameToString()+":\n\n"+la.dToString()+"\n\n\nAnalyse faite par Fristorm et Sorabush.";
				}catch (Exception e2) {
					Question.warn("La trame selectionnée a un taux d'invalidité superieur au maximum toléré, analyse impossible.\n Merci de selectionner une autre trame ou de vous referer au readme pour avoir les indications de mise en forme de la trame !");
					System.out.println(e2.getMessage());
					la.setectData(b);
					return;
				}
				try{
					String wrep=output_parser.writer(pathi, txt);
					Question.info("Fichier ecrit dans: \""+wrep+"\"avec succes!");
				}catch (IOException s) {
					Question.warn("Erreur sur l'ecriture du fichier!");
				}
				la.setectData(b);
			}
		});
		bprinter.setBackground(UIManager.getColor("ToolTip.background"));
		Trame.add(bprinter);
		
		JButton bvalide = new JButton("Valider");
		sl_Trame.putConstraint(SpringLayout.NORTH, bvalide, 97, SpringLayout.SOUTH, lblNewLabel);
		sl_Trame.putConstraint(SpringLayout.WEST, bvalide, 30, SpringLayout.EAST, comboBox);
		sl_Trame.putConstraint(SpringLayout.EAST, bvalide, -182, SpringLayout.EAST, Trame);
		bvalide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=comboBox.getSelectedIndex()-1;
				if (a==-1) {
					Question.info("Veuillez Choisir une trame dans le selecteur avant de cliquer sur Valider");
					return;
				}
				la.setectData(a);
				try {
					IP.setText(la.ipHToString());
					Ethernet.setText(la.ethernetToString());
					Brut.setText(la.brutToString());
					Protocole.setText(la.protocoleToString());
					tabbedPane.setTitleAt(4,la.protocolNameToString());
					if (la.protocolNameToString().equals("UDP")) {
						tabbedPane.setTitleAt(5,la.dNameToString());
						lesD.setText(la.dToString());
					}else {
						tabbedPane.setTitleAt(5,"DNS/DCHP non present");
						lesD.setText("En "+la.protocolNameToString()+" Il n'y a pas de DNS ou DHCP!");
					}
					frmAnalyserReseau.setTitle("Analyseur Reseau ("+path+")  Trame N°:"+(la.getActuel()+1));
					Question.info("Trame: "+(a+1)+" Chargée avec succes!");}
				catch (Exception e1) {
					Question.warn("La trame selectionnee a un taux d'invalidité superieur au maximum toléré, analyse impossible.\n Merci de selectionner une autre trame ou de vous referer au readme pour avoir les indications de mise en forme de la trame !");
					//System.out.println(e1.getMessage());
				}}});
		bvalide.setBackground(UIManager.getColor("Tree.selectionBackground"));
		Trame.add(bvalide);
		
		
	}
}
