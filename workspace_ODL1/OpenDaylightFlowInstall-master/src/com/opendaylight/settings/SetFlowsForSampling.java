package com.opendaylight.settings;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONException;

import com.opendaylight.managers.FlowManager;

public class SetFlowsForSampling {
	/**
	 * @param args
	 * @throws JSONException
	 */

	private static final String node1_id = "00:00:00:13:3b:8b:28:27";
	private static final String node2_id = "00:00:00:13:3b:8b:29:80";
	private static final String node3_id = "00:00:00:13:3b:8b:27:e7";
	private static final String node4_id = "00:00:00:13:3b:8b:46:c3";
	private static final String node5_id = "00:00:00:13:3b:8b:49:14";
	private static final String node6_id = "00:00:00:13:3b:89:16:80";

	/**
	 * @param args
	 * @throws JSONException
	 */
	public static void setNormalFlow2() throws JSONException {
		// TODO Auto-generated method stub

		/* Node1's flow */

		// Sample post data.
		JSONObject postData1 = new JSONObject();
		postData1.put("name", "Flow2_OVS1_nwDst_10.0.0.51");
		postData1.put("nwSrc", "10.0.0.12");
		// postData1.put("dlDst", "52:54:00:12:34:59");
		postData1.put("nwDst", "10.0.0.51");
		postData1.put("installInHw", "true");
		postData1.put("priority", "501");
		postData1.put("ingressPort", "4");
		postData1.put("etherType", "0x800");
		// postData1.put("vlan_tci", "0/0xfff");
		postData1.put("actions", new JSONArray().put("OUTPUT=1"));

		// Node on which this flow should be installed
		JSONObject node1 = new JSONObject();
		node1.put("id", node1_id);
		node1.put("type", "OF");
		postData1.put("node", node1);

		// Actual flow install
		FlowManager.installFlow(node1_id, "Flow2_OVS1_nwDst_10.0.0.51", postData1);

		// Sample post data.
		JSONObject postData2 = new JSONObject();
		postData2.put("name", "Flow2_OVS1_nwDst_10.0.0.12");
		postData2.put("nwSrc", "10.0.0.51");
		// postData1.put("dlDst", "52:54:00:12:34:59");
		postData2.put("nwDst", "10.0.0.12");
		postData2.put("installInHw", "true");
		postData2.put("priority", "501");
		postData2.put("ingressPort", "1");
		postData2.put("etherType", "0x800");
		// postData1.put("vlan_tci", "0/0xfff");
		postData2.put("actions", new JSONArray().put("OUTPUT=4").put("SET_DL_DST=52:54:00:12:34:54"));

		// Node on which this flow should be installed
		postData2.put("node", node1);

		// Actual flow install
		FlowManager.installFlow(node1_id, "Flow2_OVS1_nwDst_10.0.0.12", postData2);

		/* Node2's flow */

		// Sample post data.
		JSONObject postData3 = new JSONObject();
		postData3.put("name", "Flow2_OVS2_nwDst_10.0.0.51");
		postData3.put("nwSrc", "10.0.0.12");
		postData3.put("nwDst", "10.0.0.51");
		postData3.put("installInHw", "true");
		postData3.put("priority", "501");
		postData3.put("ingressPort", "2");
		postData3.put("etherType", "0x800");
		postData3.put("actions", new JSONArray().put("OUTPUT=3"));

		// Node on which this flow should be installed
		JSONObject node2 = new JSONObject();
		node2.put("id", node2_id);
		node2.put("type", "OF");
		postData3.put("node", node2);

		// Actual flow install
		FlowManager.installFlow(node2_id, "Flow2_OVS2_nwDst_10.0.0.51", postData3);

		// Sample post data.
		JSONObject postData4 = new JSONObject();
		postData4.put("name", "Flow2_OVS2_nwDst_10.0.0.12");
		postData4.put("nwSrc", "10.0.0.51");
		postData4.put("nwDst", "10.0.0.12");
		postData4.put("installInHw", "true");
		postData4.put("priority", "501");
		postData4.put("ingressPort", "3");
		postData4.put("etherType", "0x800");
		postData4.put("actions", new JSONArray().put("OUTPUT=2"));

		// Node on which this flow should be installed
		postData4.put("node", node2);

		// Actual flow install
		FlowManager.installFlow(node2_id, "Flow2_OVS2_nwDst_10.0.0.12", postData4);

		/* Node3's flow */

		// Sample post data.
		JSONObject postData5 = new JSONObject();
		postData5.put("name", "Flow2_OVS3_nwDst_10.0.0.51");
		postData5.put("nwSrc", "10.0.0.12");
		postData5.put("nwDst", "10.0.0.51");
		postData5.put("installInHw", "true");
		postData5.put("priority", "501");
		postData5.put("ingressPort", "3");
		postData5.put("etherType", "0x800");
		postData5.put("actions", new JSONArray().put("OUTPUT=6"));

		// Node on which this flow should be installed
		JSONObject node3 = new JSONObject();
		node3.put("id", node3_id);
		node3.put("type", "OF");
		postData5.put("node", node3);

		// Actual flow install
		FlowManager.installFlow(node3_id, "Flow2_OVS3_nwDst_10.0.0.51", postData5);

		// Sample post data.
		JSONObject postData6 = new JSONObject();
		postData6.put("name", "Flow2_OVS3_nwDst_10.0.0.12");
		postData6.put("nwSrc", "10.0.0.51");
		postData6.put("nwDst", "10.0.0.12");
		postData6.put("installInHw", "true");
		postData6.put("priority", "501");
		postData6.put("ingressPort", "6");
		postData6.put("etherType", "0x800");
		postData6.put("actions", new JSONArray().put("OUTPUT=3"));

		// Node on which this flow should be installed
		postData6.put("node", node3);

		// Actual flow install
		FlowManager.installFlow(node3_id, "Flow2_OVS3_nwDst_10.0.0.12", postData6);

		/* Node5's flow */

		// Sample post data.
		JSONObject postData7 = new JSONObject();
		postData7.put("name", "Flow2_OVS5_nwDst_10.0.0.51");
		postData7.put("nwSrc", "10.0.0.12");
		postData7.put("nwDst", "10.0.0.51");
		postData7.put("installInHw", "true");
		postData7.put("priority", "501");
		postData7.put("ingressPort", "2");
		postData7.put("etherType", "0x800");
		postData7.put("actions", new JSONArray().put("OUTPUT=3").put("SET_DL_DST=52:54:00:12:34:59"));

		// Node on which this flow should be installed
		JSONObject node5 = new JSONObject();
		node5.put("id", node5_id);
		node5.put("type", "OF");
		postData7.put("node", node5);

		// Actual flow install
		FlowManager.installFlow(node5_id, "Flow2_OVS5_nwDst_10.0.0.51", postData7);

		// Sample post data.
		JSONObject postData8 = new JSONObject();
		postData8.put("name", "Flow2_OVS5_nwDst_10.0.0.12");
		postData8.put("nwSrc", "10.0.0.51");
		postData8.put("nwDst", "10.0.0.12");
		postData8.put("installInHw", "true");
		postData8.put("priority", "501");
		postData8.put("ingressPort", "3");
		postData8.put("etherType", "0x800");
		postData8.put("actions", new JSONArray().put("OUTPUT=2"));

		// Node on which this flow should be installed
		postData8.put("node", node5);

		// Actual flow install
		FlowManager.installFlow(node5_id, "Flow2_OVS5_nwDst_10.0.0.12", postData8);
	}

	/**
	 * @param args
	 * @throws JSONException
	 */
	public static void setNormalFlow3() throws JSONException {
		// TODO Auto-generated method stub

		/* Node2's flow */

		// Sample post data.
		JSONObject postData1 = new JSONObject();
		postData1.put("name", "Flow3_OVS2_nwDst_10.0.0.42");
		postData1.put("nwSrc", "10.0.0.22");
		// postData1.put("dlDst", "52:54:00:12:34:59");
		postData1.put("nwDst", "10.0.0.42");
		postData1.put("installInHw", "true");
		postData1.put("priority", "501");
		postData1.put("ingressPort", "5");
		postData1.put("etherType", "0x800");
		// postData1.put("vlan_tci", "0/0xfff");
		postData1.put("actions", new JSONArray().put("OUTPUT=4"));

		// Node on which this flow should be installed
		JSONObject node2 = new JSONObject();
		node2.put("id", node2_id);
		node2.put("type", "OF");
		postData1.put("node", node2);

		// Actual flow install
		FlowManager.installFlow(node2_id, "Flow3_OVS2_nwDst_10.0.0.42", postData1);

		// Sample post data.
		JSONObject postData2 = new JSONObject();
		postData2.put("name", "Flow3_OVS2_nwDst_10.0.0.22");
		postData2.put("nwSrc", "10.0.0.42");
		// postData1.put("dlDst", "52:54:00:12:34:59");
		postData2.put("nwDst", "10.0.0.22");
		postData2.put("installInHw", "true");
		postData2.put("priority", "501");
		postData2.put("ingressPort", "4");
		postData2.put("etherType", "0x800");
		// postData1.put("vlan_tci", "0/0xfff");
		postData2.put("actions", new JSONArray().put("OUTPUT=5").put("SET_DL_DST=52:54:00:12:34:56"));

		// Node on which this flow should be installed
		postData2.put("node", node2);

		// Actual flow install
		FlowManager.installFlow(node2_id, "Flow3_OVS2_nwDst_10.0.0.22", postData2);

		/* Node4's flow */

		// Sample post data.
		JSONObject postData3 = new JSONObject();
		postData3.put("name", "Flow3_OVS4_nwDst_10.0.0.22");
		postData3.put("nwSrc", "10.0.0.42");
		postData3.put("nwDst", "10.0.0.22");
		postData3.put("installInHw", "true");
		postData3.put("priority", "501");
		postData3.put("ingressPort", "5");
		postData3.put("etherType", "0x800");
		postData3.put("actions", new JSONArray().put("OUTPUT=1"));

		// Node on which this flow should be installed
		JSONObject node4 = new JSONObject();
		node4.put("id", node4_id);
		node4.put("type", "OF");
		postData3.put("node", node4);

		// Actual flow install
		FlowManager.installFlow(node4_id, "Flow3_OVS4_nwDst_10.0.0.22", postData3);

		// Sample post data.
		JSONObject postData4 = new JSONObject();
		postData4.put("name", "Flow3_OVS4_nwDst_10.0.0.42");
		postData4.put("nwSrc", "10.0.0.22");
		postData4.put("nwDst", "10.0.0.42");
		postData4.put("installInHw", "true");
		postData4.put("priority", "501");
		postData4.put("ingressPort", "1");
		postData4.put("etherType", "0x800");
		postData4.put("actions", new JSONArray().put("OUTPUT=5").put("SET_DL_DST=52:54:00:12:34:63"));

		// Node on which this flow should be installed
		postData4.put("node", node4);

		// Actual flow install
		FlowManager.installFlow(node4_id, "Flow3_OVS4_nwDst_10.0.0.42", postData4);
	}

	public static void setNormalFlow4() throws JSONException {
		// TODO Auto-generated method stub

		/* Node3's flow */

		// Sample post data.
		JSONObject postData1 = new JSONObject();
		postData1.put("name", "Flow4_OVS3_nwDst_10.0.0.41");
		postData1.put("nwSrc", "10.0.0.31");
		// postData1.put("dlDst", "52:54:00:12:34:59");
		postData1.put("nwDst", "10.0.0.41");
		postData1.put("installInHw", "true");
		postData1.put("priority", "501");
		postData1.put("ingressPort", "1");
		postData1.put("etherType", "0x800");
		// postData1.put("vlan_tci", "0/0xfff");
		postData1.put("actions", new JSONArray().put("OUTPUT=6"));

		// Node on which this flow should be installed
		JSONObject node3 = new JSONObject();
		node3.put("id", node3_id);
		node3.put("type", "OF");
		postData1.put("node", node3);

		// Actual flow install
		FlowManager.installFlow(node3_id, "Flow4_OVS3_nwDst_10.0.0.41", postData1);

		// Sample post data.
		JSONObject postData2 = new JSONObject();
		postData2.put("name", "Flow4_OVS1_nwDst_10.0.0.31");
		postData2.put("nwSrc", "10.0.0.41");
		// postData1.put("dlDst", "52:54:00:12:34:59");
		postData2.put("nwDst", "10.0.0.31");
		postData2.put("installInHw", "true");
		postData2.put("priority", "501");
		postData2.put("ingressPort", "6");
		postData2.put("etherType", "0x800");
		// postData1.put("vlan_tci", "0/0xfff");
		postData2.put("actions", new JSONArray().put("OUTPUT=1").put("SET_DL_DST=52:54:00:12:34:57"));

		// Node on which this flow should be installed
		postData2.put("node", node3);

		// Actual flow install
		FlowManager.installFlow(node3_id, "Flow4_OVS1_nwDst_10.0.0.31", postData2);

		/* Node4's flow */

		// Sample post data.
		JSONObject postData3 = new JSONObject();
		postData3.put("name", "Flow4_OVS4_nwDst_10.0.0.31");
		postData3.put("nwSrc", "10.0.0.41");
		postData3.put("nwDst", "10.0.0.31");
		postData3.put("installInHw", "true");
		postData3.put("priority", "501");
		postData3.put("ingressPort", "4");
		postData3.put("etherType", "0x800");
		postData3.put("actions", new JSONArray().put("OUTPUT=2"));

		// Node on which this flow should be installed
		JSONObject node4 = new JSONObject();
		node4.put("id", node4_id);
		node4.put("type", "OF");
		postData3.put("node", node4);

		// Actual flow install
		FlowManager.installFlow(node4_id, "Flow4_OVS4_nwDst_10.0.0.31", postData3);

		// Sample post data.
		JSONObject postData4 = new JSONObject();
		postData4.put("name", "Flow4_OVS4_nwDst_10.0.0.41");
		postData4.put("nwSrc", "10.0.0.31");
		postData4.put("nwDst", "10.0.0.41");
		postData4.put("installInHw", "true");
		postData4.put("priority", "501");
		postData4.put("ingressPort", "2");
		postData4.put("etherType", "0x800");
		postData4.put("actions", new JSONArray().put("OUTPUT=4").put("SET_DL_DST=52:54:00:12:34:58"));

		// Node on which this flow should be installed
		postData4.put("node", node4);

		// Actual flow install
		FlowManager.installFlow(node4_id, "Flow4_OVS4_nwDst_10.0.0.41", postData4);

		/* Node5's flow */

		// Sample post data.
		JSONObject postData5 = new JSONObject();
		postData5.put("name", "Flow4_OVS5_nwDst_10.0.0.41");
		postData5.put("nwSrc", "10.0.0.31");
		postData5.put("nwDst", "10.0.0.41");
		postData5.put("installInHw", "true");
		postData5.put("priority", "501");
		postData5.put("ingressPort", "2");
		postData5.put("etherType", "0x800");
		postData5.put("actions", new JSONArray().put("OUTPUT=1"));

		// Node on which this flow should be installed
		JSONObject node5 = new JSONObject();
		node5.put("id", node5_id);
		node5.put("type", "OF");
		postData5.put("node", node5);

		// Actual flow install
		FlowManager.installFlow(node5_id, "Flow4_OVS5_nwDst_10.0.0.41", postData5);

		// Sample post data.
		JSONObject postData6 = new JSONObject();
		postData6.put("name", "Flow4_OVS5_nwDst_10.0.0.31");
		postData6.put("nwSrc", "10.0.0.41");
		postData6.put("nwDst", "10.0.0.31");
		postData6.put("installInHw", "true");
		postData6.put("priority", "501");
		postData6.put("ingressPort", "1");
		postData6.put("etherType", "0x800");
		postData6.put("actions", new JSONArray().put("OUTPUT=2"));

		// Node on which this flow should be installed
		postData6.put("node", node5);

		// Actual flow install
		FlowManager.installFlow(node5_id, "Flow4_OVS5_nwDst_10.0.0.31", postData6);
	}

	/**
	 * @param args
	 * @throws JSONException
	 */
	public static void setNormalFlow5() throws JSONException {
		// TODO Auto-generated method stub

		/* Node1's flow */

		// Sample post data.
		JSONObject postData1 = new JSONObject();
		postData1.put("name", "Flow5_OVS1_nwDst_10.0.0.61");
		postData1.put("nwSrc", "10.0.0.13");
		// postData1.put("dlDst", "52:54:00:12:34:59");
		postData1.put("nwDst", "10.0.0.61");
		postData1.put("installInHw", "true");
		postData1.put("priority", "501");
		postData1.put("ingressPort", "6");
		postData1.put("etherType", "0x800");
		// postData1.put("vlan_tci", "0/0xfff");
		postData1.put("actions", new JSONArray().put("OUTPUT=1"));

		// Node on which this flow should be installed
		JSONObject node1 = new JSONObject();
		node1.put("id", node1_id);
		node1.put("type", "OF");
		postData1.put("node", node1);

		// Actual flow install
		FlowManager.installFlow(node1_id, "Flow5_OVS1_nwDst_10.0.0.61", postData1);

		// Sample post data.
		JSONObject postData2 = new JSONObject();
		postData2.put("name", "Flow5_OVS1_nwDst_10.0.0.13");
		postData2.put("nwSrc", "10.0.0.61");
		// postData1.put("dlDst", "52:54:00:12:34:59");
		postData2.put("nwDst", "10.0.0.13");
		postData2.put("installInHw", "true");
		postData2.put("priority", "501");
		postData2.put("ingressPort", "1");
		postData2.put("etherType", "0x800");
		// postData1.put("vlan_tci", "0/0xfff");
		postData2.put("actions", new JSONArray().put("OUTPUT=6").put("SET_DL_DST=52:54:00:12:34:64"));

		// Node on which this flow should be installed
		postData2.put("node", node1);

		// Actual flow install
		FlowManager.installFlow(node1_id, "Flow5_OVS1_nwDst_10.0.0.13", postData2);

		/* Node2's flow */ 

		// Sample post data.
		JSONObject postData3 = new JSONObject();
		postData3.put("name", "Flow5_OVS2_nwDst_10.0.0.61");
		postData3.put("nwSrc", "10.0.0.13");
		postData3.put("nwDst", "10.0.0.61");
		postData3.put("installInHw", "true");
		postData3.put("priority", "501");
		postData3.put("ingressPort", "2");
		postData3.put("etherType", "0x800");
		postData3.put("actions", new JSONArray().put("OUTPUT=3"));

		// Node on which this flow should be installed
		JSONObject node2 = new JSONObject();
		node2.put("id", node2_id);
		node2.put("type", "OF");
		postData3.put("node", node2);

		// Actual flow install
		FlowManager.installFlow(node2_id, "Flow5_OVS2_nwDst_10.0.0.61", postData3);

		// Sample post data.
		JSONObject postData4 = new JSONObject();
		postData4.put("name", "Flow5_OVS2_nwDst_10.0.0.13");
		postData4.put("nwSrc", "10.0.0.61");
		postData4.put("nwDst", "10.0.0.13");
		postData4.put("installInHw", "true");
		postData4.put("priority", "501");
		postData4.put("ingressPort", "3");
		postData4.put("etherType", "0x800");
		postData4.put("actions", new JSONArray().put("OUTPUT=2"));

		// Node on which this flow should be installed
		postData4.put("node", node2);

		// Actual flow install
		FlowManager.installFlow(node2_id, "Flow5_OVS2_nwDst_10.0.0.13", postData4);

		/* Node3's flow */

		// Sample post data.
		JSONObject postData5 = new JSONObject();
		postData5.put("name", "Flow5_OVS3_nwDst_10.0.0.61");
		postData5.put("nwSrc", "10.0.0.13");
		postData5.put("nwDst", "10.0.0.61");
		postData5.put("installInHw", "true");
		postData5.put("priority", "501");
		postData5.put("ingressPort", "3");
		postData5.put("etherType", "0x800");
		postData5.put("actions", new JSONArray().put("OUTPUT=4"));

		// Node on which this flow should be installed
		JSONObject node3 = new JSONObject();
		node3.put("id", node3_id);
		node3.put("type", "OF");
		postData5.put("node", node3);

		// Actual flow install
		FlowManager.installFlow(node3_id, "Flow5_OVS3_nwDst_10.0.0.61", postData5);

		// Sample post data.
		JSONObject postData6 = new JSONObject();
		postData6.put("name", "Flow5_OVS3_nwDst_10.0.0.13");
		postData6.put("nwSrc", "10.0.0.61");
		postData6.put("nwDst", "10.0.0.13");
		postData6.put("installInHw", "true");
		postData6.put("priority", "501");
		postData6.put("ingressPort", "4");
		postData6.put("etherType", "0x800");
		postData6.put("actions", new JSONArray().put("OUTPUT=3"));

		// Node on which this flow should be installed
		postData6.put("node", node3);

		// Actual flow install
		FlowManager.installFlow(node3_id, "Flow5_OVS3_nwDst_10.0.0.13", postData6);

		/* Node6's flow */ 

		// Sample post data.
		JSONObject postData7 = new JSONObject();
		postData7.put("name", "Flow5_OVS6_nwDst_10.0.0.61");
		postData7.put("nwSrc", "10.0.0.13");
		postData7.put("nwDst", "10.0.0.61");
		postData7.put("installInHw", "true");
		postData7.put("priority", "501");
		postData7.put("ingressPort", "2");
		postData7.put("etherType", "0x800");
		postData7.put("actions", new JSONArray().put("OUTPUT=3").put("SET_DL_DST=52:54:00:12:34:60"));

		// Node on which this flow should be installed
		JSONObject node6 = new JSONObject();
		node6.put("id", node6_id);
		node6.put("type", "OF");
		postData7.put("node", node6);

		// Actual flow install
		FlowManager.installFlow(node6_id, "Flow5_OVS6_nwDst_10.0.0.61", postData7);

		// Sample post data.
		JSONObject postData8 = new JSONObject();
		postData8.put("name", "Flow5_OVS6_nwDst_10.0.0.13");
		postData8.put("nwSrc", "10.0.0.61");
		postData8.put("nwDst", "10.0.0.13");
		postData8.put("installInHw", "true");
		postData8.put("priority", "501");
		postData8.put("ingressPort", "3");
		postData8.put("etherType", "0x800");
		postData8.put("actions", new JSONArray().put("OUTPUT=2"));

		// Node on which this flow should be installed
		postData8.put("node", node6);

		// Actual flow install
		FlowManager.installFlow(node6_id, "Flow5_OVS6_nwDst_10.0.0.13", postData8);
	}

	/**
	 * @param args
	 * @throws JSONException
	 */
	public static void setMaliciousFlow1() throws JSONException {
		// TODO Auto-generated method stub

		/* Node1's flow */

		// Sample post data.
		JSONObject postData1 = new JSONObject();
		postData1.put("name", "mFlow1_OVS1_nwDst_10.0.0.21");
		postData1.put("nwSrc", "10.0.0.11");
		// postData1.put("dlDst", "52:54:00:12:34:59");
		postData1.put("nwDst", "10.0.0.21");
		postData1.put("installInHw", "true");
		postData1.put("priority", "501");
		postData1.put("ingressPort", "3");
		postData1.put("etherType", "0x800");
		// postData1.put("vlan_tci", "0/0xfff");
		postData1.put("actions", new JSONArray().put("OUTPUT=1"));

		// Node on which this flow should be installed
		JSONObject node1 = new JSONObject();
		node1.put("id", node1_id);
		node1.put("type", "OF");
		postData1.put("node", node1);

		// Actual flow install
		FlowManager.installFlow(node1_id, "mFlow1_OVS1_nwDst_10.0.0.21", postData1);

		/*// Sample post data.
		JSONObject postData2 = new JSONObject();
		postData2.put("name", "mFlow1_OVS1_nwDst_10.0.0.11");
		postData2.put("nwSrc", "10.0.0.21");
		// postData1.put("dlDst", "52:54:00:12:34:59");
		postData2.put("nwDst", "10.0.0.11");
		postData2.put("installInHw", "true");
		postData2.put("priority", "501");
		postData2.put("ingressPort", "1");
		postData2.put("etherType", "0x800");
		// postData1.put("vlan_tci", "0/0xfff");
		postData2.put("actions", new JSONArray().put("OUTPUT=3").put("SET_DL_DST=52:54:00:12:34:53"));

		// Node on which this flow should be installed
		postData2.put("node", node1);

		// Actual flow install
		FlowManager.installFlow(node1_id, "mFlow1_OVS1_nwDst_10.0.0.11", postData2);

		 Node2's flow 

		// Sample post data.
		JSONObject postData3 = new JSONObject();
		postData3.put("name", "mFlow1_OVS2_nwDst_10.0.0.11");
		postData3.put("nwSrc", "10.0.0.21");
		postData3.put("nwDst", "10.0.0.11");
		postData3.put("installInHw", "true");
		postData3.put("priority", "501");
		postData3.put("ingressPort", "1");
		postData3.put("etherType", "0x800");
		postData3.put("actions", new JSONArray().put("OUTPUT=2"));

		// Node on which this flow should be installed
		JSONObject node2 = new JSONObject();
		node2.put("id", node2_id);
		node2.put("type", "OF");
		postData3.put("node", node2);

		// Actual flow install
		FlowManager.installFlow(node2_id, "mFlow1_OVS2_nwDst_10.0.0.11", postData3);

		// Sample post data.
		JSONObject postData4 = new JSONObject();
		postData4.put("name", "mFlow1_OVS2_nwDst_10.0.0.21");
		postData4.put("nwSrc", "10.0.0.11");
		postData4.put("nwDst", "10.0.0.21");
		postData4.put("installInHw", "true");
		postData4.put("priority", "501");
		postData4.put("ingressPort", "2");
		postData4.put("etherType", "0x800");
		postData4.put("actions", new JSONArray().put("OUTPUT=1").put("SET_DL_DST=52:54:00:12:34:55"));

		// Node on which this flow should be installed
		postData4.put("node", node2);

		// Actual flow install
		FlowManager.installFlow(node2_id, "mFlow1_OVS2_nwDst_10.0.0.21", postData4);*/
	}
	
	public static void setDropMaliciousFlow() throws JSONException {
		// TODO Auto-generated method stub

		/* Node1's flow */

		// Sample post data.
		JSONObject postData1 = new JSONObject();
		postData1.put("name", "mFlow1_OVS1_nwDst_10.0.0.21");
		postData1.put("tpDst", "10000");
		postData1.put("protocol", "UDP");
		postData1.put("nwSrc", "10.0.0.11");
		// postData1.put("dlDst", "52:54:00:12:34:59");
		postData1.put("nwDst", "10.0.0.21");
		postData1.put("installInHw", "true");
		postData1.put("priority", "1000");
		postData1.put("ingressPort", "3");
		postData1.put("etherType", "0x800");
		
		// postData1.put("vlan_tci", "0/0xfff");
		postData1.put("actions", new JSONArray().put("DROP"));

		// Node on which this flow should be installed
		JSONObject node1 = new JSONObject();
		node1.put("id", node1_id);
		node1.put("type", "OF");
		postData1.put("node", node1);

		// Actual flow install
		FlowManager.installFlow(node1_id, "mFlow1_OVS1_nwDst_10.0.0.21", postData1);

		/* Node2's flow */

		/*// Sample post data.
		JSONObject postData4 = new JSONObject();
		postData4.put("name", "mFlow1_OVS2_nwDst_10.0.0.21");
		postData4.put("tpDst", "10000");
		postData4.put("protocol", "UDP");
		postData4.put("nwSrc", "10.0.0.11");
		postData4.put("nwDst", "10.0.0.21");
		postData4.put("installInHw", "true");
		postData4.put("priority", "1000");
		postData4.put("ingressPort", "2");
		postData4.put("etherType", "0x800");
		postData4.put("actions", new JSONArray().put("DROP"));
		
		
		
		// Node on which this flow should be installed
		JSONObject node2 = new JSONObject();
		node2.put("id", node2_id);
		node2.put("type", "OF");
		postData4.put("node", node2);

		// Actual flow install
		FlowManager.installFlow(node2_id, "mFlow1_OVS2_nwDst_10.0.0.21", postData4);*/
	}
	
	public static void setControlFlow() throws JSONException {

		/* Node1's flow */

		// Sample post data.
		JSONObject postData1 = new JSONObject();
		postData1.put("name", "ControlFlow_OVS1_nwSrc_10.0.0.11_nwDst_16");
		postData1.put("nwSrc", "10.0.0.11");
		postData1.put("nwDst", "10.0.0.16");
		postData1.put("installInHw", "true");
		postData1.put("priority", "501");
		postData1.put("ingressPort", "3");
		postData1.put("etherType", "0x800");
		postData1.put("actions", new JSONArray().put("OUTPUT=5").put("SET_DL_DST=00:1a:80:d5:68:71"));

		// Node on which this flow should be installed
		JSONObject node1 = new JSONObject();
		node1.put("id", node1_id);
		node1.put("type", "OF");
		postData1.put("node", node1);

		// Actual flow install
		FlowManager.installFlow(node1_id, "ControlFlow_OVS1_nwSrc_10.0.0.11_nwDst_16", postData1);

		// Sample post data.
		JSONObject postData2 = new JSONObject();
		postData2.put("name", "ControlFlow_OVS1_nwSrc_10.0.0.16_nwDst_11");
		postData2.put("nwSrc", "10.0.0.16");
		postData2.put("nwDst", "10.0.0.11");
		postData2.put("installInHw", "true");
		postData2.put("priority", "501");
		postData2.put("ingressPort", "5");
		postData2.put("etherType", "0x800");
		postData2.put("actions", new JSONArray().put("OUTPUT=3").put("SET_DL_DST=52:54:00:12:34:53"));

		// Node on which this flow should be installed
		postData2.put("node", node1);

		// Actual flow install
		FlowManager.installFlow(node1_id, "ControlFlow_OVS1_nwSrc_10.0.0.16_nwDst_11", postData2);
	}
}
