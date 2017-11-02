package com.opendaylight.managers;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;
import org.codehaus.jettison.json.JSONObject;

import com.opendaylight.settings.ODL;

public class VtnManager {
	private static String VTN_REST_API = "/controller/nb/v2/vtn/default/vtns/";
	
	private static final int CREATED = 201;
	private static final int OK = 200;
	
	public static boolean setVtns(String vtnName, JSONObject postData) {

		HttpURLConnection connection = null;
		int callStatus = 0;

		// Creating the actual URL to call
		String baseURL = ODL.URL + VTN_REST_API + vtnName;

		try {

			// Create URL = base URL + container
			URL url = new URL(baseURL);

			// Create authentication string and encode it to Base64
			String authStr = ODL.USERNAME + ":" + ODL.PASSWORD;
			String encodedAuthStr = Base64.encodeBase64String(authStr
					.getBytes());

			// Create Http connection
			connection = (HttpURLConnection) url.openConnection();

			// Set connection properties
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Authorization", "Basic "
					+ encodedAuthStr);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);

			// Set Post Data
			OutputStream os = connection.getOutputStream();
			os.write(postData.toString().getBytes());
			os.close();

			// Getting the response code
			callStatus = connection.getResponseCode();

		} catch (Exception e) {
			System.err.println("Unexpected error while flow installation.. "
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.disconnect();
		}

		if (callStatus == CREATED) {
			System.out.println("Vtn created Successfully");
			return true;
		} else if (callStatus == OK){
			System.out.println("Vtn modified Successfully");
			return true;
		}
		else {
			System.err.println("Failed to create vtn.. " + callStatus);
			return false;
		}
	}
	
	public static boolean setVBridge(String vtnName, String vbridgeName, JSONObject postData) {

		HttpURLConnection connection = null;
		int callStatus = 0;

		// Creating the actual URL to call
		String baseURL = ODL.URL + VTN_REST_API + vtnName + "/vbridges/" + vbridgeName;

		try {

			// Create URL = base URL + container
			URL url = new URL(baseURL);

			// Create authentication string and encode it to Base64
			String authStr = ODL.USERNAME + ":" + ODL.PASSWORD;
			String encodedAuthStr = Base64.encodeBase64String(authStr
					.getBytes());

			// Create Http connection
			connection = (HttpURLConnection) url.openConnection();

			// Set connection properties
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Authorization", "Basic "
					+ encodedAuthStr);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);

			// Set Post Data
			OutputStream os = connection.getOutputStream();
			os.write(postData.toString().getBytes());
			os.close();

			// Getting the response code
			callStatus = connection.getResponseCode();

		} catch (Exception e) {
			System.err.println("Unexpected error while flow installation.. "
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.disconnect();
		}

		if (callStatus == CREATED) {
			System.out.println("VBridge created Successfully");
			return true;
		} else if (callStatus == OK){
			System.out.println("VBridge modified Successfully");
			return true;
		}
		else {
			System.err.println("Failed to create VBridge.. " + callStatus);
			return false;
		}
	}
	
	public static boolean setVlanMap(String vtnName, String vbridgeName, JSONObject postData) {

		HttpURLConnection connection = null;
		int callStatus = 0;

		// Creating the actual URL to call
		String baseURL = ODL.URL + VTN_REST_API + vtnName + "/vbridges/" + vbridgeName + "/vlanmaps";

		try {

			// Create URL = base URL + container
			URL url = new URL(baseURL);

			// Create authentication string and encode it to Base64
			String authStr = ODL.USERNAME + ":" + ODL.PASSWORD;
			String encodedAuthStr = Base64.encodeBase64String(authStr
					.getBytes());

			// Create Http connection
			connection = (HttpURLConnection) url.openConnection();

			// Set connection properties
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Authorization", "Basic "
					+ encodedAuthStr);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);

			// Set Post Data
			OutputStream os = connection.getOutputStream();
			os.write(postData.toString().getBytes());
			os.close();

			// Getting the response code
			callStatus = connection.getResponseCode();

		} catch (Exception e) {
			System.err.println("Unexpected error while flow installation.. "
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.disconnect();
		}

		if (callStatus == CREATED) {
			System.out.println("VlanMap created Successfully");
			return true;
		} else if (callStatus == OK){
			System.out.println("VlanMap modified Successfully");
			return true;
		}
		else {
			System.err.println("Failed to create VlanMap.. " + callStatus);
			return false;
		}
	}
	
	public static boolean setVlanInterface(String vtnName, String vbridgeName, String ifName, JSONObject postData) {

		HttpURLConnection connection = null;
		int callStatus = 0;

		// Creating the actual URL to call
		String baseURL = ODL.URL + VTN_REST_API + vtnName + "/vbridges/" + vbridgeName + "/interfaces/" + ifName;

		try {

			// Create URL = base URL + container
			URL url = new URL(baseURL);

			// Create authentication string and encode it to Base64
			String authStr = ODL.USERNAME + ":" + ODL.PASSWORD;
			String encodedAuthStr = Base64.encodeBase64String(authStr
					.getBytes());

			// Create Http connection
			connection = (HttpURLConnection) url.openConnection();

			// Set connection properties
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Authorization", "Basic "
					+ encodedAuthStr);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);

			// Set Post Data
			OutputStream os = connection.getOutputStream();
			os.write(postData.toString().getBytes());
			os.close();

			// Getting the response code
			callStatus = connection.getResponseCode();

		} catch (Exception e) {
			System.err.println("Unexpected error while flow installation.. "
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.disconnect();
		}

		if (callStatus == CREATED) {
			System.out.println("VlanInterface created Successfully");
			return true;
		} else if (callStatus == OK){
			System.out.println("VlanInterface modified Successfully");
			return true;
		}
		else {
			System.err.println("Failed to create VlanInterface.. " + callStatus);
			return false;
		}
	}
	
	public static boolean setPortMap(String vtnName, String vbridgeName, String ifName, JSONObject postData) {

		HttpURLConnection connection = null;
		int callStatus = 0;

		// Creating the actual URL to call
		String baseURL = ODL.URL + VTN_REST_API + vtnName + "/vbridges/" + vbridgeName + "/interfaces/" + ifName + "/portmap";

		try {

			// Create URL = base URL + container
			URL url = new URL(baseURL);

			// Create authentication string and encode it to Base64
			String authStr = ODL.USERNAME + ":" + ODL.PASSWORD;
			String encodedAuthStr = Base64.encodeBase64String(authStr
					.getBytes());

			// Create Http connection
			connection = (HttpURLConnection) url.openConnection();

			// Set connection properties
			connection.setRequestMethod("PUT");
			connection.setRequestProperty("Authorization", "Basic "
					+ encodedAuthStr);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);

			// Set Post Data
			OutputStream os = connection.getOutputStream();
			os.write(postData.toString().getBytes());
			os.close();

			// Getting the response code
			callStatus = connection.getResponseCode();

		} catch (Exception e) {
			System.err.println("Unexpected error while flow installation.. "
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.disconnect();
		}

		if (callStatus == CREATED) {
			System.out.println("PortMap created Successfully");
			return true;
		} else if (callStatus == OK){
			System.out.println("PortMap modified Successfully");
			return true;
		}
		else {
			System.err.println("Failed to create PortMap.. " + callStatus);
			return false;
		}
	}
	
	public static boolean deleteVtn(String vtnName) {

		HttpURLConnection connection = null;
		int callStatus = 0;
		String baseURL = ODL.URL + VTN_REST_API + vtnName;

		try {

			// Create URL = base URL + container
			URL url = new URL(baseURL);

			// Create authentication string and encode it to Base64
			String authStr = ODL.USERNAME + ":" + ODL.PASSWORD;
			String encodedAuthStr = Base64.encodeBase64String(authStr
					.getBytes());

			// Create Http connection
			connection = (HttpURLConnection) url.openConnection();

			// Set connection properties
			connection.setRequestMethod("DELETE");
			connection.setRequestProperty("Authorization", "Basic "
					+ encodedAuthStr);
			connection.setRequestProperty("Content-Type", "application/json");

			callStatus = connection.getResponseCode();

		} catch (Exception e) {
			System.err.println("Unexpected error while flow deletion.."
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.disconnect();
		}

		if (callStatus == OK) {
			System.out.println("Vtn deleted Successfully");
			return true;
		} else {
			System.err.println("Failed to delete the Vtn..." + callStatus);
			return false;
		}
	}
	
	public static boolean deleteVbridge(String vtnName, String vbridgeName) {

		HttpURLConnection connection = null;
		int callStatus = 0;
		String baseURL = ODL.URL + VTN_REST_API + vtnName + "/vbridges/" + vbridgeName;

		try {

			// Create URL = base URL + container
			URL url = new URL(baseURL);

			// Create authentication string and encode it to Base64
			String authStr = ODL.USERNAME + ":" + ODL.PASSWORD;
			String encodedAuthStr = Base64.encodeBase64String(authStr
					.getBytes());

			// Create Http connection
			connection = (HttpURLConnection) url.openConnection();

			// Set connection properties
			connection.setRequestMethod("DELETE");
			connection.setRequestProperty("Authorization", "Basic "
					+ encodedAuthStr);
			connection.setRequestProperty("Content-Type", "application/json");

			callStatus = connection.getResponseCode();

		} catch (Exception e) {
			System.err.println("Unexpected error while flow deletion.."
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.disconnect();
		}

		if (callStatus == OK) {
			System.out.println("VBridge deleted Successfully");
			return true;
		} else {
			System.err.println("Failed to delete the VBridge..." + callStatus);
			return false;
		}
	}
	
	
	public static boolean getVtnInfo(String vtnName) {
		HttpURLConnection connection = null;
		int callStatus = 0;

		// Creating the actual URL to call
		//String baseURL = ODL.URL + FLOW_STATISTICS_REST_API;
		String baseURL = ODL.URL + VTN_REST_API + vtnName;
		
		try {

			// Create URL = base URL + container
			URL url = new URL(baseURL);

			// Create authentication string and encode it to Base64
			String authStr = ODL.USERNAME + ":" + ODL.PASSWORD;
			String encodedAuthStr = Base64.encodeBase64String(authStr
					.getBytes());

			// Create Http connection
			connection = (HttpURLConnection) url.openConnection();

			// Set connection properties
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Authorization", "Basic "
					+ encodedAuthStr);
			connection.setRequestProperty("Content-Type", "application/json");

			callStatus = connection.getResponseCode();
			
			InputStream is = connection.getInputStream();
	        
	        // Converse from InputStream to String //
	        int e;
	        StringBuffer buffer = new StringBuffer();
	        byte[] b = new byte[4096];
	        while( (e = is.read(b)) != -1) {
	         buffer.append(new String(b, 0, e));
	        }
	        String json = buffer.toString();
	        System.out.println(json);

		} catch (Exception e) {
			System.err.println("Unexpected error while vtn info.."
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.disconnect();
		}
		
		if (callStatus == OK) {
			System.out.println("vtn info read Successfully");
			return true;
		} else {
			System.err.println("Failed to read the vtn info..." + callStatus);
			return false;
		}
		
	}
	
	public static boolean getVtnPortMapInfo(String vtnName, String vbridgeName,
			String ifName) {
		HttpURLConnection connection = null;
		int callStatus = 0;

		// Creating the actual URL to call
		//String baseURL = ODL.URL + FLOW_STATISTICS_REST_API;
		String baseURL = ODL.URL + VTN_REST_API + vtnName + "/vbridges/" + vbridgeName + "/interfaces/" + ifName + "/portmap";
		
		try {

			// Create URL = base URL + container
			URL url = new URL(baseURL);

			// Create authentication string and encode it to Base64
			String authStr = ODL.USERNAME + ":" + ODL.PASSWORD;
			String encodedAuthStr = Base64.encodeBase64String(authStr
					.getBytes());

			// Create Http connection
			connection = (HttpURLConnection) url.openConnection();

			// Set connection properties
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Authorization", "Basic "
					+ encodedAuthStr);
			connection.setRequestProperty("Content-Type", "application/json");

			callStatus = connection.getResponseCode();
			
			InputStream is = connection.getInputStream();
	        
	        // Converse from InputStream to String //
	        int e;
	        StringBuffer buffer = new StringBuffer();
	        byte[] b = new byte[4096];
	        while( (e = is.read(b)) != -1) {
	         buffer.append(new String(b, 0, e));
	        }
	        String json = buffer.toString();
	        System.out.println(json);

		} catch (Exception e) {
			System.err.println("Unexpected error while vtn info.."
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.disconnect();
		}
		
		if (callStatus == OK) {
			System.out.println("vtn info read Successfully");
			return true;
		} else {
			System.err.println("Failed to read the vtn info..." + callStatus);
			return false;
		}
		
	}
}
