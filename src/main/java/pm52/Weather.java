package pm52;

import java.util.Iterator;

public class Weather {

    public static void main(String[] args) {
        for (String c : new WeatherIterable<>(new String[] {"beijing", "shanghai"})) {
            System.out.println(c);
        }
        new WeatherIterable<>(new String[]{"hello", "world"}).forEach(System.out::println);
    }

    private static class WeatherIterable<String> implements Iterable<String> {

        private final String[] cities;

        WeatherIterable(String[] cities) {
            this.cities = cities;
        }

        @Override
        public Iterator<String> iterator() {
            return new WeatherIterator<>(cities);
        }
    }

    private static class WeatherIterator<String> implements Iterator<String> {

        private final String[] cities;
        private int index;

        WeatherIterator(String[] cities) {
            this.cities = cities;
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < cities.length;
        }

        @Override
        public String next() {
            if (index >= cities.length) return null;
            return cities[index++];
        }
    }
}
