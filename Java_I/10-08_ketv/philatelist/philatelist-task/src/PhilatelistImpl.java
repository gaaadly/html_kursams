import lt.techin.philatelist.Philatelist;
import lt.techin.philatelist.PostStamp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PhilatelistImpl implements Philatelist {

    private List<PostStamp> stamps = new ArrayList<>();

    @Override
    public void addToCollection(PostStamp postStamp) {
        if (postStamp == null) {
            throw new IllegalArgumentException("Post stamp must not be null");
        }
        if (postStamp.getName() == null || postStamp.getName().isEmpty()) {
            throw new IllegalArgumentException("Post stamp name must not be null or empty");
        }
        stamps.add(postStamp);
    }

    @Override
    public int getNumberOfPostStampsInCollection() {
        return stamps.size();
    }

    @Override
    public void printAllPostStampNames() {
        stamps.forEach(stamp -> System.out.println(stamp.getName()));
    }

    @Override
    public void printPostStampsWithPriceGreaterThan(double v) {
        stamps.stream()
                .filter(stamp -> stamp.getMarketPrice() > v)
                .forEach(stamp -> System.out.println(stamp.getName()));
    }

    @Override
    public boolean isPostStampInCollection(PostStamp postStamp) {
        return stamps.contains(postStamp);
    }

    @Override
    public boolean isPostStampWithNameInCollection(String s) {
        return stamps.stream()
                .anyMatch(stamp -> stamp.getName().equals(s));
    }

    @Override
    public double calculateTotalMarketPrice() {
        return stamps.stream()
                .mapToDouble(stamp -> stamp.getMarketPrice())
                .sum();
    }

    @Override
    public double getAveragePostStampPrice() {
        return stamps.stream()
                .mapToDouble(stamp -> stamp.getMarketPrice())
                .average()
                .orElse(0.0);
    }

    @Override
    public PostStamp getTheMostExpensivePostStampByMarketValue() {
        return stamps.stream()
                .max(Comparator.comparingDouble(PostStamp::getMarketPrice))
                .orElse(null);
    }

    @Override
    public List<PostStamp> findPostStampsByNameContaining(String s) {
        return stamps.stream()
                .filter(stamp -> stamp.getName().contains(s))
                .toList();
    }

    @Override
    public List<PostStamp> getSortedPostStampsByName() {
        return stamps.stream()
                .sorted(Comparator.comparing(stamp -> stamp.getName()))
                .toList();
    }
}
