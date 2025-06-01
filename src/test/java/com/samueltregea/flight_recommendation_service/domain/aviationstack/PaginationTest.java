package com.samueltregea.flight_recommendation_service.domain.aviationstack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PaginationTest {

    /**
     * Test the standard Pagination record.
     */
    @Test
    public void testPagination() {
        final Integer limit = 100;
        final Integer offset = 0;
        final Integer count = 100;
        final Integer total = 1669022;

        Pagination pagination = new Pagination(limit, offset, count, total);

        assertNotNull(pagination);
        assertEquals(limit, pagination.limit());
        assertEquals(offset, pagination.offset());
        assertEquals(count, pagination.count());
        assertEquals(total, pagination.total());
    }
}
