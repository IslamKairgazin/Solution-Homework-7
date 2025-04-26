package part1;

public class Main {
    public static void main(String[] args) {

        Series series = new Series();

        Season season1 = new Season();
        season1.addEpisode(new Episode("S1E1 - The Beginning", 1800));
        season1.addEpisode(new Episode("S1E2 - The Middle", 1800));
        season1.addEpisode(new Episode("S1E3 - The End", 1800));

        Season season2 = new Season();
        season2.addEpisode(new Episode("S2E1 - The Return", 1900));
        season2.addEpisode(new Episode("S2E2 - The Plot Twist", 2000));

        series.addSeason(season1);
        series.addSeason(season2);

        System.out.println("--- Normal Season Traversal ---");
        EpisodeIterator normalIterator = new SeasonIterator(season1);
        while (normalIterator.hasNext()) {
            System.out.println(normalIterator.next().getTitle());
        }

        System.out.println("\n--- Reverse Season Traversal ---");
        EpisodeIterator reverseIterator = new ReverseSeasonIterator(season1);
        while (reverseIterator.hasNext()) {
            System.out.println(reverseIterator.next().getTitle());
        }

        System.out.println("\n--- Shuffle Season Traversal ---");
        EpisodeIterator shuffleIterator = new ShuffleSeasonIterator(season1);
        while (shuffleIterator.hasNext()) {
            System.out.println(shuffleIterator.next().getTitle());
        }

        System.out.println("\n--- Binge Watching the Whole Series ---");
        EpisodeIterator bingeIterator = new BingeIterator(series);
        while (bingeIterator.hasNext()) {
            System.out.println(bingeIterator.next().getTitle());
        }
    }
}
