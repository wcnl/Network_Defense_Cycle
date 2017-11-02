package com.opendaylight.managers;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;
import org.codehaus.jettison.json.JSONObject;

import com.opendaylight.settings.ODL;

public class FlowManager {

	// REST NBI Hydrogen for FlowGrogrammerNorthbound.

	private static String FLOW_CONFIG_REST_API = "/controller/nb/v2/flowprogrammer/default/";
	private static String FLOW_PROGRAMMER_REST_API = "/controller/nb/v2/flowprogrammer/default/node/OF/";
	private static String FLOW_STATISTICS_REST_API = "/controller/nb/v2/statistics/default/flow";
	private static String VTN_REST_API = "/controller/nb/v2/vtn/default/vtns/";
	
	// HTTP statuses for checking the call output
	private static final int NO_CONTENT = 204;
	private static final int CREATED = 201;
	private static final int OK = 200;

	public static boolean installFlow(String nodeId, String flowName,
			JSONObject postData) {

		HttpURLConnection connection = null;
		int callStatus = 0;

		// Creating the actual URL to call
		String baseURL = ODL.URL + FLOW_PROGRAMMER_REST_API + nodeId
				+ "/staticFlow/" + flowName;

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
			System.out.println("Flow installed Successfully");
			return true;
		} else if (callStatus == OK){
			System.out.println("Flow modified Successfully");
			return true;
		}
		else {
			System.err.println("Failed to install flow.. " + callStatus);
			return false;
		}
	}

	public static boolean deleteFlow(String flowName, String nodeId) {

		HttpURLConnection connection = null;
		int callStatus = 0;
		String baseURL = ODL.URL + FLOW_PROGRAMMER_REST_API + nodeId
				+ "/staticFlow/" + flowName;

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

		if (callStatus == NO_CONTENT) {
			System.out.println("Flow deleted Successfully");
			return true;
		} else {
			System.err.println("Failed to delete the flow..." + callStatus);
			return false;
		}
	}
	
	public static boolean getFlowStatistics() {
		HttpURLConnection connection = null;
		int callStatus = 0;

		// Creating the actual URL to call
		String baseURL = ODL.URL + FLOW_STATISTICS_REST_API;
		//String baseURL = ODL.URL +"/controller/nb/v2/flowprogrammer/default/";
		
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
			System.err.println("Unexpected error while flow statistics.."
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.disconnect();
		}
		
		if (callStatus == OK) {
			System.out.println("Flow statistics read Successfully");
			return true;
		} else {
			System.err.println("Failed to read the flow statistics..." + callStatus);
			return false;
		}
		
	}
	
	public static boolean getFlowConfig() {
		HttpURLConnection connection = null;
		int callStatus = 0;

		// Creating the actual URL to call
		//String baseURL = ODL.URL + FLOW_STATISTICS_REST_API;
		String baseURL = ODL.URL + FLOW_CONFIG_REST_API;
		
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
			System.err.println("Unexpected error while flow config.."
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.disconnect();
		}
		
		if (callStatus == OK) {
			System.out.println("Flow config read Successfully");
			return true;
		} else {
			System.err.println("Failed to read the flow config..." + callStatus);
			return false;
		}
		
	}
}
