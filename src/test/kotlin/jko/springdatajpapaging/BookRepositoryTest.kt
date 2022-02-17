package jko.springdatajpapaging

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

@DataJpaTest
internal class BookRepositoryTest {

    @Autowired
    private lateinit var bookRepository: BookRepository

    @BeforeEach
    internal fun setUp() {
        bookRepository.findAll().map {
            println("---")
        }
        val books = listOf(
            Book(name = "jpa-paging-1"),
            Book(name = "jpa-paging-2"),
            Book(name = "jpa-paging-3"),
            Book(name = "jpa-paging-4"),
            Book(name = "jpa-paging-5"),
            Book(name = "jpa-paging-6"),
            Book(name = "jpa-paging-7"),
            Book(name = "jpa-paging-8"),
            Book(name = "jpa-paging-9"),
            Book(name = "jpa-paging-10")
        )

        bookRepository.saveAll(books)
    }

    @Test
    internal fun `Page 를 return 하면, count query 가 발생한다`() {
        val firstPage = PageRequest.of(0, 4)
        val books: Page<Book> = bookRepository.findAll(firstPage)

        books.map {
            println("name: ${it.name}")
        }
    }

    @Test
    internal fun `List 를 return 하면, count query 가 발생하지 않는다`() {
        val firstPage = PageRequest.of(0, 4)
        val books: List<Book> = bookRepository.findAllBy(firstPage)

        books.map {
            println("name: ${it.name}")
        }
    }
}
