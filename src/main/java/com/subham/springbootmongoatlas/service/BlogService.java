package com.subham.springbootmongoatlas.service;

import com.subham.springbootmongoatlas.model.Blog;
import com.subham.springbootmongoatlas.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BlogService {

    @Autowired
    private BlogRepository repository;
   //create
    public Blog addblog(Blog blog){
        blog.setBlogId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(blog);
    }
    //read
    public List<Blog>findallBlogs(){
        return repository.findAll();
    }
    public Blog getBlogByBlogId(String blogId){
        return repository.findById(blogId).get();
    }

    public List<Blog> getBlogbyUserId(String userId){
        return repository.findByUserId(userId);
    }

    //update

    public Blog updateBlog(Blog blogRequest){
        Blog existingBlog = repository.findById(blogRequest.getBlogId()).get();
        existingBlog.setTitle(blogRequest.getTitle());
        existingBlog.setContent(blogRequest.getContent());
        return repository.save(existingBlog);

    }

    //delete

    public String deleteBlog(String blogId){
        repository.deleteById(blogId);
        return blogId + "blog deleted";
    }
}
