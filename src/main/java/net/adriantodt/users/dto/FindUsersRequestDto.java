package net.adriantodt.users.dto;

import lombok.Data;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
public class FindUsersRequestDto {
    private FindUserRequestDto params;
    private Integer paginationSize;
    private Integer currentPage;
    private List<OrderBy> orderBy;

    @Data
    public static class OrderBy {
        private Sort.Direction direction;
        private String property;
    }
}
