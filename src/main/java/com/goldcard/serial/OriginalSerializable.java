package com.goldcard.serial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class OriginalSerializable {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		long start = System.currentTimeMillis();
		setSerializableObject();
		System.out.println("java原生序列化时间:" + (System.currentTimeMillis() - start) + " ms");
		start = System.currentTimeMillis();
		getSerializableObject();
		System.out.println("java原生反序列化时间:" + (System.currentTimeMillis() - start) + " ms");
	}

	public static void setSerializableObject() throws IOException {

		FileOutputStream fo = new FileOutputStream("simple.bin");

		ObjectOutputStream so = new ObjectOutputStream(fo);

		for (int i = 0; i < 100000; i++) {
			Map<String, Integer> map = new HashMap<String, Integer>(2);
			map.put("zhang0", i);
			map.put("zhang1", i);
			so.writeObject(new Simple("zhang" + i, (i + 1), map));
		}
		so.flush();
		so.close();
	}

	public static void getSerializableObject() {
		FileInputStream fi = null;
		ObjectInputStream si = null;
		try {
			fi = new FileInputStream("simple.bin");
			si = new ObjectInputStream(fi);

			Simple simple = null;
			simple = (Simple) si.readObject();
			while ((simple = (Simple) si.readObject()) != null) {
				// System.out.println(simple.getAge() + " " + simple.getName());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				fi.close();
				si.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

}