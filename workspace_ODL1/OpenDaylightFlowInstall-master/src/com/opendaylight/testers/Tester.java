package com.opendaylight.testers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.opendaylight.managers.FlowManager;
import com.opendaylight.managers.VtnManager;

import com.opendaylight.settings.SetFlows;
import com.opendaylight.settings.SetVtns;
import com.opendaylight.settings.SetFlowsPerRouter;
import com.opendaylight.settings.SetFlowsForSampling;

public class Tester {

	private static final String node1 = "00:00:00:13:3b:8b:28:27";
	private static final String node2 = "00:00:00:13:3b:8b:29:80";
	private static final String node3 = "00:00:00:13:3b:8b:27:e7";
	private static final String node4 = "00:00:00:13:3b:8b:46:c3";
	private static final String node5 = "00:00:00:13:3b:8b:49:14";
	private static final String node6 = "00:00:00:13:3b:89:16:80";

	public static void deleteFlow() {
		/*
		 * FlowManager.deleteFlow("Flow1_OVS1_nwDst_10.0.0.41", node1);
		 * FlowManager.deleteFlow("Flow2_OVS1_nwDst_10.0.0.51", node1);
		 * FlowManager.deleteFlow("Flow2_OVS1_nwDst_10.0.0.12", node1);
		 * FlowManager.deleteFlow("Flow1_OVS1_nwDst_10.0.0.11", node1);
		 * 
		 * FlowManager.deleteFlow("Flow1_OVS2_nwDst_10.0.0.41", node2);
		 * FlowManager.deleteFlow("Flow2_OVS2_nwDst_10.0.0.51", node2);
		 * FlowManager.deleteFlow("Flow1_OVS2_nwDst_10.0.0.11", node2);
		 * FlowManager.deleteFlow("Flow2_OVS2_nwDst_10.0.0.12", node2);
		 * 
		 * FlowManager.deleteFlow("Flow2_OVS3_nwDst_10.0.0.12", node3);
		 * FlowManager.deleteFlow("Flow3_OVS3_nwDst_10.0.0.61", node3);
		 * FlowManager.deleteFlow("Flow3_OVS3_nwDst_10.0.0.51", node3);
		 * FlowManager.deleteFlow("Flow2_OVS3_nwDst_10.0.0.51", node3);
		 * 
		 * FlowManager.deleteFlow("Flow1_OVS4_nwDst_10.0.0.41", node4);
		 * FlowManager.deleteFlow("Flow1_OVS4_nwDst_10.0.0.11", node4);
		 * 
		 * FlowManager.deleteFlow("Flow2_OVS5_nwDst_10.0.0.51", node5);
		 * FlowManager.deleteFlow("Flow3_OVS5_nwDst_10.0.0.51", node5);
		 * FlowManager.deleteFlow("Flow3_OVS5_nwDst_10.0.0.61", node5);
		 * FlowManager.deleteFlow("Flow2_OVS5_nwDst_10.0.0.12", node5);
		 * 
		 * FlowManager.deleteFlow("Flow3_OVS6_nwDst_10.0.0.61", node6);
		 * FlowManager.deleteFlow("Flow3_OVS6_nwDst_10.0.0.51", node6);
		 */

	}

	public static void deleteControlFlow() {
		FlowManager.deleteFlow("ControlFlow_OVS1_nwSrc_10.0.0.11_nwDst_16", node1);
		FlowManager.deleteFlow("ControlFlow_OVS1_nwSrc_10.0.0.16_nwDst_11", node1);
		FlowManager.deleteFlow("ControlFlow_OVS1_nwSrc_10.0.0.12_nwDst_16", node1);
		FlowManager.deleteFlow("ControlFlow_OVS1_nwSrc_10.0.0.16_nwDst_12", node1);
		FlowManager.deleteFlow("ControlFlow_OVS1_nwSrc_10.0.0.16_nwDst_61", node1);
		FlowManager.deleteFlow("ControlFlow_OVS1_nwSrc_10.0.0.61_nwDst_16", node1);

		FlowManager.deleteFlow("ControlFlow_OVS6_nwSrc_10.0.0.16_nwDst_61", node6);
		FlowManager.deleteFlow("ControlFlow_OVS6_nwSrc_10.0.0.61_nwDst_16", node6);
	}

	public static void setFlowsPerFlow(String PcP1, String PcP2, String PcP3) throws JSONException {
		SetFlows.setFlow1(PcP1);
		SetFlows.setFlow2(PcP2);
		SetFlows.setFlow3(PcP3);
	}

	public static void setFlowsPerRouter(int RNum, String PcP1, String PcP2) throws JSONException {
		if (RNum == 1) {
			SetFlowsPerRouter.setRouter1(PcP1, PcP2);
		} else if (RNum == 2) {
			SetFlowsPerRouter.setRouter2(PcP1, PcP2);
		} else if (RNum == 3) {
			SetFlowsPerRouter.setRouter3(PcP1, PcP2);
		} else if (RNum == 4) {
			SetFlowsPerRouter.setRouter4(PcP1);
		} else if (RNum == 5) {
			SetFlowsPerRouter.setRouter5(PcP1, PcP2);
		} else if (RNum == 6) {
			SetFlowsPerRouter.setRouter6(PcP1);
		} else {
			System.out.println("Doesn't exist Router.");
		}
	}

	public static void setNormalFlowsForSampling() throws JSONException {
		SetFlowsForSampling.setNormalFlow2();
		SetFlowsForSampling.setNormalFlow3();
		SetFlowsForSampling.setNormalFlow4();
		SetFlowsForSampling.setNormalFlow5();
		// SetFlowsForSampling.setNormalFlow6();
	}

	public static void setMaliciousFlowsForSampling() throws JSONException {
		SetFlowsForSampling.setMaliciousFlow1();
	}

	public static void main(String[] args) throws JSONException, InterruptedException {
		/* flows add */

		// SetFlows.setFlow1("2");
		// SetFlows.setFlow2("2");
		// SetFlows.setFlow3("2");

		/* flows statistics read & save */

		// Timer timer = new Timer(true);
		// TimerTask task1 = new WorkTask();
		// TimerTask task2 = new WorkTask1();

		// timer.schedule(task1, 10000);
		// timer.schedule(task2, 12000);

		// Thread.sleep(20000);

		/* algorithm */

		/* Flow Test */

		// deleteFlow();
		// SetFlows.setControlFlow();
		// setFlowsPerFlow("1","1","1");

		// setFlowsPerRouter(1, "1", "1");
		// setFlowsPerRouter(2, "1", "1");
		// setFlowsPerRouter(3, "1", "1");
		// setFlowsPerRouter(5, "1", "1");
		//
		// setFlowsPerRouter(4, "1", "1");
		// setFlowsPerRouter(6, "1", "1");

		// System.out.println("start1");
		// for(int i=0; i<10000; i++) System.out.println("start2");
		//
		// System.out.println("start3");
		//
		// ping();

		// deleteControlFlow();
		// SetFlows.setControlFlow();
		// deleteFlow();
		// setFlowsPerFlow("1", "1", "1");

		// FlowManager.getFlowStatistics();
		// FlowManager.getFlowConfig();

		/*
		 * try { BufferedWriter perFlow = new BufferedWriter(new
		 * FileWriter("per_flow.txt"));
		 * 
		 * for (int i = 1; i <= 2; i++) { for (int j = 1; j <= 2; j++) { for
		 * (int k = 1; k <= 2; k++) { String prioFlow1 = Integer.toString(i);
		 * String prioFlow2 = Integer.toString(j); String prioFlow3 =
		 * Integer.toString(k);
		 * 
		 * deleteFlow(); setFlowsPerFlow(prioFlow1, prioFlow2, prioFlow3);
		 * 
		 * //System.out.println(1); Thread.sleep(3000); //System.out.println(2);
		 * 
		 * ping();
		 * 
		 * perFlow.write(prioFlow1 + " " + prioFlow2 + " " + prioFlow3 + " " +
		 * avg[0] + " " + avg[1] + " " + avg[2]); perFlow.newLine(); } } }
		 * perFlow.close(); } catch (IOException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */

		// FlowManager.getFlowConfig();
		// FlowManager.getFlowStatistics();

		/* Vtn Test */
		// SetVtns.setVtn("BLUE");
		// SetVtns.setVBridge("BLUE", "br100");
		// SetVtns.setVlanInterface("BLUE", "br100", "IF1");
		// SetVtns.setVlanInterface("BLUE", "br100", "IF2");
		// SetVtns.setPortMap("BLUE", "br100", "IF1", node1, "3", "tap0");
		// SetVtns.setPortMap("BLUE", "br100", "IF2", node5, "3", "tap0");

		// VtnManager.getVtnInfo("BLUE");
		// VtnManager.getVtnPortMapInfo("BLUE", "br100", "IF2");

		// VtnManager.deleteVtn("BLUE");

		/* sampling exp */

		// setNormalFlowsForSampling();
		// setMaliciousFlowsForSampling();
		// SetFlowsForSampling.setControlFlow();
		// FlowManager.getFlowStatistics();
		// FlowManager.getFlowConfig();

		int sumAlert = 0;
		int dropThreshold = 0;
		long start, end;
		int dropFlag = 0;
		int sumAlert_old = 0;
		int l_history = 0;

		/* initialize */

		start = System.currentTimeMillis();

		samplingUpdate();

		// record initial number of alert
		sumAlert = statiscticsAlertUpdate();
		dropThreshold = sumAlert;
		FileWriter(sumAlert);

		// initalize l_history
		lFileWriter(l_history);

		end = System.currentTimeMillis();

		// record initialize runtime
		TimeFileWriter((end - start) / 1000.0);
		System.out.println("init run time : " + (end - start) / 1000.0 + " sec");
		System.out.println(" ");

		// algorithm

		for (int i = 0; i <= 10000; i++) {
			start = System.currentTimeMillis();

			// record sum of alert
			sumAlert = statiscticsAlertUpdate();
			FileWriter(sumAlert);

			// perform algorithm & update sampling rate
			if (sumAlert - sumAlert_old != 0 && sumAlert - dropThreshold != 0) {
				//samplingAlgorithm();
				//samplingUpdate();
			}

			end = System.currentTimeMillis();

			// drop the malicious flow
			if (sumAlert - dropThreshold > 400 && dropFlag == 0) {
				// FlowManager.deleteFlow("mFlow1_OVS1_nwDst_10.0.0.21", node1);
				SetFlowsForSampling.setDropMaliciousFlow();
				DropTimeFileWriter("drop!");		
				System.out.println("drop!");
				// System.out.println(" ");
				dropFlag = 1;		
			}
			
			// record runtime
			TimeFileWriter((end - start) / 1000.0);
			System.out.println("run time : " + (end - start) / 1000.0 + " sec");

			System.out.println("num alert : " + (sumAlert - dropThreshold));
			System.out.println(" ");
			
			sumAlert_old = sumAlert;
		}
	}

	/*
	 * public static class WorkTask extends TimerTask {
	 * 
	 * @Override public void run() {
	 * 
	 * FlowManager.getFlowStatistics(); } }
	 * 
	 * public static class WorkTask1 extends TimerTask {
	 * 
	 * @Override public void run() {
	 * 
	 * try { SetFlows.setFlow2("2"); } catch (JSONException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } } }
	 */
	public static BufferedWriter writer = null;

	public static double[] avg = { 0, 0, 0 };

	public static void ping() // (String ip, double interval)
	{

		try {
			/*
			 * if(writer == null) { BufferedWriter writer = new
			 * BufferedWriter(new FileWriter("data.txt")); }
			 */

			String command = "/home/wits_controller/ping_test.sh";
			Process proc;

			proc = Runtime.getRuntime().exec(command);
			BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			while (reader.readLine() != null) {
			}
			reader.close();
			proc.waitFor();
			proc.destroy();

			for (int i = 0; i < 3; i++) {
				reader = new BufferedReader(new FileReader("/home/wits_controller/samba/flow" + (i + 1) + ".txt"));
				reader.readLine();
				String line;
				while ((line = reader.readLine()) != null) {
					// System.out.println(line.split(" ")[0]);
					if (line.split(" ")[0].equals("rtt")) {
						// System.out.println(line.split("/")[4]);
						avg[i] = Double.parseDouble(line.split("/")[4]);
						System.out.println("flow" + (i + 1) + ": " + line);
					}
				}

				reader.close();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static int count(String name, BufferedReader in) throws IOException {
		int numLines = 0;
		String line;
		do {
			line = in.readLine();
			if (line != null) {
				numLines++;
			}
		} while (line != null);
		System.out.println(name + "\t" + numLines);
		return numLines;
	}

	private static int lineCount(String fileName) {
		BufferedReader in = null;
		int sumAlert = 0;
		try {
			FileReader fileReader = new FileReader(fileName);
			in = new BufferedReader(fileReader);
			sumAlert = count(fileName, in);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
		return sumAlert;
	}

	public static void FileWriter(int sumAlert) {

		String fileName = "/home/wits_controller/IDS_Alert/AlertStatistics.txt";
		String sum = String.valueOf(sumAlert);
		// String per = String.valueOf(perAlert);
		try {

			// BufferedWriter 와 FileWriter를 조합하여 사용 (속도 향상)
			BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));

			// 파일안에 문자열 쓰기
			fw.write(sum);
			fw.newLine();
			fw.flush();

			// 객체 닫기
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static int statiscticsAlertUpdate() {
		int sumAlert = 0;
		try {
			String command = "scp root@192.168.1.70:/var/log/snort/alert /home/wits_controller/IDS_Alert";
			Process proc;
			proc = Runtime.getRuntime().exec(command);
			proc.waitFor();
			proc.destroy();

			sumAlert = lineCount("/home/wits_controller/IDS_Alert/alert");
			// monitoringDir("/home/wits_controller/alert");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sumAlert;
	}

	public static void samplingUpdate() {

		List<String> rateList = getRateList("/home/wits_controller/IDS_Alert/rate.txt");
		String rate1 = null, rate2 = null, rate3 = null, rate4 = null, rate5 = null, rate6 = null;
		// for(String biz : rateList){
		for (int i = 0; i < rateList.size(); i++) {
			rate1 = rateList.get(0);
			rate2 = rateList.get(1);
			rate3 = rateList.get(2);
			rate4 = rateList.get(3);
			rate5 = rateList.get(4);
			rate6 = rateList.get(5);
		}
		try {
			String command = "/home/wits_controller/IDS_Alert/rate.sh " + rate1 + " " + rate2 + " " + rate3 + " "
					+ rate4 + " " + rate5 + " " + rate6;
			Process proc;
			proc = Runtime.getRuntime().exec(command);
			proc.waitFor();
			proc.destroy();

			System.out.println("rate updated");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static List<String> getRateList(String filePath) {
		List<String> rateList = null;
		BufferedReader br = null;

		if (!(filePath == null)) {
			rateList = new ArrayList<String>();
			try {
				br = new BufferedReader(new FileReader(filePath));
				String s;

				while ((s = br.readLine()) != null) {
					rateList.add(s);
				}
				br.close();
			} catch (IOException e) {
				System.err.println(e);
			} finally {
				try {
					if (br != null) {
						br.close();
					}
				} catch (Exception ex) {
				}
			}
		}

		return rateList;
	}

	public static void samplingAlgorithm() {
		try {
			String command = "/home/wits_controller/IDS_Alert/matlab_test.sh";
			Process proc;
			proc = Runtime.getRuntime().exec(command);
			proc.waitFor();
			proc.destroy();
			System.out.println("algorithm end");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void TimeFileWriter(double d) {

		String fileName = "/home/wits_controller/IDS_Alert/TimeStatistics.txt";
		String runtime = String.valueOf(d);
		// String per = String.valueOf(perAlert);
		try {

			// BufferedWriter 와 FileWriter를 조합하여 사용 (속도 향상)
			BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));

			// 파일안에 문자열 쓰기
			fw.write(runtime);
			fw.newLine();
			fw.flush();

			// 객체 닫기
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void DropTimeFileWriter(String d) {

		String fileName = "/home/wits_controller/IDS_Alert/TimeStatistics.txt";
		String droptime = d;
		// String per = String.valueOf(perAlert);
		try {

			// BufferedWriter 와 FileWriter를 조합하여 사용 (속도 향상)
			BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));

			// 파일안에 문자열 쓰기
			fw.write(droptime);
			fw.newLine();
			fw.flush();

			// 객체 닫기
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void lFileWriter(int d) {

		String fileName = "/home/wits_controller/IDS_Alert/l_history.txt";
		String init = String.valueOf(d);
		// String per = String.valueOf(perAlert);
		try {

			// BufferedWriter 와 FileWriter를 조합하여 사용 (속도 향상)
			BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, false));

			// 파일안에 문자열 쓰기
			fw.write(init);
			fw.newLine();
			fw.flush();

			// 객체 닫기
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/*
	 * private static void monitoringDir(String dir) throws IOException,
	 * InterruptedException {
	 * 
	 * WatchService myWatchService = FileSystems.getDefault().newWatchService();
	 * 
	 * // 모니터링을 원하는 디렉토리 Path를 얻는다. Path path = Paths.get(dir); // Get the
	 * directory to be monitored
	 * 
	 * // 모니터링 서비스를 할 path에 의해 파일로케이션을 등록 WatchKey watchKey =
	 * path.register(myWatchService, StandardWatchEventKinds.ENTRY_CREATE,
	 * StandardWatchEventKinds.ENTRY_MODIFY,
	 * StandardWatchEventKinds.ENTRY_DELETE); // Register // the // directory
	 * 
	 * // 무한루프 while (true) { // 변화가 감지되는 경우 이벤트 종류와 파일명을 출력 for (WatchEvent
	 * event : watchKey.pollEvents()) { System.out.println(event.kind() + ": " +
	 * event.context()); }
	 * 
	 * // * Resets this watch key. // * @return {@code true} if the watch key is
	 * valid and has been // reset // * {@code false} if the watch key could not
	 * be reset because it is // * no longer {@link #isValid valid}, 디렉토리등이 삭제되는
	 * 경우 if (!watchKey.reset()) { break; // 디렉토리등이 삭제되는 경우 } } }
	 */

}
