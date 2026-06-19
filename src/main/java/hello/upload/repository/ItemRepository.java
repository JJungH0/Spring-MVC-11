package hello.upload.repository;

import hello.upload.domain.Item;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ItemRepository {

    private final Map<Long, Item> store = new ConcurrentHashMap<>();
    private long sequence = 0L;

    public Item save(Item item) {
        item.setId(++sequence);
        return store.put(item.getId(), item);
    }

    public Optional<Item> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }
}
