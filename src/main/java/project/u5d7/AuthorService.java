package project.u5d7;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    private List<Author> authors = new ArrayList<>();

    public List<Author> getAllAuthors() {
        return authors;
    }

    public Author getAuthorById(Long id) {
        return authors.stream()
                .filter(author -> author.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Author createAuthor(Author author) {
        author.setId((long) (authors.size() + 1));
        authors.add(author);
        return author;
    }

    public Author updateAuthor(Long id, Author updatedAuthor) {
        Author author = getAuthorById(id);
        if (author != null) {
            author.setNome(updatedAuthor.getNome());
            author.setCognome(updatedAuthor.getCognome());
            author.setEmail(updatedAuthor.getEmail());
            author.setDataDiNascita(updatedAuthor.getDataDiNascita());
            author.setAvatar(updatedAuthor.getAvatar());
        }
        return author;
    }

    public void deleteAuthor(Long id) {
        authors.removeIf(author -> author.getId().equals(id));
    }
}
