package Emergency.boardV0.service;

import Emergency.boardV0.Blog;
import Emergency.boardV0.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BlogService {
    private final BlogRepository blogRepository;

    public Blog save(Blog blog){
        return blogRepository.save(blog);
    }

    public List<Blog> findAll(){
        return blogRepository.findAll();
    }

    public Blog findById(Long id){
        return blogRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 블로그가 없습니다. id = "+id));
    }
    public void delete(Long id){
        blogRepository.deleteById(id);
    }
}
