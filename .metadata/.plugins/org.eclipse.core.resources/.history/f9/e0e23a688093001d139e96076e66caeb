package com.december30.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class BAUtils {

		private static Scanner scan = new Scanner(System.in);

		public static void footer() {
			System.out.println("\n\n\tProgramı kullandığınız için teşekkürler");
			System.out.println("\t\tTekrar görüşmek üzere");
			closeResources();
		}

		public static int menu(HashMap<Integer, String> menuItems) {
			boolean correctAnswer = false;
			int selection = -1;
			do {
				showMenuItems(menuItems);
				selection = getUserSelection();
				correctAnswer = evaluateAnswer(menuItems, selection);
			} while (!correctAnswer);
			return selection;
		}

		private static boolean evaluateAnswer(HashMap<Integer, String> menuItems, int selection) {
			return menuItems.containsKey(selection);
		}

		private static int getUserSelection() {
			return readInt("Lütfen seçiminizi yapınız");
		}

		private static void showMenuItems(HashMap<Integer, String> menuItems) {
			// Set<Entry<Integer, String>> items = menuItems.entrySet();
			ArrayList<Integer> keys = new ArrayList<Integer>(menuItems.keySet());
			Collections.sort(keys);
			// for (int i = 0; i < keys.size(); i++) {
			// int key = keys.get(i);
			// System.out.println("\t(" + key + ") .... " + menuItems.get(key).trim());
			// }
			for (Integer key : keys) {
				System.out.println("\t(" + key + ") .... " + menuItems.get(key).trim());
			}
			System.out.println();
		}

		public static void header(String title) {
			// ===========
			// ** title **
			// ===========
			int len = title.length();
			StringBuilder row = new StringBuilder("");
			for (int i = 0; i < (len + 6); i++) {
				row.append("=");
			}
			System.err.println("\n\n\t\t" + row);
			System.err.println("\t\t** " + title.toUpperCase() + " **");
			System.err.println("\t\t" + row + "\n");
		}

		public static String readString(String query) {
			showQuery(query);
			String retVal = scan.nextLine();
			return retVal;
		}

		private static void showQuery(String query) {
			System.out.print("\t" + query + ": ");
		}

		public static int readInt(String query) {
			int retVal = Integer.MIN_VALUE;
			showQuery(query);
			try {
				retVal = scan.nextInt();
			} catch (Exception e) {
				System.out.println("Lütfen sayı gir");
			} finally {
				scan.nextLine();
			}
			return retVal;
		}

		public static int[] readInt(String start, String query, int numElements) {
			showQuery(start + " " + numElements + " " + query + "\n");
			int[] retVal = new int[numElements];
			for (int i = 0; i < numElements; i++) {
				System.out.print((i + 1) + ". değeri giriniz: ");
				retVal[i] = scan.nextInt();
			}
			scan.nextLine();
			return retVal;
		}

		public static double readDouble(String query) {
			double retVal = Double.NEGATIVE_INFINITY;
			showQuery(query);
			retVal = scan.nextDouble();
			scan.nextLine();
			return retVal;
		}

		public static void closeResources() {
			scan.close();
		}

		public static boolean wantToEnd(String question, String negativeAnswer) {
			boolean retVal = true;
			showQuery(question);
			String answer = scan.next();
			retVal = answer.equalsIgnoreCase(negativeAnswer);
			scan.nextLine();
			return !retVal;
		}

		/*
		 * public static boolean proceeding(String question, String positiveAnswer) {
		 * return readString(question).equalsIgnoreCase(positiveAnswer); }
		 */ /**
			 * long şeklinde belirtilmiş bir zaman bilgisini dd.MMM.yyyy şeklinde ger döner
			 *
			 * @param timestamp zaman bilgisi
			 * @return
			 */
		public static String dateAsString(long timestamp) {
			LocalDateTime dateTime = LocalDateTime.ofEpochSecond(timestamp, 0, ZoneOffset.UTC);
			return dateTime.format(DateTimeFormatter.ofPattern("dd.MMM.yyyy"));
		}

		/**
		 * long şeklinde belirtilmiş bir zaman bilgisini dd.MMM.yyyy şeklinde ger döner
		 *
		 * @param timestamp zaman bilgisi
		 * @return
		 */
		public static String timeAsString(long timestamp) {
			LocalDateTime dateTime = LocalDateTime.ofEpochSecond(timestamp, 0, ZoneOffset.UTC);
			return dateTime.format(DateTimeFormatter.ofPattern("HH:mm"));
		}

}
