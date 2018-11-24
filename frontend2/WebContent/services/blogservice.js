/**
 * BlogService
 */
app.factory('BlogService',function($http){
	var blogService={}
	
	blogService.addBlog=function(blog){
		return $http.post("http://localhost:8090/middleware/addblogpost",blog)
	}
	
	blogService.getBlogsWaitingForApproval=function(){
		return $http.get("http://localhost:8090/middleware/blogswaitingforapproval")
	}
	
	blogService.getBlogsApproved=function(){
		return $http.get("http://localhost:8090/middleware/blogsapproved")
	}
	
	blogService.getBlog=function(blogPostId){
		return $http.get("http://localhost:8090/middleware/getBlog/"+blogPostId)
	}
	
    blogService.approve=function(blogPost){
    	return $http.put("http://localhost:8090/middleware/approve",blogPost)
    }	
	
	blogService.reject=function(blogPost,rejectionReason){
		return $http.put("http://localhost:8090/middleware/reject/"+rejectionReason,blogPost)
	}

	blogService.hasUserLikedBlogPost=function(blogPostId){
		return $http.get("http://localhost:8090/middleware/hasUserLikedBlogPost/"+blogPostId);
	}
	
	blogService.updateLikes=function(blogPostId){
		return $http.put("http://localhost:8090/middleware/updatelikes/"+blogPostId);
	}
	
	blogService.addBlogComment=function(blogComment){
		
		return $http.post("http://localhost:8090/middleware/addblogcomment",blogComment)
	}
	
	blogService.getAllBlogComments=function(blogPostId){
	return $http.get("http://localhost:8090/middleware/getblogcomments/"+blogPostId)	
	}
	
	return blogService;
})
