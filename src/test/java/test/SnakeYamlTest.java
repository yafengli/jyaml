package test;

import org.junit.Test;
import org.yaml.snakeyaml.Yaml;
import test.bean.Entity;

import java.io.File;
import java.io.FileInputStream;

public class SnakeYamlTest {
  @Test
  public void testYaml() {
    Yaml yaml = new Yaml();

    File f = new File("src/test/resources/test.yml");
    //读入文件
    try {
      Entity result = yaml.loadAs(new FileInputStream(f), Entity.class);
      System.out.println(result);

      System.out.println(yaml.dump(result));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
