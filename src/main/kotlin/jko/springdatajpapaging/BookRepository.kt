package jko.springdatajpapaging

import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Slice
import org.springframework.data.repository.PagingAndSortingRepository

interface BookRepository : PagingAndSortingRepository<Book, Long> {

    fun findAllBy(pageable: Pageable): List<Book>
}
