package part1;

import java.util.List;

public class BingeIterator implements EpisodeIterator {
    private List<Season> seasons;
    private int seasonIndex = 0;
    private EpisodeIterator currentIterator;

    public BingeIterator(Series series) {
        this.seasons = series.getSeasons();
        if (!seasons.isEmpty()) {
            currentIterator = new SeasonIterator(seasons.get(0));
        }
    }

    @Override
    public boolean hasNext() {
        while (currentIterator != null) {
            if (currentIterator.hasNext()) {
                return true;
            } else {
                seasonIndex++;
                if (seasonIndex < seasons.size()) {
                    currentIterator = new SeasonIterator(seasons.get(seasonIndex));
                } else {
                    currentIterator = null;
                }
            }
        }
        return false;
    }

    @Override
    public Episode next() {
        return currentIterator.next();
    }
}
