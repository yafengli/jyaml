package test;

import org.junit.BeforeClass;
import org.junit.Test;

import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;
import java.time.Duration;

import static java.net.http.HttpClient.Redirect;
import static java.net.http.HttpClient.Version;

public class HTTPTest {
  static HttpClient client;
  static HttpRequest request;

  @BeforeClass
  public static void init() {
    try {
      client = HttpClient.newBuilder()
          .version(Version.HTTP_1_1)
          .followRedirects(Redirect.NORMAL)
          .connectTimeout(Duration.ofSeconds(20))
          //.proxy(ProxySelector.of(new InetSocketAddress("127.0.0.1", 8989)))
          //.authenticator(Authenticator.getDefault())
          .build();
      request = HttpRequest.newBuilder()
          .uri(URI.create("https://www.baidu.com/"))
          //.uri(URI.create("https://www.google.com/"))
          .timeout(Duration.ofMinutes(2))
          .header("Content-Type", "application/json")
          //.POST(HttpRequest.BodyPublishers.ofFile(Paths.get("file.json")))
          .GET()
          .build();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testSyn() {
    try {
      var response = client.send(request, HttpResponse.BodyHandlers.ofString());
      System.out.println(response.statusCode());
      System.out.println(response.body());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testAsync() {
    var future = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
        .thenApply(HttpResponse::body)
        .thenAccept(System.out::println);
    try {
      Thread.sleep(1000);
      if (future.isDone()) System.out.println("Future is done.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
