package Emergency.boardV0.controller;

import Emergency.boardV0.Blog;
import Emergency.boardV0.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping // 블로그 생성
    public Blog create(@RequestBody Blog blog){
        return blogService.save(blog);
    }

    //2전체 블로그 조회
    @GetMapping
    public List<Blog>getAll(){
        return blogService.findAll();
    }

    //3 단일 블로그 조회
    @GetMapping("/{id}")
    public Blog getOne(@PathVariable Long id){
        return blogService.findById(id);
    }

    //4블로그 삭제
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        blogService.delete(id);
    }
}
