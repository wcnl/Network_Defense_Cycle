package com.opendaylight.settings;

import com.opendaylight.managers.VtnManager;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class SetVtns {
	public static void setVtn(String vtnName) throws JSONException {
		/* Vtn Test */
		JSONObject postData = new JSONObject();
		postData.put("description", vtnName + " Colored Virtual Network");
		postData.put("idleTimeout", "0");
		postData.put("hardTimeout", "0");

		VtnManager.setVtns(vtnName, postData);
	}

	public static void setVBridge(String vtnName, String vbridgeName) throws JSONException {
		JSONObject postData = new JSONObject();
		postData.put("description", vbridgeName + " for VLAN 100");
		postData.put("ageInterval", "600");

		VtnManager.setVBridge(vtnName, vbridgeName, postData);
	}

	public static void setVlanInterface(String vtnName, String vbridgeName,
			String ifName) throws JSONException {
		JSONObject postData = new JSONObject();
		postData.put("description", ifName + " on Br100");
		postData.put("enabled", "true");

		VtnManager.setVlanInterface(vtnName, vbridgeName, ifName, postData);
	}
	
	public static void setPortMap(String vtnName, String vbridgeName,
			String ifName, String nodeId, String portId, String portName) throws JSONException {
		JSONObject postData = new JSONObject();
		postData.put("vlan", "100");

		// Node on which this PortMap should be installed
		JSONObject node = new JSONObject();
		node.put("id", nodeId);
		node.put("type", "OF");
		postData.put("node", node);
		
		// Port on which this PortMap should be installed
		JSONObject port = new JSONObject();
		port.put("id", portId);
		port.put("type", "OF");
		port.put("name", portName);
		postData.put("port", port);
		
		VtnManager.setPortMap(vtnName, vbridgeName, ifName, postData);
	}
	
	//
	// JSONObject postData3 = new JSONObject();
	// postData3.put("vlan", "100");
	//
	// // Node on which this flow should be installed
	// JSONObject node1 = new JSONObject();
	// node1.put("id", "00:00:00:13:3b:8b:28:1b");
	// node1.put("type", "OF");
	// postData3.put("node", node1);
	//
	// VtnManager.setVlanMap("BLUE", "br100", postData3);
	//
	// JSONObject postData4 = new JSONObject();
	// postData4.put("vlan", "100");
	//
	// // Node on which this flow should be installed
	// JSONObject node5 = new JSONObject();
	// node5.put("id", "00:00:00:13:3b:8b:49:14");
	// node5.put("type", "OF");
	// postData4.put("node", node5);
	//
	// VtnManager.setVlanMap("BLUE", "br100", postData4);
	//
	// VtnManager.getVtnInfo();
	// VtnManager.deleteVtn("BLUE");
	// VtnManager.deleteVbridge("BLUE", "br100");
}
