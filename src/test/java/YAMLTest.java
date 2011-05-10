import java.io.File;
import java.io.FileNotFoundException;

import org.ho.yaml.Yaml;
import org.junit.Test;

public class YAMLTest{

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
		Info info = Yaml.loadType(dog,Info.class);	
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
}
