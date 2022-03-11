package common;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;

/**
 * @author lihailong
 * @since 2021/08/16 10:38:09
 */
public class GeoHash {

  public static final double MIN_LAT = -90;
  public static final double MAX_LAT = 90;
  public static final double MIN_LNG = -180;
  public static final double MAX_LNG = 180;

  private static final int numBits = 3 * 5;

  private static double minLat;
  private static double minLng;

  private static final char[] digits = {
    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'k', 'm',
    'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
  };

  // 定义编码映射关系
  static final HashMap<Character, Integer> lookup = new HashMap<>();

  static {
    int i = 0;
    for (char c : digits) {
      lookup.put(c, i++);
    }
  }

  public GeoHash() {
    setMinLatLng();
  }

  public List<String> getAroundGeoHash(double lat, double lng) {
    List<String> list = new ArrayList<>();
    double upLat = lat + minLat;
    double downLat = lat - minLat;

    double leftLng = lng - minLng;
    double rightLng = lng + minLng;

    for (double i : new double[] {upLat, lat, downLat}) {
      for (double j : new double[] {leftLng, lng, rightLng}) {
        list.add(encode(i, j));
      }
    }

    //    String leftUp = encode(upLat, leftLng);
    //    list.add(leftUp);
    //
    //    String leftMid = encode(lat, leftLng);
    //    list.add(leftMid);
    //
    //    String leftDown = encode(downLat, leftLng);
    //    list.add(leftDown);
    //
    //    String midUp = encode(upLat, lng);
    //    list.add(midUp);
    //
    //    String midMid = encode(lat, lng);
    //    list.add(midMid);
    //
    //    String midDown = encode(lat, minLng);
    //    list.add(midDown);
    //
    //    String rightUp = encode(upLat, rightLng);
    //    list.add(rightUp);
    //
    //    String rightMid = encode(lat, rightLng);
    //    list.add(rightMid);
    //
    //    String rightDown = encode(downLat, rightLng);
    //    list.add(rightDown);

    return list;
  }

  public String encode(double lat, double lng) {
    BitSet latBits = getBits(lat, MIN_LAT, MAX_LAT);
    BitSet lngBits = getBits(lng, MIN_LNG, MAX_LNG);

    StringBuilder buffer = new StringBuilder();

    for (int i = 0; i < numBits; i++) {
      buffer.append(lngBits.get(i) ? 1 : 0);
      buffer.append(latBits.get(i) ? 1 : 0);
    }

    return base32(Long.parseLong(buffer.toString(), 2));
  }

  public double[] decode(String geoHash) {
    StringBuilder buffer = new StringBuilder();
    for (char c : geoHash.toCharArray()) {
      int i = lookup.get(c) + 32;
      buffer.append(Integer.toString(i, 2).substring(1));
    }

    BitSet lngSet = new BitSet();
    BitSet latSet = new BitSet();

    int j = 0;
    for (int i = 0; i < numBits * 2; i += 2) {
      boolean isSet = false;
      if (i < buffer.length()) {
        isSet = buffer.charAt(i) == '1';
      }
      lngSet.set(j++, isSet);
    }

    j = 0;
    for (int i = 0; i < numBits * 2; i += 2) {
      boolean isSet = false;
      if (i < buffer.length()) {
        isSet = buffer.charAt(i) == '1';
      }
      latSet.set(j++, isSet);
    }

    double lng = decode(lngSet, MIN_LNG, MAX_LNG);
    double lat = decode(latSet, MIN_LAT, MAX_LAT);
    return new double[] {lng, lat};
  }

  private double decode(BitSet bs, double min, double max) {
    double mid = 0;
    for (int i = 0; i < bs.length(); i++) {
      mid = (min + max) / 2;
      if (bs.get(i)) min = mid;
      else max = mid;
    }
    return mid;
  }

  private BitSet getBits(double val, double min, double max) {
    BitSet buffer = new BitSet(numBits);

    for (int i = 0; i < numBits; i++) {
      double mid = (min + max) / 2;
      if (val >= mid) {
        buffer.set(i);
        min = mid;
      } else {
        max = mid;
      }
    }

    return buffer;
  }

  private String base32(long i) {
    char[] buf = new char[65];
    int charPos = 64;
    boolean negative = (i < 0);
    if (!negative) {
      i = -i;
    }

    while (i <= -32) {
      buf[charPos--] = digits[(int) (-(i % 32))];
      i /= 32;
    }

    buf[charPos] = digits[(int) (-i)];
    if (negative) {
      buf[--charPos] = '-';
    }
    return new String(buf, charPos, (65 - charPos));
  }

  private void setMinLatLng() {
    minLat = MAX_LAT - MIN_LAT;
    for (int i = 0; i < numBits; i++) {
      minLat /= 2.0;
    }

    minLng = MAX_LNG - MIN_LAT;
    for (int i = 0; i < numBits; i++) {
      minLng /= 2;
    }
  }

  public static void main(String[] args) {
    GeoHash geoHash = new GeoHash();
    final String encode = geoHash.encode(40.222012, 116.248283);
    System.out.println(encode);
    final List<String> aroundGeoHash = geoHash.getAroundGeoHash(40.222012, 116.248283);
    System.out.println(aroundGeoHash);
  }
}
