package kapitel7;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
	/**
	 * Liefert die Werte aus inputs zu den in indexes gegebenen Index-Werten als Liste.
	 */
	static List<Integer> selectData(int[] inputs, int[] indexes) {
		List<Integer> list = new ArrayList<>();
		
		for (int index : indexes) {
			// Fehlervermeidung
			if (index >= inputs.length || index < 0) {
				continue;
			}
			// Hauptablauf
			list.add(inputs[index]);
		}
		
		return list;
	}
	
	/**
	 * Liefert die Werte aus inputs zu den in indexes gegebenen Index-Werten als Liste.
	 */
	static List<Integer> selectData2(int[] inputs, int[] indexes) {
		List<Integer> list = new ArrayList<>();
		
		for (int index : indexes) {
			// Hauptablauf
			try {
				list.add(inputs[index]);
			} catch (ArrayIndexOutOfBoundsException e) {
				// ignore
			} catch (Exception ex) {
				// muss als letztes stehen, fängt alle Exceptions
				if (ex instanceof IndexOutOfBoundsException) {
					// ...
				}
			}
		}
		
		return list;
	}

	public static void main(String[] args) {
		List<Integer> result = selectData2(
				new int[] { -99, 23, 3, 0, 1000, 134 }, 
				new int[] { 1, 200, 0, -10 });
		for (int i : result) {
			System.out.println(i);
		}
	}

}
