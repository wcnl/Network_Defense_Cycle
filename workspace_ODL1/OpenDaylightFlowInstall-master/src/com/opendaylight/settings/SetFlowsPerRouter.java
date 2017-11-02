package com.opendaylight.settings;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONException;

import com.opendaylight.managers.FlowManager;

public class SetFlowsPerRouter {

	public static void setRouter1(String QueuePcp1, String QueuePcp2) throws JSONException {
		// Sample post data.
		JSONObject postData1 = new JSONObject();
		postData1.put("name", "Flow1_OVS1_nwDst_10.0.0.11");
		postData1.put("nwSrc", "10.0.0.41");
		postData1.put("nwDst", "10.0.0.11");
		postData1.put("installInHw", "true");
		postData1.put("priority", "501");
		postData1.put("ingressPort", "3");
		postData1.put("etherType", "0x800");
		postData1.put("actions", new JSONArray().put("OUTPUT=5").put("SET_DL_DST=52:54:00:12:34:53"));

		// Node on which this flow should be installed
		JSONObject node1 = new JSONObject();
		node1.put("id", "00:00:00:13:3b:8b:27:d9");
		node1.put("type", "OF");
		postData1.put("node", node1);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:27:d9", "Flow1_OVS1_nwDst_10.0.0.11", postData1);

		// Sample post data.
		JSONObject postData2 = new JSONObject();
		postData2.put("name", "Flow1_OVS1_nwDst_10.0.0.41");
		postData2.put("nwSrc", "10.0.0.11");
		postData2.put("nwDst", "10.0.0.41");
		postData2.put("installInHw", "true");
		postData2.put("priority", "501");
		postData2.put("ingressPort", "5");
		postData2.put("etherType", "0x800");
		postData2.put("actions", new JSONArray().put("ENQUEUE=3:" + QueuePcp1));

		// Node on which this flow should be installed
		postData2.put("node", node1);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:27:d9", "Flow1_OVS1_nwDst_10.0.0.41", postData2);

		// Sample post data.
		JSONObject postData3 = new JSONObject();
		postData3.put("name", "Flow2_OVS1_nwDst_10.0.0.51");
		postData3.put("nwSrc", "10.0.0.12");
		// postData1.put("dlDst", "52:54:00:12:34:59");
		postData3.put("nwDst", "10.0.0.51");
		postData3.put("installInHw", "true");
		postData3.put("priority", "501");
		postData3.put("ingressPort", "2");
		postData3.put("etherType", "0x800");
		// postData1.put("vlan_tci", "0/0xfff");
		postData3.put("actions", new JSONArray().put("ENQUEUE=3:"
				+ QueuePcp2)/*
							 * .put("pushVlan=0").put("SET_VLAN_ID=0").put(
							 * "SET_VLAN_PCP=7")
							 */);

		// Node on which this flow should be installed
		postData3.put("node", node1);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:27:d9", "Flow2_OVS1_nwDst_10.0.0.51", postData3);

		// Sample post data.
		JSONObject postData4 = new JSONObject();
		postData4.put("name", "Flow2_OVS1_nwDst_10.0.0.12");
		postData4.put("nwSrc", "10.0.0.51");
		postData4.put("nwDst", "10.0.0.12");
		postData4.put("installInHw", "true");
		postData4.put("priority", "501");
		postData4.put("ingressPort", "3");
		postData4.put("etherType", "0x800");
		postData4.put("actions", new JSONArray().put("OUTPUT=2").put("SET_DL_DST=52:54:00:12:34:54"));

		// Node on which this flow should be installed
		postData4.put("node", node1);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:27:d9", "Flow2_OVS1_nwDst_10.0.0.12", postData4);
	}

	public static void setRouter2(String QueuePcp1, String QueuePcp2) throws JSONException {
		// Sample post data.
		JSONObject postData1 = new JSONObject();
		postData1.put("name", "Flow1_OVS2_nwDst_10.0.0.11");
		postData1.put("nwSrc", "10.0.0.41");
		postData1.put("nwDst", "10.0.0.11");
		postData1.put("installInHw", "true");
		postData1.put("priority", "501");
		postData1.put("ingressPort", "2");
		postData1.put("etherType", "0x800");
		postData1.put("actions", new JSONArray().put("ENQUEUE=1:" + QueuePcp1));

		// Node on which this flow should be installed
		JSONObject node2 = new JSONObject();
		node2.put("id", "00:00:00:13:3b:8b:29:80");
		node2.put("type", "OF");
		postData1.put("node", node2);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:29:80", "Flow1_OVS2_nwDst_10.0.0.11", postData1);

		// Sample post data.
		JSONObject postData2 = new JSONObject();
		postData2.put("name", "Flow1_OVS2_nwDst_10.0.0.41");
		postData2.put("nwSrc", "10.0.0.11");
		postData2.put("nwDst", "10.0.0.41");
		postData2.put("installInHw", "true");
		postData2.put("priority", "501");
		postData2.put("ingressPort", "1");
		postData2.put("etherType", "0x800");
		postData2.put("actions", new JSONArray().put("ENQUEUE=2:" + QueuePcp1));

		// Node on which this flow should be installed
		postData2.put("node", node2);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:29:80", "Flow1_OVS2_nwDst_10.0.0.41", postData2);

		// Sample post data.
		JSONObject postData3 = new JSONObject();
		postData3.put("name", "Flow2_OVS2_nwDst_10.0.0.51");
		postData3.put("nwSrc", "10.0.0.12");
		postData3.put("nwDst", "10.0.0.51");
		postData3.put("installInHw", "true");
		postData3.put("priority", "501");
		postData3.put("ingressPort", "1");
		postData3.put("etherType", "0x800");
		postData3.put("actions", new JSONArray().put("ENQUEUE=3:" + QueuePcp2));

		// Node on which this flow should be installed
		postData3.put("node", node2);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:29:80", "Flow2_OVS2_nwDst_10.0.0.51", postData3);

		// Sample post data.
		JSONObject postData4 = new JSONObject();
		postData4.put("name", "Flow2_OVS2_nwDst_10.0.0.12");
		postData4.put("nwSrc", "10.0.0.51");
		postData4.put("nwDst", "10.0.0.12");
		postData4.put("installInHw", "true");
		postData4.put("priority", "501");
		postData4.put("ingressPort", "3");
		postData4.put("etherType", "0x800");
		postData4.put("actions", new JSONArray().put("ENQUEUE=1:" + QueuePcp2));

		// Node on which this flow should be installed
		postData4.put("node", node2);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:29:80", "Flow2_OVS2_nwDst_10.0.0.12", postData4);

	}

	public static void setRouter3(String QueuePcp1, String QueuePcp2) throws JSONException {
		// Sample post data.
		JSONObject postData1 = new JSONObject();
		postData1.put("name", "Flow2_OVS3_nwDst_10.0.0.51");
		postData1.put("nwSrc", "10.0.0.12");
		postData1.put("nwDst", "10.0.0.51");
		postData1.put("installInHw", "true");
		postData1.put("priority", "501");
		postData1.put("ingressPort", "1");
		postData1.put("etherType", "0x800");
		postData1.put("actions", new JSONArray().put("ENQUEUE=3:" + QueuePcp1));

		// Node on which this flow should be installed
		JSONObject node3 = new JSONObject();
		node3.put("id", "00:00:00:13:3b:8b:27:e7");
		node3.put("type", "OF");
		postData1.put("node", node3);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:27:e7", "Flow2_OVS3_nwDst_10.0.0.51", postData1);

		// Sample post data.
		JSONObject postData2 = new JSONObject();
		postData2.put("name", "Flow2_OVS3_nwDst_10.0.0.12");
		postData2.put("nwSrc", "10.0.0.51");
		postData2.put("nwDst", "10.0.0.12");
		postData2.put("installInHw", "true");
		postData2.put("priority", "501");
		postData2.put("ingressPort", "3");
		postData2.put("etherType", "0x800");
		postData2.put("actions", new JSONArray().put("ENQUEUE=1:" + QueuePcp1));

		// Node on which this flow should be installed
		postData2.put("node", node3);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:27:e7", "Flow2_OVS3_nwDst_10.0.0.12", postData2);

		// Sample post data.
		JSONObject postData3 = new JSONObject();
		postData3.put("name", "Flow3_OVS3_nwDst_10.0.0.51");
		postData3.put("nwSrc", "10.0.0.61");
		postData3.put("nwDst", "10.0.0.51");
		postData3.put("installInHw", "true");
		postData3.put("priority", "501");
		postData3.put("ingressPort", "2");
		postData3.put("etherType", "0x800");
		postData3.put("actions", new JSONArray().put("ENQUEUE=3:" + QueuePcp2));

		// Node on which this flow should be installed
		postData3.put("node", node3);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:27:e7", "Flow3_OVS3_nwDst_10.0.0.51", postData3);

		// Sample post data.
		JSONObject postData4 = new JSONObject();
		postData4.put("name", "Flow3_OVS3_nwDst_10.0.0.61");
		postData4.put("nwSrc", "10.0.0.51");
		postData4.put("nwDst", "10.0.0.61");
		postData4.put("installInHw", "true");
		postData4.put("priority", "501");
		postData4.put("ingressPort", "3");
		postData4.put("etherType", "0x800");
		postData4.put("actions", new JSONArray().put("ENQUEUE=2:" + QueuePcp2));

		// Node on which this flow should be installed
		postData4.put("node", node3);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:27:e7", "Flow3_OVS3_nwDst_10.0.0.61", postData4);
	}

	public static void setRouter5(String QueuePcp1, String QueuePcp2) throws JSONException {
		// Sample post data.
		JSONObject postData1 = new JSONObject();
		postData1.put("name", "Flow2_OVS5_nwDst_10.0.0.51");
		postData1.put("nwSrc", "10.0.0.12");
		postData1.put("nwDst", "10.0.0.51");
		postData1.put("installInHw", "true");
		postData1.put("priority", "501");
		postData1.put("ingressPort", "2");
		postData1.put("etherType", "0x800");
		postData1.put("actions", new JSONArray().put("OUTPUT=3").put("SET_DL_DST=52:54:00:12:34:59"));

		// Node on which this flow should be installed
		JSONObject node5 = new JSONObject();
		node5.put("id", "00:00:00:13:3b:8b:49:14");
		node5.put("type", "OF");
		postData1.put("node", node5);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:49:14", "Flow2_OVS5_nwDst_10.0.0.51", postData1);

		// Sample post data.
		JSONObject postData2 = new JSONObject();
		postData2.put("name", "Flow2_OVS5_nwDst_10.0.0.12");
		postData2.put("nwSrc", "10.0.0.51");
		postData2.put("nwDst", "10.0.0.12");
		postData2.put("installInHw", "true");
		postData2.put("priority", "501");
		postData2.put("ingressPort", "3");
		postData2.put("etherType", "0x800");
		postData2.put("actions", new JSONArray().put("ENQUEUE=2:" + QueuePcp1));

		// Node on which this flow should be installed
		postData2.put("node", node5);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:49:14", "Flow2_OVS5_nwDst_10.0.0.12", postData2);

		// Sample post data.
		JSONObject postData3 = new JSONObject();
		postData3.put("name", "Flow3_OVS5_nwDst_10.0.0.51");
		postData3.put("nwSrc", "10.0.0.61");
		postData3.put("nwDst", "10.0.0.51");
		postData3.put("installInHw", "true");
		postData3.put("priority", "501");
		postData3.put("ingressPort", "2");
		postData3.put("etherType", "0x800");
		postData3.put("actions", new JSONArray().put("OUTPUT=3").put("SET_DL_DST=52:54:00:12:34:59"));

		// Node on which this flow should be installed
		postData3.put("node", node5);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:49:14", "Flow3_OVS5_nwDst_10.0.0.51", postData3);

		// Sample post data.
		JSONObject postData4 = new JSONObject();
		postData4.put("name", "Flow3_OVS5_nwDst_10.0.0.61");
		postData4.put("nwSrc", "10.0.0.51");
		postData4.put("nwDst", "10.0.0.61");
		postData4.put("installInHw", "true");
		postData4.put("priority", "501");
		postData4.put("ingressPort", "3");
		postData4.put("etherType", "0x800");
		postData4.put("actions", new JSONArray().put("ENQUEUE=2:" + QueuePcp2));

		// Node on which this flow should be installed
		postData4.put("node", node5);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:49:14", "Flow3_OVS5_nwDst_10.0.0.61", postData4);
	}

	public static void setRouter4(String QueuePcp) throws JSONException {
		// Sample post data.
		JSONObject postData7 = new JSONObject();
		postData7.put("name", "Flow1_OVS4_nwDst_10.0.0.11");
		postData7.put("nwSrc", "10.0.0.41");
		// postData7.put("dlSrc", "52:54:00:12:34:58");
		postData7.put("nwDst", "10.0.0.11");
		postData7.put("installInHw", "true");
		postData7.put("priority", "501");
		postData7.put("ingressPort", "3");
		postData7.put("etherType", "0x800");
		postData7.put("actions", new JSONArray().put("ENQUEUE=1:" + QueuePcp));

		// Node on which this flow should be installed
		JSONObject node4 = new JSONObject();
		node4.put("id", "00:00:00:13:3b:8b:46:c3");
		node4.put("type", "OF");
		postData7.put("node", node4);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:46:c3", "Flow1_OVS4_nwDst_10.0.0.11", postData7);

		// Sample post data.
		JSONObject postData8 = new JSONObject();
		postData8.put("name", "Flow1_OVS4_nwDst_10.0.0.41");
		postData8.put("nwSrc", "10.0.0.11");
		postData8.put("nwDst", "10.0.0.41");
		postData8.put("installInHw", "true");
		postData8.put("priority", "501");
		postData8.put("ingressPort", "1");
		postData8.put("etherType", "0x800");
		postData8.put("actions", new JSONArray().put("OUTPUT=3").put("SET_DL_DST=52:54:00:12:34:58"));

		// Node on which this flow should be installed
		postData8.put("node", node4);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:46:c3", "Flow1_OVS4_nwDst_10.0.0.41", postData8);

	}

	public static void setRouter6(String QueuePcp) throws JSONException {

		// Sample post data.
		JSONObject postData11 = new JSONObject();
		postData11.put("name", "Flow3_OVS6_nwDst_10.0.0.51");
		postData11.put("nwSrc", "10.0.0.61");
		postData11.put("nwDst", "10.0.0.51");
		postData11.put("installInHw", "true");
		postData11.put("priority", "501");
		postData11.put("ingressPort", "3");
		postData11.put("etherType", "0x800");
		postData11.put("actions", new JSONArray().put("ENQUEUE=2:" + QueuePcp));

		// Node on which this flow should be installed
		JSONObject node6 = new JSONObject();
		node6.put("id", "00:00:00:13:3b:89:16:80");
		node6.put("type", "OF");
		postData11.put("node", node6);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:89:16:80", "Flow3_OVS6_nwDst_10.0.0.51", postData11);

		// Sample post data.
		JSONObject postData12 = new JSONObject();
		postData12.put("name", "Flow3_OVS6_nwDst_10.0.0.61");
		postData12.put("nwSrc", "10.0.0.51");
		postData12.put("nwDst", "10.0.0.61");
		postData12.put("installInHw", "true");
		postData12.put("priority", "501");
		postData12.put("ingressPort", "2");
		postData12.put("etherType", "0x800");
		postData12.put("actions", new JSONArray().put("OUTPUT=3").put("SET_DL_DST=52:54:00:12:34:60"));

		// Node on which this flow should be installed
		postData12.put("node", node6);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:89:16:80", "Flow3_OVS6_nwDst_10.0.0.61", postData12);
	}
}
