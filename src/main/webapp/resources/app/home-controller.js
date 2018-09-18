var app = require('./app');

var homeController = function($scope, dataService, authService) {
	$scope.currentMenu = 'userList';
	
	$scope.logout = function() {
		authService.logout();
	  }
};

app.controller("homeController", [ '$scope', 'dataService', 'authService', homeController ]);
module.exports = app;