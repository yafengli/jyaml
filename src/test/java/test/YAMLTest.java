package test;

import org.ho.yaml.Yaml;
import org.junit.Test;
import test.bean.Entity;
import test.bean.Info;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class YAMLTest {

	@Test
	public void testConfig() {
		// First load a YAML string into an object
		String dog = "---\n  animal: dog\n  qualities:\n    - loyal\n    - friendly\n    - furry\n";
		Object test = Yaml.load(dog);
		System.out.println("Dog: " + test);

		// Now spit the object back out as a YAML string
		System.out.println("");
		System.out.println(Yaml.dump(test, true));

		//type
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
		System.out.println("This should print loyal: " + ((List) a.get("dog")).get(0));

		String s2 = Yaml.dump(a);
		System.out.println("Here is the object encoded back to a YAML string:");
		System.out.println(s2);
	}

	@Test
	public void testYaml() {
		File f = new File("src/test/resources/test.yml");
		System.out.printf("$file absolute path:$%s\n", f.getAbsolutePath());
		try {
			Object obj = Yaml.load(f);
			System.out.println(obj);
			Entity entity = Yaml.loadType(f, Entity.class);
			System.out.println(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
