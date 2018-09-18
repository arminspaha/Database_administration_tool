var app = require('../app');

var profileController = function($scope, $state, profileService) {

	$scope.basicInfo = profileService.getProfileBasicInfo();
	$scope.social = profileService.getSocialData();

	$scope.goToHomePage = function() {
		$state.go("userList", {}, {
			reload : true
		});
	}

};

app.controller("profileController", [ "$scope", '$state', 'profileService',
		profileController ]);

module.exports = app;