import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;


public class Scraper {

    public static void main(String[] args) throws Exception {
        ArrayList<String> Drivers = new ArrayList<>();
        final Document document = Jsoup.connect("https://www.f1-fansite.com/f1-results/2015-f1-championship-standings/").get();

        for (Element row : document.select("table.motor-sport-results.msr_season_driver_results tr")){

            if (row.select("td.msr_pos").text().equals("")) {
                continue;
            }else if (row.select("td.msr_driver").text().equals("")) {
                continue;
            }else if (row.select("td.msr_total").text().equals("")) {
                continue;
            }else {
                final String position = row.select("td.msr_pos").text();
                final String name = row.select("td.msr_driver").text();
                final String score = row.select("td.msr_total").text();


                Drivers.add(position + " " + name + " points " + score);
            }
        }

            List<String> topTen = Drivers.subList(0, 10);
            System.out.println(topTen);


        ArrayList<String> Team = new ArrayList<>();
        for (Element row : document.select("table.motor-sport-results.msr_season_team_results tr")){
            if (row.select("td.msr_pos").text().equals("")) {
                continue;
            }else if (row.select("td.msr_team").text().equals("")) {
                continue;
            }else if (row.select("td.msr_total").text().equals("")) {
                continue;
            }else {
                final String rank = row.select("td.msr_pos").text();
                final String team = row.select("td.msr_team").text();
                final String point = row.select("td.msr_total").text();

                Team.add(rank + " " + team + " " + point);
            }
        }

        List<String> topFive = Team.subList(0,5);
        System.out.println(topFive);
    }
}
