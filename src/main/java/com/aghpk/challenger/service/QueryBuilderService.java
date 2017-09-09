package com.aghpk.challenger.service;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QueryBuilderService {

    /**
     * This method build NativeSearchQuery which support search with whitespaces
     * ElasticSearch does not support filter value with spaces so custom method is needed
     *
     * @param filter    - value what you want to find
     * @param indexName - elasticsearch parameter (see: @Document annotation)
     * @param type      - elasticsearch parameter (see: @Document annotation)
     * @param pageNo    - page number
     * @param pageSize  - page size
     * @param firstField - search by this class field
     * @param secondField - search by this class field
     * @return NativeSearchQuery which support filters with whitespaces
     */
    public NativeSearchQuery buildMultiTermNativeSearchQuery(String filter, String indexName, String type, int pageNo, int pageSize, String firstField, String secondField) {

        String joinedQueryParams = reformatFilterParams(filter);

        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withIndices(indexName).withTypes(type).withPageable(new PageRequest(pageNo, pageSize));
        final BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();

        boolQueryBuilder.should(QueryBuilders.queryStringQuery(joinedQueryParams).field(firstField).field(secondField));

        return nativeSearchQueryBuilder.withQuery(boolQueryBuilder).build();
    }

    private String reformatFilterParams(String filter) {
        // query should looks like "*part1* *part2*"
        // elastic build query like "*" part1 part2 "*"
        // we have to fix search value
        if (filter.matches("\\\\s+")) {
            List<String> tokens = Arrays.asList(filter.split("\\s+"));
            return String.join(
                    " ",
                            tokens
                                .stream()
                                .map(p -> "*" + p + "*")
                                .collect(Collectors.toList()));
        }

        return "*" + filter + "*";
    }
}
