package part1;

import java.util.List;

public class SeasonIterator implements EpisodeIterator, java.util.Iterator<Episode> {
    private List<Episode> episodes;
    private int position = 0;

    public SeasonIterator(Season season) {
        this.episodes = season.getEpisodes();
    }

    @Override
    public boolean hasNext() {
        return position < episodes.size();
    }

    @Override
    public Episode next() {
        return episodes.get(position++);
    }
}
