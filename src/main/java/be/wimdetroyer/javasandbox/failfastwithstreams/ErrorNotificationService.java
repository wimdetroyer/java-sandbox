package be.wimdetroyer.javasandbox.failfastwithstreams;

public class ErrorNotificationService {

  public void notify(Error error) {
    System.out.println("Got an error...! notifying somebody" + error);
  }
}
