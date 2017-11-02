package com.opendaylight.settings;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONException;

import com.opendaylight.managers.FlowManager;

public class SetFlows {
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
	
	public static void setFlow1(String QueuePcp) throws JSONException {

		/* Node1's flow */

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
		postData2.put("actions", new JSONArray().put("ENQUEUE=3:" + QueuePcp));

		// Node on which this flow should be installed
		postData2.put("node", node1);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:27:d9", "Flow1_OVS1_nwDst_10.0.0.41", postData2);

		/* Node2's flow */

		// Sample post data.
		JSONObject postData3 = new JSONObject();
		postData3.put("name", "Flow1_OVS2_nwDst_10.0.0.11");
		postData3.put("nwSrc", "10.0.0.41");
		postData3.put("nwDst", "10.0.0.11");
		postData3.put("installInHw", "true");
		postData3.put("priority", "501");
		postData3.put("ingressPort", "2");
		postData3.put("etherType", "0x800");
		postData3.put("actions", new JSONArray().put("ENQUEUE=1:" + QueuePcp));

		// Node on which this flow should be installed
		JSONObject node2 = new JSONObject();
		node2.put("id", "00:00:00:13:3b:8b:29:80");
		node2.put("type", "OF");
		postData3.put("node", node2);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:29:80", "Flow1_OVS2_nwDst_10.0.0.11", postData3);

		// Sample post data.
		JSONObject postData4 = new JSONObject();
		postData4.put("name", "Flow1_OVS2_nwDst_10.0.0.41");
		postData4.put("nwSrc", "10.0.0.11");
		postData4.put("nwDst", "10.0.0.41");
		postData4.put("installInHw", "true");
		postData4.put("priority", "501");
		postData4.put("ingressPort", "1");
		postData4.put("etherType", "0x800");
		postData4.put("actions", new JSONArray().put("ENQUEUE=2:" + QueuePcp));

		// Node on which this flow should be installed
		postData4.put("node", node2);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:29:80", "Flow1_OVS2_nwDst_10.0.0.41", postData4);

		/// * Node3's flow */
		//
		// // Sample post data.
		// JSONObject postData5 = new JSONObject();
		// postData5.put("name", "TestFlow29");
		// // postData.put("nwSrc", "10.0.0.41");
		// postData5.put("nwDst", "10.0.0.12");
		// postData5.put("installInHw", "true");
		// postData5.put("priority", "501");
		// if (VlanPCP != null) {
		// postData5.put("vlanId", "0");
		// postData5.put("vlanPriority", VlanPCP);
		// }
		// postData5.put("etherType", "0x800");
		// postData5.put("actions", new JSONArray().put("OUTPUT=2"));
		//
		// // Node on which this flow should be installed
		// JSONObject node3 = new JSONObject();
		// node3.put("id", "00:00:00:13:3b:8b:27:e7");
		// node3.put("type", "OF");
		// postData5.put("node", node3);
		//
		// // Actual flow install
		// FlowManager.installFlow("00:00:00:13:3b:8b:27:e7", "TestFlow29",
		// postData5);
		//
		// // Sample post data.
		// JSONObject postData6 = new JSONObject();
		// postData6.put("name", "TestFlow30");
		// // postData.put("nwSrc", "10.0.0.41");
		// postData6.put("nwDst", "10.0.0.41");
		// postData6.put("installInHw", "true");
		// postData6.put("priority", "501");
		// if (VlanPCP != null) {
		// postData6.put("vlanId", "0");
		// postData6.put("vlanPriority", VlanPCP);
		// }
		// postData6.put("etherType", "0x800");
		// postData6.put("actions", new JSONArray().put("OUTPUT=1"));
		//
		// // Node on which this flow should be installed
		// postData6.put("node", node3);
		//
		// // Actual flow install
		// FlowManager.installFlow("00:00:00:13:3b:8b:27:e7", "TestFlow30",
		// postData6);

		/* Node4's flow */

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

		/// * Node5's flow */
		//
		// // Sample post data.
		// JSONObject postData9 = new JSONObject();
		// postData9.put("name", "TestFlow33");
		// // postData.put("nwSrc", "10.0.0.41");
		// postData9.put("nwDst", "10.0.0.12");
		// postData9.put("installInHw", "true");
		// postData9.put("priority", "501");
		// if (VlanPCP != null) {
		// postData9.put("vlanId", "0");
		// postData9.put("vlanPriority", VlanPCP);
		// }
		// postData9.put("etherType", "0x800");
		// postData9.put(
		// "actions",
		// new JSONArray().put("OUTPUT=2").put(
		// "SET_DL_DST=52:54:00:12:34:61"));
		//
		// // Node on which this flow should be installed
		// JSONObject node5 = new JSONObject();
		// node5.put("id", "00:00:00:13:3b:8b:49:14");
		// node5.put("type", "OF");
		// postData9.put("node", node5);
		//
		// // Actual flow install
		// FlowManager.installFlow("00:00:00:13:3b:8b:49:14", "TestFlow33",
		// postData9);
		//
		// // Sample post data.
		// JSONObject postData10 = new JSONObject();
		// postData10.put("name", "TestFlow34");
		// // postData.put("nwSrc", "10.0.0.41");
		// postData10.put("nwDst", "10.0.0.41");
		// postData10.put("installInHw", "true");
		// postData10.put("priority", "501");
		// if (VlanPCP != null) {
		// postData10.put("vlanId", "0");
		// postData10.put("vlanPriority", VlanPCP);
		// }
		// postData10.put("etherType", "0x800");
		// postData10.put("actions", new JSONArray().put("OUTPUT=1"));
		//
		// // Node on which this flow should be installed
		// postData10.put("node", node5);
		//
		// // Actual flow install
		// FlowManager.installFlow("00:00:00:13:3b:8b:49:14", "TestFlow34",
		// postData10);
		//
		/// * Node6's flow */
		//
		// // Sample post data.
		// JSONObject postData11 = new JSONObject();
		// postData11.put("name", "TestFlow35");
		// // postData.put("nwSrc", "10.0.0.41");
		// postData11.put("nwDst", "10.0.0.12");
		// postData11.put("installInHw", "true");
		// postData11.put("priority", "501");
		// if (VlanPCP != null) {
		// postData11.put("vlanId", "0");
		// postData11.put("vlanPriority", VlanPCP);
		// }
		// postData11.put("etherType", "0x800");
		// postData11.put("actions", new JSONArray().put("OUTPUT=1"));
		//
		// // Node on which this flow should be installed
		// JSONObject node6 = new JSONObject();
		// node6.put("id", "00:00:00:13:3b:89:16:80");
		// node6.put("type", "OF");
		// postData11.put("node", node6);
		//
		// // Actual flow install
		// FlowManager.installFlow("00:00:00:13:3b:89:16:80", "TestFlow35",
		// postData11);
		//
		// // Sample post data.
		// JSONObject postData12 = new JSONObject();
		// postData12.put("name", "TestFlow36");
		// // postData.put("nwSrc", "10.0.0.41");
		// postData12.put("nwDst", "10.0.0.41");
		// postData12.put("installInHw", "true");
		// postData12.put("priority", "501");
		// if (VlanPCP != null) {
		// postData12.put("vlanId", "0");
		// postData12.put("vlanPriority", VlanPCP);
		// }
		// postData12.put("etherType", "0x800");
		// postData12.put("actions", new JSONArray().put("OUTPUT=2")
		// /*.put("SET_VLAN_ID=1") .put("SET_VLAN_PCP=1")*/);
		//
		// // Node on which this flow should be installed
		// postData12.put("node", node6);
		//
		// // Actual flow install
		// FlowManager.installFlow("00:00:00:13:3b:89:16:80", "TestFlow36",
		// postData12);

	}

	/**
	 * @param args
	 * @throws JSONException
	 */
	public static void setFlow2(String QueuePcp) throws JSONException {
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
		postData1.put("ingressPort", "2");
		postData1.put("etherType", "0x800");
		// postData1.put("vlan_tci", "0/0xfff");
		postData1.put("actions", new JSONArray().put("ENQUEUE=3:"
				+ QueuePcp)/*
							 * .put("pushVlan=0").put("SET_VLAN_ID=0").put(
							 * "SET_VLAN_PCP=7")
							 */);

		// Node on which this flow should be installed
		JSONObject node1 = new JSONObject();
		node1.put("id", "00:00:00:13:3b:8b:27:d9");
		node1.put("type", "OF");
		postData1.put("node", node1);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:27:d9", "Flow2_OVS1_nwDst_10.0.0.51", postData1);

		// Sample post data.
		JSONObject postData2 = new JSONObject();
		postData2.put("name", "Flow2_OVS1_nwDst_10.0.0.12");
		postData2.put("nwSrc", "10.0.0.51");
		postData2.put("nwDst", "10.0.0.12");
		postData2.put("installInHw", "true");
		postData2.put("priority", "501");
		postData2.put("ingressPort", "3");
		postData2.put("etherType", "0x800");
		postData2.put("actions", new JSONArray().put("OUTPUT=2").put("SET_DL_DST=52:54:00:12:34:54"));

		// Node on which this flow should be installed
		postData2.put("node", node1);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:27:d9", "Flow2_OVS1_nwDst_10.0.0.12", postData2);

		/* Node2's flow */

		// Sample post data.
		JSONObject postData3 = new JSONObject();
		postData3.put("name", "Flow2_OVS2_nwDst_10.0.0.51");
		postData3.put("nwSrc", "10.0.0.12");
		postData3.put("nwDst", "10.0.0.51");
		postData3.put("installInHw", "true");
		postData3.put("priority", "501");
		postData3.put("ingressPort", "1");
		postData3.put("etherType", "0x800");
		postData3.put("actions", new JSONArray().put("ENQUEUE=3:" + QueuePcp));

		// Node on which this flow should be installed
		JSONObject node2 = new JSONObject();
		node2.put("id", "00:00:00:13:3b:8b:29:80");
		node2.put("type", "OF");
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
		postData4.put("actions", new JSONArray().put("ENQUEUE=1:" + QueuePcp));

		// Node on which this flow should be installed
		postData4.put("node", node2);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:29:80", "Flow2_OVS2_nwDst_10.0.0.12", postData4);

		/* Node3's flow */

		// Sample post data.
		JSONObject postData5 = new JSONObject();
		postData5.put("name", "Flow2_OVS3_nwDst_10.0.0.51");
		postData5.put("nwSrc", "10.0.0.12");
		postData5.put("nwDst", "10.0.0.51");
		postData5.put("installInHw", "true");
		postData5.put("priority", "501");
		postData5.put("ingressPort", "1");
		postData5.put("etherType", "0x800");
		postData5.put("actions", new JSONArray().put("ENQUEUE=3:" + QueuePcp));

		// Node on which this flow should be installed
		JSONObject node3 = new JSONObject();
		node3.put("id", "00:00:00:13:3b:8b:27:e7");
		node3.put("type", "OF");
		postData5.put("node", node3);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:27:e7", "Flow2_OVS3_nwDst_10.0.0.51", postData5);

		// Sample post data.
		JSONObject postData6 = new JSONObject();
		postData6.put("name", "Flow2_OVS3_nwDst_10.0.0.12");
		postData6.put("nwSrc", "10.0.0.51");
		postData6.put("nwDst", "10.0.0.12");
		postData6.put("installInHw", "true");
		postData6.put("priority", "501");
		postData6.put("ingressPort", "3");
		postData6.put("etherType", "0x800");
		postData6.put("actions", new JSONArray().put("ENQUEUE=1:" + QueuePcp));

		// Node on which this flow should be installed
		postData6.put("node", node3);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:27:e7", "Flow2_OVS3_nwDst_10.0.0.12", postData6);

		/* Node4's flow */

		// Sample post data.
		// JSONObject postData7 = new JSONObject();
		// postData7.put("name", "TestFlow7");
		// // postData.put("nwSrc", "10.0.0.41");
		// postData7.put("dlDst", "52:54:00:12:34:59");
		// //postData7.put("nwDst", "10.0.0.51");
		// postData7.put("installInHw", "true");
		// postData7.put("priority", "501");
		// if (VlanId != null && VlanPCP != null) {
		// postData7.put("vlanId", VlanId);
		// postData7.put("vlanPriority", VlanPCP);
		// }
		// postData7.put("etherType", "0x8100");
		// postData7.put("actions", new JSONArray().put("OUTPUT=1"));
		//
		// // Node on which this flow should be installed
		// JSONObject node4 = new JSONObject();
		// node4.put("id", "00:00:00:13:3b:8b:46:c3");
		// node4.put("type", "OF");
		// postData7.put("node", node4);
		//
		// // Actual flow install
		// FlowManager.installFlow("00:00:00:13:3b:8b:46:c3", "TestFlow7",
		// postData7);
		//
		// // Sample post data.
		// JSONObject postData8 = new JSONObject();
		// postData8.put("name", "TestFlow8");
		// // postData.put("nwSrc", "10.0.0.41");
		// postData8.put("dlDst", "52:54:00:12:34:53");
		// //postData8.put("nwDst", "10.0.0.11");
		// postData8.put("installInHw", "true");
		// postData8.put("priority", "501");
		// if (VlanId != null && VlanPCP != null) {
		// postData8.put("vlanId", VlanId);
		// postData8.put("vlanPriority", VlanPCP);
		// }
		// postData8.put("etherType", "0x8100");
		// postData8.put("actions", new JSONArray().put("OUTPUT=1"));
		//
		// // Node on which this flow should be installed
		// postData8.put("node", node4);
		//
		// // Actual flow install
		// FlowManager.installFlow("00:00:00:13:3b:8b:46:c3", "TestFlow8",
		// postData8);

		/* Node5's flow */

		// Sample post data.
		JSONObject postData9 = new JSONObject();
		postData9.put("name", "Flow2_OVS5_nwDst_10.0.0.51");
		postData9.put("nwSrc", "10.0.0.12");
		postData9.put("nwDst", "10.0.0.51");
		postData9.put("installInHw", "true");
		postData9.put("priority", "501");
		postData9.put("ingressPort", "2");
		postData9.put("etherType", "0x800");
		postData9.put("actions", new JSONArray().put("OUTPUT=3").put("SET_DL_DST=52:54:00:12:34:59"));

		// Node on which this flow should be installed
		JSONObject node5 = new JSONObject();
		node5.put("id", "00:00:00:13:3b:8b:49:14");
		node5.put("type", "OF");
		postData9.put("node", node5);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:49:14", "Flow2_OVS5_nwDst_10.0.0.51", postData9);

		// Sample post data.
		JSONObject postData10 = new JSONObject();
		postData10.put("name", "Flow2_OVS5_nwDst_10.0.0.12");
		postData10.put("nwSrc", "10.0.0.51");
		postData10.put("nwDst", "10.0.0.12");
		postData10.put("installInHw", "true");
		postData10.put("priority", "501");
		postData10.put("ingressPort", "3");
		postData10.put("etherType", "0x800");
		postData10.put("actions", new JSONArray().put("ENQUEUE=2:" + QueuePcp));

		// Node on which this flow should be installed
		postData10.put("node", node5);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:49:14", "Flow2_OVS5_nwDst_10.0.0.12", postData10);

		/* Node6's flow */

		// Sample post data.
		// JSONObject postData11 = new JSONObject();
		// postData11.put("name", "TestFlow11");
		// // postData.put("nwSrc", "10.0.0.41");
		// postData11.put("dlDst", "52:54:00:12:34:59");
		// //postData11.put("nwDst", "10.0.0.51");
		// postData11.put("installInHw", "true");
		// postData11.put("priority", "501");
		// if (VlanId != null && VlanPCP != null) {
		// postData11.put("vlanId", VlanId);
		// postData11.put("vlanPriority", VlanPCP);
		// }
		// postData11.put("etherType", "0x8100");
		// postData11.put("actions", new JSONArray().put("OUTPUT=2"));
		//
		// // Node on which this flow should be installed
		// JSONObject node6 = new JSONObject();
		// node6.put("id", "00:00:00:13:3b:89:16:80");
		// node6.put("type", "OF");
		// postData11.put("node", node6);
		//
		// // Actual flow install
		// FlowManager.installFlow("00:00:00:13:3b:89:16:80", "TestFlow11",
		// postData11);
		//
		// // Sample post data.
		// JSONObject postData12 = new JSONObject();
		// postData12.put("name", "TestFlow12");
		// // postData.put("nwSrc", "10.0.0.41");
		// postData12.put("dlDst", "52:54:00:12:34:53");
		// //postData12.put("nwDst", "10.0.0.11");
		// postData12.put("installInHw", "true");
		// postData12.put("priority", "501");
		// if (VlanId != null && VlanPCP != null) {
		// postData12.put("vlanId", VlanId);
		// postData12.put("vlanPriority", VlanPCP);
		// }
		// postData12.put("etherType", "0x8100");
		// postData12.put("actions", new JSONArray().put("OUTPUT=2"));
		//
		// // Node on which this flow should be installed
		// postData12.put("node", node6);
		//
		// // Actual flow install
		// FlowManager.installFlow("00:00:00:13:3b:89:16:80", "TestFlow12",
		// postData12);
	}

	/**
	 * @param args
	 * @throws JSONException
	 */
	public static void setFlow3(String QueuePcp) throws JSONException {

		/* Node1's flow */

		// Sample post data.
		// JSONObject postData1 = new JSONObject();
		// postData1.put("name", "TestFlow13");
		// // postData.put("nwSrc", "10.0.0.41");
		// postData1.put("nwDst", "10.0.0.52");
		// postData1.put("installInHw", "true");
		// postData1.put("priority", "501");
		// if (VlanPCP != null) {
		// postData1.put("vlanId", "0");
		// postData1.put("vlanPriority", VlanPCP);
		// }
		// postData1.put("etherType", "0x800");
		// postData1.put("actions", new JSONArray().put("OUTPUT=2"));
		//
		// // Node on which this flow should be installed
		// JSONObject node1 = new JSONObject();
		// node1.put("id", "00:00:00:13:3b:8b:28:1b");
		// node1.put("type", "OF");
		// postData1.put("node", node1);
		//
		// // Actual flow install
		// FlowManager.installFlow("00:00:00:13:3b:8b:28:1b", "TestFlow13",
		// postData1);
		//
		// // Sample post data.
		// JSONObject postData2 = new JSONObject();
		// postData2.put("name", "TestFlow14");
		// // postData.put("nwSrc", "10.0.0.41");
		// postData2.put("nwDst", "10.0.0.61");
		// postData2.put("installInHw", "true");
		// postData2.put("priority", "501");
		// if (VlanPCP != null) {
		// postData2.put("vlanId", "0");
		// postData2.put("vlanPriority", VlanPCP);
		// }
		// postData2.put("etherType", "0x800");
		// postData2.put("actions", new JSONArray().put("OUTPUT=1"));
		//
		// // Node on which this flow should be installed
		// postData2.put("node", node1);
		//
		// // Actual flow install
		// FlowManager.installFlow("00:00:00:13:3b:8b:28:1b", "TestFlow14",
		// postData2);
		//
		/// * Node2's flow */
		//
		// // Sample post data.
		// JSONObject postData3 = new JSONObject();
		// postData3.put("name", "TestFlow15");
		// // postData.put("nwSrc", "10.0.0.41");
		// postData3.put("nwDst", "10.0.0.52");
		// postData3.put("installInHw", "true");
		// postData3.put("priority", "501");
		// if (VlanPCP != null) {
		// postData3.put("vlanId", "0");
		// postData3.put("vlanPriority", VlanPCP);
		// }
		// postData3.put("etherType", "0x800");
		// postData3.put("actions", new JSONArray().put("OUTPUT=2"));
		//
		// // Node on which this flow should be installed
		// JSONObject node2 = new JSONObject();
		// node2.put("id", "00:00:00:13:3b:8b:29:80");
		// node2.put("type", "OF");
		// postData3.put("node", node2);
		//
		// // Actual flow install
		// FlowManager.installFlow("00:00:00:13:3b:8b:29:80", "TestFlow15",
		// postData3);
		//
		// // Sample post data.
		// JSONObject postData4 = new JSONObject();
		// postData4.put("name", "TestFlow16");
		// // postData.put("nwSrc", "10.0.0.41");
		// postData4.put("nwDst", "10.0.0.61");
		// postData4.put("installInHw", "true");
		// postData4.put("priority", "501");
		// if (VlanPCP != null) {
		// postData4.put("vlanId", "0");
		// postData4.put("vlanPriority", VlanPCP);
		// }
		// postData4.put("etherType", "0x800");
		// postData4.put("actions", new JSONArray().put("OUTPUT=1"));
		//
		// // Node on which this flow should be installed
		// postData4.put("node", node2);
		//
		// // Actual flow install
		// FlowManager.installFlow("00:00:00:13:3b:8b:29:80", "TestFlow16",
		// postData4);

		/* Node3's flow */

		// Sample post data.
		JSONObject postData5 = new JSONObject();
		postData5.put("name", "Flow3_OVS3_nwDst_10.0.0.51");
		postData5.put("nwSrc", "10.0.0.61");
		postData5.put("nwDst", "10.0.0.51");
		postData5.put("installInHw", "true");
		postData5.put("priority", "501");
		postData5.put("ingressPort", "2");
		postData5.put("etherType", "0x800");
		postData5.put("actions", new JSONArray().put("ENQUEUE=3:" + QueuePcp));

		// Node on which this flow should be installed
		JSONObject node3 = new JSONObject();
		node3.put("id", "00:00:00:13:3b:8b:27:e7");
		node3.put("type", "OF");
		postData5.put("node", node3);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:27:e7", "Flow3_OVS3_nwDst_10.0.0.51", postData5);

		// Sample post data.
		JSONObject postData6 = new JSONObject();
		postData6.put("name", "Flow3_OVS3_nwDst_10.0.0.61");
		postData6.put("nwSrc", "10.0.0.51");
		postData6.put("nwDst", "10.0.0.61");
		postData6.put("installInHw", "true");
		postData6.put("priority", "501");
		postData6.put("ingressPort", "3");
		postData6.put("etherType", "0x800");
		postData6.put("actions", new JSONArray().put("ENQUEUE=2:" + QueuePcp));

		// Node on which this flow should be installed
		postData6.put("node", node3);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:27:e7", "Flow3_OVS3_nwDst_10.0.0.61", postData6);

		/* Node4's flow */

		// Sample post data.
		// JSONObject postData7 = new JSONObject();
		// postData7.put("name", "TestFlow19");
		// // postData.put("nwSrc", "10.0.0.41");
		// postData7.put("nwDst", "10.0.0.52");
		// postData7.put("installInHw", "true");
		// postData7.put("priority", "501");
		// if (VlanPCP != null) {
		// postData7.put("vlanId", "0");
		// postData7.put("vlanPriority", VlanPCP);
		// }
		// postData7.put("etherType", "0x800");
		// postData7.put("actions", new JSONArray().put("OUTPUT=2"));
		//
		// // Node on which this flow should be installed
		// JSONObject node4 = new JSONObject();
		// node4.put("id", "00:00:00:13:3b:8b:46:c3");
		// node4.put("type", "OF");
		// postData7.put("node", node4);
		//
		// // Actual flow install
		// FlowManager.installFlow("00:00:00:13:3b:8b:46:c3", "TestFlow19",
		// postData7);
		//
		// // Sample post data.
		// JSONObject postData8 = new JSONObject();
		// postData8.put("name", "TestFlow20");
		// // postData.put("nwSrc", "10.0.0.41");
		// postData8.put("nwDst", "10.0.0.61");
		// postData8.put("installInHw", "true");
		// postData8.put("priority", "501");
		// if (VlanPCP != null) {
		// postData8.put("vlanId", "0");
		// postData8.put("vlanPriority", VlanPCP);
		// }
		// postData8.put("etherType", "0x800");
		// postData8.put("actions", new JSONArray().put("OUTPUT=1"));
		//
		// // Node on which this flow should be installed
		// postData8.put("node", node4);
		//
		// // Actual flow install
		// FlowManager.installFlow("00:00:00:13:3b:8b:46:c3", "TestFlow20",
		// postData8);

		/* Node5's flow */

		// Sample post data.
		JSONObject postData9 = new JSONObject();
		postData9.put("name", "Flow3_OVS5_nwDst_10.0.0.51");
		postData9.put("nwSrc", "10.0.0.61");
		postData9.put("nwDst", "10.0.0.51");
		postData9.put("installInHw", "true");
		postData9.put("priority", "501");
		postData9.put("ingressPort", "2");
		postData9.put("etherType", "0x800");
		postData9.put("actions", new JSONArray().put("OUTPUT=3").put("SET_DL_DST=52:54:00:12:34:59"));

		// Node on which this flow should be installed
		JSONObject node5 = new JSONObject();
		node5.put("id", "00:00:00:13:3b:8b:49:14");
		node5.put("type", "OF");
		postData9.put("node", node5);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:49:14", "Flow3_OVS5_nwDst_10.0.0.51", postData9);

		// Sample post data.
		JSONObject postData10 = new JSONObject();
		postData10.put("name", "Flow3_OVS5_nwDst_10.0.0.61");
		postData10.put("nwSrc", "10.0.0.51");
		postData10.put("nwDst", "10.0.0.61");
		postData10.put("installInHw", "true");
		postData10.put("priority", "501");
		postData10.put("ingressPort", "3");
		postData10.put("etherType", "0x800");
		postData10.put("actions", new JSONArray().put("ENQUEUE=2:" + QueuePcp));

		// Node on which this flow should be installed
		postData10.put("node", node5);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:49:14", "Flow3_OVS5_nwDst_10.0.0.61", postData10);

		/* Node6's flow */

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

	public static void setControlFlow() throws JSONException {

		/* Node1's flow */

		// Sample post data.
		JSONObject postData1 = new JSONObject();
		postData1.put("name", "ControlFlow_OVS1_nwSrc_10.0.0.11_nwDst_16");
		postData1.put("nwSrc", "10.0.0.11");
		postData1.put("nwDst", "10.0.0.16");
		postData1.put("installInHw", "true");
		postData1.put("priority", "501");
		postData1.put("ingressPort", "5");
		postData1.put("etherType", "0x800");
		postData1.put("actions", new JSONArray().put("OUTPUT=7").put("SET_DL_DST=00:1a:80:d5:68:71"));

		// Node on which this flow should be installed
		JSONObject node1 = new JSONObject();
		node1.put("id", "00:00:00:13:3b:99:58:74");
		node1.put("type", "OF");
		postData1.put("node", node1);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:99:58:74", "ControlFlow_OVS1_nwSrc_10.0.0.11_nwDst_16", postData1);

		// Sample post data.
		JSONObject postData2 = new JSONObject();
		postData2.put("name", "ControlFlow_OVS1_nwSrc_10.0.0.16_nwDst_11");
		postData2.put("nwSrc", "10.0.0.16");
		postData2.put("nwDst", "10.0.0.11");
		postData2.put("installInHw", "true");
		postData2.put("priority", "501");
		postData2.put("ingressPort", "7");
		postData2.put("etherType", "0x800");
		postData2.put("actions", new JSONArray().put("OUTPUT=5").put("SET_DL_DST=52:54:00:12:34:53"));

		// Node on which this flow should be installed
		postData2.put("node", node1);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:99:58:74", "ControlFlow_OVS1_nwSrc_10.0.0.16_nwDst_11", postData2);

		// Sample post data.
		JSONObject postData3 = new JSONObject();
		postData3.put("name", "ControlFlow_OVS1_nwSrc_10.0.0.12_nwDst_16");
		postData3.put("nwSrc", "10.0.0.12");
		postData3.put("nwDst", "10.0.0.16");
		postData3.put("installInHw", "true");
		postData3.put("priority", "501");
		postData3.put("ingressPort", "2");
		postData3.put("etherType", "0x800");
		postData3.put("actions", new JSONArray().put("OUTPUT=7").put("SET_DL_DST=00:1a:80:d5:68:71"));

		// Node on which this flow should be installed
		postData3.put("node", node1);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:27:d9", "ControlFlow_OVS1_nwSrc_10.0.0.12_nwDst_16", postData3);

		// Sample post data.
		JSONObject postData4 = new JSONObject();
		postData4.put("name", "ControlFlow_OVS1_nwSrc_10.0.0.16_nwDst_12");
		postData4.put("nwSrc", "10.0.0.16");
		postData4.put("nwDst", "10.0.0.12");
		postData4.put("installInHw", "true");
		postData4.put("priority", "501");
		postData4.put("ingressPort", "7");
		postData4.put("etherType", "0x800");
		postData4.put("actions", new JSONArray().put("OUTPUT=2").put("SET_DL_DST=52:54:00:12:34:54"));

		// Node on which this flow should be installed
		postData4.put("node", node1);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:27:d9", "ControlFlow_OVS1_nwSrc_10.0.0.16_nwDst_12", postData4);

		// Sample post data.
		JSONObject postData5 = new JSONObject();
		postData5.put("name", "ControlFlow_OVS1_nwSrc_10.0.0.16_nwDst_61");
		postData5.put("nwSrc", "10.0.0.16");
		postData5.put("nwDst", "10.0.0.61");
		postData5.put("installInHw", "true");
		postData5.put("priority", "501");
		postData5.put("ingressPort", "7");
		postData5.put("etherType", "0x800");
		postData5.put("actions", new JSONArray().put("OUTPUT=4"));

		// Node on which this flow should be installed
		postData5.put("node", node1);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:27:d9", "ControlFlow_OVS1_nwSrc_10.0.0.16_nwDst_61", postData5);
		
		// Sample post data.
		JSONObject postData6 = new JSONObject();
		postData6.put("name", "ControlFlow_OVS1_nwSrc_10.0.0.61_nwDst_16");
		postData6.put("nwSrc", "10.0.0.61");
		postData6.put("nwDst", "10.0.0.16");
		postData6.put("installInHw", "true");
		postData6.put("priority", "501");
		postData6.put("ingressPort", "4");
		postData6.put("etherType", "0x800");
		postData6.put("actions", new JSONArray().put("OUTPUT=7").put("SET_DL_DST=00:1a:80:d5:68:71"));

		// Node on which this flow should be installed
		postData6.put("node", node1);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:8b:27:d9", "ControlFlow_OVS1_nwSrc_10.0.0.61_nwDst_16", postData6);

		/* Node6's flow */

		// Sample post data.
		JSONObject postData7 = new JSONObject();
		postData7.put("name", "ControlFlow_OVS6_nwSrc_10.0.0.16_nwDst_61");
		postData7.put("nwSrc", "10.0.0.16");
		postData7.put("nwDst", "10.0.0.61");
		postData7.put("installInHw", "true");
		postData7.put("priority", "501");
		postData7.put("ingressPort", "1");
		postData7.put("etherType", "0x800");
		postData7.put("actions", new JSONArray().put("OUTPUT=3").put("SET_DL_DST=52:54:00:12:34:60"));

		// Node on which this flow should be installed
		JSONObject node6 = new JSONObject();
		node6.put("id", "00:00:00:13:3b:89:16:80");
		node6.put("type", "OF");
		postData7.put("node", node6);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:89:16:80", "ControlFlow_OVS6_nwSrc_10.0.0.16_nwDst_61", postData7);

		// Sample post data.
		JSONObject postData8 = new JSONObject();
		postData8.put("name", "ControlFlow_OVS6_nwSrc_10.0.0.61_nwDst_16");
		postData8.put("nwSrc", "10.0.0.61");
		postData8.put("nwDst", "10.0.0.16");
		postData8.put("installInHw", "true");
		postData8.put("priority", "501");
		postData8.put("ingressPort", "3");
		postData8.put("etherType", "0x800");
		postData8.put("actions", new JSONArray().put("OUTPUT=1"));

		// Node on which this flow should be installed
		postData8.put("node", node6);

		// Actual flow install
		FlowManager.installFlow("00:00:00:13:3b:89:16:80", "ControlFlow_OVS6_nwSrc_10.0.0.61_nwDst_16", postData8);
	}
}
