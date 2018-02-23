package top.cmoon.micoservice.blog.blogservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import top.cmoon.micoservice.blog.blogservice.model.Blog;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog, Integer> {

}
