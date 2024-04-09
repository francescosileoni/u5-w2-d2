package project.u5d7;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class BlogPostService {
    private List<BlogPost> blogPosts = new ArrayList<>();

    public List<BlogPost> getAllBlogPosts() {
        return blogPosts;
    }

    public BlogPost getBlogPostById(Long id) {
        return blogPosts.stream()
                .filter(blogPost -> blogPost.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public BlogPost createBlogPost(BlogPost blogPost) {
        blogPost.setId((long) (blogPosts.size() + 1));
        blogPosts.add(blogPost);
        return blogPost;
    }

    public BlogPost updateBlogPost(Long id, BlogPost updatedBlogPost) {
        BlogPost blogPost = getBlogPostById(id);
        if (blogPost != null) {
            blogPost.setCategoria(updatedBlogPost.getCategoria());
            blogPost.setTitolo(updatedBlogPost.getTitolo());
            blogPost.setCover(updatedBlogPost.getCover());
            blogPost.setContenuto(updatedBlogPost.getContenuto());
            blogPost.setTempoDiLettura(updatedBlogPost.getTempoDiLettura());
        }
        return blogPost;
    }

    public void deleteBlogPost(Long id) {
        blogPosts.removeIf(blogPost -> blogPost.getId().equals(id));
    }
}

