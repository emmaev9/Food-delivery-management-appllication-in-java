package DAL;
import BLL.BaseProduct;
import BLL.MenuItem;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileSplit {
    HashMap<String, MenuItem> hashMap;
    String fileName = "C://products.csv";

    public HashMap<String, MenuItem> splite() {
        hashMap = new HashMap<>();
        String title;
        double rating;
        int calories, protein, fat, sodium, price;
        Path path = Paths.get("C://products.csv");
        ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        try {
            if (Files.exists(path)) {
                Stream<String> lines = Files.lines(path);
                List<List<String>> values = lines.skip(1).map(line -> Arrays.asList(line.split(","))).distinct().collect(Collectors.toList());

                for (int i = 0; i < values.size(); i++) {
                    title = values.get(i).get(0);
                    rating = Double.parseDouble(values.get(i).get(1));
                    calories = Integer.parseInt(values.get(i).get(2));
                    protein = Integer.parseInt(values.get(i).get(3));
                    fat = Integer.parseInt(values.get(i).get(4));
                    sodium = Integer.parseInt(values.get(i).get(5));
                    price = Integer.parseInt(values.get(i).get(6));
                    BaseProduct menuItem = new BaseProduct(title, rating, calories, protein, fat, sodium, price);

                    items.add(menuItem);
                }
                for (MenuItem p : items) {
                    hashMap.put(p.getTitle(), p);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return hashMap;
    }
}
