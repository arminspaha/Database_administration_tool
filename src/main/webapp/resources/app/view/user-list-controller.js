var app = require('../app');

var userListController = function($scope, dataService, profileService) {

	$scope.users = dataService.getUsers();

	$scope.basicInfo = profileService.getProfileBasicInfo();
	$scope.social = profileService.getSocialData();

};

app.controller("userListController", [ '$scope', 'dataService',
		'profileService', userListController ]);

module.exports = app;