/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

/**
 *
 * @author Admins
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class sfsdfdsf {
   



	public static void main(String[] args) {
		
		Map<String, Integer> mapString = new HashMap<String, Integer>();
		String sourceStr = "day nhau hoc. hoc nhau day. HOC hoc ?? ^_^ day day. day MA khong hoc".toLowerCase();
		String[] des = sourceStr.split("[^a-zA-Z0-9']+");
		System.out.println(Arrays.asList(des));
		mapString.put(des[0], 1);
		for (int i = 1; i < des.length; i++) {
			if (mapString.containsKey(des[i])) {
				int currentVal = mapString.get(des[i]);
				mapString.put(des[i], ++currentVal);
			} else {
				mapString.put(des[i], 1);
			}

		}
		Map<String, Integer> sortedMap = sortByValue(mapString);
		for (Map.Entry m : sortedMap.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}

	}

	private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

		// 1. Convert Map to List of Map
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

		// 2. Sort list with Collections.sort(), provide a custom Comparator
		// Try switch the o1 o2 position for a different order
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		// 3. Loop the sorted list and put it into a new insertion order Map
		// LinkedHashMap
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}


}
