package ru.cloudinfosys.sm.db;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.cloudinfosys.sm.domain.Market;

public interface MarketRepository extends MongoRepository<Market, String> {
}
