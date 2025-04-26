package part1;

import java.util.ArrayList;
import java.util.List;

public class Series {
    private List<Season> seasons = new ArrayList<>();

    public void addSeason(Season season) {
        seasons.add(season);
    }

    public List<Season> getSeasons() {
        return seasons;
    }
}
