/**
	 * UserService
	 */
	app.factory('UserService',function($http){
		var userService={}
		
		userService.registration=function(user){
			return $http.post("http://localhost:8090/middleware/register",user)
		}
		
		userService.login=function(user){
			return $http.put("http://localhost:8090/middleware/login",user)
		}
		
		
		userService.logout=function(){
			return $http.put("http://localhost:8090/middleware/logout")
		}
		
		return userService;
	})





