package horloge;

import java.net.InetAddress;
import java.util.Calendar;
import java.util.GregorianCalendar;

import td1.HorlogePOA;

public class HorlogeImpl extends HorlogePOA {
  private String localite;
  private GregorianCalendar calendar = new GregorianCalendar();
  private long setTime = System.currentTimeMillis();

  public HorlogeImpl() {
    super();
    try {
      localite = InetAddress.getLocalHost().getHostName();
    } catch (Exception e) {
      localite = "Unknown";
    }
  }

  public String getTime() {
    Calendar currentTime = new GregorianCalendar();
    long offsetTime =currentTime.getTimeInMillis()  - setTime;
    currentTime.setTimeInMillis(calendar.getTimeInMillis() + offsetTime);
    String time = currentTime.getTime().toString();
    System.err.println(time);
    return time;
  }

  public void setHours(short val) {
    calendar.set(Calendar.HOUR_OF_DAY, val);
    setTime = System.currentTimeMillis();
    System.err.println("set_hours " + val);
  }

  public void setMinutes(short val) {
    calendar.set(Calendar.MINUTE, val);
    setTime = System.currentTimeMillis();
    System.err.println("set_minutes " + val);
  }

  public String localite() {
    System.err.println("Reading localite");
    return localite;
  }
}