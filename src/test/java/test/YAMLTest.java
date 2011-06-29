package test;

import org.ho.yaml.Yaml;
import org.junit.BeforeClass;
import org.junit.Test;
import test.bean.Entity;
import test.bean.Info;
import test.bean.Receipty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class YAMLTest {
	private static File yamlFile;

	@BeforeClass
	public static void init() {
		yamlFile = new File("src/test/resources/test.yml");
	}

	@Test
	public void testConfig() {
		// First load a YAML string into an object
		String dog = "---\n  animal: dog\n  qualities:\n    - loyal\n    - friendly\n    - furry\n";
		Object test = Yaml.load(dog);
		System.out.println("Dog: " + test);

		// Now spit the object back out as a YAML string
		System.out.println("");
		System.out.println(Yaml.dump(test, true));

		// type
		Info info = Yaml.loadType(dog, Info.class);
		System.out.println(Yaml.dump(info, true));
		System.out.println("Dog: " + test);
		// We can also load YAML from a file
		try {
			File f = new File("yml/mydata.yml");
			Object mydata = Yaml.load(f);
			System.out.println(mydata);
		} catch (FileNotFoundException e) {
			System.out.println("Not found!");
		}
	}

	@Test
	public void testDemo() {
		String s = "---\n  a: cat\n  dog:\n    - loyal\n    - friendly\n    - furry\n";
		System.out.println(s);
		Map a = (Map) Yaml.load(s);
		System.out.println("This should print loyal: "
				+ ((List) a.get("dog")).get(0));

		String s2 = Yaml.dump(a);
		System.out.println("Here is the object encoded back to a YAML string:");
		System.out.println(s2);
	}

	@Test
	public void testLoadByMap() {
		try {
			Object obj = Yaml.load(yamlFile);
			if (obj != null && obj instanceof Map) {
				for (Object key : ((Map) obj).keySet()) {
					Object val = ((Map) obj).get(key);
					System.out.printf("^:%s,%s\n", key.getClass().getName(),
							val.getClass().getName());
					if (val instanceof Collection) {
						for (Iterator it = ((Collection) val).iterator(); it
								.hasNext();) {
							Object item = it.next();
							System.out.printf("^^^:%s,%s\n", item.getClass()
									.getName(), item);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testLoadByType() {
		try {
			Entity entity = Yaml.loadType(yamlFile, Entity.class);
			System.out.printf("%s,%s\n", entity, entity.getReceipts()
					.getClass());
			for (Receipty rty : entity.getReceipts()) {
				System.out.printf("item:%s,%s,%s\n", rty.getStore(),
						rty.getCategory(), rty.getTotal());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
