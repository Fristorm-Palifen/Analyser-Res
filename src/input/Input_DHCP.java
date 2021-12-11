package input;

import java.util.concurrent.TimeUnit;

/**
 * Cette classe permet de Recupérer les options DHCP
 * @author Fristorm, Sorabush 
 */
public class Input_DHCP {
	/**
	  * tableau contenant l'integraliter des options DHCP
	  */
	private static final String[] tab= {"Pad","Subnet Mask","Time Offset","Router","Time Server","Name Server","Domaine Server","Log Server","Quotes Server","LPR Server","Impress Server","RLP Server","Hostname","Boot File Size","Merit Dump File","Domain Name","Swap Server","Root Path","Extension File","Forward On/Off","SrcRte On/Off","Policy Filter","Max DG Assembly","Default IP TTL","MTU Timeout","MTU Plateau","MTU Interface","MTU Subnet","Broadcast Address","Mask Discovery","Mask Supplier","Router Discovery","Router Request","Static Route","Trailers","ARP Timeout","Ethernet","Default TCP TTL","Keepalive Time","Keepalive Data","NIS Domain","NIS Servers","NTP Servers","Vendor Specific","NETBIOS Name Srv","NETBIOS Dist Srv","NETBIOS Node Type","NETBIOS Scope","X Window Font","X Window Manager","Address Request","Address Time","Overload","DHCP Msg Type","DHCP Server Id","Parameter List","DHCP Message","DHCP Max Msg Size","Renewal Time","Rebinding Time","Class Id","Client Id","NetWare/IP Domain","NetWare/IP Option","NIS-Domain-Name","NIS-Server-Addr","Server-Name","Bootfile-Name","Home-Agent-Addrs","SMTP-Server","POP3-Server","NNTP-Server","WWW-Server","Finger-Server","IRC-Server","StreetTalk-Server","STDA-Server","User-Class","Directory Agent","Service Scope","Rapid Commit","Client FQDN","Relay Agent Information","iSNS","REMOVED/Unassigned","NDS Servers","NDS Tree Name","NDS Context","BCMCS Controller Domain Name list","BCMCS Controller IPv4 address option","Authentication","client-last-transaction-time option","associated-ip option","Client System","Client NDI","LDAP","REMOVED/Unassigned","UUID/GUID","User-Auth","GEOCONF_CIVIC","PCode","TCode","REMOVED/Unassigned","REMOVED/Unassigned","REMOVED/Unassigned","REMOVED/Unassigned","REMOVED/Unassigned","REMOVED/Unassigned","IPv6-Only Preferred","OPTION_DHCP4O6_S46_SADDR","REMOVED/Unassigned","Unassigned","Netinfo Address","Netinfo Tag","DHCP Captive-Portal","REMOVED/Unassigned","Auto-Config","Name Service Search","Subnet Selection Option","Domain Search","SIP Servers DHCP Option","Classless Static Route Option","CCC","GeoConf Option","V-I Vendor Class","V-I Vendor-Specific Information","Removed/Unassigned","Removed/Unassigned","PXE - undefined (vendor specific)","PXE - undefined (vendor specific)","PXE - undefined (vendor specific)","PXE - undefined (vendor specific)","PXE - undefined (vendor specific)","PXE - undefined (vendor specific)","PXE - undefined (vendor specific)","PXE - undefined (vendor specific)","OPTION_PANA_AGENT","OPTION_V4_LOST","OPTION_CAPWAP_AC_V4","OPTION-IPv4_Address-MoS","OPTION-IPv4_FQDN-MoS","SIP UA Configuration Service Domains","OPTION-IPv4_Address-ANDSF","OPTION_V4_SZTP_REDIRECT","GeoLoc","FORCERENEW_NONCE_CAPABLE","RDNSS Selection","OPTION_V4_DOTS_RI","OPTION_V4_DOTS_ADDRESS","Unassigned","TFTP server address","status-code","base-time","start-time-of-state","query-start-time","query-end-time","dhcp-state","data-source","OPTION_V4_PCP_SERVER","OPTION_V4_PORTPARAMS","Unassigned","OPTION_MUD_URL_V4","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Etherboot (Tentatively Assigned - 2005-06-23)","IP Telephone (Tentatively Assigned - 2005-06-23)","Etherboot (Tentatively Assigned - 2005-06-23)","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","PXELINUX Magic","Configuration File","Path Prefix","Reboot Time","OPTION_6RD","OPTION_V4_ACCESS_DOMAIN","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Unassigned","Subnet Allocation Option","Virtual Subnet Selection (VSS) Option","Unassigned","Unassigned","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","Reserved (Private Use)","End"};
	/**
	  * tableau contenant l'integraliter des Type Hardware
	  */
	private static final String[] hardwaret= {"Unknown","Ethernet","Experimental Ethernet","Amateur Radio AX.25","Proteon ProNET Token Ring","Chaos","IEEE 802","ARCNET","Hyperchannel","Lanstar","Autonet Short Address","LocalTalk","LocalNet (IBM PCNet or SYTEK LocalNET)","Ultra link","SMDS","Frame Relay","ATM, Asynchronous Transmission Mode","HDLC","Fibre Channel","ATM, Asynchronous Transmission Mode","Serial Line","ATM, Asynchronous Transmission Mode","MIL-STD-188-220","Metricom","IEEE 1394.1995","MAPOS","Twinaxial","EUI-64","HIPARP","IP and ARP over ISO 7816-3","ARPSec","IPsec tunnel","Infiniband","CAI, TIA-102 Project 25 Common Air Interface","Wiegand Interface","Pure IP"};
	/**
	 * Permet d'obtenir l'option par rapport à son numéro
	 * @param val: Le numero de l'option
	 * @return L'option en String
	 */
	public static String getOption(int val) {
		return tab[val];
	}
	
	/**
	 * Permet d'obtenir le type Hardware par rapport a son numéro
	 * @param val: Le numero du type
	 * @return Le type hardware en String
	 */
	public static String getHardware(int val) {
		return hardwaret[val];
	}
	
	/**
	 * Permet de transformer un Hex en Ascii
	 * @param hexStr le ASCII encodé en hex
	 * @return Le String ASCII
	 */
	public static String hexToAscii(String hexStr) {
	    StringBuilder output = new StringBuilder("");
	    
	    for (int i = 0; i < hexStr.length(); i += 2) {
	        String str = hexStr.substring(i, i + 2);
	        output.append((char) Integer.parseInt(str, 16));
	    }
	    
	    return output.toString();
	}
	
	/**
	 * Permet de donner le tableau total des types
	 * @return le tableau de types
	 */
	public static String[] getTab() {
		return tab;
	}
	
	/**
	 * Permet de transformer les secondes en jours
	 * @param sec les secondes en int
	 * @return Le nombre de jour en int
	 */
	public static int secToDays(int sec) {
		return (int)TimeUnit.SECONDS.toDays(sec);
	}
	
}
