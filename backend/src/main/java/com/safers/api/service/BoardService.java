package com.safers.api.service;

import com.safers.api.response.BoardGetResponse;
import com.safers.db.entity.board.Board;
import com.safers.db.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public List<BoardGetResponse> findBoardListByPage(int page) {
        PageRequest pageRequest = PageRequest.of(page, 30, Sort.Direction.DESC, "regDt");

        Page<Board> boardPage = boardRepository.findAllByIsDeleteEquals(false, pageRequest);
        for(Board board : boardPage) {
            System.out.println("board >> " + board.getTitle());
        }
        return null;
    }

//    private Specification<Board> getIsDeleteFilter() {
//        return new Specification<Board>() {
//            @Override
//            public Predicate toPredicate(Root<Board> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//                Predicate p = criteriaBuilder.conjunction();
//                p = criteriaBuilder.equal()
//                return null;
//            }
//        }
//    }
}